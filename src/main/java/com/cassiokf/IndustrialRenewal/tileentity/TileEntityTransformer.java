package com.cassiokf.IndustrialRenewal.tileentity;

import com.cassiokf.IndustrialRenewal.blocks.BlockTransformer;
import com.cassiokf.IndustrialRenewal.init.ModTileEntities;
//import com.cassiokf.IndustrialRenewal.tileentity.abstracts.HvNode;
import com.cassiokf.IndustrialRenewal.tileentity.abstracts.TileEntity3x2x3MachineBase;
import com.cassiokf.IndustrialRenewal.util.CustomEnergyStorage;
import com.cassiokf.IndustrialRenewal.util.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IntegerProperty;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;
import java.util.stream.Collectors;

public class TileEntityTransformer extends TileEntity3x2x3MachineBase<TileEntityTransformer> implements ITickableTileEntity {

    public int MAX_CAPACITY = 1000000;
    public int TRANSFER_SPEED = 1000000;
    private int tick = 0;

    public CustomEnergyStorage energyStorage = new CustomEnergyStorage(MAX_CAPACITY, TRANSFER_SPEED, TRANSFER_SPEED){
        @Override
        public void onEnergyChange() {
            super.onEnergyChange();
            sync();
        }
    };
    public LazyOptional<CustomEnergyStorage> energyStorageHandler = LazyOptional.of(()->energyStorage);

    public CustomEnergyStorage energyDummy = new CustomEnergyStorage(0);
    public LazyOptional<CustomEnergyStorage> dummyHandler = LazyOptional.of(()->energyDummy);

    public TileEntityTransformer() {
        super(ModTileEntities.TRANSFORMER_TILE.get());
    }

    @Override
    public void tick() {
        if(!level.isClientSide && isMaster()){
            if(extract()){
                requestEnergy();
                extractEnergy();
            }
//            if(hasIsolator()){
//                initializeIsolator();
//            }
        }
    }

    public boolean extract(){
        return level.getBlockState(worldPosition).getValue(BlockTransformer.OUTPUT) == 2;
    }

    public Direction getFacing(){
        return level.getBlockState(worldPosition).getValue(BlockTransformer.FACING);
    }

    public void extractEnergy(){
        BlockPos targetLocation = worldPosition.below().relative(getFacing().getOpposite(), 2);
        TileEntity te = level.getBlockEntity(targetLocation);
        if(te != null){
            IEnergyStorage teEnergyStorage = te.getCapability(CapabilityEnergy.ENERGY, getFacing()).orElse(null);
            if(teEnergyStorage != null){
                int amount = teEnergyStorage.receiveEnergy(energyStorage.extractEnergy(TRANSFER_SPEED, true), true);
                teEnergyStorage.receiveEnergy(energyStorage.extractEnergy(amount, false), false);
            }
        }
    }

    public void requestEnergy(){
        TileEntityWireIsolator isolator = getIsolator();
        if(isolator != null){
            Set<BlockPos> allNodesPos = isolator.allNodes;
            Set<TileEntityTransformer> availableTransformers = allNodesPos.stream()
                    .filter(x -> level.getBlockEntity(x.below()) instanceof TileEntityTransformer)
                    .filter(x -> !((TileEntityTransformer)level.getBlockEntity(x.below())).extract())
                    .map(x -> (TileEntityTransformer)level.getBlockEntity(x.below()))
                    .collect(Collectors.toSet());

            int quota = Math.min(TRANSFER_SPEED, energyStorage.getMaxEnergyStored()-energyStorage.getEnergyStored());

            for (TileEntityTransformer transformer : availableTransformers){
                EnergyStorage e = transformer.energyStorageHandler.orElse(null);
                int amount = energyStorage.receiveEnergy(e.extractEnergy(quota, true), true);
                energyStorage.receiveEnergy(e.extractEnergy(quota, false), false);
                quota -= amount;
                if(quota <= 0)
                    break;
            }

        }
    }

    public boolean hasIsolator(){
        return level.getBlockEntity(worldPosition.above()) instanceof TileEntityWireIsolator;
    }

    public TileEntityWireIsolator getIsolator(){
        TileEntity TE = level.getBlockEntity(worldPosition.above());
        if(TE instanceof TileEntityWireIsolator)
            return (TileEntityWireIsolator)TE;
        return null;
    }
//
//    public void initializeIsolator(){
//        TileEntity teAbove = level.getBlockEntity(worldPosition.above());
//        if(teAbove instanceof TileEntityWireIsolator){
////            TileEntityWireIsolator isolatorTE = (TileEntityWireIsolator) teAbove;
////            if(isolatorTE.node == null){
////                isolatorTE.node = new HvNode(energyStorageHandler.orElse(null), extract(), worldPosition.above());
////            }
////            else{
////                isolatorTE.node.setEnergyStorage(energyStorageHandler.orElse(null));
////                isolatorTE.node.setProvider(extract());
////            }
//        }
//    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        Direction masterFacing = getFacing();
        BlockPos masterPos = super.masterPos!=null ? super.masterPos : worldPosition;

        if (side == null)
            return super.getCapability(cap, side);

        if(cap == CapabilityEnergy.ENERGY){
            if(worldPosition.equals(masterPos.below().relative(masterFacing.getOpposite())) && side == masterFacing.getOpposite()){
                if(getMaster().extract())
                    return getMaster().dummyHandler.cast();
                else
                    return getMaster().energyStorageHandler.cast();
                //return dummyHandler.cast();
            }
        }


        return super.getCapability(cap, side);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        energyStorageHandler.ifPresent(energy-> compound.put("ernergy", ((INBTSerializable<CompoundNBT>) energy).serializeNBT()));
        return super.save(compound);
    }

    @Override
    public void load(BlockState state, CompoundNBT compound) {
        energyStorageHandler.ifPresent(energy -> ((INBTSerializable<CompoundNBT>) energy).deserializeNBT(compound.getCompound("energy")));
        super.load(state, compound);
    }
}
