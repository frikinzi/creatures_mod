package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.LookdownEntity;
import com.frikinzi.creatures.entity.RedSnapperEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LookdownModel extends AnimatedGeoModel<LookdownEntity> {
    @Override
    public ResourceLocation getModelLocation(LookdownEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/lookdown/lookdownbaby.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/lookdown/lookdown.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(LookdownEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/lookdown/lookdownbaby.png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/lookdown/lookdown" + object.getVariant() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(LookdownEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.lookdownbaby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.lookdown.json");
    }
}
