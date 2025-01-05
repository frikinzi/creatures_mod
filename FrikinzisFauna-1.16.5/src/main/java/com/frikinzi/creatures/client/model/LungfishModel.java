package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.BarracudaEntity;
import com.frikinzi.creatures.entity.LungfishEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LungfishModel extends AnimatedGeoModel<LungfishEntity> {
    @Override
    public ResourceLocation getModelLocation(LungfishEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "geo/entity/lungfish/lungfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(LungfishEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "textures/entity/lungfish/lungfish" + object.getVariant() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(LungfishEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.lungfish.json");
    }
}
