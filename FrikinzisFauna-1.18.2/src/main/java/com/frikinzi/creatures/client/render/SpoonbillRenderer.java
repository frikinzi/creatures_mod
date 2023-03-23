package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.LovebirdModel;
import com.frikinzi.creatures.client.model.SpoonbillModel;
import com.frikinzi.creatures.entity.LovebirdEntity;
import com.frikinzi.creatures.entity.SpoonbillEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SpoonbillRenderer extends GeoEntityRenderer<SpoonbillEntity> {

    public SpoonbillRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new SpoonbillModel());
    }

    @Override
    public void renderEarly(SpoonbillEntity animatable, PoseStack stack, float partialTick, MultiBufferSource bufferSource,
                            VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
                            float partialTicks) {
        super.renderEarly(animatable, stack, partialTick, bufferSource, buffer, packedLight, packedOverlay, red,
                green, blue, partialTicks);
        Float multiplier;
        multiplier = animatable.getHeightMultiplier();

        if (animatable.isBaby()) {
            stack.scale(0.5F, 0.5F, 0.5F);
        }
        stack.scale(0.8F * multiplier, 0.8F * multiplier, 0.8F * multiplier);
    }

}