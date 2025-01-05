package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.MantisShrimpEntity;
import com.frikinzi.creatures.entity.ShrimpEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MantisShrimpModel extends AnimatedGeoModel<MantisShrimpEntity> {
    @Override
    public ResourceLocation getModelLocation(MantisShrimpEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "geo/entity/mantisshrimp/mantis_shrimp.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MantisShrimpEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "textures/entity/mantisshrimp/mantisshrimp" + object.getVariant() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MantisShrimpEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.mantis_shrimp.json");
    }
}
