package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.ElephantNoseFishEntity;
import com.frikinzi.creatures.entity.SquidEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SquidModel extends AnimatedGeoModel<SquidEntity> {
    @Override
    public ResourceLocation getModelLocation(SquidEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/squid/squidbaby.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/squid/squid.geo.json");    }

    @Override
    public ResourceLocation getTextureLocation(SquidEntity object)
    {
        if (object.isBaby()) {
            if (object.isReef()) {
                return new ResourceLocation(Creatures.MODID, "textures/entity/squid/squidbaby2.png");
            }
            return new ResourceLocation(Creatures.MODID, "textures/entity/squid/squidbaby1.png");
        }
        int sub= object.getSubVariant();
        return new ResourceLocation(Creatures.MODID, "textures/entity/squid/squid" + object.getVariant() + "_" + sub + ".png");    }

    @Override
    public ResourceLocation getAnimationFileLocation(SquidEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.squidbaby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.squid.json");
    }
}
