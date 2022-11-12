package com.cassiokf.industrialrenewal.blockentity;

import com.cassiokf.industrialrenewal.blockentity.abstracts.BlockEntitySyncable;
import com.cassiokf.industrialrenewal.blocks.BlockWindTurbineHead;
import com.cassiokf.industrialrenewal.config.Config;
import com.cassiokf.industrialrenewal.init.ModBlockEntity;
import com.cassiokf.industrialrenewal.items.ItemWindBlade;
import com.cassiokf.industrialrenewal.util.CustomEnergyStorage;
import com.cassiokf.industrialrenewal.util.CustomItemStackHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;
import java.util.Random;

//import com.cassiokf.IndustrialRenewal.util.CustomEnergyStorage;

public class BlockEntityWindTurbineHead extends BlockEntitySyncable {


    private float rotation;
    private int energyGenerated;

    public static final int energyGeneration = Config.WIND_TURBINE_ENERGY_PER_TICK.get();
    private final int energyCapacity = Config.WIND_TURBINE_CAPACITY.get();
    private final int energyTransfer = Config.WIND_TURBINE_TRANSFER_RATE.get();
    private int tickToDamage;

    private final Random random = new Random();

    public BlockEntityWindTurbineHead(BlockPos pos, BlockState state) {
        super(ModBlockEntity.WIND_TURBINE_TILE.get(), pos, state);
    }

    private final CustomEnergyStorage energyStorage = new CustomEnergyStorage(energyCapacity, energyTransfer, energyTransfer)
    {
        @Override
        public void onEnergyChange()
        {
            BlockEntityWindTurbineHead.this.sync();
        }
    };

    public LazyOptional<IItemHandler> bladeInv = LazyOptional.of(this::createHandler);
    private LazyOptional<IEnergyStorage> energyStorageHandler = LazyOptional.of(()->energyStorage);

    private IItemHandler createHandler()
    {
        return new CustomItemStackHandler(1)
        {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack)
            {
                return stack.getItem() instanceof ItemWindBlade;
            }

            @Override
            protected void onContentsChanged(int slot)
            {
                BlockEntityWindTurbineHead.this.sync();
                //level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
            }
        };
    }

    @Override
    public void setRemoved() {
        bladeInv.ifPresent(inv->{
            Block.popResource(level, worldPosition, inv.getStackInSlot(0));
        });
        super.setRemoved();
    }


    public void tick() {
        if (!level.isClientSide)
        {
            //Generate Energy
            IEnergyStorage thisEnergy = energyStorageHandler.orElse(null);
            if(!energyStorageHandler.isPresent())
                return;
            if (hasBlade())
            {
                int energyGen = Math.round(energyGeneration * getEfficiency());
                energyGenerated = thisEnergy.receiveEnergy(energyGen, false);
                if (++tickToDamage >= 1200 && energyGen > 0)
                {
                    tickToDamage = 0;
                    bladeInv.ifPresent(inv->{
                        ItemStack stack = inv.getStackInSlot(0);
                        if(stack != null && !stack.isEmpty()){
                            if(stack.hurt(1, new Random(), null))
                                stack.shrink(1);
                        }
                    });
                }
            } else
            {
                energyGenerated = 0;
            }
            //OutPut Energy
            if (thisEnergy.getEnergyStored() > 0)
            {
                BlockEntity te = level.getBlockEntity(worldPosition.below());
                if (te != null)
                {
                    IEnergyStorage downE = te.getCapability(CapabilityEnergy.ENERGY, Direction.UP).orElse(null);
                    if (downE != null && downE.canReceive())
                    {
                        thisEnergy.extractEnergy(downE.receiveEnergy(thisEnergy.extractEnergy(1024, true), false), false);
                        this.setChanged();
                    }
                }
            }
        } else
        {
            rotation += 4.5f * getEfficiency();
            if (rotation > 360) rotation = 0;
        }
    }

    public IItemHandler getBladeHandler()
    {
        return bladeInv.orElse(null);
    }

    public float getRotation()
    {
        return -rotation;
    }

    public boolean hasBlade()
    {
        if(bladeInv.isPresent()) {
            IItemHandler iItemHandler = bladeInv.orElse(null);
            return !iItemHandler.getStackInSlot(0).isEmpty();
        }
        return false;
    }

    private float getEfficiency()
    {
        float weatherModifier;
        if (level.isThundering())
        {
            weatherModifier = 1f;
        } else if (level.isRaining())
        {
            weatherModifier = 0.9f;
        } else
        {
            weatherModifier = 0.8f;
        }

        float heightModifier;
        float posMin = -2040f;
        if (worldPosition.getY() - 62 <= 0) heightModifier = 0;
        else heightModifier = (worldPosition.getY() - posMin) / (255 - posMin);
        heightModifier = Mth.clamp(heightModifier, 0, 1);

        return weatherModifier * heightModifier;
    }


    public Direction getBlockFacing()
    {
        return getBlockState().getValue(BlockWindTurbineHead.FACING);
    }

//    @Override
//    public double getViewDistance() {
//        return super.getViewDistance();
//    }


//    @Override
//    @Nullable
//    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing)
//    {
//        if (capability == CapabilityEnergy.ENERGY && facing == Direction.DOWN)
//            return energyStorage.cast();
//        return super.getCapability(capability, facing);
//    }


    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        compoundTag.putInt("energy", energyStorage.getEnergyStored());
        bladeInv.ifPresent(h ->
        {
            CompoundTag tag = ((INBTSerializable<CompoundTag>) h).serializeNBT();
            compoundTag.put("inv", tag);
        });
        compoundTag.putInt("generation", this.energyGenerated);
        compoundTag.putInt("damageTick", tickToDamage);
        super.saveAdditional(compoundTag);
    }


    @Override
    public void load(CompoundTag compoundTag) {
        energyStorage.setEnergy(compoundTag.getInt("energy"));
        CompoundTag invTag = compoundTag.getCompound("inv");
        bladeInv.ifPresent(h -> ((INBTSerializable<CompoundTag>) h).deserializeNBT(invTag));
        energyGenerated = compoundTag.getInt("generation");
        tickToDamage = compoundTag.getInt("damageTick");
        super.load(compoundTag);
    }

    @Override
    public AABB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }
}