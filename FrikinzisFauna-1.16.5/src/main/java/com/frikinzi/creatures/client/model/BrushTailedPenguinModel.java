package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.BandedPenguinEntity;
import com.frikinzi.creatures.entity.BrushTailedPenguinEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BrushTailedPenguinModel extends AnimatedGeoModel<BrushTailedPenguinEntity> {
    @Override
    public ResourceLocation getModelLocation(BrushTailedPenguinEntity object) {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/brushtailedpenguin/brushtailedpenguinbaby.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/brushtailedpenguin/brushtailedpenguin.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(BrushTailedPenguinEntity object)
    {
        if (object.isBaby()) {
            if (object.isSleeping()) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/brushtailedpenguin/brushtailedpenguinbaby" + object.getVariant() + "_1" + "sleep.png");

            }
            return new ResourceLocation(Creatures.MODID, "textures/entity/brushtailedpenguin/brushtailedpenguinbaby" + object.getVariant() + "_1"+ ".png");

        }
        if (object.onIceBlock(object) && object.moving()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/brushtailedpenguin/brushtailedpenguin" + object.getVariant() + "_"+  object.getSubVariant() + "swim.png");

        }
        if (object.isInWater()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/brushtailedpenguin/brushtailedpenguin" + object.getVariant() + "_"+  object.getSubVariant() + "swim.png");
        }
        if (object.isSleeping()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/brushtailedpenguin/brushtailedpenguin" + object.getVariant() + "_"+  object.getSubVariant() + "sleep.png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/brushtailedpenguin/brushtailedpenguin" + object.getVariant() + "_"+  object.getSubVariant()+ ".png");

    }

    @Override
    public ResourceLocation getAnimationFileLocation(BrushTailedPenguinEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.brushtailedpenguinbaby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.brushtailedpenguin.json");

    }
}
