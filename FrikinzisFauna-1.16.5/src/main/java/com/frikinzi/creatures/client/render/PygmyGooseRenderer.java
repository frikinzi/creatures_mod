package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.PygmyGooseModel;
import com.frikinzi.creatures.client.model.WildDuckModel;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.PygmyGooseEntity;
import com.frikinzi.creatures.entity.WildDuckEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PygmyGooseRenderer extends GeoEntityRenderer<PygmyGooseEntity> {
    public PygmyGooseRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PygmyGooseModel());
        this.shadowRadius = 0.3F;
    }

    @Override
    public void renderEarly(PygmyGooseEntity animatable, MatrixStack stackIn, float ticks,
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
            stackIn.scale(0.8F * multiplier, 0.8F * multiplier, 0.8F * multiplier);
        }
        stackIn.scale(0.7F * multiplier, 0.7F * multiplier, 0.7F * multiplier);
    }
}
