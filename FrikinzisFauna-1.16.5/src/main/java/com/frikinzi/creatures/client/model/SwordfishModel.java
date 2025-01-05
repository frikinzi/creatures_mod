package com.frikinzi.creatures.client.model;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.SwordfishEntity;
import com.frikinzi.creatures.entity.TambaquiEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SwordfishModel extends AnimatedGeoModel<SwordfishEntity> {
    @Override
    public ResourceLocation getModelLocation(SwordfishEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "geo/entity/swordfish/swordfishbaby.geo.json");
        }
        return new ResourceLocation(Creatures.MODID, "geo/entity/swordfish/swordfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SwordfishEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "textures/entity/swordfish/billfishbaby" + object.getBabyVariant() + ".png");

        }
        return new ResourceLocation(Creatures.MODID, "textures/entity/swordfish/billfish" + object.getTextureString() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SwordfishEntity object)
    {
        if (object.isBaby()) {
            return new ResourceLocation(Creatures.MODID, "animations/animation.swordfishbaby.json");
        }
        return new ResourceLocation(Creatures.MODID, "animations/animation.swordfish.json");
    }
}
