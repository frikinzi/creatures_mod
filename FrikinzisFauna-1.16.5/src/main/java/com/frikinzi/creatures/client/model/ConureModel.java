package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.ConureEntity;
import com.frikinzi.creatures.entity.DoveEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ConureModel extends AnimatedGeoModel<ConureEntity> {
    @Override
    public ResourceLocation getModelLocation(ConureEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/baby_parrot/parrotchick.geo.json");
        }
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/conure/conurefly.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/conure/conure.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ConureEntity object)
    {
        if (object.isBaby()) {
            if (object.isSleeping()) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/conure/conure" + object.getVariant() + "_baby_sleep.png");

            }
            return new ResourceLocation(Creatures.MODID, "textures/entity/conure/conure" + object.getVariant() + "_baby.png");

        }
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/conure/conure" + object.getVariant() + "fly.png");
        } else if (object.isSleeping()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/conure/conure" + object.getVariant() + "sleep.png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/conure/conure" + object.getVariant() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ConureEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.parrotbaby.json");
        }
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.conure.fly.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.conure.json");
    }
}
