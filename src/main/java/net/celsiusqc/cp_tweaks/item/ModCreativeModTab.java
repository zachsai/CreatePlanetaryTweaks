package net.celsiusqc.cp_tweaks.item;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.celsiusqc.cp_tweaks.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreatePlanetaryTweaks.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CP_TWEAKS_TAB = CREATIVE_MODE_TABS.register("cp_tweaks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VOID_WORM_GU.get()))
                    .title(Component.translatable("creativetab.cp_tweaks_tab"))
                    .displayItems((parameters, output) -> {
                        ModList mods = ModList.get();

                        // Always visible
                        output.accept(ModItems.CREATE_PLANETARY_TWEAKS_LOGO.get());

                        if (mods.isLoaded("create") && mods.isLoaded("ad_astra")) {
                            output.accept(ModItems.UNSTABLE_ICE_SHARD.get());

                            if (mods.isLoaded("alexsmobs") && mods.isLoaded("cataclysm")) {
                                output.accept(ModItems.STABILIZED_FROZEN_GU.get());
                                output.accept(ModItems.STABILIZED_ICE_SHEET.get());
                                output.accept(ModItems.GLACIAN_ENGINE_FAN.get());
                                output.accept(ModItems.GLACIAN_ENGINE_FRAME.get());
                                output.accept(ModItems.FTL_GLACIAN_ENGINE.get());

                                if (mods.isLoaded("twilightforest")) {
                                    output.accept(ModItems.WEIRD_SATELLITE.get());
                                }
                            }
                        }

                        if (mods.isLoaded("blue_skies")) {
                            output.accept(ModItems.ARACHNARCH_VENOM_BOTTLE.get());
                            output.accept(ModItems.ARACHNARCH_VENOM_BUCKET.get());
                            output.accept(ModItems.STARLIT_TREE_BARK.get());
                        }

                        if (mods.isLoaded("create") && mods.isLoaded("alexsmobs")) {
                            output.accept(ModItems.VOID_WORM_GU.get());
                        }

                        if (mods.isLoaded("cataclysm") && mods.isLoaded("create")) {
                            output.accept(ModItems.ENDER_GUARDIAN_GU.get());
                            output.accept(ModItems.MONSTROSITY_GU.get());
                        }

                        if (mods.isLoaded("sereneseasons")) {
                            output.accept(ModItems.AUTUMN.get());
                            output.accept(ModItems.WINTER.get());
                            output.accept(ModItems.SPRING.get());
                            output.accept(ModItems.SUMMER.get());
                            output.accept(ModItems.DRY.get());
                            output.accept(ModItems.WET.get());
                        }

                        if (!mods.isLoaded("create_sa")) {
                            output.accept(Tools.COPPER_AXE.get());
                            output.accept(Tools.COPPER_SWORD.get());
                            output.accept(Tools.COPPER_PICKAXE.get());
                            output.accept(Tools.COPPER_SHOVEL.get());
                            output.accept(Tools.COPPER_HOE.get());
                        }

                        if (mods.isLoaded("create") && !mods.isLoaded("create_sa")) {
                            // Zinc tools
                            output.accept(ZincTools.ZINC_AXE.get());
                            output.accept(ZincTools.ZINC_SWORD.get());
                            output.accept(ZincTools.ZINC_PICKAXE.get());
                            output.accept(ZincTools.ZINC_SHOVEL.get());
                            output.accept(ZincTools.ZINC_HOE.get());

                            // Brass tools
                            output.accept(Tools.BRASS_AXE.get());
                            output.accept(Tools.BRASS_SWORD.get());
                            output.accept(Tools.BRASS_PICKAXE.get());
                            output.accept(Tools.BRASS_SHOVEL.get());
                            output.accept(Tools.BRASS_HOE.get());
                        }

                        if (!mods.isLoaded("alloyed")) {
                            // Steel tools only if Alloyed isn't providing its own
                            output.accept(Tools.STEEL_AXE.get());
                            output.accept(Tools.STEEL_SWORD.get());
                            output.accept(Tools.STEEL_PICKAXE.get());
                            output.accept(Tools.STEEL_SHOVEL.get());
                            output.accept(Tools.STEEL_HOE.get());

                            if (!mods.isLoaded("ad_astra")) {
                                output.accept(ModItems.STEEL_INGOT.get());
                            }
                        }

                        if (mods.isLoaded("create") && mods.isLoaded("alexsmobs")) {
                            output.accept(Tools.VOID_WORM_AXE.get());
                            output.accept(Tools.VOID_WORM_SWORD.get());
                            output.accept(Tools.VOID_WORM_PICKAXE.get());
                            output.accept(Tools.VOID_WORM_SHOVEL.get());
                            output.accept(Tools.VOID_WORM_HOE.get());
                            output.accept(Armor.VOID_WORMED_HELMET.get());
                            output.accept(Armor.VOID_WORMED_CHESTPLATE.get());
                            output.accept(Armor.VOID_WORMED_LEGGINGS.get());
                            output.accept(Armor.VOID_WORMED_BOOTS.get());
                        }

                        if (mods.isLoaded("ad_astra")) {
                            // Desh items
                            output.accept(Tools.DESH_AXE.get());
                            output.accept(Tools.DESH_SWORD.get());
                            output.accept(Tools.DESH_PICKAXE.get());
                            output.accept(Tools.DESH_SHOVEL.get());
                            output.accept(Tools.DESH_HOE.get());
                            output.accept(Armor.DESH_HELMET.get());
                            output.accept(Armor.DESH_CHESTPLATE.get());
                            output.accept(Armor.DESH_LEGGINGS.get());
                            output.accept(Armor.DESH_BOOTS.get());

                            // Calorite items
                            output.accept(Tools.CALORITE_AXE.get());
                            output.accept(Tools.CALORITE_SWORD.get());
                            output.accept(Tools.CALORITE_PICKAXE.get());
                            output.accept(Tools.CALORITE_SHOVEL.get());
                            output.accept(Tools.CALORITE_HOE.get());
                            output.accept(Armor.CALORITE_HELMET.get());
                            output.accept(Armor.CALORITE_CHESTPLATE.get());
                            output.accept(Armor.CALORITE_LEGGINGS.get());
                            output.accept(Armor.CALORITE_BOOTS.get());

                            // Ostrum items
                            output.accept(Tools.OSTRUM_AXE.get());
                            output.accept(Tools.OSTRUM_SWORD.get());
                            output.accept(Tools.OSTRUM_PICKAXE.get());
                            output.accept(Tools.OSTRUM_SHOVEL.get());
                            output.accept(Tools.OSTRUM_HOE.get());
                            output.accept(Armor.OSTRUM_HELMET.get());
                            output.accept(Armor.OSTRUM_CHESTPLATE.get());
                            output.accept(Armor.OSTRUM_LEGGINGS.get());
                            output.accept(Armor.OSTRUM_BOOTS.get());

                            output.accept(ModItems.REINFORCED_ROCKET_FIN.get());
                        }

                        if (mods.isLoaded("ad_astra") && mods.isLoaded("create")) {
                            // Ice Shard armor
                            output.accept(Armor.ICE_SHARD_HELMET.get());
                            output.accept(Armor.ICE_SHARD_CHESTPLATE.get());
                            output.accept(Armor.ICE_SHARD_LEGGINGS.get());
                            output.accept(Armor.ICE_SHARD_BOOTS.get());

                            // Ice Shard tools
                            output.accept(Tools.ICE_SHARD_AXE.get());
                            output.accept(Tools.ICE_SHARD_SWORD.get());
                            output.accept(Tools.ICE_SHARD_PICKAXE.get());
                            output.accept(Tools.ICE_SHARD_SHOVEL.get());
                            output.accept(Tools.ICE_SHARD_HOE.get());

                            if (mods.isLoaded("twilightforest")) {
                                output.accept(Tools.GIANT_ICE_SHARD_SWORD.get());
                                output.accept(Tools.GIANT_ICE_SHARD_AXE.get());
                            }
                        }

                        if (mods.isLoaded("cataclysm") && mods.isLoaded("create")) {
                            output.accept(ModItems.STURDY_DESH_SHEET.get());
                            output.accept(ModItems.IGNITIUM_SHEET.get());

                            if (mods.isLoaded("ad_astra")) {
                                output.accept(ModItems.STURDY_OSTRUM_SHEET.get());
                                output.accept(ModItems.IGNITIUM_ENGINE.get());
                                output.accept(ModItems.REINFORCED_ROCKET_NOSE_CONE.get());
                            }
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
