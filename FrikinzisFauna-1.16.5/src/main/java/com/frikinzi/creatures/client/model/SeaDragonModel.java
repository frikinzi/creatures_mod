package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.ArapaimaEntity;
import com.frikinzi.creatures.entity.SeaDragonEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SeaDragonModel extends AnimatedGeoModel<SeaDragonEntity> {
    @Override
    public ResourceLocation getModelLocation(SeaDragonEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "geo/entity/seadragon/seadragon.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SeaDragonEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "textures/entity/seadragon/seadragon" + object.getVariant() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SeaDragonEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.seadragon.json");
    }
}
