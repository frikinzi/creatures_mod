package com.frikinzi.creatures.item;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.client.gui.GUICreatures;
import com.frikinzi.creatures.entity.base.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FFGuideItem extends Item {
    ArrayList<CreaturesBirdEntity> list = new ArrayList<CreaturesBirdEntity>();
    Map<Integer, List<Integer>> pages;

    public FFGuideItem(Item.Properties properties) {
        super(properties);


    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
            if (!worldIn.isClientSide()) {
                openCreaturesGUI(itemstack);
            }
            return ActionResult.success(itemstack);
    }


    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
        if (!(target instanceof AbstractCrabBase) || !(target instanceof FishBase) || !(target instanceof GroupFishBase) || !(target instanceof NonTameableFlyingBirdBase)  || !(target instanceof NonTameableBirdBase)  || !(target instanceof TameableBirdBase)  || !(target instanceof TameableWalkingBirdBase)) {
            // Most likely someone summoned this item by command without data
            return ActionResultType.FAIL;
        }
        else {
            Creatures.PROXY.setReferencedMob(target);
            if (!player.level.isClientSide()) {
            openCreaturesGUI(stack);
            return ActionResultType.PASS;
            }
        }
        return ActionResultType.PASS;
        //return ActionResultType.sidedSuccess(player.level.isClientSide);
    }

    @OnlyIn(Dist.CLIENT)
    public void openCreaturesGUI(ItemStack book) {
        Minecraft mc = Minecraft.getInstance();
        mc.setScreen(new GUICreatures());
    }

    public Map<Integer, List<Integer>> getCustomMap(ItemStack stack) {
        CompoundNBT nbt = stack.getOrCreateTag();
        Map<Integer, List<Integer>> map = new HashMap<>();

        CompoundNBT mapNBT = nbt.getCompound("CustomMap");

        for (String key : mapNBT.getAllKeys()) {
            int intKey = Integer.parseInt(key);
            ListNBT listNBT = mapNBT.getList(key, 3); // 3 is the tag type for int arrays
            List<Integer> list = listNBT.stream().map(inbt -> ((IntNBT) inbt).getAsInt()).collect(Collectors.toList());
            map.put(intKey, list);
        }

        return map;
    }

    public void addBirdPage(CreaturesBirdEntity e) {
        this.list.add(e);
    }

    public boolean birdPageExist(CreaturesBirdEntity e) {
        return this.list.contains(e);
    }


}
