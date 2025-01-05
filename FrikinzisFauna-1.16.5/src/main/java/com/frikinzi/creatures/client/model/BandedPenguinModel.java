package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.BandedPenguinEntity;
import com.frikinzi.creatures.entity.CormorantEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BandedPenguinModel extends AnimatedGeoModel<BandedPenguinEntity> {
    @Override
    public ResourceLocation getModelLocation(BandedPenguinEntity object) {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/bandedpenguin/bandedpenguinbaby.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/bandedpenguin/bandedpenguin.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(BandedPenguinEntity object)
    {
        if (object.isBaby()) {
            if (object.isSleeping()) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/bandedpenguin/bandedpenguinbaby" + object.getVariant() + "_1"+ "sleep.png");

            }
            return new ResourceLocation(Creatures.MODID, "textures/entity/bandedpenguin/bandedpenguinbaby" + object.getVariant() + "_1"+ ".png");

        }
        if (object.isInWater()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/bandedpenguin/bandedpenguin" + object.getVariant() + "_"+  object.getSubVariant()+  object.getGenderName() + "swim.png");

        }
        if (object.isSleeping()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/bandedpenguin/bandedpenguin" + object.getVariant() + "_"+  object.getSubVariant()+  object.getGenderName() + "sleep.png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/bandedpenguin/bandedpenguin" + object.getVariant() + "_"+  object.getSubVariant()+  object.getGenderName()  + ".png");

    }

    @Override
    public ResourceLocation getAnimationFileLocation(BandedPenguinEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.bandedpenguinbaby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.bandedpenguin.json");

    }
}
