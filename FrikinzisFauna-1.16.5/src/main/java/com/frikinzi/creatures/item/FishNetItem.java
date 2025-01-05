package com.frikinzi.creatures.item;

import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.entity.base.FishBase;
import com.frikinzi.creatures.entity.base.GroupFishBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class FishNetItem extends Item {

    public FishNetItem(Properties p_i48465_4_) {
        super(p_i48465_4_);
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
        if (target instanceof FishBase) {
            if (stack.hasTag()) {
                player.displayClientMessage(new TranslationTextComponent("creatures.message.fishingnet.full"), true);
                return ActionResultType.PASS;
            } else {
                FishBase fish = (FishBase) target;
                if (player.level.isClientSide) return ActionResultType.SUCCESS;
                CompoundNBT tags = new CompoundNBT();
                fish.save(tags);
                ResourceLocation key = EntityType.getKey(target.getType());
                tags.putString("id", key.toString());
                tags.putInt("Variant", fish.getVariant());
                tags.putInt("SubVariant", fish.getSubVariant());
                tags.putFloat("SizeMultiplier", fish.getHeightMultiplier());
                if (target.hasCustomName()) tags.putString("DisplayName", fish.getDisplayName().getString());
                tags.putString("Species", fish.getSpeciesName());
                target.remove();
                player.displayClientMessage(new TranslationTextComponent("creatures.message.fishingnet.retrieve"), true);
                ItemStack newStack = new ItemStack(this);
                newStack.setTag(tags);
                player.setItemInHand(hand, newStack);

            }
        }        if (target instanceof GroupFishBase) {
            if (stack.hasTag()) {
                player.displayClientMessage(new TranslationTextComponent("creatures.message.fishingnet.full"), true);
                return ActionResultType.PASS;
            } else {
                GroupFishBase fish = (GroupFishBase) target;
                if (player.level.isClientSide) return ActionResultType.SUCCESS;
                CompoundNBT tags = new CompoundNBT();
                fish.save(tags);
                ResourceLocation key = EntityType.getKey(target.getType());
                tags.putString("id", key.toString());
                tags.putInt("Variant", fish.getVariant());
                tags.putInt("SubVariant", fish.getSubVariant());
                tags.putFloat("SizeMultiplier", fish.getHeightMultiplier());
                if (target.hasCustomName()) tags.putString("DisplayName", fish.getDisplayName().getString());
                tags.putString("Species", fish.getSpeciesName());
                target.remove();
                player.displayClientMessage(new TranslationTextComponent("creatures.message.fishingnet.retrieve"), true);
                ItemStack newStack = new ItemStack(this);
                newStack.setTag(tags);
                player.setItemInHand(hand, newStack);

            }
        }
        return ActionResultType.SUCCESS;
    }

    public ActionResultType useOn(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getLevel();
        ItemStack item = context.getItemInHand();
        if (!item.hasTag()) {
            player.displayClientMessage(new TranslationTextComponent("creatures.message.fishingnet.empty"), true);
            return ActionResultType.PASS;
        }
        if (!world.isClientSide) {
            BlockPos blockPos = new BlockPos(context.getClickedPos()).relative(context.getClickedFace());
            CompoundNBT tags;
            tags = item.getTag();
            Entity entity = EntityType.loadEntityRecursive(tags, world, entity1 -> entity1);

            if (entity instanceof FishBase) {
                entity.absMoveTo(blockPos.getX() + 0.5D, blockPos.getY(), blockPos.getZ() + 0.5D, context.getRotation(), 0);
                entity.setUUID(tags.getUUID("UUID"));
                world.addFreshEntity(entity);

                player.setItemInHand(context.getHand(), new ItemStack(this));
                player.displayClientMessage(new TranslationTextComponent("creatures.message.fishingnet.released"), true);
            }
            if (entity instanceof GroupFishBase) {
                entity.absMoveTo(blockPos.getX() + 0.5D, blockPos.getY(), blockPos.getZ() + 0.5D, context.getRotation(), 0);
                entity.setUUID(tags.getUUID("UUID"));
                world.addFreshEntity(entity);

                player.setItemInHand(context.getHand(), new ItemStack(this));
                player.displayClientMessage(new TranslationTextComponent("creatures.message.fishingnet.released"), true);
            }

        }
        return ActionResultType.SUCCESS;

    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (stack.hasTag()) {
            tooltip.add(new TranslationTextComponent(stack.getTag().getString("Species")).withStyle(TextFormatting.ITALIC, TextFormatting.GRAY));
        }
    }
}
