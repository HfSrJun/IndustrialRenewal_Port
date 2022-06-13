package com.cassiokf.IndustrialRenewal.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.network.play.server.SChatPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemBlockScaffold extends BlockItem {
    public ItemBlockScaffold(Block block, Properties props) {
        super(block, props);
    }

    @Nullable
    @Override
    public BlockItemUseContext updatePlacementContext(BlockItemUseContext context) {
        BlockPos pos = context.getClickedPos();
        World world = context.getLevel();
        BlockState state = world.getBlockState(pos);
        Block block = this.getBlock();

//            Vector3d hit = context.getClickLocation();
//            Vector3d hitQuad = hit.subtract(Vector3d.atCenterOf(pos));

        if (!state.is(block) || context.getPlayer().isCrouching()) {
            return context;
        }
        else{
            Direction direction;
            if (context.isSecondaryUseActive()) {
                direction = context.isInside() ? context.getClickedFace().getOpposite() : context.getClickedFace();
            } else {
                direction = context.getClickedFace() == Direction.UP ? context.getHorizontalDirection() : Direction.UP;
            }

            //int i = 0;
            BlockPos.Mutable blockpos$mutable = pos.mutable().move(direction);

            while(true) {
                if (!world.isClientSide && !World.isInWorldBounds(blockpos$mutable)) {
                    PlayerEntity playerentity = context.getPlayer();
                    int j = world.getMaxBuildHeight();
                    if (playerentity instanceof ServerPlayerEntity && blockpos$mutable.getY() >= j) {
                        SChatPacket schatpacket = new SChatPacket((new TranslationTextComponent("build.tooHigh", j)).withStyle(TextFormatting.RED), ChatType.GAME_INFO, Util.NIL_UUID);
                        ((ServerPlayerEntity)playerentity).connection.send(schatpacket);
                    }
                    break;
                }

                state = world.getBlockState(blockpos$mutable);
                if (!state.is(this.getBlock())) {
                    if (state.canBeReplaced(context)) {
                        return BlockItemUseContext.at(context, blockpos$mutable, direction);
                    }
                    break;
                }

                blockpos$mutable.move(direction);
//                if (direction.getAxis().isHorizontal()) {
//                    ++i;
//                }
            }

            return null;
        }
        //return super.updatePlacementContext(context);
    }
}
