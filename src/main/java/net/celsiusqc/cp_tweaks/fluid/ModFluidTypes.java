package net.celsiusqc.cp_tweaks.fluid;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.FastColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

public class ModFluidTypes {

    public static final ResourceLocation ARACHNARCH_VENOM_STILL_RL =
            ResourceLocation.fromNamespaceAndPath(CreatePlanetaryTweaks.MOD_ID, "block/fluid/arachnarch_venom/still");
    public static final ResourceLocation ARACHNARCH_VENOM_FLOWING_RL =
            ResourceLocation.fromNamespaceAndPath(CreatePlanetaryTweaks.MOD_ID, "block/fluid/arachnarch_venom/flowing");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, CreatePlanetaryTweaks.MOD_ID);

    public static final DeferredHolder<FluidType, VenomFluidType> ARACHNARCH_VENOM_TYPE = FLUID_TYPES.register("arachnarch_venom_fluid",
            () -> new VenomFluidType(
                    ARACHNARCH_VENOM_STILL_RL,
                    ARACHNARCH_VENOM_FLOWING_RL,
                    ARACHNARCH_VENOM_FLOWING_RL,
                    0xFFFFFFFF,
                    colorVecFromHex(0x3F2F96),
                    FluidType.Properties.create()
                            .lightLevel(15)
                            .density(15)
                            .viscosity(1)
                            .canSwim(false)
                            .canHydrate(false)
                            .canConvertToSource(false)
                            .canPushEntity(true)
                            .temperature(9000)
                            .supportsBoating(true)
                            .canDrown(false)
                            .sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

    static Vector3f colorVecFromHex(int color) {
        return new Vector3f(FastColor.ARGB32.red(color) / 255f, FastColor.ARGB32.green(color) / 255f, FastColor.ARGB32.blue(color) / 255f);
    }
}
