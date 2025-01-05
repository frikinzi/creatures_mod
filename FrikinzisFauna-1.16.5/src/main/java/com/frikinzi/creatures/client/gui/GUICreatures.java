package com.frikinzi.creatures.client.gui;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.base.*;
import com.frikinzi.creatures.entity.egg.CreaturesEggEntity;
import com.frikinzi.creatures.entity.egg.CreaturesRoeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.opengl.GL11;

@OnlyIn(Dist.CLIENT)
public class GUICreatures extends Screen {
    private final int bookImageHeight = 245;
    private final int bookImageWidth = 390;
    protected int xSize = 176;
    protected int ySize = 166;
    public final int xGui = 390;
    public final int yGui = 320;
    private static final ResourceLocation TEXTURE = new ResourceLocation("creatures:textures/gui/creatures/book.png");

    public GUICreatures() {
        super(new TranslationTextComponent("creatures_gui"));
        xSize = 390;
        ySize = 245;
    }

    protected void init() {
        super.init();
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
            this.renderBackground(matrices);
            int offLeft = (int) ((this.width - 272) / 2.0F);
            int offTop = (int) ((this.height - 250) / 2.0F);
            int mousePosX = mouseX;
            int mousePosY = mouseY;
            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.getMinecraft().getInstance().getTextureManager().bind(TEXTURE);
            this.blit(matrices, i, j, 0, 0, xSize, ySize, xSize, ySize + 120);
            LivingEntity entity = Creatures.PROXY.getReferencedMob();
            if (entity instanceof TameableBirdBase) {
                TameableBirdBase bird = (TameableBirdBase) entity;
                matrices.pushPose();
                this.font.draw(matrices, TextFormatting.BOLD + bird.getDisplayName().getString(), offLeft, offTop + 50, 0);
                this.font.draw(matrices, TextFormatting.ITALIC + bird.getScientificName(), offLeft, offTop + 60, 0);
                matrices.popPose();
                matrices.pushPose();
                ITextComponent g = new TranslationTextComponent("gui.sex");
                this.font.draw(matrices, TextFormatting.BOLD + g.getString() + TextFormatting.RESET + " " + bird.getGenderString(), offLeft, offTop + 80, 0);
                matrices.popPose();
                matrices.pushPose();
                //matrices.scale(0.9f,0.9f, 0.9f);
                ITextComponent h = new TranslationTextComponent("gui.health");
                this.font.draw(matrices, TextFormatting.BOLD + h.getString() + TextFormatting.RESET + " " + bird.getHealth() + "/" + bird.getMaxHealth(), offLeft, offTop + 90, 0);
                ITextComponent owner;
                if (bird.getOwner() == null) {
                    owner = new TranslationTextComponent("gui.untamed");
                } else {
                    owner = bird.getOwner().getDisplayName();
                }
                ITextComponent o = new TranslationTextComponent("gui.owner");
                this.font.draw(matrices, TextFormatting.BOLD + o.getString() + TextFormatting.RESET + " " + owner.getString(), offLeft, offTop + 100, 0);
                ITextComponent species = new TranslationTextComponent("gui.species");
                this.font.draw(matrices, TextFormatting.BOLD + bird.getSpeciesName(), offLeft, offTop + 110, 0);
                ITextComponent height = new TranslationTextComponent("gui.height");
                this.font.draw(matrices, TextFormatting.BOLD + height.getString() + TextFormatting.RESET + " " + bird.getHeightString(), offLeft, offTop + 120, 0);
                ITextComponent food = new TranslationTextComponent("gui.food");
                this.font.draw(matrices, TextFormatting.BOLD + food.getString() + TextFormatting.RESET + " ", offLeft, offTop + 140, 0);
                this.itemRenderer.renderGuiItem(bird.getFoodItem(), offLeft + 30, 130 + offTop);
                this.font.drawWordWrap(bird.getFunFact(), offLeft + 160, 120 + offTop, 114, 0);
                ITextComponent iucn_status = new TranslationTextComponent("gui.iucn");
                this.font.draw(matrices, TextFormatting.BOLD + iucn_status.getString() + " " + bird.getIUCNColor() + bird.getIUCNText().getString(), offLeft, offTop + 160, 0);

                matrices.popPose();

            }
            if (entity instanceof TameableWalkingBirdBase) {
                TameableWalkingBirdBase bird = (TameableWalkingBirdBase) entity;
                matrices.pushPose();
                this.font.draw(matrices, TextFormatting.BOLD + bird.getDisplayName().getString(), offLeft, offTop + 50, 0);
                this.font.draw(matrices, TextFormatting.ITALIC + bird.getScientificName(), offLeft, offTop + 60, 0);
                matrices.popPose();
                matrices.pushPose();
                ITextComponent g = new TranslationTextComponent("gui.sex");
                this.font.draw(matrices, TextFormatting.BOLD + g.getString() + TextFormatting.RESET + " " + bird.getGenderString(), offLeft, offTop + 80, 0);
                matrices.popPose();
                matrices.pushPose();
                //matrices.scale(0.9f,0.9f, 0.9f);
                ITextComponent h = new TranslationTextComponent("gui.health");
                this.font.draw(matrices, TextFormatting.BOLD + h.getString() + TextFormatting.RESET + " " + bird.getHealth() + "/" + bird.getMaxHealth(), offLeft, offTop + 90, 0);
                ITextComponent owner;
                if (bird.getOwner() == null) {
                    owner = new TranslationTextComponent("gui.untamed");
                } else {
                    owner = bird.getOwner().getDisplayName();
                }
                ITextComponent o = new TranslationTextComponent("gui.owner");
                this.font.draw(matrices, TextFormatting.BOLD + o.getString() + TextFormatting.RESET + " " + owner.getString(), offLeft, offTop + 100, 0);
                ITextComponent species = new TranslationTextComponent("gui.species");
                this.font.draw(matrices, TextFormatting.BOLD + bird.getSpeciesName(), offLeft, offTop + 110, 0);
                ITextComponent height = new TranslationTextComponent("gui.height");
                this.font.draw(matrices, TextFormatting.BOLD + height.getString() + TextFormatting.RESET + " " + bird.getHeightString(), offLeft, offTop + 120, 0);
                ITextComponent food = new TranslationTextComponent("gui.food");
                this.font.draw(matrices, TextFormatting.BOLD + food.getString() + TextFormatting.RESET + " ", offLeft, offTop + 140, 0);
                this.itemRenderer.renderGuiItem(bird.getFoodItem(), offLeft + 30, 130 + offTop);
                this.font.drawWordWrap(bird.getFunFact(), offLeft + 160, 120 + offTop, 114, 0);
                ITextComponent iucn_status = new TranslationTextComponent("gui.iucn");
                this.font.draw(matrices, TextFormatting.BOLD + iucn_status.getString() + " " + bird.getIUCNColor() + bird.getIUCNText().getString(), offLeft, offTop + 160, 0);

                matrices.popPose();
            }
            if (entity instanceof NonTameableBirdBase) {
                NonTameableBirdBase bird = (NonTameableBirdBase) entity;
                matrices.pushPose();
                this.font.draw(matrices, TextFormatting.BOLD + bird.getDisplayName().getString(), offLeft, offTop + 50, 0);
                this.font.draw(matrices, TextFormatting.ITALIC + bird.getScientificName(), offLeft, offTop + 60, 0);
                matrices.popPose();
                matrices.pushPose();
                ITextComponent g = new TranslationTextComponent("gui.sex");
                this.font.draw(matrices, TextFormatting.BOLD + g.getString() + TextFormatting.RESET + " " + bird.getGenderString(), offLeft, offTop + 80, 0);
                matrices.popPose();
                matrices.pushPose();
                //matrices.scale(0.9f,0.9f, 0.9f);
                ITextComponent h = new TranslationTextComponent("gui.health");
                this.font.draw(matrices, TextFormatting.BOLD + h.getString() + TextFormatting.RESET + " " + bird.getHealth() + "/" + bird.getMaxHealth(), offLeft, offTop + 90, 0);
                ITextComponent species = new TranslationTextComponent("gui.species");
                this.font.draw(matrices, TextFormatting.BOLD + bird.getSpeciesName(), offLeft, offTop + 110, 0);
                ITextComponent height = new TranslationTextComponent("gui.height");
                this.font.draw(matrices, TextFormatting.BOLD + height.getString() + TextFormatting.RESET + " " + bird.getHeightString(), offLeft, offTop + 120, 0);
                ITextComponent food = new TranslationTextComponent("gui.food");
                this.font.draw(matrices, TextFormatting.BOLD + food.getString() + TextFormatting.RESET + " ", offLeft, offTop + 140, 0);
                this.itemRenderer.renderGuiItem(bird.getFoodItem(), offLeft + 30, 130 + offTop);
                this.font.drawWordWrap(bird.getFunFact(), offLeft + 160, 120 + offTop, 114, 0);
                ITextComponent iucn_status = new TranslationTextComponent("gui.iucn");
                this.font.draw(matrices, TextFormatting.BOLD + iucn_status.getString() + " " + bird.getIUCNColor() + bird.getIUCNText().getString(), offLeft, offTop + 160, 0);

                matrices.popPose();
            }
            if (entity instanceof NonTameableFlyingBirdBase) {
                NonTameableFlyingBirdBase bird = (NonTameableFlyingBirdBase) entity;
                matrices.pushPose();
                this.font.draw(matrices, TextFormatting.BOLD + bird.getDisplayName().getString(), offLeft, offTop + 50, 0);
                this.font.draw(matrices, TextFormatting.ITALIC + bird.getScientificName(), offLeft, offTop + 60, 0);
                matrices.popPose();
                matrices.pushPose();
                ITextComponent g = new TranslationTextComponent("gui.sex");
                this.font.draw(matrices, TextFormatting.BOLD + g.getString() + TextFormatting.RESET + " " + bird.getGenderString(), offLeft, offTop + 80, 0);
                matrices.popPose();
                matrices.pushPose();
                //matrices.scale(0.9f,0.9f, 0.9f);
                ITextComponent h = new TranslationTextComponent("gui.health");
                this.font.draw(matrices, TextFormatting.BOLD + h.getString() + TextFormatting.RESET + " " + bird.getHealth() + "/" + bird.getMaxHealth(), offLeft, offTop + 90, 0);
                ITextComponent species = new TranslationTextComponent("gui.species");
                this.font.draw(matrices, TextFormatting.BOLD + bird.getSpeciesName(), offLeft, offTop + 110, 0);
                ITextComponent height = new TranslationTextComponent("gui.height");
                this.font.draw(matrices, TextFormatting.BOLD + height.getString() + TextFormatting.RESET + " " + bird.getHeightString(), offLeft, offTop + 120, 0);
                ITextComponent food = new TranslationTextComponent("gui.food");
                this.font.draw(matrices, TextFormatting.BOLD + food.getString() + TextFormatting.RESET + " ", offLeft, offTop + 140, 0);
                this.itemRenderer.renderGuiItem(bird.getFoodItem(), offLeft + 30, 130 + offTop);
                this.font.drawWordWrap(bird.getFunFact(), offLeft + 160, 120 + offTop, 114, 0);
                ITextComponent iucn_status = new TranslationTextComponent("gui.iucn");
                this.font.draw(matrices, TextFormatting.BOLD + iucn_status.getString() + " " + bird.getIUCNColor() + bird.getIUCNText().getString(), offLeft, offTop + 160, 0);

                matrices.popPose();
            }
            if (entity instanceof FishBase) {
                FishBase bird = (FishBase) entity;
                matrices.pushPose();
                this.font.draw(matrices, TextFormatting.BOLD + bird.getDisplayName().getString(), offLeft, offTop + 50, 0);
                this.font.draw(matrices, TextFormatting.ITALIC + bird.getScientificName(), offLeft, offTop + 60, 0);
                matrices.popPose();
                matrices.pushPose();
                ITextComponent g = new TranslationTextComponent("gui.sex");
                this.font.draw(matrices, TextFormatting.BOLD + g.getString() + TextFormatting.RESET + " " + bird.getGenderText(), offLeft, offTop + 80, 0);
                matrices.popPose();
                matrices.pushPose();
                //matrices.scale(0.9f,0.9f, 0.9f);
                ITextComponent h = new TranslationTextComponent("gui.health");
                this.font.draw(matrices, TextFormatting.BOLD + h.getString() + TextFormatting.RESET + " " + bird.getHealth() + "/" + bird.getMaxHealth(), offLeft, offTop + 90, 0);
                ITextComponent species = new TranslationTextComponent("gui.species");
                this.font.draw(matrices, TextFormatting.BOLD + bird.getSpeciesName(), offLeft, offTop + 110, 0);
                ITextComponent height = new TranslationTextComponent("gui.height");
                this.font.draw(matrices, TextFormatting.BOLD + height.getString() + TextFormatting.RESET + " " + bird.getHeightString(), offLeft, offTop + 120, 0);
                ITextComponent food = new TranslationTextComponent("gui.food");
                this.font.draw(matrices, TextFormatting.BOLD + food.getString() + TextFormatting.RESET + " ", offLeft, offTop + 140, 0);
                ItemStack itemStack = new ItemStack(bird.getFoodItem());
                this.itemRenderer.renderGuiItem(itemStack, offLeft + 30, 130 + offTop);
                this.font.drawWordWrap(bird.getFunFact(), offLeft + 160, 120 + offTop, 114, 0);
                ITextComponent iucn_status = new TranslationTextComponent("gui.iucn");
                this.font.draw(matrices, TextFormatting.BOLD + iucn_status.getString() + " " + bird.getIUCNColor() + bird.getIUCNText().getString(), offLeft, offTop + 160, 0);

                matrices.popPose();
            }
            if (entity instanceof GroupFishBase) {
                GroupFishBase bird = (GroupFishBase) entity;
                matrices.pushPose();
                this.font.draw(matrices, TextFormatting.BOLD + bird.getDisplayName().getString(), offLeft, offTop + 50, 0);
                this.font.draw(matrices, TextFormatting.ITALIC + bird.getScientificName(), offLeft, offTop + 60, 0);
                matrices.popPose();
                matrices.pushPose();
                ITextComponent g = new TranslationTextComponent("gui.sex");
                this.font.draw(matrices, TextFormatting.BOLD + g.getString() + TextFormatting.RESET + " " + bird.getGenderText(), offLeft, offTop + 80, 0);
                matrices.popPose();
                matrices.pushPose();
                //matrices.scale(0.9f,0.9f, 0.9f);
                ITextComponent h = new TranslationTextComponent("gui.health");
                this.font.draw(matrices, TextFormatting.BOLD + h.getString() + TextFormatting.RESET + " " + bird.getHealth() + "/" + bird.getMaxHealth(), offLeft, offTop + 90, 0);
                ITextComponent species = new TranslationTextComponent("gui.species");
                this.font.draw(matrices, TextFormatting.BOLD + bird.getSpeciesName(), offLeft, offTop + 110, 0);
                ITextComponent height = new TranslationTextComponent("gui.height");
                this.font.draw(matrices, TextFormatting.BOLD + height.getString() + TextFormatting.RESET + " " + bird.getHeightString(), offLeft, offTop + 120, 0);
                ITextComponent food = new TranslationTextComponent("gui.food");
                this.font.draw(matrices, TextFormatting.BOLD + food.getString() + TextFormatting.RESET + " ", offLeft, offTop + 140, 0);
                ItemStack itemStack = new ItemStack(bird.getFoodItem());
                this.itemRenderer.renderGuiItem(itemStack, offLeft + 30, 130 + offTop);
                this.font.drawWordWrap(bird.getFunFact(), offLeft + 160, 120 + offTop, 114, 0);
                ITextComponent iucn_status = new TranslationTextComponent("gui.iucn");
                this.font.draw(matrices, TextFormatting.BOLD + iucn_status.getString() + " " + bird.getIUCNColor() + bird.getIUCNText().getString(), offLeft, offTop + 160, 0);

                matrices.popPose();
            }
            if (entity instanceof AbstractCrabBase) {
                AbstractCrabBase bird = (AbstractCrabBase) entity;
                matrices.pushPose();
                this.font.draw(matrices, TextFormatting.BOLD + bird.getDisplayName().getString(), offLeft, offTop + 50, 0);
                this.font.draw(matrices, TextFormatting.ITALIC + bird.getScientificName(), offLeft, offTop + 60, 0);
                matrices.popPose();
                matrices.pushPose();
                ITextComponent g = new TranslationTextComponent("gui.sex");
                this.font.draw(matrices, TextFormatting.BOLD + g.getString() + TextFormatting.RESET + " " + bird.getGenderText(), offLeft, offTop + 80, 0);
                matrices.popPose();
                matrices.pushPose();
                //matrices.scale(0.9f,0.9f, 0.9f);
                ITextComponent h = new TranslationTextComponent("gui.health");
                this.font.draw(matrices, TextFormatting.BOLD + h.getString() + TextFormatting.RESET + " " + bird.getHealth() + "/" + bird.getMaxHealth(), offLeft, offTop + 90, 0);
                ITextComponent species = new TranslationTextComponent("gui.species");
                this.font.draw(matrices, TextFormatting.BOLD + bird.getSpeciesName(), offLeft, offTop + 110, 0);
                ITextComponent height = new TranslationTextComponent("gui.height");
                this.font.draw(matrices, TextFormatting.BOLD + height.getString() + TextFormatting.RESET + " " + bird.getHeightString(), offLeft, offTop + 120, 0);
                ITextComponent food = new TranslationTextComponent("gui.food");
                this.font.draw(matrices, TextFormatting.BOLD + food.getString() + TextFormatting.RESET + " ", offLeft, offTop + 140, 0);
                this.itemRenderer.renderGuiItem(bird.getFoodItem(), offLeft + 30, 130 + offTop);
                this.font.drawWordWrap(bird.getFunFact(), offLeft + 160, 120 + offTop, 114, 0);
                ITextComponent iucn_status = new TranslationTextComponent("gui.iucn");
                this.font.draw(matrices, TextFormatting.BOLD + iucn_status.getString() + " " + bird.getIUCNColor() + bird.getIUCNText().getString(), offLeft, offTop + 160, 0);

                matrices.popPose();
            }  if (entity instanceof CreaturesEggEntity) {
            CreaturesEggEntity bird = (CreaturesEggEntity) entity;
            matrices.pushPose();
            ItemStack item = bird.getEggItem();
            this.font.draw(matrices, bird.getEggItem().getItem().getName(item), offLeft, offTop + 60, 0);
            matrices.popPose();
            matrices.pushPose();
            ITextComponent h = new TranslationTextComponent("gui.hatchtime");
            this.font.draw(matrices, h.getString() + " " + bird.getHatchTime(), offLeft, offTop + 80, 0);
            matrices.popPose();
            matrices.pushPose();
            ITextComponent species = new TranslationTextComponent("gui.species");
            this.font.draw(matrices, bird.getEggItem().getDisplayName(), offLeft, offTop + 90, 0);
            ITextComponent food = new TranslationTextComponent("gui.egg");
            this.itemRenderer.renderGuiItem(bird.getEggItem(), offLeft + 0, 110 + offTop);
            matrices.popPose();
        }  if (entity instanceof CreaturesRoeEntity) {
            CreaturesRoeEntity bird = (CreaturesRoeEntity) entity;
            matrices.pushPose();
            ITextComponent h = new TranslationTextComponent("gui.hatchtime");
            this.font.draw(matrices, h.getString() + " " + bird.getHatchTime(), offLeft, offTop + 80, 0);
            matrices.popPose();
        }

            InventoryScreen.renderEntityInInventory(offLeft + 215, 100 + offTop, 60, (float) (i) - mousePosX, (float) (j + 75 - 50) - mousePosY, entity);
            super.render(matrices, mouseX, mouseY, delta);

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
