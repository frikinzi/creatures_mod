package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.ArowanaModel;
import com.frikinzi.creatures.client.model.ParrotfishModel;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.ArowanaEntity;
import com.frikinzi.creatures.entity.ParrotfishEntity;
import com.frikinzi.creatures.entity.SquidEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class ParrotfishRenderer extends GeoEntityRenderer<ParrotfishEntity>{
    public ParrotfishRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ParrotfishModel());
        this.shadowRadius = 0.3F;
    }

    @Override
    public void renderEarly(ParrotfishEntity animatable, MatrixStack stackIn, float ticks,
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
        if (animatable.getVariant() == 9 || animatable.getVariant() == 1) {
            stackIn.scale(0.9F * multiplier, 0.9F * multiplier, 0.9F * multiplier);
        } else {
            stackIn.scale(0.6F * multiplier, 0.6F * multiplier, 0.6F * multiplier);
        }
    }

    @Override
    public RenderType getRenderType(ParrotfishEntity animatable, float partialTicks, MatrixStack stack,
                                    @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if (animatable.isBaby()) {
            return RenderType.entityTranslucent(textureLocation);

        } return super.getRenderType(animatable, partialTicks, stack,renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);

    }
}
