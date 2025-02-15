package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.DoveEntity;
import com.frikinzi.creatures.entity.LovebirdEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DoveModel extends AnimatedGeoModel<DoveEntity> {
    @Override
    public ResourceLocation getModelLocation(DoveEntity object)
    {
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/dove/dovefly.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/dove/dove.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DoveEntity object)
    {
        if (object.isFlying()) {
            if (object.getVariant() == 1 || object.getVariant() == 5) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/dove/dove" + object.getVariant() + object.getGenderName() + "fly.png");
            } else {
                return new ResourceLocation(Creatures.MODID, "textures/entity/dove/dove" + object.getVariant() + "fly.png");
            }
        } else if (object.isSleeping()) {
            if (object.getVariant() == 1 || object.getVariant() == 5) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/dove/dove" + object.getVariant() + object.getGenderName() + "sleep.png");
            } else {
                return new ResourceLocation(Creatures.MODID, "textures/entity/dove/dove" + object.getVariant() + "sleep.png");
            }
        }
        else {
            if (object.getVariant() == 1 || object.getVariant() == 5) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/dove/dove" + object.getVariant() + object.getGenderName() + ".png");
            } else {
                return new ResourceLocation(Creatures.MODID, "textures/entity/dove/dove" + object.getVariant() + ".png");
            }
        }
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DoveEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.dove.json");
    }
}
