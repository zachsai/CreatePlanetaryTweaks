package net.celsiusqc.cp_tweaks.interact;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.celsiusqc.cp_tweaks.item.ModItems;
import net.celsiusqc.cp_tweaks.item.Tools;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.Optional;
import java.util.Random;

/**
 * Blue Skies integration: strip bark from the Starlit Crusher with the Ice
 * Shard axe. Registry lookup by id, so it is a no-op without Blue Skies.
 */
@EventBusSubscriber(modid = CreatePlanetaryTweaks.MOD_ID)
public class StarlitTreeBarkInteract {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onEntityRightClick(PlayerInteractEvent.EntityInteract event) {
        Level world = event.getLevel();
        Player player = event.getEntity();
        Entity targetEntity = event.getTarget();

        Optional<EntityType<?>> starlitCrusher = BuiltInRegistries.ENTITY_TYPE
                .getOptional(ResourceLocation.parse("blue_skies:starlit_crusher"));

        if (starlitCrusher.isPresent() && targetEntity.getType().equals(starlitCrusher.get())) {
            ItemStack heldItem = event.getItemStack();

            if (heldItem.getItem() instanceof AxeItem && !world.isClientSide) {
                if (heldItem.is(Tools.ICE_SHARD_AXE.get())) {
                    int currentDurability = heldItem.getDamageValue();
                    int damageToApply = RANDOM.nextInt(201) + 300; // 300-500

                    if (currentDurability + damageToApply > heldItem.getMaxDamage()) {
                        if (player instanceof ServerPlayer) {
                            player.displayClientMessage(Component.translatable("message.too_flimsy").withStyle(ChatFormatting.DARK_AQUA), true);
                        }
                        return;
                    }

                    heldItem.hurtAndBreak(damageToApply, player, EquipmentSlot.MAINHAND);
                    int quantity = 1 + RANDOM.nextInt(3);
                    player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 0));
                    ItemStack barkStack = new ItemStack(ModItems.STARLIT_TREE_BARK.get(), quantity);
                    world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.AXE_STRIP, SoundSource.PLAYERS, 1.0F, 1.0F);

                    if (!player.getInventory().add(barkStack)) {
                        player.drop(barkStack, false);
                    }
                } else {
                    if (player instanceof ServerPlayer) {
                        player.displayClientMessage(Component.translatable("message.incorrect_axe").withStyle(ChatFormatting.DARK_AQUA), true);
                    }
                }
            } else if (heldItem.getItem() instanceof PickaxeItem
                    || heldItem.getItem() instanceof ShovelItem
                    || heldItem.getItem() instanceof HoeItem
                    || heldItem.getItem() instanceof SwordItem) {
                if (player instanceof ServerPlayer) {
                    player.displayClientMessage(Component.translatable("message.unsuitable_tool").withStyle(ChatFormatting.RED), true);
                }
            }
        }
    }
}
