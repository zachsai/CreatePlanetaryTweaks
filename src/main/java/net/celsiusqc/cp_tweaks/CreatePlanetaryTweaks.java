package net.celsiusqc.cp_tweaks;

import net.celsiusqc.cp_tweaks.base.block.ModBlocks;
import net.celsiusqc.cp_tweaks.fluid.ModFluidTypes;
import net.celsiusqc.cp_tweaks.fluid.ModFluids;
import net.celsiusqc.cp_tweaks.item.*;
import net.celsiusqc.cp_tweaks.loot.ModLootModifiers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreatePlanetaryTweaks.MOD_ID)
public class CreatePlanetaryTweaks {


    public static final String MOD_ID = "cp_tweaks";
    public static final String ARMOR_DIR = MOD_ID + ":textures/models/armor/";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public CreatePlanetaryTweaks() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTab.register(modEventBus);
        modEventBus.addListener(this::setup);
        ModItems.register(modEventBus);
        Tools.register(modEventBus);
        Armor.register(modEventBus);
        ZincTools.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        //ModEntities.register(modEventBus); //////////////////////////////////// DISABLED CUSTOM ENTITY FROM TWILIGHT FOREST RENDERER //////////////////////////////////////////////

        // Soft dependency: only touch GeckoLib classes if it's actually loaded.
        if (ModList.get().isLoaded("geckolib")) {
            net.celsiusqc.cp_tweaks.compat.geckolib.GeckoLibCompat.initialize();
        }



        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }



    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void setup(final FMLCommonSetupEvent event) {
        // existing common setup...

        // additional setup, if any...
    }

//    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)                   //////////////////////////////////// DISABLED CUSTOM ENTITY FROM TWILIGHT FOREST RENDERER //////////////////////////////////////////////
//    public static class ModEvents {
//        @SubscribeEvent
//        public static void onAttributeCreate(EntityAttributeCreationEvent event) {
//            // This is where you would register your StarviewerGiant's attributes.
//            event.put(ModEntities.STARVIEWER_GIANT.get(), StarviewerGiant.createAttributes().build());
//        }
//
//        // other mod event subscribers...
//    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

}