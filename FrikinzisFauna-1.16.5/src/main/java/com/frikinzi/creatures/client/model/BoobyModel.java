package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.BoobyEntity;
import com.frikinzi.creatures.entity.PelicanEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BoobyModel extends AnimatedGeoModel<BoobyEntity> {
    @Override
    public ResourceLocation getModelLocation(BoobyEntity object)
    {
        if (object.isFlying() && !object.isInWater()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/booby/boobyfly.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/booby/booby.geo.json");
    }


    @Override
    public ResourceLocation getTextureLocation(BoobyEntity object)
    {
        if (object.isFlying() && !object.isInWater()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/booby/booby" + object.getVariant() + object.getGenderName() + "fly.png");
        }
        if (object.isSleeping()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/booby/booby" + object.getVariant() + object.getGenderName() + "sleep.png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/booby/booby" + object.getVariant() + object.getGenderName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BoobyEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.booby.json");
    }
}
