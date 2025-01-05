package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.BarracudaEntity;
import com.frikinzi.creatures.entity.RanchuEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BarracudaModel extends AnimatedGeoModel<BarracudaEntity> {
    @Override
    public ResourceLocation getModelLocation(BarracudaEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "geo/entity/barracuda/barracuda.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(BarracudaEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "textures/entity/barracuda/barracuda" + object.getVariant() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BarracudaEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.barracuda.json");
    }
}
