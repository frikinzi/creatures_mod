package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.LookdownEntity;
import com.frikinzi.creatures.entity.ParrotfishEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ParrotfishModel extends AnimatedGeoModel<ParrotfishEntity> {
    @Override
    public ResourceLocation getModelLocation(ParrotfishEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/parrotfish/parrotfishbaby.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/parrotfish/parrotfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ParrotfishEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/parrotfish/parrotfishbaby" + object.getVariant() + ".png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/parrotfish/parrotfish" + object.getVariant() + object.getGenderName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ParrotfishEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.parrotfishbaby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.parrotfish.json");
    }
}
