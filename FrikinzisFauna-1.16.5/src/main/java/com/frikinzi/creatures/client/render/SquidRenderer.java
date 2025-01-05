package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.PikeModel;
import com.frikinzi.creatures.client.model.SquidModel;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.PikeEntity;
import com.frikinzi.creatures.entity.SeaDragonEntity;
import com.frikinzi.creatures.entity.SquidEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class SquidRenderer extends GeoEntityRenderer<SquidEntity>{
    public SquidRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SquidModel());
        this.shadowRadius = 0.4F;
    }

    @Override
    public void renderEarly(SquidEntity animatable, MatrixStack stackIn, float ticks,
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
            stackIn.scale(0.2F, 0.2F, 0.2F);
        }
        multiplier = multiplier * (float) animatable.getSizeMultiplier();
        stackIn.scale(1F * multiplier, 1F * multiplier, 1F * multiplier);
    }

    @Override
    public RenderType getRenderType(SquidEntity animatable, float partialTicks, MatrixStack stack,
                                    @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if (animatable.isBaby()) {
            return RenderType.entityTranslucent(textureLocation);

        } return super.getRenderType(animatable, partialTicks, stack,renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);

    }
}
