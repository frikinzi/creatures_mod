package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.BushtitEntity;
import com.frikinzi.creatures.entity.PuffinEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PuffinModel extends AnimatedGeoModel<PuffinEntity> {
    @Override
    public ResourceLocation getModelLocation(PuffinEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/puffin/puffinbaby.geo.json");
        }
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/puffin/puffinfly.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/puffin/puffin.geo.json");
    }


    @Override
    public ResourceLocation getTextureLocation(PuffinEntity object)
    {
        if (object.isBaby()) {
            if (object.isSleeping()) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/puffin/puffinbaby" + object.getVariant() + "sleep.png");
            }
            return new ResourceLocation(Creatures.MODID, "textures/entity/puffin/puffinbaby" + object.getVariant() + ".png");
        }
        if (object.isSleeping()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/puffin/puffin" + object.getVariant() + "sleep.png");
        }
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/puffin/puffin" + object.getVariant() + "fly.png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/puffin/puffin" + object.getVariant() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PuffinEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.puffinbaby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.puffin.json");
    }
}
