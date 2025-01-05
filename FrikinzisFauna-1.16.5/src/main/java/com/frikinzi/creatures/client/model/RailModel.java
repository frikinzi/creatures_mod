package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.MonalEntity;
import com.frikinzi.creatures.entity.RailEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RailModel extends AnimatedGeoModel<RailEntity> {
    @Override
    public ResourceLocation getModelLocation(RailEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/lapwing/lapwingbaby.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/rail/rail.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RailEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/rail/railbaby.png");
        }
        if (object.isSleeping()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/rail/rail" + object.getVariant() + "sleep.png");

        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/rail/rail" + object.getVariant() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RailEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.babylapwing.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.rail.json");
    }
}
