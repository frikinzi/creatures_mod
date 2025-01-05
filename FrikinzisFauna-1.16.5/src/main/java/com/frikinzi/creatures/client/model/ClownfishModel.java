package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.BlueTangEntity;
import com.frikinzi.creatures.entity.ClownfishEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ClownfishModel extends AnimatedGeoModel<ClownfishEntity> {
    @Override
    public ResourceLocation getModelLocation(ClownfishEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "geo/entity/clownfish/clownfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ClownfishEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "textures/entity/clownfish/clownfish" + object.getVariant() + "_" + object.getSubVariant() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ClownfishEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.clownfish.json");
    }
}
