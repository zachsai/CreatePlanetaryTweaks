package net.celsiusqc.cp_tweaks;

import net.celsiusqc.cp_tweaks.base.ModArmorMaterials;
import net.celsiusqc.cp_tweaks.block.ModBlocks;
import net.celsiusqc.cp_tweaks.fluid.ModFluidTypes;
import net.celsiusqc.cp_tweaks.fluid.ModFluids;
import net.celsiusqc.cp_tweaks.item.Armor;
import net.celsiusqc.cp_tweaks.item.ModCreativeModTab;
import net.celsiusqc.cp_tweaks.item.ModItems;
import net.celsiusqc.cp_tweaks.item.Tools;
import net.celsiusqc.cp_tweaks.item.ZincTools;
import net.celsiusqc.cp_tweaks.loot.ModLootModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CreatePlanetaryTweaks.MOD_ID)
public class CreatePlanetaryTweaks {

    public static final String MOD_ID = "cp_tweaks";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public CreatePlanetaryTweaks(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeModTab.register(modEventBus);
        ModArmorMaterials.register(modEventBus);
        ModItems.register(modEventBus);
        Tools.register(modEventBus);
        Armor.register(modEventBus);
        ZincTools.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModLootModifiers.register(modEventBus);
    }
}
