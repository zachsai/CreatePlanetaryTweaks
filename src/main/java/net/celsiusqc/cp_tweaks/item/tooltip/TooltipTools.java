package net.celsiusqc.cp_tweaks.item.tooltip;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

/** Tool variants that append "<descriptionId>.tooltip" in yellow. */
public final class TooltipTools {

    private TooltipTools() {
    }

    private static Component line(String descriptionId) {
        return Component.translatable(descriptionId + ".tooltip").withStyle(ChatFormatting.YELLOW);
    }

    public static class Sword extends SwordItem {
        public Sword(Tier tier, Properties properties) {
            super(tier, properties);
        }

        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, context, tooltip, flag);
            tooltip.add(line(getDescriptionId()));
        }
    }

    public static class Axe extends AxeItem {
        public Axe(Tier tier, Properties properties) {
            super(tier, properties);
        }

        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, context, tooltip, flag);
            tooltip.add(line(getDescriptionId()));
        }
    }

    public static class Pickaxe extends PickaxeItem {
        public Pickaxe(Tier tier, Properties properties) {
            super(tier, properties);
        }

        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, context, tooltip, flag);
            tooltip.add(line(getDescriptionId()));
        }
    }

    public static class Shovel extends ShovelItem {
        public Shovel(Tier tier, Properties properties) {
            super(tier, properties);
        }

        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, context, tooltip, flag);
            tooltip.add(line(getDescriptionId()));
        }
    }

    public static class Hoe extends HoeItem {
        public Hoe(Tier tier, Properties properties) {
            super(tier, properties);
        }

        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, context, tooltip, flag);
            tooltip.add(line(getDescriptionId()));
        }
    }
}
