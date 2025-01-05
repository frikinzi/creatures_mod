package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.BandedPenguinModel;
import com.frikinzi.creatures.client.model.LargePenguinModel;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.BandedPenguinEntity;
import com.frikinzi.creatures.entity.LargePenguinEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class LargePenguinRenderer extends GeoEntityRenderer<LargePenguinEntity>{
    public LargePenguinRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new LargePenguinModel());
        this.shadowRadius = 0.4F;
    }

    @Override
    public void renderEarly(LargePenguinEntity animatable, MatrixStack stackIn, float ticks,
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
        if (animatable.isPesto()) {
            stackIn.scale(1.5F, 1.5F, 1.5F);
        }
        if (animatable.isBaby()) {
            if (!animatable.isPesto()) {
                stackIn.scale(0.6F, 0.6F, 0.6F);
            }
        }
        if (animatable.getVariant() == 2) {
            stackIn.scale(0.8F, 0.8F, 0.8F);
        }
        stackIn.scale(0.8F * multiplier, 0.8F * multiplier, 0.8F * multiplier);
    }

}
