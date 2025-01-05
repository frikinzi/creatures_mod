package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.AvocetModel;
import com.frikinzi.creatures.client.model.LapwingModel;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.AvocetEntity;
import com.frikinzi.creatures.entity.LapwingEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AvocetRenderer extends GeoEntityRenderer<AvocetEntity> {
    public AvocetRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new AvocetModel());
        this.shadowRadius = 0.4F;
    }

    @Override
    public void renderEarly(AvocetEntity animatable, MatrixStack stackIn, float ticks,
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
            stackIn.scale(0.8F, 0.8F, 0.8F);
        }
        stackIn.scale(0.4F * multiplier, 0.4F * multiplier, 0.4F * multiplier);
    }
}
