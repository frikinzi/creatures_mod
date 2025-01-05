package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.ArapaimaEntity;
import com.frikinzi.creatures.entity.TrumpetfishEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TrumpetfishModel extends AnimatedGeoModel<TrumpetfishEntity> {
    @Override
    public ResourceLocation getModelLocation(TrumpetfishEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "geo/entity/trumpetfish/trumpetfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TrumpetfishEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "textures/entity/trumpetfish/trumpetfish_" + object.getVariant() + "_" + object.getSubVariant() +  ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TrumpetfishEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.trumpetfish.json");
    }
}
