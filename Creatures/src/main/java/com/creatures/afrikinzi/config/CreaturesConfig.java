package com.creatures.afrikinzi.config;

import com.creatures.afrikinzi.util.Reference;
import net.minecraftforge.common.config.Config;

@Config(modid = Reference.MOD_ID, name = "Creatures-" + Reference.VERSION+ "Config")
@Config.LangKey("config.creatures.title")
public class CreaturesConfig {
    @Config.Name("All spawns")
    @Config.Comment("Enables natural spawning of entities from Creatures.")
    public static boolean allSpawns = true;

    //water creatures
    @Config.Name("Koi spawns")
    @Config.Comment("Enables natural spawning of Koi.")
    public static boolean koiSpawns = true;

    @Config.Name("Dottyback spawns")
    @Config.Comment("Enables natural spawning of Dottyback.")
    public static boolean dottybackSpawns = true;

    @Config.Name("Pike spawns")
    @Config.Comment("Enables natural spawning of Pike.")
    public static boolean pikeSpawns = true;

    @Config.Name("Arowana spawns")
    @Config.Comment("Enables natural spawning of Arowana.")
    public static boolean arowanaSpawns = true;

    @Config.Name("Shrimp spawns")
    @Config.Comment("Enables natural spawning of Shrimp.")
    public static boolean shrimpSpawns = true;

    @Config.Name("Guppy spawns")
    @Config.Comment("Enables natural spawning of Guppies.")
    public static boolean guppySpawns = true;

    @Config.Name("Gourami spawns")
    @Config.Comment("Enables natural spawning of Gouramis.")
    public static boolean gouramiSpawns = true;

    @Config.Name("Ghost crab spawns")
    @Config.Comment("Enables natural spawning of Ghost Crabs.")
    public static boolean ghostcrabSpawns = true;

    //avians
    @Config.Name("Lovebird spawns")
    @Config.Comment("Enables natural spawning of Lovebirds.")
    public static boolean lovebirdSpawns = true;

    @Config.Name("Spoonbill spawns")
    @Config.Comment("Enables natural spawning of Spoonbills.")
    public static boolean spoonbillSpawns = true;

    @Config.Name("Mandarin Duck spawns")
    @Config.Comment("Enables natural spawning of Mandarin Ducks.")
    public static boolean mandarinduckSpawns = true;

    @Config.Name("Raven spawns")
    @Config.Comment("Enables natural spawning of Ravens.")
    public static boolean ravenSpawns = true;

    @Config.Name("Kakapo spawns")
    @Config.Comment("Enables natural spawning of Kakapos.")
    public static boolean kakapoSpawns = true;

    @Config.Name("Ghost crab spawns")
    @Config.Comment("Enables natural spawning of Doves.")
    public static boolean doveSpawns = true;

    @Config.Name("Red kite spawns")
    @Config.Comment("Enables natural spawning of Red Kites.")
    public static boolean redkiteSpawns = true;

    @Config.Name("Golden eagle spawns")
    @Config.Comment("Enables natural spawning of Golden Eagles.")
    public static boolean goldeneagleSpawns = true;

    @Config.Name("Steller's sea eagle spawns")
    @Config.Comment("Enables natural spawning of Steller's Sea Eagle.")
    public static boolean stellersseaeagleSpawns = true;

    @Config.Name("Ghost crab spawns")
    @Config.Comment("Enables natural spawning of Gyrfalcons.")
    public static boolean gyrfalconSpawns = true;

    @Config.Name("Conure spawns")
    @Config.Comment("Enables natural spawning of Conures.")
    public static boolean conureSpawns = true;

    @Config.Name("Lorikeet spawns")
    @Config.Comment("Enables natural spawning of Lorikeets.")
    public static boolean lorikeetSpawns = true;

    @Config.Name("Fairy wren spawns")
    @Config.Comment("Enables natural spawning of Fairy Wrens.")
    public static boolean fairywrenSpawns = true;

    @Config.Name("Pygmy falcon spawns")
    @Config.Comment("Enables natural spawning of Pygmy falcons.")
    public static boolean pygmyfalconSpawns = true;

    @Config.Name("Barn owl spawns")
    @Config.Comment("Enables natural spawning of Barn Owls.")
    public static boolean barnowlSpawns = true;
}