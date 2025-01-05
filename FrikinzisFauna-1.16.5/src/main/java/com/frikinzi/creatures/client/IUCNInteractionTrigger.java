package com.frikinzi.creatures.client;

import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.*;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.util.ResourceLocation;

public class IUCNInteractionTrigger extends AbstractCriterionTrigger<IUCNInteractionTrigger.Instance> {
    public static final ResourceLocation ID = new ResourceLocation("creatures", "interact_with_endangered");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity p_204817_1_, ItemStack p_204817_2_,LivingEntity p_241476_3_) {
        this.trigger(p_204817_1_, instance -> instance.matches(p_241476_3_, p_204817_2_.getItem()));
    }

    public IUCNInteractionTrigger.Instance createInstance(JsonObject p_230241_1_, EntityPredicate.AndPredicate p_230241_2_, ConditionArrayParser p_230241_3_) {
        ItemPredicate itempredicate = ItemPredicate.fromJson(p_230241_1_.get("item"));
        return new IUCNInteractionTrigger.Instance(p_230241_2_, itempredicate);
    }

    public static class Instance extends CriterionInstance {
        private final ItemPredicate item;

        public Instance(EntityPredicate.AndPredicate entityPredicate, ItemPredicate item) {
            super(IUCNInteractionTrigger.ID, entityPredicate);
            this.item = item;
        }

        public boolean matches(LivingEntity entity, Item usedItem) {
            return entity instanceof CreaturesBirdEntity && ((CreaturesBirdEntity) entity).getIUCNStatus() == 3 && this.item.matches(new ItemStack(usedItem));
        }
    }
}
