package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.ConureModel;
import com.frikinzi.creatures.client.model.RollerModel;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.ConureEntity;
import com.frikinzi.creatures.entity.RollerEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RollerRenderer extends GeoEntityRenderer<RollerEntity> {
    public RollerRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RollerModel());
        this.shadowRadius = 0.4F;
    }

    @Override
    public void renderEarly(RollerEntity animatable, MatrixStack stackIn, float ticks,
                            IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, int packedOverlayIn,
                            float red, float green, float blue, float partialTicks) {
        super.renderEarly(animatable, stackIn, ticks, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn,
                red, green, blue, partialTicks);
        Float multiplier;
        if (CreaturesConfig.height_on.get() == true) {
            multiplier = animatable.getHeightMultiplier();
        } else {
            multiplier = 1.0F;
        }
        if (animatable.isBaby()) {
            stackIn.scale(0.5F * multiplier, 0.5F * multiplier, 0.5F * multiplier);
        }
        stackIn.scale(0.8F * multiplier, 0.8F * multiplier, 0.8F * multiplier);
    }
}
