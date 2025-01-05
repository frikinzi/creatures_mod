package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.CrestedPenguinEntity;
import com.frikinzi.creatures.entity.YellowEyedPenguinEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class YellowEyedPenguinModel extends AnimatedGeoModel<YellowEyedPenguinEntity> {
    @Override
    public ResourceLocation getModelLocation(YellowEyedPenguinEntity object) {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/yelloweyedpenguin/yelloweyedpenguinbaby.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/yelloweyedpenguin/yelloweyedpenguin.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(YellowEyedPenguinEntity object)
    {
        if (object.isBaby()) {
            if (object.isSleeping()) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/yelloweyedpenguin/yelloweyedpenguinbaby1sleep.png");

            }
            return new ResourceLocation(Creatures.MODID, "textures/entity/yelloweyedpenguin/yelloweyedpenguinbaby1.png");

        }
        if (object.isSleeping()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/yelloweyedpenguin/yelloweyedpenguin1sleep.png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/yelloweyedpenguin/yelloweyedpenguin1.png");

    }

    @Override
    public ResourceLocation getAnimationFileLocation(YellowEyedPenguinEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.yelloweyedpenguinbaby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.yelloweyedpenguin.json");

    }
}
