package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.EdibleCrabEntity;
import com.frikinzi.creatures.entity.VampireCrabEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EdibleCrabModel extends AnimatedGeoModel<EdibleCrabEntity> {
    @Override
    public ResourceLocation getModelLocation(EdibleCrabEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "geo/entity/ediblecrab/ediblecrab.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EdibleCrabEntity object)
    {

        return new ResourceLocation(Creatures.MODID, "textures/entity/ediblecrab/ediblecrab" + object.getVariant() + object.getGenderName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EdibleCrabEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.ediblecrab.json");
    }
}
