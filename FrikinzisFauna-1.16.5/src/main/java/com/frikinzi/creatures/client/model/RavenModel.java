package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.DottybackEntity;
import com.frikinzi.creatures.entity.RavenEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RavenModel extends AnimatedGeoModel<RavenEntity> {
    @Override
    public ResourceLocation getModelLocation(RavenEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/raven/raven_baby.geo.json");
        }
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/raven/ravenfly.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/raven/raven.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RavenEntity object)
    {
        if (object.isBaby()) {
            if (object.isSleeping()) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/raven/raven" + object.getVariant() + "_baby_sleep.png");

            }
            return new ResourceLocation(Creatures.MODID, "textures/entity/raven/raven" + object.getVariant() + "_baby.png");

        }
        if (object.isFlying()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/raven/raven" + object.getVariant() + "fly.png");

        } else if (object.isSleeping()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/raven/raven" + object.getVariant() + "sleep.png");

        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/raven/raven" + object.getVariant() + ".png");

    }

    @Override
    public ResourceLocation getAnimationFileLocation(RavenEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.raven_baby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.raven.json");
    }
}
