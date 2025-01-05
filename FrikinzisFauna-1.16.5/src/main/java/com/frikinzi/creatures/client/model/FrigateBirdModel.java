package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.AvocetEntity;
import com.frikinzi.creatures.entity.FrigateBirdEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FrigateBirdModel extends AnimatedGeoModel<FrigateBirdEntity> {
    @Override
    public ResourceLocation getModelLocation(FrigateBirdEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/frigate/frigatebaby.geo.json");
        }
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/frigate/frigatefly.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/frigate/frigate.geo.json");
    }


    @Override
    public ResourceLocation getTextureLocation(FrigateBirdEntity object)
    {
        if (object.isBaby()) {
            if (object.isSleeping()) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/frigate/frigatebabysleep.png");
            }
            return new ResourceLocation(Creatures.MODID, "textures/entity/frigate/frigatebaby.png");
        }
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/frigate/frigate" + object.getVariant() + object.getGenderName() + "fly.png");
        }
        if (object.isSleeping()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/frigate/frigate" + object.getVariant() + object.getGenderName() + "sleep.png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/frigate/frigate" + object.getVariant() + object.getGenderName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FrigateBirdEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.frigatebaby.json");
        }
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.frigatefly.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.frigate.json");
    }
}
