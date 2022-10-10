//package com.cassiokf.industrialrenewal.data.client;
//
//import com.cassiokf.IndustrialRenewal.init.ModBlocks;
//import com.cassiokf.IndustrialRenewal.init.ModItems;
//import net.minecraft.block.Blocks;
//import net.minecraft.data.DataGenerator;
//import net.minecraft.item.Item;
//import net.minecraft.item.Items;
//import net.minecraft.tags.ITag;
//import net.minecraft.tags.ItemTags;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.common.Tags;
//
//import java.util.function.Consumer;
//
//public class ModRecipeProvider extends RecipeProvider {
//    ITag.INamedTag<Item> STEEL_BLOCKS = ItemTags.bind("forge:storage_blocks/steel");
//    ITag.INamedTag<Item> STEEL_INGOT = ItemTags.bind("forge:ingots/steel");
//    ITag.INamedTag<Item> STEEL_ROD = ItemTags.bind("forge:rods/steel");
//    ITag.INamedTag<Item> IRON_ROD = ItemTags.bind("forge:rods/iron");
//
//    public ModRecipeProvider(DataGenerator generator) {
//        super(generator);
//    }
//
//    @Override
//    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
//        ShapedRecipeBuilder.shaped(ModBlocks.BLOCKHAZARD, 16)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('Y', Items.YELLOW_DYE)
//                .define('B', Items.BLACK_DYE)
//                .pattern("###")
//                .pattern("Y B")
//                .pattern("###")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.AISLEHAZARD, 16)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('Y', Items.BLACK_DYE)
//                .define('B', Items.WHITE_DYE)
//                .pattern("###")
//                .pattern("Y B")
//                .pattern("###")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CAUTIONHAZARD, 16)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('Y', Items.ORANGE_DYE)
//                .define('B', Items.WHITE_DYE)
//                .pattern("###")
//                .pattern("Y B")
//                .pattern("###")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.DEFECTIVEHAZARD, 16)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('Y', Items.BLUE_DYE)
//                .define('B', Items.WHITE_DYE)
//                .pattern("###")
//                .pattern("Y B")
//                .pattern("###")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.FIREHAZARD, 16)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('Y', Items.RED_DYE)
//                .define('B', Items.WHITE_DYE)
//                .pattern("###")
//                .pattern("Y B")
//                .pattern("###")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.RADIATIONHAZARD, 16)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('Y', Items.MAGENTA_DYE)
//                .define('B', Items.YELLOW_DYE)
//                .pattern("###")
//                .pattern("Y B")
//                .pattern("###")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.SAFETYHAZARD, 16)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('Y', Items.LIME_DYE)
//                .define('B', Items.WHITE_DYE)
//                .pattern("###")
//                .pattern("Y B")
//                .pattern("###")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.sMotor, 2)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('Y', Tags.Items.DUSTS_REDSTONE)
//                .define('B', Items.GOLD_INGOT)
//                .define('X', Items.PISTON)
//                .pattern("###")
//                .pattern("YXB")
//                .pattern("###")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.battery, 1)
//                .define('#', Tags.Items.DUSTS_REDSTONE)
//                .define('A', Tags.Items.NUGGETS_IRON)
//                .define('B', Items.GOLD_NUGGET)
//                .define('C', Items.LAPIS_LAZULI)
//                .define('D', Tags.Items.INGOTS_IRON)
//                .define('E', Items.GOLD_INGOT)
//                .pattern("A#B")
//                .pattern("A#B")
//                .pattern("DCE")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.battery_lithium, 1)
//                .define('#', Tags.Items.STORAGE_BLOCKS_REDSTONE)
//                .define('A', Tags.Items.NUGGETS_IRON)
//                .define('B', Items.GOLD_NUGGET)
//                .define('C', Items.LAPIS_BLOCK)
//                .define('D', Tags.Items.INGOTS_IRON)
//                .define('E', Items.GOLD_INGOT)
//                .pattern("A#B")
//                .pattern("D#E")
//                .pattern("DCE")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.screwDrive, 1)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('Y', ModItems.sMotor)
//                .define('A', ModItems.battery)
//                .define('B', Items.STONE_BUTTON)
//                .pattern("##Y")
//                .pattern(" BA")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.SPANEL.get(), 1)
//                .define('#', Items.GLASS_PANE)
//                .define('A', Items.LAPIS_LAZULI)
//                .define('B', Tags.Items.INGOTS_IRON)
//                .define('C', Tags.Items.DUSTS_REDSTONE)
//                .pattern("###")
//                .pattern("AAA")
//                .pattern("BCB")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.ENERGYCABLE_LV.get(), 6)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('A', Tags.Items.DUSTS_REDSTONE)
//                .define('X', Items.GLASS_PANE)
//                .pattern("#X#")
//                .pattern("AAA")
//                .pattern("#X#")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.ENERGYCABLE_MV.get(), 6)
//                .define('#', Items.GOLD_INGOT)
//                .define('A', Tags.Items.DUSTS_REDSTONE)
//                .define('X', Items.GLASS_PANE)
//                .pattern("#X#")
//                .pattern("AAA")
//                .pattern("#X#")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.ENERGYCABLE_MV.get(), 6)
//                .define('#', ModBlocks.ENERGYCABLE_LV.get())
//                .define('A', Items.GOLD_INGOT)
//                .pattern("###")
//                .pattern("AAA")
//                .pattern("###")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer, new ResourceLocation("energy_cable_mv_2"));
//
//        ShapedRecipeBuilder.shaped(ModBlocks.ENERGYCABLE_HV.get(), 6)
//                .define('#', Items.GLASS_PANE)
//                .define('A', Tags.Items.DUSTS_REDSTONE)
//                .define('X', Items.DIAMOND)
//                .pattern("#X#")
//                .pattern("AAA")
//                .pattern("#X#")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.ENERGYCABLE_HV.get(), 6)
//                .define('#', ModBlocks.ENERGYCABLE_MV.get())
//                .define('A', Items.REDSTONE)
//                .define('X', Items.DIAMOND)
//                .pattern("###")
//                .pattern("AXA")
//                .pattern("###")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer, new ResourceLocation("energy_cable_hv_2"));
//
//        ShapedRecipeBuilder.shaped(ModBlocks.BARREL.get(), 1)
//                .define('#', Items.IRON_TRAPDOOR)
//                .define('A', Tags.Items.STORAGE_BLOCKS_IRON)
//                .pattern("#")
//                .pattern("A")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.PORTABLE_GENERATOR.get(), 1)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('Y', Items.FURNACE)
//                .define('A', ModItems.sMotor)
//                .define('B', ModBlocks.BARREL.get())
//                .pattern("#B#")
//                .pattern("A#Y")
//                .pattern("# #")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.FLUID_PIPE.get(), 16)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('A', Tags.Items.NUGGETS_IRON)
//                .pattern("#A#")
//                .pattern("A A")
//                .pattern("#A#")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.FLUID_TANK.get(), 1)
//                .define('#', STEEL_ROD)
//                .define('A', ModBlocks.BARREL.get())
//                .define('B', ModBlocks.FLUID_PIPE.get())
//                .pattern("AAA")
//                .pattern("AAA")
//                .pattern("#B#")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.fireBoxSolid, 1)
//                .define('A', Tags.Items.DUSTS_REDSTONE)
//                .define('B', Items.HOPPER)
//                .define('C', Items.DROPPER)
//                .define('D', Items.FURNACE)
//                .pattern(" A ")
//                .pattern("BCD")
//                .pattern(" A ")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.fireBoxFluid, 1)
//                .define('A', Tags.Items.DUSTS_REDSTONE)
//                .define('B', ModBlocks.FLUID_PIPE.get())
//                .define('C', ModBlocks.BARREL.get())
//                .define('D', Items.FURNACE)
//                .pattern(" A ")
//                .pattern("CBD")
//                .pattern(" A ")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.INDUSTRIAL_BATTERY_BANK.get(), 1)
//                .define('A', ModBlocks.ENERGYCABLE_HV.get())
//                .define('B', ModBlocks.FRAME.get())
//                .define('C', ModBlocks.SCAFFOLD.get())
//                .pattern("ACA")
//                .pattern("B B")
//                .pattern("BCB")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.STEELBLOCK, 1)
//                .define('A', STEEL_INGOT)
//                .pattern("AAA")
//                .pattern("AAA")
//                .pattern("AAA")
//                .unlockedBy("has_item", has(STEEL_INGOT))
//                .save(consumer);
//
//        ShapelessRecipeBuilder.shapeless(ModItems.ingotSteel, 9)
//                .requires(STEEL_BLOCKS)
//                .unlockedBy("has_item", has(STEEL_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.STEAM_BOILER.get(), 1)
//                .define('A', ModBlocks.FLUID_PIPE.get())
//                .define('B', ModBlocks.BARREL.get())
//                .define('C', Tags.Items.DUSTS_REDSTONE)
//                .define('D', ModBlocks.FRAME.get())
//                .pattern("ABA")
//                .pattern("CBC")
//                .pattern("DDD")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.STEAM_TURBINE.get(), 1)
//                .define('A', ModBlocks.FLUID_PIPE.get())
//                .define('B', ModBlocks.BARREL.get())
//                .define('C', Tags.Items.DUSTS_REDSTONE)
//                .define('D', ModBlocks.FRAME.get())
//                .define('E', ModItems.sMotor)
//                .define('F', ModBlocks.BATTERYBANK.get())
//                .pattern("CBA")
//                .pattern("DED")
//                .pattern("DFD")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.MINER.get(), 1)
//                .define('A', ModBlocks.FRAME.get())
//                .define('B', ModItems.sMotor)
//                .define('C', Tags.Items.DUSTS_REDSTONE)
//                .define('D', ModBlocks.ELECTRIC_PUMP.get())
//                .define('E', Items.HOPPER)
//                .define('F', ModBlocks.BARREL.get())
//                .pattern("ABA")
//                .pattern("CDE")
//                .pattern("AFA")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.STORAGE_CHEST.get(), 1)
//                .define('#', ModBlocks.SCAFFOLD.get())
//                .define('A', Tags.Items.CHESTS)
//                .pattern("AAA")
//                .pattern("AAA")
//                .pattern("# #")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.TURBINE_PILLAR.get(), 6)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('A', ModBlocks.ENERGYCABLE_LV.get())
//                .pattern("#A#")
//                .pattern("#A#")
//                .pattern("#A#")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.WIND_TURBINE.get(), 1)
//                .define('#', Tags.Items.INGOTS_IRON)
//                .define('A', ModItems.sMotor)
//                .define('B', ModBlocks.ENERGYCABLE_LV.get())
//                .define('C', STEEL_ROD)
//                .pattern(" # ")
//                .pattern("#AC")
//                .pattern(" B ")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.windBlade, 1)
//                .define('A', Tags.Items.INGOTS_IRON)
//                .define('B', STEEL_ROD)
//                .define('C', STEEL_INGOT)
//                .pattern("ABA")
//                .pattern("BCB")
//                .pattern("ABA")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.drillSteel, 1)
//                .define('A', STEEL_ROD)
//                .define('B', STEEL_INGOT)
//                .pattern(" A ")
//                .pattern(" A ")
//                .pattern("BBB")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.drillDiamond, 1)
//                .define('A', STEEL_ROD)
//                .define('B', STEEL_INGOT)
//                .define('C', Items.DIAMOND)
//                .pattern(" A ")
//                .pattern(" B ")
//                .pattern("CBC")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.drillDeep, 1)
//                .define('A', STEEL_INGOT)
//                .define('B', STEEL_BLOCKS)
//                .define('C', Items.DIAMOND_BLOCK)
//                .pattern(" B ")
//                .pattern("ABA")
//                .pattern("C C")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.BATTERYBANK.get(), 1)
//                .define('A', Tags.Items.INGOTS_IRON)
//                .define('B', ModItems.battery)
//                .define('D', Tags.Items.DUSTS_REDSTONE)
//                .pattern("ABA")
//                .pattern("BBB")
//                .pattern("ADA")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.TRASH.get(), 1)
//                .define('A', Tags.Items.INGOTS_IRON)
//                .define('B', Items.HOPPER)
//                .define('C', ModBlocks.FLUID_PIPE.get())
//                .define('D', Items.ENDER_PEARL)
//                .define('E', ModBlocks.ENERGYCABLE_LV.get())
//                .pattern("ABA")
//                .pattern("CDE")
//                .pattern("AAA")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.ELECTRIC_PUMP.get(), 1)
//                .define('A', Tags.Items.INGOTS_IRON)
//                .define('B', ModBlocks.FLUID_PIPE.get())
//                .define('C', ModItems.sMotor)
//                .define('D', IRON_ROD)
//                .pattern(" BA")
//                .pattern("CDA")
//                .pattern(" BA")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.LOCKER.get(), 1)
//                .define('A', IRON_ROD)
//                .define('B', Tags.Items.CHESTS)
//                .pattern(" A ")
//                .pattern("ABA")
//                .pattern(" A ")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CONCRETE, 8)
//                .define('A', Tags.Items.GRAVEL)
//                .define('B', Tags.Items.SAND)
//                .pattern("BAB")
//                .pattern("A A")
//                .pattern("BAB")
//                .unlockedBy("has_item", has(Tags.Items.SAND))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CONCRETEWALL.get(), 8)
//                .define('A', ModBlocks.CONCRETE)
//                .pattern("AAA")
//                .pattern("AAA")
//                .unlockedBy("has_item", has(ModBlocks.CONCRETE))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.LATHE.get(), 1)
//                .define('A', Tags.Items.INGOTS_IRON)
//                .define('B', ModItems.sMotor)
//                .define('C', STEEL_INGOT)
//                .define('D', ModBlocks.BATTERYBANK.get())
//                .pattern("AAA")
//                .pattern("BCC")
//                .pattern("ADA")
//                .unlockedBy("has_item", has(STEEL_INGOT))
//                .save(consumer);
//        //super.buildShapelessRecipes(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.PILLAR.get(), 16)
//                .define('A', Tags.Items.INGOTS_IRON)
//                .define('B', IRON_ROD)
//                .pattern("BAB")
//                .pattern("BAB")
//                .pattern("BAB")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.PILLAR_STEEL.get(), 16)
//                .define('A', STEEL_INGOT)
//                .define('B', STEEL_ROD)
//                .pattern("BAB")
//                .pattern("BAB")
//                .pattern("BAB")
//                .unlockedBy("has_item", has(STEEL_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.BRACE.get(), 16)
//                .define('A', Tags.Items.INGOTS_IRON)
//                .define('B', IRON_ROD)
//                .pattern("AB ")
//                .pattern("BAB")
//                .pattern(" BA")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.BRACE_STEEL.get(), 16)
//                .define('A', STEEL_INGOT)
//                .define('B', STEEL_ROD)
//                .pattern("AB ")
//                .pattern("BAB")
//                .pattern(" BA")
//                .unlockedBy("has_item", has(STEEL_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.COLUMN.get(), 16)
//                .define('A', IRON_ROD)
//                .define('B', Tags.Items.INGOTS_IRON)
//                .pattern("AAA")
//                .pattern("BBB")
//                .pattern("AAA")
//                .unlockedBy("has_item", has(Items.IRON_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.COLUMN_STEEL.get(), 16)
//                .define('A', STEEL_ROD)
//                .define('B', STEEL_INGOT)
//                .pattern("AAA")
//                .pattern("BBB")
//                .pattern("AAA")
//                .unlockedBy("has_item", has(STEEL_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CATWALK.get(), 6)
//                .define('A', Items.IRON_BARS)
//                .define('B', IRON_ROD)
//                .pattern("B B")
//                .pattern("AAA")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CATWALK_STEEL.get(), 6)
//                .define('A', Items.IRON_BARS)
//                .define('B', STEEL_ROD)
//                .pattern("B B")
//                .pattern("AAA")
//                .unlockedBy("has_item", has(STEEL_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CATWALK_STAIR.get(), 6)
//                .define('A', Items.IRON_BARS)
//                .define('B', IRON_ROD)
//                .pattern("ABB")
//                .pattern(" AB")
//                .pattern("  A")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CATWALK_STAIR_STEEL.get(), 6)
//                .define('A', Items.IRON_BARS)
//                .define('B', STEEL_ROD)
//                .pattern("ABB")
//                .pattern(" AB")
//                .pattern("  A")
//                .unlockedBy("has_item", has(STEEL_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.HANDRAIL.get(), 4)
//                .define('A', IRON_ROD)
//                .pattern("AA")
//                .pattern("AA")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.HANDRAIL_STEEL.get(), 4)
//                .define('A', STEEL_ROD)
//                .pattern("AA")
//                .pattern("AA")
//                .unlockedBy("has_item", has(STEEL_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CATWALK_LADDER.get(), 6)
//                .define('A', IRON_ROD)
//                .define('B', Items.LADDER)
//                .pattern("A A")
//                .pattern("ABA")
//                .pattern("A A")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CATWALK_LADDER_STEEL.get(), 6)
//                .define('A', STEEL_ROD)
//                .define('B', Items.LADDER)
//                .pattern("A A")
//                .pattern("ABA")
//                .pattern("A A")
//                .unlockedBy("has_item", has(STEEL_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.FRAME.get(), 6)
//                .define('A', IRON_ROD)
//                .define('B', STEEL_INGOT)
//                .pattern("ABA")
//                .pattern(" B ")
//                .pattern("ABA")
//                .unlockedBy("has_item", has(STEEL_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.PLATFORM.get(), 4)
//                .define('A', IRON_ROD)
//                .define('B', ItemTags.PLANKS)
//                .define('C', ModBlocks.PILLAR.get())
//                .pattern("A A")
//                .pattern("ABA")
//                .pattern(" C ")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.SCAFFOLD.get(), 12)
//                .define('A', IRON_ROD)
//                .define('B', ItemTags.PLANKS)
//                .pattern("ABA")
//                .pattern("A A")
//                .pattern("A A")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CATWALK_GATE.get(), 2)
//                .define('A', IRON_ROD)
//                .define('B', Tags.Items.INGOTS_IRON)
//                .pattern("ABA")
//                .pattern("ABA")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapelessRecipeBuilder.shapeless(ModBlocks.CATWALK_HATCH.get(), 1)
//                .requires(Items.IRON_TRAPDOOR)
//                .requires(Items.LADDER)
//                .unlockedBy("has_item", has(Tags.Items.INGOTS_IRON))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.BIG_FENCE_COLUMN.get(), 6)
//                .define('A', STEEL_INGOT)
//                .define('B', IRON_ROD)
//                .pattern("ABA")
//                .pattern("ABA")
//                .pattern("ABA")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.BIG_FENCE_WIRE.get(), 6)
//                .define('A', STEEL_INGOT)
//                .define('B', IRON_ROD)
//                .pattern(" B ")
//                .pattern(" B ")
//                .pattern("BAB")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.ELECTRIC_FENCE.get(), 6)
//                .define('A', IRON_ROD)
//                .define('B', STEEL_ROD)
//                .pattern("ABA")
//                .pattern("ABA")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.ELECTRIC_GATE.get(), 4)
//                .define('A', STEEL_ROD)
//                .define('B', Tags.Items.INGOTS_IRON)
//                .pattern("ABA")
//                .pattern("ABA")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.RAZOR_WIRE.get(), 6)
//                .define('A', Tags.Items.RODS_WOODEN)
//                .define('B', Tags.Items.NUGGETS_IRON)
//                .define('C', IRON_ROD)
//                .pattern("B B")
//                .pattern("CCC")
//                .pattern("ABA")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//
//        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT.get(), 1)
//                .requires(Tags.Items.DUSTS_GLOWSTONE)
//                .requires(Tags.Items.INGOTS_IRON)
//                .requires(Tags.Items.GLASS_PANES)
//                .unlockedBy("has_item", has(Tags.Items.DUSTS_GLOWSTONE))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.FLUORESCENT.get(), 4)
//                .define('A', IRON_ROD)
//                .define('B', Blocks.GLOWSTONE)
//                .define('C', Tags.Items.GLASS_PANES)
//                .pattern(" A ")
//                .pattern("CBC")
//                .unlockedBy("has_item", has(Tags.Items.DUSTS_GLOWSTONE))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.DAM_INTAKE.get(), 1)
//                .define('A', ModBlocks.CONCRETE.getBlock())
//                .define('B', Items.IRON_BARS)
//                .pattern("AAA")
//                .pattern("  B")
//                .pattern("AAA")
//                .unlockedBy("has_item", has(ModBlocks.HIGH_PRESSURE_PIPE.get()))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.DAM_OUTLET.get(), 1)
//                .define('A', ModBlocks.CONCRETE.getBlock())
//                .define('B', Items.IRON_BARS)
//                .pattern("AAA")
//                .pattern("B  ")
//                .pattern("AAA")
//                .unlockedBy("has_item", has(ModBlocks.HIGH_PRESSURE_PIPE.get()))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.HIGH_PRESSURE_PIPE.get(), 2)
//                .define('A', STEEL_INGOT)
//                .define('B', ModBlocks.FLUID_PIPE.get())
//                .pattern("ABA")
//                .pattern("B B")
//                .pattern("ABA")
//                .unlockedBy("has_item", has(STEEL_INGOT))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.DAM_TURBINE.get(), 1)
//                .define('A', STEEL_BLOCKS)
//                .define('B', STEEL_ROD)
//                .define('C', ModItems.sMotor)
//                .define('D', ModBlocks.HIGH_PRESSURE_PIPE.get())
//                .pattern("ABA")
//                .pattern("DBA")
//                .pattern("ACD")
//                .unlockedBy("has_item", has(ModBlocks.HIGH_PRESSURE_PIPE.get()))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.DAM_GENERATOR.get(), 1)
//                .define('A', STEEL_INGOT)
//                .define('C', STEEL_ROD)
//                .define('B', ModItems.sMotor)
//                .define('D', STEEL_BLOCKS)
//                .pattern("ACA")
//                .pattern("ABA")
//                .pattern("DBD")
//                .unlockedBy("has_item", has(ModBlocks.HIGH_PRESSURE_PIPE.get()))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.ROTATIONAL_SHAFT.get(), 9)
//                .define('A', STEEL_BLOCKS)
//                .pattern("A")
//                .pattern("A")
//                .pattern("A")
//                .unlockedBy("has_item", has(STEEL_BLOCKS))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CARGO_LOADER.get(), 1)
//                .define('A', Items.HOPPER)
//                .define('B', ModBlocks.FRAME.get())
//                .define('C', IRON_ROD)
//                .define('D', ModItems.sMotor)
//                .define('E', Tags.Items.DUSTS_REDSTONE)
//                .pattern("ABC")
//                .pattern("DBE")
//                .pattern("ABC")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.FLUID_LOADER.get(), 1)
//                .define('A', Items.HOPPER)
//                .define('B', ModBlocks.FRAME.get())
//                .define('C', IRON_ROD)
//                .define('D', ModItems.sMotor)
//                .define('E', Tags.Items.DUSTS_REDSTONE)
//                .define('F', ModBlocks.FLUID_TANK.get())
//                .pattern("ABC")
//                .pattern("DBE")
//                .pattern("FBC")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.BOOSTER_RAIL.get(), 1)
//                .define('A', Tags.Items.INGOTS_GOLD)
//                .define('B', Tags.Items.RODS_WOODEN)
//                .define('C', Tags.Items.DUSTS_REDSTONE)
//                .pattern("ABA")
//                .pattern("ACA")
//                .pattern("ACA")
//                .unlockedBy("has_item", has(Tags.Items.INGOTS_GOLD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.CONVEYOR.get(), 8)
//                .define('A', Tags.Items.LEATHER)
//                .define('B', IRON_ROD)
//                .define('C', ModItems.sMotor)
//                .define('D', Tags.Items.INGOTS_IRON)
//                .pattern("AAA")
//                .pattern("BBC")
//                .pattern("DDD")
//                .unlockedBy("has_item", has(Tags.Items.INGOTS_IRON))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.INDUSTRIAL_FLOOR.get(), 6)
//                .define('A', Items.IRON_BARS)
//                .define('B', Tags.Items.INGOTS_IRON)
//                .pattern("AAA")
//                .pattern("   ")
//                .pattern("BBB")
//                .unlockedBy("has_item", has(Tags.Items.INGOTS_IRON))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.cartLinkable, 1)
//                .define('A', Tags.Items.INGOTS_IRON)
//                .define('B', STEEL_INGOT)
//                .define('C', Tags.Items.NUGGETS_IRON)
//                .pattern("AB")
//                .pattern("AC")
//                .pattern("A ")
//                .unlockedBy("has_item", has(STEEL_INGOT))
//                .save(consumer);
//
//        ShapelessRecipeBuilder.shapeless(ModItems.flatCart, 1)
//                .requires(Items.SMOOTH_STONE_SLAB)
//                .requires(Items.MINECART)
//                .unlockedBy("has_item", has(Items.MINECART))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.cargoContainer, 1)
//                .define('A', ModItems.flatCart)
//                .define('B', Tags.Items.CHESTS)
//                .pattern("B")
//                .pattern("A")
//                .unlockedBy("has_item", has(ModItems.flatCart))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.passengerCar, 1)
//                .define('A', ModItems.flatCart)
//                .define('B', ItemTags.CARPETS)
//                .define('C', ItemTags.PLANKS)
//                .define('D', Tags.Items.RODS_WOODEN)
//                .define('E', ItemTags.WOODEN_SLABS)
//                .pattern("EEE")
//                .pattern("DBD")
//                .pattern("CAC")
//                .unlockedBy("has_item", has(ModItems.flatCart))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.passengerCartMk2, 1)
//                .define('A', ModItems.flatCart)
//                .define('B', ItemTags.CARPETS)
//                .define('C', Tags.Items.INGOTS_IRON)
//                .pattern("CCC")
//                .pattern("CBC")
//                .pattern("CAC")
//                .unlockedBy("has_item", has(ModItems.flatCart))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModItems.fluidContainer, 1)
//                .define('A', ModItems.flatCart)
//                .define('B', ModBlocks.BARREL.get())
//                .define('C', Tags.Items.INGOTS_IRON)
//                .pattern("BBB")
//                .pattern("CAC")
//                .unlockedBy("has_item", has(ModItems.flatCart))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.SPANEL_FRAME.get(), 1)
//                .define('A', IRON_ROD)
//                .define('B', ModItems.battery)
//                .define('C', ModBlocks.ENERGYCABLE_LV.get())
//                .pattern("A  ")
//                .pattern("AA ")
//                .pattern("CBA")
//                .unlockedBy("has_item", has(IRON_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.HV_ISOLATOR.get(), 1)
//                .define('A', STEEL_ROD)
//                .define('B', STEEL_INGOT)
//                .pattern("A")
//                .pattern("B")
//                .unlockedBy("has_item", has(STEEL_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.TRANSFORMER.get(), 1)
//                .define('A', STEEL_INGOT)
//                .define('B', ModItems.battery_lithium.getItem())
//                .define('C', STEEL_ROD)
//                .pattern("ACA")
//                .pattern("BBB")
//                .pattern("BBB")
//                .unlockedBy("has_item", has(STEEL_ROD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.FLUID_VALVE.get(), 1)
//                .define('A', Items.LEVER)
//                .define('B', ModBlocks.HIGH_PRESSURE_PIPE.get())
//                .define('C', Blocks.IRON_TRAPDOOR)
//                .pattern(" A ")
//                .pattern("BCB")
//                .pattern(" A ")
//                .unlockedBy("has_item", has(ModBlocks.HIGH_PRESSURE_PIPE.get()))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(ModBlocks.ENERGY_SWITCH.get(), 1)
//                .define('A', Items.LEVER)
//                .define('B', ModBlocks.ENERGYCABLE_HV.get())
//                .define('C', Tags.Items.STORAGE_BLOCKS_REDSTONE)
//                .pattern(" A ")
//                .pattern("BCB")
//                .pattern(" A ")
//                .unlockedBy("has_item", has(ModBlocks.ENERGYCABLE_HV.get()))
//                .save(consumer);
//    }
//}
