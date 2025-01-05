package com.frikinzi.creatures.client.render;

import com.frikinzi.creatures.client.model.RavenModel;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.RavenEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.vector.Vector3f;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RavenRenderer extends GeoEntityRenderer<RavenEntity>{
    private static final ItemStack book = new ItemStack(Items.BOOK);
    public RavenRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RavenModel());
        this.shadowRadius = 0.4F;
    }

    @Override
    public void renderEarly(RavenEntity animatable, MatrixStack stackIn, float ticks,
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
        if (!animatable.isBaby()) {
            stackIn.scale(0.7F *multiplier, 0.7F *multiplier, 0.7F *multiplier);
        } else {
            stackIn.scale(multiplier, multiplier, multiplier);

        }
    }

}
