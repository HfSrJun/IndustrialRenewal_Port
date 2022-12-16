package com.cassiokf.industrialrenewal.blocks;

import com.cassiokf.industrialrenewal.blockentity.BlockEntityFluidTank;
import com.cassiokf.industrialrenewal.blockentity.BlockEntityIndustrialBatteryBank;
import com.cassiokf.industrialrenewal.blocks.abstracts.BlockTowerBase;
import com.cassiokf.industrialrenewal.init.ModBlockEntity;
import com.cassiokf.industrialrenewal.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockFluidTank extends BlockTowerBase<BlockEntityFluidTank> implements EntityBlock {
    public BlockFluidTank(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @org.jetbrains.annotations.Nullable LivingEntity livingEntity, ItemStack itemStack) {
        if(!world.isClientSide()){
            super.setPlacedBy(world, pos, state, livingEntity, itemStack);
            List<BlockPos> blocks = Utils.getBlocksIn3x3x3Centered(pos);
            for(BlockPos blockPos : blocks){
                BlockEntity te = world.getBlockEntity(blockPos);
                if(te instanceof BlockEntityFluidTank bankTE && ((BlockEntityFluidTank)te).isMaster()){

                    bankTE.setSelfBooleanProperty();
                    bankTE.setOtherBooleanProperty(TOP, false, false);
                    bankTE.setOtherBooleanProperty(BASE, false, true);
                    bankTE.getBase().loadTower();
                }
            }
        }
    }

    @Override
    public void destroy(LevelAccessor world, BlockPos pos, BlockState state) {
        if(!world.isClientSide()){
            List<BlockPos> blocks = Utils.getBlocksIn3x3x3Centered(pos);
            for(BlockPos blockPos : blocks){
                BlockEntity te = world.getBlockEntity(blockPos);
                if(te instanceof BlockEntityFluidTank bankTE && ((BlockEntityFluidTank)te).isMaster()){
                    bankTE.setOtherBooleanProperty(TOP, true, false);
                    bankTE.setOtherBooleanProperty(BASE, true, true);
                    if(!bankTE.isBase()){
                        bankTE.getBase().removeTower(bankTE);
                    }
                    if(bankTE.getAbove() != null){
                        bankTE.getAbove().loadTower();
                    }
                }
            }
        }
        super.destroy(world, pos, state);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntity.FLUID_TANK_TILE.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> p_153214_) {
        return ($0, $1, $2, blockEntity) -> ((BlockEntityFluidTank)blockEntity).tick();
    }
}
