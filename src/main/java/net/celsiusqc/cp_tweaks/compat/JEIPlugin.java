package net.celsiusqc.cp_tweaks.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.celsiusqc.cp_tweaks.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/** Only instantiated by JEI itself — inert when JEI isn't installed. */
@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(CreatePlanetaryTweaks.MOD_ID, "enchantment");
    }

    @Override
    public void registerRecipes(IRecipeRegistration reg) {
        reg.addIngredientInfo(new ItemStack(ModItems.VOID_WORM_GU.get()), VanillaTypes.ITEM_STACK, Component.translatable("info.celsiusqc.void_worm_gu"));
        reg.addIngredientInfo(new ItemStack(ModItems.MONSTROSITY_GU.get()), VanillaTypes.ITEM_STACK, Component.translatable("info.celsiusqc.monstrosity_gu"));
        reg.addIngredientInfo(new ItemStack(ModItems.ENDER_GUARDIAN_GU.get()), VanillaTypes.ITEM_STACK, Component.translatable("info.celsiusqc.ender_guardian_gu"));
        reg.addIngredientInfo(new ItemStack(ModItems.UNSTABLE_ICE_SHARD.get()), VanillaTypes.ITEM_STACK, Component.translatable("info.celsiusqc.unstable_ice_shard"));
    }
}
