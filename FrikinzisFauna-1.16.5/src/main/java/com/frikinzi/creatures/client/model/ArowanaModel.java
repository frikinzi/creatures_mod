package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.ArowanaEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArowanaModel extends AnimatedGeoModel<ArowanaEntity> {
    @Override
    public ResourceLocation getModelLocation(ArowanaEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "geo/entity/arowana/arowana.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ArowanaEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "textures/entity/arowana/arowana" + object.getVariant() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ArowanaEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.arowana.json");
    }
}
