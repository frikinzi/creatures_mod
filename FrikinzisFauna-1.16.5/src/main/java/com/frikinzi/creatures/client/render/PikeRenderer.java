package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.KoiModel;
import com.frikinzi.creatures.client.model.PikeModel;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.GuppyEntity;
import com.frikinzi.creatures.entity.KoiEntity;
import com.frikinzi.creatures.entity.PikeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PikeRenderer extends GeoEntityRenderer<PikeEntity>{
    public PikeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PikeModel());
        this.shadowRadius = 0.4F;
    }

    @Override
    public void renderEarly(PikeEntity animatable, MatrixStack stackIn, float ticks,
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
        stackIn.scale(1F * multiplier, 1F * multiplier, 1F * multiplier);
    }
}
