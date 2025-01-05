package com.frikinzi.creatures.client;

import com.frikinzi.creatures.client.render.*;
import com.frikinzi.creatures.entity.*;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.registry.ModEntityTypes;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.vector.Vector3f;


public class ShoulderLayer<T extends PlayerEntity> extends LayerRenderer<T, PlayerModel<T>> {
    private CreaturesBirdEntity birdEntity;
    public ShoulderLayer(IEntityRenderer<T, PlayerModel<T>> parent) {
        super(parent);
    }


    @Override
    public void render(MatrixStack poseStack, IRenderTypeBuffer bufferSource, int packedLight, T entity, float partialTick, float yaw, float r, float g, float b, float a) {
        if (!entity.getShoulderEntityLeft().isEmpty()) {
            CompoundNBT shoulderNBT = entity.getShoulderEntityLeft();
            EntityType<?> type = EntityType.byString(shoulderNBT.getString("id")).orElse(null);


            if (type != null) {
                if (type == ModEntityTypes.DOVE.get()) {
                    DoveEntity dove = (DoveEntity) getOrCreateBirdEntity(shoulderNBT);

                    if (dove != null) {
                        DoveRenderer fakeRenderer = (DoveRenderer) Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(dove);
                        dove.setOnGround(true);
                        dove.tickCount = entity.tickCount;

                        poseStack.pushPose();
                        getParentModel().head.translateAndRotate(poseStack);
                        poseStack.mulPose(Vector3f.XN.rotationDegrees(180));
                        poseStack.translate(0, 0.45f, 0);
                        fakeRenderer.render(dove, yaw, partialTick, poseStack, bufferSource, packedLight);
                        poseStack.popPose();
                    }
                }
                if (type == ModEntityTypes.LOVEBIRD.get()) {
                    LovebirdEntity lovebird = (LovebirdEntity) getOrCreateBirdEntity(shoulderNBT);

                    if (lovebird != null) {
                        LovebirdRenderer fakeRenderer = (LovebirdRenderer) Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(lovebird);
                        lovebird.setOnGround(true);
                        lovebird.tickCount = entity.tickCount;

                        poseStack.pushPose();
                        getParentModel().head.translateAndRotate(poseStack);
                        poseStack.mulPose(Vector3f.XN.rotationDegrees(180));
                        poseStack.translate(0, 0.45f, 0);
                        fakeRenderer.render(lovebird, yaw, partialTick, poseStack, bufferSource, packedLight);
                        poseStack.popPose();
                    }
                }
                if (type == ModEntityTypes.CONURE.get()) {
                    ConureEntity conure = (ConureEntity) getOrCreateBirdEntity(shoulderNBT);

                    if (conure != null) {
                        ConureRenderer fakeRenderer = (ConureRenderer) Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(conure);
                        conure.setOnGround(true);
                        conure.tickCount = entity.tickCount;

                        poseStack.pushPose();
                        getParentModel().head.translateAndRotate(poseStack);
                        poseStack.mulPose(Vector3f.XN.rotationDegrees(180));
                        poseStack.translate(0, 0.45f, 0);
                        fakeRenderer.render(conure, yaw, partialTick, poseStack, bufferSource, packedLight);
                        poseStack.popPose();
                    }
                }
                if (type == ModEntityTypes.FINCH.get()) {
                    FinchEntity finch = (FinchEntity) getOrCreateBirdEntity(shoulderNBT);

                    if (finch != null) {
                        FinchRenderer fakeRenderer = (FinchRenderer) Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(finch);
                        finch.setOnGround(true);
                        finch.tickCount = entity.tickCount;

                        poseStack.pushPose();
                        getParentModel().head.translateAndRotate(poseStack);
                        poseStack.mulPose(Vector3f.XN.rotationDegrees(180));
                        poseStack.translate(0, 0.45f, 0);
                        fakeRenderer.render(finch, yaw, partialTick, poseStack, bufferSource, packedLight);
                        poseStack.popPose();
                    }
                }
                if (type == ModEntityTypes.LORIKEET.get()) {
                    LorikeetEntity lorikeet = (LorikeetEntity) getOrCreateBirdEntity(shoulderNBT);

                    if (lorikeet != null) {
                        LorikeetRenderer fakeRenderer = (LorikeetRenderer) Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(lorikeet);
                        lorikeet.setOnGround(true);
                        lorikeet.tickCount = entity.tickCount;

                        poseStack.pushPose();
                        getParentModel().head.translateAndRotate(poseStack);
                        poseStack.mulPose(Vector3f.XN.rotationDegrees(180));
                        poseStack.translate(0, 0.55f, 0);
                        fakeRenderer.render(lorikeet, yaw, partialTick, poseStack, bufferSource, packedLight);
                        poseStack.popPose();
                    }
                }
                if (type == ModEntityTypes.RAVEN.get()) {
                    RavenEntity raven = (RavenEntity) getOrCreateBirdEntity(shoulderNBT);

                    if (raven != null) {
                        RavenRenderer fakeRenderer = (RavenRenderer) Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(raven);
                        raven.setOnGround(true);
                        raven.tickCount = entity.tickCount;

                        poseStack.pushPose();
                        getParentModel().head.translateAndRotate(poseStack);
                        poseStack.mulPose(Vector3f.XN.rotationDegrees(180));
                        poseStack.translate(0, 0.45f, 0);
                        fakeRenderer.render(raven, yaw, partialTick, poseStack, bufferSource, packedLight);
                        poseStack.popPose();
                    }
                }

            }
        }
    }

    private CreaturesBirdEntity getOrCreateBirdEntity(CompoundNBT shoulderNBT) {
        EntityType<?> type = EntityType.byString(shoulderNBT.getString("id")).orElse(null);
        if (type == null) {
            return null;
        }
        CreaturesBirdEntity doveEntity = (CreaturesBirdEntity) type.create(Minecraft.getInstance().level);
        if (doveEntity != null) {
            doveEntity.readAdditionalSaveData(shoulderNBT);
        }
        return doveEntity;
    }
}