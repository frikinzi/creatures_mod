package com.frikinzi.creatures;

import com.frikinzi.creatures.client.ClientProxy;
import com.frikinzi.creatures.client.CommonProxy;
import com.frikinzi.creatures.client.IUCNInteractionTrigger;
import com.frikinzi.creatures.client.block.CreaturesBlocks;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.item.ModSpawnEgg;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.registry.CreaturesSpawnEggs;
import com.frikinzi.creatures.registry.ModEntityTypes;
import com.frikinzi.creatures.util.FFLootModifier;
import com.frikinzi.creatures.util.Utils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.network.GeckoLibNetwork;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Creatures.MODID)
public class Creatures
{
    // Directly reference a log4j logger.
    public static final String MODID = "creatures";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final IUCNInteractionTrigger IUCN_INTERACTION_TRIGGER = new IUCNInteractionTrigger();

    public Creatures() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        CreaturesBlocks.register(modEventBus);
        CreaturesItems.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        CreaturesSpawnEggs.ITEMS.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CreaturesConfig.SPEC, "frikinzis-fauna-common.toml");
        PROXY.init();
        GeckoLib.initialize();
        GeckoLibNetwork.initialize();
    }
    public static CommonProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);


    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            Utils.addSpawnEggs();
        });
        CriteriaTriggers.register(IUCN_INTERACTION_TRIGGER);
        // some preinit code
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("creatures", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

        }

        @SubscribeEvent
        public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
            ModSpawnEgg.initUnaddedEggs();
        }

        @SubscribeEvent
        public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                               event) {
            event.getRegistry().registerAll(
                    new FFLootModifier.Serializer().setRegistryName
                            (new ResourceLocation(Creatures.MODID,"mealworms_dirt")),
                    new FFLootModifier.Serializer().setRegistryName
                            (new ResourceLocation(Creatures.MODID,"mealworms_farmland"))
            );
        }
    }

    private static void addSpawnEgg(Item item)
    {
        if (item instanceof SpawnEggItem)
        {
            Utils.EGG_MAP.put(((SpawnEggItem) item).getType(null), (SpawnEggItem) item);
        }
    }

    public static final ItemGroup CreaturesItemGroup = (new ItemGroup("creaturesitems") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CreaturesItems.RAW_KOI);
        }
    });
}
