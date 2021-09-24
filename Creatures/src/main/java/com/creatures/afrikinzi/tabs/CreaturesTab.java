package com.creatures.afrikinzi.tabs;

import com.creatures.afrikinzi.init.ItemInit;
import com.creatures.afrikinzi.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreaturesTab extends CreativeTabs {
    public CreaturesTab(String label) {
        super("itemsblockstab");
    }

    @Override
    public ItemStack getTabIconItem() {

        //For an item - return new ItemStack(ItemInit.EXAMPLE);
        //For a block - return new ItemStack(Item.getItemFromBlock(BlockInit.EXAMPLE));

        return new ItemStack(ItemInit.DUCK_FEATHER);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems(NonNullList<ItemStack> itemList) {
        super.displayAllRelevantItems(itemList);
        for (EntityList.EntityEggInfo eggInfo : EntityList.ENTITY_EGGS.values()) {
            if (eggInfo.spawnedID.getResourceDomain().equals(Reference.MOD_ID)) {
                ItemStack itemstack = new ItemStack(Items.SPAWN_EGG, 1);
                ItemMonsterPlacer.applyEntityIdToItemStack(itemstack, eggInfo.spawnedID);
                itemList.add(itemstack);
            }
        }
    }
}
