package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.BandedPenguinEntity;
import com.frikinzi.creatures.entity.LargePenguinEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LargePenguinModel extends AnimatedGeoModel<LargePenguinEntity> {
    @Override
    public ResourceLocation getModelLocation(LargePenguinEntity object) {
        if (object.isBaby() || object.isPesto()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/largepenguin/largepenguinbaby.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/largepenguin/largepenguin.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(LargePenguinEntity object)
    {
        if (object.isBaby() || object.isPesto()) {
            if (object.isInWater()) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/largepenguin/largepenguinbaby" + object.getVariant() + "swim.png");

            }
            if (object.isSleeping()) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/largepenguin/largepenguinbaby" + object.getVariant() + "sleep.png");

            }
            return new ResourceLocation(Creatures.MODID, "textures/entity/largepenguin/largepenguinbaby" + object.getVariant() + ".png");

        }

        if (object.onIceBlock(object) && object.moving()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/largepenguin/largepenguin" + object.getVariant() + "swim.png");

        }
        if (object.isInWater()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/largepenguin/largepenguin" + object.getVariant() + "swim.png");

        }
        if (object.isSleeping()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/largepenguin/largepenguin" + object.getVariant() + "sleep.png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/largepenguin/largepenguin" + object.getVariant() + ".png");

    }

    @Override
    public ResourceLocation getAnimationFileLocation(LargePenguinEntity object)
    {
        if (object.isBaby() || object.isPesto()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.largepenguinbaby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.largepenguin.json");

    }
}
