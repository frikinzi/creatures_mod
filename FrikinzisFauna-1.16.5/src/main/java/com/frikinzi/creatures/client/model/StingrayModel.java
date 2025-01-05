package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.ShrimpEntity;
import com.frikinzi.creatures.entity.StingrayEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StingrayModel extends AnimatedGeoModel<StingrayEntity> {
    @Override
    public ResourceLocation getModelLocation(StingrayEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/stingray/stingraybaby.geo.json");

        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/stingray/stingray.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(StingrayEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/stingray/stingraybaby" + object.getVariant() + ".png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/stingray/stingray_" + object.getVariant() + object.getGenderName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(StingrayEntity object)
    {
        return new ResourceLocation(Creatures.MODID, "animations/animation.stingray.json");
    }
}
