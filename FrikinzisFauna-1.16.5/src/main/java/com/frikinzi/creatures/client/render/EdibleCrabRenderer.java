package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.EdibleCrabModel;
import com.frikinzi.creatures.client.model.VampireCrabModel;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.EdibleCrabEntity;
import com.frikinzi.creatures.entity.VampireCrabEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EdibleCrabRenderer extends GeoEntityRenderer<EdibleCrabEntity> {
    public EdibleCrabRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EdibleCrabModel());
        this.shadowRadius = 0.2F;
    }

    @Override
    public void renderEarly(EdibleCrabEntity animatable, MatrixStack stackIn, float ticks,
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
            stackIn.scale(0.5F, 0.5F, 0.5F);
        }
        stackIn.scale(0.6F *multiplier, 0.6F *multiplier, 0.6F *multiplier);
    }
}
