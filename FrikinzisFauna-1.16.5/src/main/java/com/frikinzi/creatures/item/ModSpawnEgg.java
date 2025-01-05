package com.frikinzi.creatures.item;


import com.frikinzi.creatures.entity.base.FishBase;
import com.frikinzi.creatures.entity.base.GroupFishBase;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ModSpawnEgg extends SpawnEggItem {
    private int currentSpecies;
    protected static final List<ModSpawnEgg> UNADDED_EGGS = new ArrayList<>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;


    public ModSpawnEgg(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int p_i48465_2_,
                       final int p_i48465_3_, final Properties p_i48465_4_) {
        super(null, p_i48465_2_, p_i48465_3_, p_i48465_4_);
        this.currentSpecies = 0;
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
    }

    public ModSpawnEgg(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int p_i48465_2_,
                       final int p_i48465_3_, final Properties p_i48465_4_) {
        super(null, p_i48465_2_, p_i48465_3_, p_i48465_4_);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier);
        UNADDED_EGGS.add(this);
    }

    public static void initUnaddedEggs() {
        final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class,
                null, "field_195987_b");
        DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior() {
            public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                EntityType<?> entitytype = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                entitytype.spawn(source.getLevel(), stack, null, source.getPos().relative(direction),
                        SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };
        for (final SpawnEggItem egg : UNADDED_EGGS) {
            EGGS.put(egg.getType(null), egg);
            DispenserBlock.registerBehavior(egg, defaultDispenseItemBehavior);
            // ItemColors for each spawn egg don't need to be registered because this method
            // is called before ItemColors is created
        }
        UNADDED_EGGS.clear();
    }

    @Override
    public EntityType<?> getType(@Nullable final CompoundNBT p_208076_1_) {
        return entityTypeSupplier.get();
    }


    @Override
    public Optional<MobEntity> spawnOffspringFromSpawnEgg(PlayerEntity p_234809_1_, MobEntity p_234809_2_, EntityType<? extends MobEntity> p_234809_3_, ServerWorld p_234809_4_, Vector3d p_234809_5_, ItemStack p_234809_6_) {
        if (!this.spawnsEntity(p_234809_6_.getTag(), p_234809_3_)) {
            return Optional.empty();
        } else {
            MobEntity mobentity;

            if (p_234809_2_ instanceof AgeableEntity) {
                mobentity = ((AgeableEntity)p_234809_2_).getBreedOffspring(p_234809_4_, (AgeableEntity)p_234809_2_);
            } else {
                mobentity = p_234809_3_.create(p_234809_4_);
                if (p_234809_2_ instanceof FishBase) {
                    ((FishBase)mobentity).setVariant(((FishBase) p_234809_2_).getVariant());
                    ((FishBase)mobentity).setSubVariant(((FishBase) p_234809_2_).getSubVariant());

                } if (p_234809_2_ instanceof GroupFishBase) {
                    ((GroupFishBase)mobentity).setVariant(((GroupFishBase) p_234809_2_).getVariant());
                    ((GroupFishBase)mobentity).setSubVariant(((GroupFishBase) p_234809_2_).getSubVariant());

                }
            }

            if (mobentity == null) {
                return Optional.empty();
            } else {
                mobentity.setBaby(true);
                if (!mobentity.isBaby()) {
                    return Optional.empty();
                } else {
                    mobentity.moveTo(p_234809_5_.x(), p_234809_5_.y(), p_234809_5_.z(), 0.0F, 0.0F);
                    p_234809_4_.addFreshEntityWithPassengers(mobentity);
                    if (p_234809_6_.hasCustomHoverName()) {
                        mobentity.setCustomName(p_234809_6_.getHoverName());
                    }

                    if (!p_234809_1_.abilities.instabuild) {
                        p_234809_6_.shrink(1);
                    }

                    return Optional.of(mobentity);
                }
            }
        }
    }

}
