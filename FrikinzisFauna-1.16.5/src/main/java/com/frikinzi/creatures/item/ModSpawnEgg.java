package com.frikinzi.creatures.item;

<<<<<<< Updated upstream
import net.minecraft.block.DispenserBlock;
=======
import com.frikinzi.creatures.entity.LovebirdEntity;
import com.frikinzi.creatures.entity.base.AbstractCrabBase;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.registry.ModEntityTypes;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.util.ITooltipFlag;
>>>>>>> Stashed changes
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
<<<<<<< Updated upstream
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
=======
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
>>>>>>> Stashed changes
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModSpawnEgg extends SpawnEggItem {
<<<<<<< Updated upstream
    protected static final List<ModSpawnEgg> UNADDED_EGGS = new ArrayList<>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;

    public ModSpawnEgg(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int p_i48465_2_,
                       final int p_i48465_3_, final Properties p_i48465_4_) {
        super(null, p_i48465_2_, p_i48465_3_, p_i48465_4_);
=======
    private int currentSpecies;
    protected static final List<ModSpawnEgg> UNADDED_EGGS = new ArrayList<>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;


    public ModSpawnEgg(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int p_i48465_2_,
                       final int p_i48465_3_, final Properties p_i48465_4_) {
        super(null, p_i48465_2_, p_i48465_3_, p_i48465_4_);
        this.currentSpecies = 0;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
}