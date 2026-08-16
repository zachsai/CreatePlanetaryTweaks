package net.celsiusqc.cp_tweaks.fluid;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.celsiusqc.cp_tweaks.block.ModBlocks;
import net.celsiusqc.cp_tweaks.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, CreatePlanetaryTweaks.MOD_ID);

    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_ARACHNARCH_VENOM = FLUIDS.register("arachnarch_venom",
            () -> new BaseFlowingFluid.Source(ModFluids.ARACHNARCH_VENOM_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ARACHNARCH_VENOM = FLUIDS.register("flowing_arachnarch_venom",
            () -> new BaseFlowingFluid.Flowing(ModFluids.ARACHNARCH_VENOM_PROPERTIES));

    public static final BaseFlowingFluid.Properties ARACHNARCH_VENOM_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.ARACHNARCH_VENOM_TYPE::get, SOURCE_ARACHNARCH_VENOM, FLOWING_ARACHNARCH_VENOM)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.ARACHNARCH_VENOM_BLOCK)
            .bucket(ModItems.ARACHNARCH_VENOM_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
