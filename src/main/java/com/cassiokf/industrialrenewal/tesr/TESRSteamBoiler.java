package com.cassiokf.industrialrenewal.tesr;

import com.cassiokf.industrialrenewal.blockentity.BlockEntitySteamBoiler;
import com.cassiokf.industrialrenewal.init.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TESRSteamBoiler extends TESRBase<BlockEntitySteamBoiler>{

    private static final ItemStack fire = new ItemStack(ModItems.fire.get());

    public TESRSteamBoiler(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(BlockEntitySteamBoiler blockEntity, float partialTick, PoseStack stack, MultiBufferSource buffer, int combinedOverlay, int packedLight) {
        int x = 0;
        int z = 0;
        int y = 0;

        if (blockEntity!= null && blockEntity.isMaster())
        {
            Direction facing = blockEntity.getMasterFacing();
            //WATER
            doTheMath(facing, x, z, 1.9, -0.69);
            //Utils.debug("Water:", tileEntity.GetWaterFill());
            renderText(stack, facing, xPos, y + 0.25, zPos, blockEntity.getWaterText(), 0.01F);
            renderPointer(stack, lighting(blockEntity), combinedOverlay, buffer, facing, xPos, y + 0.51, zPos, blockEntity.GetWaterFill(), pointer, 0.3F);
            //STEAM
            doTheMath(facing, x, z, 1.9, 0.69);
            //Utils.debug("Steam:", tileEntity.getSteamText());
            renderText(stack, facing, xPos, y + 0.25, zPos, blockEntity.getSteamText(), 0.01F);
            renderPointer(stack, lighting(blockEntity), combinedOverlay, buffer, facing, xPos, y + 0.51, zPos, blockEntity.GetSteamFill(), pointer, 0.3F);
            //FUEL
            doTheMath(facing, x, z, 1.9, 0);
            //Utils.debug("Fuel:", tileEntity.getFuelText());
            renderText(stack, facing, xPos, y + 0.18, zPos, blockEntity.getFuelText(), 0.01F);
            renderPointer(stack, lighting(blockEntity), combinedOverlay, buffer, facing, xPos, y + 0.44, zPos, blockEntity.getFuelFill(), pointer, 0.3F);
            //HEAT
            doTheMath(facing, x, z, 1.9, 0);
            //Utils.debug("Heat:", tileEntity.getHeatText());
            renderText(stack, facing, xPos, y + 0.93, zPos, blockEntity.getHeatText(), 0.01F);
            renderPointer(stack, lighting(blockEntity), combinedOverlay, buffer, facing, xPos, y + 1.19, zPos, blockEntity.getHeatFill(), pointer, 0.3F);
            //Fire
            if (blockEntity.getIntType() > 0 && blockEntity.canRun())
            {
                doTheMath(facing, x, z, 1.9, 0);
                render3dItem(stack, lighting(blockEntity), combinedOverlay, buffer, facing, blockEntity.getLevel(), xPos, y - 0.7, zPos, fire, 1, true);
            }
        }
        super.render(blockEntity, partialTick, stack, buffer, combinedOverlay, packedLight);
    }
}
