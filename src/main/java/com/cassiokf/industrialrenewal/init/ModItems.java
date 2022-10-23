package com.cassiokf.industrialrenewal.init;

import com.cassiokf.industrialrenewal.IndustrialRenewal;
import com.cassiokf.industrialrenewal.items.IRBaseItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, IndustrialRenewal.MODID);

//    public static final IRBaseItem pointer;
    public static final RegistryObject<Item> pointer = registerItem("pointer", IRBaseItem::new);
    public static final RegistryObject<Item> limiter = registerItem("limiter", IRBaseItem::new);
    public static final RegistryObject<Item> pointerLong = registerItem("pointer_long", IRBaseItem::new);
    public static final RegistryObject<Item> fire = registerItem("fire", IRBaseItem::new);
    public static final RegistryObject<Item> barLevel = registerItem("bar_level", IRBaseItem::new);
    public static final RegistryObject<Item> fluidLoaderArm = registerItem("fluid_loader_arm", IRBaseItem::new);
    public static final RegistryObject<Item> tambor = registerItem("rotary_drum", IRBaseItem::new);
    public static final RegistryObject<Item> cutter = registerItem("lathecutter", IRBaseItem::new);
    public static final RegistryObject<Item> indicator_on = registerItem("indicator_on", IRBaseItem::new);
    public static final RegistryObject<Item> indicator_off = registerItem("indicator_off", IRBaseItem::new);
    public static final RegistryObject<Item> switch_on = registerItem("switch_on", IRBaseItem::new);
    public static final RegistryObject<Item> switch_off = registerItem("switch_off", IRBaseItem::new);
    public static final RegistryObject<Item> push_button = registerItem("push_button", IRBaseItem::new);
    public static final RegistryObject<Item> label_5 = registerItem("label_5", IRBaseItem::new);

    public static void register(final IForgeRegistry<Item> registry) {
        for (Item item : IndustrialRenewal.registeredIRItems) {
            registry.register(item);
        }
    }

    private static <T extends Item>RegistryObject<T> registerItem(String name, Supplier<T> item) {
        RegistryObject<T> toReturn = ITEMS.register(name, item);
        return toReturn;
    }

    public static void registerInit(IEventBus bus){
        ITEMS.register(bus);
    }

}