package net.celsiusqc.cp_tweaks.interact;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.celsiusqc.cp_tweaks.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.Optional;
import java.util.Random;

/**
 * Blue Skies integration: bottle venom from the Arachnarch. Uses a registry
 * lookup by id, so it is a no-op when Blue Skies isn't installed.
 */
@EventBusSubscriber(modid = CreatePlanetaryTweaks.MOD_ID)
public class ArachnarchVenomInteract {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onEntityRightClick(PlayerInteractEvent.EntityInteract event) {
        Level world = event.getLevel();
        Player player = event.getEntity();
        Entity targetEntity = event.getTarget();

        Optional<EntityType<?>> arachnarch = BuiltInRegistries.ENTITY_TYPE
                .getOptional(ResourceLocation.parse("blue_skies:arachnarch"));

        if (arachnarch.isPresent() && targetEntity.getType().equals(arachnarch.get())) {
            ItemStack heldItem = event.getItemStack();

            if (heldItem.getItem() == Items.GLASS_BOTTLE) {
                event.setCanceled(true);

                if (!world.isClientSide) {
                    boolean gotVenomBottle = RANDOM.nextFloat() < 0.33;

                    if (!player.isCreative()) {
                        heldItem.shrink(1);
                    }

                    if (gotVenomBottle) {
                        ItemStack venomBottle = new ItemStack(ModItems.ARACHNARCH_VENOM_BOTTLE.get());
                        if (!player.getInventory().add(venomBottle)) {
                            player.drop(venomBottle, false);
                        }
                        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.PLAYERS, 1.0F, 1.0F);
                    } else {
                        player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));
                        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_HURT, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }

                    event.setCancellationResult(InteractionResult.CONSUME);
                }
            }
        }
    }
}
