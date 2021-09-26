package com.creatures.afrikinzi.util.handlers;

import com.creatures.afrikinzi.entity.arowana.EntityArowana;
import com.creatures.afrikinzi.entity.arowana.RenderArowana;
import com.creatures.afrikinzi.entity.barn_owl.EntityBarnOwl;
import com.creatures.afrikinzi.entity.barn_owl.RenderBarnOwl;
import com.creatures.afrikinzi.entity.conure.EntityConure;
import com.creatures.afrikinzi.entity.conure.RenderConure;
import com.creatures.afrikinzi.entity.dottyback.EntityDottyback;
import com.creatures.afrikinzi.entity.dottyback.RenderDottyback;
import com.creatures.afrikinzi.entity.dove.EntityDove;
import com.creatures.afrikinzi.entity.dove.RenderDove;
import com.creatures.afrikinzi.entity.fairy_wren.EntityFairyWren;
import com.creatures.afrikinzi.entity.fairy_wren.RenderFairyWren;
import com.creatures.afrikinzi.entity.ghostcrab.EntityGhostCrab;
import com.creatures.afrikinzi.entity.ghostcrab.RenderGhostCrab;
import com.creatures.afrikinzi.entity.golden_eagle.EntityGoldenEagle;
import com.creatures.afrikinzi.entity.golden_eagle.RenderGoldenEagle;
import com.creatures.afrikinzi.entity.goldfish.EntityGoldfish;
import com.creatures.afrikinzi.entity.goldfish.EntityRanchuGoldfish;
import com.creatures.afrikinzi.entity.goldfish.RenderGoldfish;
import com.creatures.afrikinzi.entity.goldfish.RenderRanchu;
import com.creatures.afrikinzi.entity.gourami.EntityGourami;
import com.creatures.afrikinzi.entity.gourami.RenderGourami;
import com.creatures.afrikinzi.entity.guppy.EntityGuppy;
import com.creatures.afrikinzi.entity.guppy.RenderGuppy;
import com.creatures.afrikinzi.entity.gyrfalcon.EntityGyrfalcon;
import com.creatures.afrikinzi.entity.gyrfalcon.RenderGyrfalcon;
import com.creatures.afrikinzi.entity.iberian_lynx.EntityIberianLynx;
import com.creatures.afrikinzi.entity.iberian_lynx.RenderIberianLynx;
import com.creatures.afrikinzi.entity.kakapo.EntityKakapo;
import com.creatures.afrikinzi.entity.kakapo.RenderKakapo;
import com.creatures.afrikinzi.entity.koi.EntityKoi;
import com.creatures.afrikinzi.entity.koi.RenderKoi;
import com.creatures.afrikinzi.entity.lorikeet.EntityLorikeet;
import com.creatures.afrikinzi.entity.lorikeet.RenderLorikeet;
import com.creatures.afrikinzi.entity.lovebird.EntityLovebird;
import com.creatures.afrikinzi.entity.lovebird.RenderLovebird;
import com.creatures.afrikinzi.entity.mandarin_duck.EntityMandarinDuck;
import com.creatures.afrikinzi.entity.mandarin_duck.RenderMandarinDuck;
import com.creatures.afrikinzi.entity.pike.EntityPike;
import com.creatures.afrikinzi.entity.pike.RenderPike;
import com.creatures.afrikinzi.entity.pygmyfalcon.EntityPygmyFalcon;
import com.creatures.afrikinzi.entity.pygmyfalcon.RenderPygmyFalcon;
import com.creatures.afrikinzi.entity.raven.EntityRaven;
import com.creatures.afrikinzi.entity.raven.RenderRaven;
import com.creatures.afrikinzi.entity.red_kite.EntityRedKite;
import com.creatures.afrikinzi.entity.red_kite.RenderRedKite;
import com.creatures.afrikinzi.entity.roller.EntityRoller;
import com.creatures.afrikinzi.entity.roller.RenderRoller;
import com.creatures.afrikinzi.entity.shrimp.EntityShrimp;
import com.creatures.afrikinzi.entity.shrimp.RenderShrimp;
import com.creatures.afrikinzi.entity.creatures_spoonbill.EntityCreaturesSpoonbill;
import com.creatures.afrikinzi.entity.creatures_spoonbill.RenderCreaturesSpoonbill;
import com.creatures.afrikinzi.entity.stellers_sea_eagle.EntityStellersSeaEagle;
import com.creatures.afrikinzi.entity.stellers_sea_eagle.RenderStellersSeaEagle;
import com.creatures.afrikinzi.entity.wild_duck.EntityWildDuck;
import com.creatures.afrikinzi.entity.wild_duck.RenderWildDuck;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
    public static void registerEntityRenders()
    {
        //aquatic creatures
        RenderingRegistry.registerEntityRenderingHandler(EntityKoi.class, RenderKoi::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDottyback.class, RenderDottyback::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPike.class, RenderPike::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityArowana.class, RenderArowana::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGuppy.class, RenderGuppy::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityShrimp.class, RenderShrimp::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGourami.class, RenderGourami::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGhostCrab.class, RenderGhostCrab::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldfish.class, RenderGoldfish::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRanchuGoldfish.class, RenderRanchu::new);

        //avians
        RenderingRegistry.registerEntityRenderingHandler(EntityLovebird.class, RenderLovebird::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityKakapo.class, RenderKakapo::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCreaturesSpoonbill.class, RenderCreaturesSpoonbill::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMandarinDuck.class, RenderMandarinDuck::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRaven.class, RenderRaven::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDove.class, RenderDove::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRedKite.class, RenderRedKite::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldenEagle.class, RenderGoldenEagle::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityStellersSeaEagle.class, RenderStellersSeaEagle::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGyrfalcon.class, RenderGyrfalcon::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityConure.class, RenderConure::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLorikeet.class, RenderLorikeet::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFairyWren.class, RenderFairyWren::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPygmyFalcon.class, RenderPygmyFalcon::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBarnOwl.class, RenderBarnOwl::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityWildDuck.class, RenderWildDuck::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRoller.class, RenderRoller::new);

        //land animals
        RenderingRegistry.registerEntityRenderingHandler(EntityIberianLynx.class, RenderIberianLynx::new);
    }
}
