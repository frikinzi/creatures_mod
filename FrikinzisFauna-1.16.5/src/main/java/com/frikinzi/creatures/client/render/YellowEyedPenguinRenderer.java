package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.YellowEyedPenguinModel;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.YellowEyedPenguinEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class YellowEyedPenguinRenderer extends GeoEntityRenderer<YellowEyedPenguinEntity>{
    public YellowEyedPenguinRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new YellowEyedPenguinModel());
        this.shadowRadius = 0.4F;
    }

    @Override
    public void renderEarly(YellowEyedPenguinEntity animatable, MatrixStack stackIn, float ticks,
                            IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, int packedOverlayIn,
                            float red, float green, float blue, float partialTicks) {
        super.renderEarly(animatable, stackIn, ticks, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn,
                red, green, blue, partialTicks);
        float multiplier;
        if (CreaturesConfig.height_on.get()) {
            multiplier = animatable.getHeightMultiplier();
        } else {
            multiplier = 1.0F;
        }
        if (animatable.isBaby()) {
            stackIn.scale(0.6F, 0.6F, 0.6F);
        }
        stackIn.scale(0.6F * multiplier, 0.6F * multiplier, 0.6F * multiplier);
    }

}
