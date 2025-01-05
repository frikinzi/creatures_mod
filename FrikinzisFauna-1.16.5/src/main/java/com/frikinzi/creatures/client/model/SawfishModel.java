package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.ArapaimaEntity;
import com.frikinzi.creatures.entity.SawfishEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SawfishModel extends AnimatedGeoModel<SawfishEntity> {
    @Override
    public ResourceLocation getModelLocation(SawfishEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/sawfish/sawfishbaby.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/sawfish/sawfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SawfishEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/sawfish/sawfishbaby" + object.getVariant() + ".png");
        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/sawfish/sawfish" + object.getVariant() + object.getGenderString() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SawfishEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.sawfishbaby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.sawfish.json");
    }
}
