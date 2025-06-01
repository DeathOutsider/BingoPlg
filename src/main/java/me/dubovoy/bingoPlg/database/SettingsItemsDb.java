package me.dubovoy.bingoPlg.database;

import me.dubovoy.bingoPlg.BingoPlg;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SettingsItemsDb {
    private final BingoPlg bingoPlg;
    public SettingsItemsDb(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    public void fillSettings(){
        List<String> items = fillItems();
        List<String> materials = fillMaterials();
        List<Integer> qualities = fillQualities();
        for (int i = 0; i < items.size(); i++) {
            try {

                bingoPlg.getDb().addItemSetting(items.get(i), materials.get(i), qualities.get(i));
            } catch (SQLException e) {
                bingoPlg.LogErrorsMsg(e);
            }
        }
    }

    public void fillBingo() {
        List<String> allItems = new ArrayList<>();

        String[][] items ={
                //ItemName, Material, Meta, Difficulty, MinecraftType, BingoType
                {"Acacia Boat", "ACACIA_BOAT", "", "3", "Tools & Utilities", ""},
                {"Acacia Boat with Chest", "ACACIA_CHEST_BOAT", "", "3", "Tools & Utilities", ""},
                {"Acacia Button", "ACACIA_BUTTON", "", "3", "Building Blocks", ""},
                {"Acacia Door", "ACACIA_DOOR", "", "3", "Building Blocks", ""},
                {"Acacia Fence", "ACACIA_FENCE", "", "3", "Building Blocks", ""},
                {"Acacia Fence Gate", "ACACIA_FENCE_GATE", "", "3", "Building Blocks", ""},
                {"Acacia Hanging Sign", "ACACIA_HANGING_SIGN", "", "3", "Functional Blocks", ""},
                {"Acacia Leaves", "ACACIA_LEAVES", "", "3", "Natural Blocks", ""},
                {"Acacia Log", "ACACIA_LOG", "", "3", "Building Blocks", ""},
                {"Acacia Planks", "ACACIA_PLANKS", "", "3", "Building Blocks", ""},
                {"Acacia Pressure Plate", "ACACIA_PRESSURE_PLATE", "", "3", "Building Blocks", ""},
                {"Acacia Sapling", "ACACIA_SAPLING", "", "3", "Natural Blocks", ""},
                {"Acacia Sign", "ACACIA_SIGN", "", "3", "Functional Blocks", ""},
                {"Acacia Slab", "ACACIA_SLAB", "", "3", "Building Blocks", ""},
                {"Acacia Stairs", "ACACIA_STAIRS", "", "3", "Building Blocks", ""},
                {"Acacia Trapdoor", "ACACIA_TRAPDOOR", "", "3", "Building Blocks", ""},
                {"Acacia Wood", "ACACIA_WOOD", "", "3", "Building Blocks", ""},
                {"Activator Rail", "ACTIVATOR_RAIL", "", "2", "Redstone Blocks", ""},
                {"Allium", "ALLIUM", "", "1", "Natural Blocks", ""},
                {"Amethyst Cluster", "AMETHYST_CLUSTER", "", "5", "Natural Blocks", ""},
                {"Amethyst Shard", "AMETHYST_SHARD", "", "4", "Ingidients", ""},
                {"Ancient Debris", "ANCIENT_DEBRIS", "", "5", "Natural Blocks", ""},
                {"Andesite", "ANDESITE", "", "2", "Building Blocks", ""},
                {"Andesite Slab", "ANDESITE_SLAB", "", "2", "Building Blocks", ""},
                {"Andesite Stairs", "ANDESITE_STAIRS", "", "2", "Building Blocks", ""},
                {"Andesite Wall", "ANDESITE_WALL", "", "2", "Building Blocks", ""},
                {"Angler Pottery Sherd", "ANGLER_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Anvil", "ANVIL", "", "3", "Functional Blocks", ""},
                {"Apple", "APPLE", "", "1", "Food & Drinks", ""},
                {"Archer Pottery Sherd", "ARCHER_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Armadillo Scute", "ARMADILLO_SCUTE", "", "3", "Ingidients", ""},
                {"Armor Stand", "ARMOR_STAND", "", "2", "Functional Blocks", ""},
                {"Arms Up Pottery Sherd", "ARMS_UP_POTTERY_SHERD", "", "6", "Ingidients", ""},
                {"Arrow", "ARROW", "", "2", "Combat", ""},
                {"Azalea", "AZALEA", "", "3", "Natural Blocks", ""},
                {"Azalea Leaves", "AZALEA_LEAVES", "", "3", "Natural Blocks", ""},
                {"Azure Bluet", "AZURE_BLUET", "", "1", "Natural Blocks", ""},
                {"Baked Potato", "BAKED_POTATO", "", "3", "Food & Drinks", ""},
                {"Bamboo", "BAMBOO", "", "4", "Natural Blocks", ""},
                {"Bamboo Button", "BAMBOO_BUTTON", "", "4", "Building Blocks", ""},
                {"Bamboo Door", "BAMBOO_DOOR", "", "4", "Building Blocks", ""},
                {"Bamboo Fence", "BAMBOO_FENCE", "", "4", "Building Blocks", ""},
                {"Bamboo Fence Gate", "BAMBOO_FENCE_GATE", "", "4", "Building Blocks", ""},
                {"Bamboo Hanging Sign", "BAMBOO_HANGING_SIGN", "", "4", "Functional Blocks", ""},
                {"Bamboo Mosaic", "BAMBOO_MOSAIC", "", "4", "Building Blocks", ""},
                {"Bamboo Mosaic Slab", "BAMBOO_MOSAIC_SLAB", "", "4", "Building Blocks", ""},
                {"Bamboo Mosaic Stairs", "BAMBOO_MOSAIC_STAIRS", "", "4", "Building Blocks", ""},
                {"Bamboo Planks", "BAMBOO_PLANKS", "", "4", "Building Blocks", ""},
                {"Bamboo Pressure Plate", "BAMBOO_PRESSURE_PLATE", "", "4", "Building Blocks", ""},
                {"Bamboo Raft", "BAMBOO_RAFT", "", "4", "Tools & Utilities", ""},
                {"Bamboo Raft with Chest", "BAMBOO_CHEST_RAFT", "", "4", "Tools & Utilities", ""},
                {"Bamboo Sign", "BAMBOO_SIGN", "", "4", "Functional Blocks", ""},
                {"Bamboo Slab", "BAMBOO_SLAB", "", "4", "Building Blocks", ""},
                {"Bamboo Stairs", "BAMBOO_STAIRS", "", "4", "Building Blocks", ""},
                {"Bamboo Trapdoor", "BAMBOO_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Barrel", "BARREL", "", "1", "Functional Blocks", ""},
                {"Basalt", "BASALT", "", "3", "Building Blocks", ""},
                {"Beacon", "BEACON", "", "6", "Functional Blocks", ""},
                {"Bedrock", "BEDROCK", "", "0", "Natural Blocks", ""},
                {"Bee Nest", "BEE_NEST", "", "4", "Natural Blocks", ""},
                {"Beehive", "BEEHIVE", "", "3", "Functional Blocks", ""},
                {"Beetroot", "BEETROOT", "", "3", "Food & Drinks", ""},
                {"Beetroot Seeds", "BEETROOT_SEEDS", "", "3", "Natural Blocks", ""},
                {"Beetroot Soup", "BEETROOT_SOUP", "", "3", "Food & Drinks", ""},
                {"Bell", "BELL", "", "3", "Functional Blocks", ""},
                {"Big Dripleaf", "BIG_DRIPLEAF", "", "3", "Natural Blocks", ""},
                {"Birch Boat", "BIRCH_BOAT", "", "1", "Tools & Utilities", ""},
                {"Birch Boat with Chest", "BIRCH_CHEST_BOAT", "", "1", "Tools & Utilities", ""},
                {"Birch Button", "BIRCH_BUTTON", "", "1", "Building Blocks", ""},
                {"Birch Door", "BIRCH_DOOR", "", "1", "Building Blocks", ""},
                {"Birch Fence", "BIRCH_FENCE", "", "1", "Building Blocks", ""},
                {"Birch Fence Gate", "BIRCH_FENCE_GATE", "", "1", "Building Blocks", ""},
                {"Birch Hanging Sign", "BIRCH_HANGING_SIGN", "", "1", "Functional Blocks", ""},
                {"Birch Leaves", "BIRCH_LEAVES", "", "2", "Natural Blocks", ""},
                {"Birch Log", "BIRCH_LOG", "", "1", "Building Blocks", ""},
                {"Birch Planks", "BIRCH_PLANKS", "", "1", "Building Blocks", ""},
                {"Birch Pressure Plate", "BIRCH_PRESSURE_PLATE", "", "1", "Building Blocks", ""},
                {"Birch Sapling", "BIRCH_SAPLING", "", "1", "Natural Blocks", ""},
                {"Birch Sign", "BIRCH_SIGN", "", "1", "Functional Blocks", ""},
                {"Birch Slab", "BIRCH_SLAB", "", "1", "Building Blocks", ""},
                {"Birch Stairs", "BIRCH_STAIRS", "", "1", "Building Blocks", ""},
                {"Birch Trapdoor", "BIRCH_TRAPDOOR", "", "1", "Building Blocks", ""},
                {"Birch Wood", "BIRCH_WOOD", "", "1", "Building Blocks", ""},
                {"Biscuit", "COOKIE", "", "4", "Food & Drinks", ""},
                {"Black Banner", "BLACK_BANNER", "", "2", "Colored Blocks", ""},
                {"Black Bed", "BLACK_BED", "", "2", "Colored Blocks", ""},
                {"Black Bundle", "BLACK_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Black Candle", "BLACK_CANDLE", "", "3", "Colored Blocks", ""},
                {"Black Carpet", "BLACK_CARPET", "", "2", "Colored Blocks", ""},
                {"Black Concrete", "BLACK_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Black Concrete Powder", "BLACK_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Black Dye", "BLACK_DYE", "", "1", "Ingidients", ""},
                {"Black Glazed Terracotta", "BLACK_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Black Shulker Box", "BLACK_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Black Stained Glass", "BLACK_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Black Stained Glass Pane", "BLACK_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Black Terracotta", "BLACK_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Black Wool", "BLACK_WOOL", "", "2", "Colored Blocks", ""},
                {"Blackstone", "BLACKSTONE", "", "3", "Building Blocks", ""},
                {"Blackstone Slab", "BLACKSTONE_SLAB", "", "3", "Building Blocks", ""},
                {"Blackstone Stairs", "BLACKSTONE_STAIRS", "", "3", "Building Blocks", ""},
                {"Blackstone Wall", "BLACKSTONE_WALL", "", "3", "Building Blocks", ""},
                {"Blade Pottery Sherd", "BLADE_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Blast Furnace", "BLAST_FURNACE", "", "2", "Functional Blocks", ""},
                {"Blaze Powder", "BLAZE_POWDER", "", "3", "Ingidients", ""},
                {"Blaze Rod", "BLAZE_ROD", "", "3", "Ingidients", ""},
                {"Block of Amethyst", "AMETHYST_BLOCK", "", "4", "Building Blocks", ""},
                {"Block of Bamboo", "BAMBOO_BLOCK", "", "4", "Building Blocks", ""},
                {"Block of Coal", "COAL_BLOCK", "", "1", "Building Blocks", ""},
                {"Block of Copper", "COPPER_BLOCK", "", "1", "Building Blocks", ""},
                {"Block of Diamond", "DIAMOND_BLOCK", "", "3", "Building Blocks", ""},
                {"Block of Emerald", "EMERALD_BLOCK", "", "3", "Building Blocks", ""},
                {"Block of Gold", "GOLD_BLOCK", "", "2", "Building Blocks", ""},
                {"Block of Iron", "IRON_BLOCK", "", "2", "Building Blocks", ""},
                {"Block of Lapis Lazuli", "LAPIS_BLOCK", "", "3", "Building Blocks", ""},
                {"Block of Netherite", "NETHERITE_BLOCK", "", "5", "Building Blocks", ""},
                {"Block of Quartz", "QUARTZ_BLOCK", "", "2", "Building Blocks", ""},
                {"Block of Raw Copper", "RAW_COPPER_BLOCK", "", "2", "Natural Blocks", ""},
                {"Block of Raw Gold", "RAW_GOLD_BLOCK", "", "3", "Natural Blocks", ""},
                {"Block of Raw Iron", "RAW_IRON_BLOCK", "", "2", "Natural Blocks", ""},
                {"Block of Redstone", "REDSTONE_BLOCK", "", "2", "Building Blocks", ""},
                {"Block of Resin", "RESIN_BLOCK", "", "4", "Natural Blocks", ""},
                {"Block of Stripped Bamboo", "STRIPPED_BAMBOO_BLOCK", "", "4", "Building Blocks", ""},
                {"Blue Banner", "BLUE_BANNER", "", "2", "Colored Blocks", ""},
                {"Blue Bed", "BLUE_BED", "", "2", "Colored Blocks", ""},
                {"Blue Bundle", "BLUE_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Blue Candle", "BLUE_CANDLE", "", "3", "Colored Blocks", ""},
                {"Blue Carpet", "BLUE_CARPET", "", "2", "Colored Blocks", ""},
                {"Blue Concrete", "BLUE_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Blue Concrete Powder", "BLUE_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Blue Dye", "BLUE_DYE", "", "1", "Ingidients", ""},
                {"Blue Egg", "BLUE_EGG", "", "4", "Combat", ""},
                {"Blue Glazed Terracotta", "BLUE_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Blue Ice", "BLUE_ICE", "", "4", "Natural Blocks", ""},
                {"Blue Orchid", "BLUE_ORCHID", "", "3", "Natural Blocks", ""},
                {"Blue Shulker Box", "BLUE_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Blue Stained Glass", "BLUE_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Blue Stained Glass Pane", "BLUE_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Blue Terracotta", "BLUE_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Blue Wool", "BLUE_WOOL", "", "2", "Colored Blocks", ""},
                {"Bolt Armour Trim", "BOLT_ARMOR_TRIM_SMITHING_TEMPLATE", "", "4", "Ingidients", ""},
                {"Bone", "BONE", "", "2", "Ingidients", ""},
                {"Bone Block", "BONE_BLOCK", "", "2", "Natural Blocks", ""},
                {"Bone Meal", "BONE_MEAL", "", "2", "Tools & Utilities", ""},
                {"Book", "BOOK", "", "2", "Ingidients", ""},
                {"Book and Quill", "WRITABLE_BOOK", "", "2", "Tools & Utilities", ""},
                {"Bookshelf", "BOOKSHELF", "", "2", "Functional Blocks", ""},
                {"Bottle o' Enchanting", "EXPERIENCE_BOTTLE", "", "5", "Ingidients", ""},
                {"Bow", "BOW", "", "2", "Combat", ""},
                {"Bowl", "BOWL", "", "1", "Ingidients", ""},
                {"Brain Coral", "BRAIN_CORAL", "", "4", "Natural Blocks", ""},
                {"Brain Coral Block", "BRAIN_CORAL_BLOCK", "", "4", "Natural Blocks", ""},
                {"Brain Coral Fan", "BRAIN_CORAL_FAN", "", "4", "Natural Blocks", ""},
                {"Bread", "BREAD", "", "2", "Food & Drinks", ""},
                {"Breeze Rod", "BREEZE_ROD", "", "4", "Ingidients", ""},
                {"Brewer Pottery Sherd", "BREWER_POTTERY_SHERD", "", "6", "Ingidients", ""},
                {"Brewing Stand", "BREWING_STAND", "", "3", "Functional Blocks", ""},
                {"Brick", "BRICK", "", "1", "Ingidients", ""},
                {"Brick Slab", "BRICK_SLAB", "", "2", "Building Blocks", ""},
                {"Brick Stairs", "BRICK_STAIRS", "", "2", "Building Blocks", ""},
                {"Brick Wall", "BRICK_WALL", "", "2", "Building Blocks", ""},
                {"Bricks", "BRICKS", "", "2", "Building Blocks", ""},
                {"Brown Banner", "BROWN_BANNER", "", "4", "Colored Blocks", ""},
                {"Brown Bed", "BROWN_BED", "", "4", "Colored Blocks", ""},
                {"Brown Bundle", "BROWN_BUNDLE", "", "4", "Tools & Utilities", ""},
                {"Brown Candle", "BROWN_CANDLE", "", "4", "Colored Blocks", ""},
                {"Brown Carpet", "BROWN_CARPET", "", "4", "Colored Blocks", ""},
                {"Brown Concrete", "BROWN_CONCRETE", "", "4", "Colored Blocks", ""},
                {"Brown Concrete Powder", "BROWN_CONCRETE_POWDER", "", "4", "Colored Blocks", ""},
                {"Brown Dye", "BROWN_DYE", "", "4", "Ingidients", ""},
                {"Brown Egg", "BROWN_EGG", "", "3", "Combat", ""},
                {"Brown Glazed Terracotta", "BROWN_GLAZED_TERRACOTTA", "", "4", "Colored Blocks", ""},
                {"Brown Mushroom", "BROWN_MUSHROOM", "", "2", "Natural Blocks", ""},
                {"Brown Mushroom Block", "BROWN_MUSHROOM_BLOCK", "", "4", "Natural Blocks", ""},
                {"Brown Shulker Box", "BROWN_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Brown Stained Glass", "BROWN_STAINED_GLASS", "", "4", "Colored Blocks", ""},
                {"Brown Stained Glass Pane", "BROWN_STAINED_GLASS_PANE", "", "4", "Colored Blocks", ""},
                {"Brown Terracotta", "BROWN_TERRACOTTA", "", "4", "Colored Blocks", ""},
                {"Brown Wool", "BROWN_WOOL", "", "4", "Colored Blocks", ""},
                {"Brush", "BRUSH", "", "2", "Tools & Utilities", ""},
                {"Bubble Coral", "BUBBLE_CORAL", "", "4", "Natural Blocks", ""},
                {"Bubble Coral Block", "BUBBLE_CORAL_BLOCK", "", "4", "Natural Blocks", ""},
                {"Bubble Coral Fan", "BUBBLE_CORAL_FAN", "", "4", "Natural Blocks", ""},
                {"Bucket", "BUCKET", "", "2", "Tools & Utilities", ""},
                {"Bucket of Axolotl", "AXOLOTL_BUCKET", "", "4", "Tools & Utilities", ""},
                {"Bucket of Cod", "COD_BUCKET", "", "2", "Tools & Utilities", ""},
                {"Bucket of Pufferfish", "PUFFERFISH_BUCKET", "", "5", "Tools & Utilities", ""},
                {"Bucket of Salmon", "SALMON_BUCKET", "", "2", "Tools & Utilities", ""},
                {"Bucket of Tadpole", "TADPOLE_BUCKET", "", "4", "Tools & Utilities", ""},
                {"Bucket of Tropical Fish", "TROPICAL_FISH_BUCKET", "", "3", "Tools & Utilities", ""},
                {"Budding Amethyst", "BUDDING_AMETHYST", "", "0", "Natural Blocks", ""},
                {"Bundle", "BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Burn Pottery Sherd", "BURN_POTTERY_SHERD", "", "4", "Ingidients", ""},
                {"Bush", "BUSH", "", "2", "Natural Blocks", ""},
                {"Cactus", "CACTUS", "", "4", "Natural Blocks", ""},
                {"Cactus Flower", "CACTUS_FLOWER", "", "4", "Natural Blocks", ""},
                {"Cake", "CAKE", "", "2", "Food & Drinks", ""},
                {"Calcite", "CALCITE", "", "4", "Natural Blocks", ""},
                {"Calibrated Sculk Sensor", "CALIBRATED_SCULK_SENSOR", "", "4", "Redstone Blocks", ""},
                {"Campfire", "CAMPFIRE", "", "1", "Functional Blocks", ""},
                {"Candle", "CANDLE", "", "3", "Colored Blocks", ""},
                {"Carrot", "CARROT", "", "3", "Food & Drinks", ""},
                {"Carrot on a Stick", "CARROT_ON_A_STICK", "", "3", "Tools & Utilities", ""},
                {"Cartography Table", "CARTOGRAPHY_TABLE", "", "1", "Functional Blocks", ""},
                {"Carved Pumpkin", "CARVED_PUMPKIN", "", "2", "Natural Blocks", ""},
                {"Cauldron", "CAULDRON", "", "2", "Functional Blocks", ""},
                {"Chain", "CHAIN", "", "2", "Building Blocks", ""},
                {"Chainmail Boots", "CHAINMAIL_BOOTS", "", "5", "Combat", ""},
                {"Chainmail Chestplate", "CHAINMAIL_CHESTPLATE", "", "5", "Combat", ""},
                {"Chainmail Helmet", "CHAINMAIL_HELMET", "", "5", "Combat", ""},
                {"Chainmail Leggins", "CHAINMAIL_LEGGINGS", "", "5", "Combat", ""},
                {"Charcoal", "CHARCOAL", "", "1", "Ingidients", ""},
                {"Cherry Boat", "CHERRY_BOAT", "", "4", "Tools & Utilities", ""},
                {"Cherry Boat with Chest", "CHERRY_CHEST_BOAT", "", "4", "Tools & Utilities", ""},
                {"Cherry Button", "CHERRY_BUTTON", "", "4", "Building Blocks", ""},
                {"Cherry Door", "CHERRY_DOOR", "", "4", "Building Blocks", ""},
                {"Cherry Fence", "CHERRY_FENCE", "", "4", "Building Blocks", ""},
                {"Cherry Fence Gate", "CHERRY_FENCE_GATE", "", "4", "Building Blocks", ""},
                {"Cherry Hanging Sign", "CHERRY_HANGING_SIGN", "", "4", "Functional Blocks", ""},
                {"Cherry Leaves", "CHERRY_LEAVES", "", "4", "Natural Blocks", ""},
                {"Cherry Log", "CHERRY_LOG", "", "4", "Building Blocks", ""},
                {"Cherry Planks", "CHERRY_PLANKS", "", "4", "Building Blocks", ""},
                {"Cherry Pressure Plate", "CHERRY_PRESSURE_PLATE", "", "4", "Building Blocks", ""},
                {"Cherry Sapling", "CHERRY_SAPLING", "", "4", "Natural Blocks", ""},
                {"Cherry Sign", "CHERRY_SIGN", "", "4", "Functional Blocks", ""},
                {"Cherry Slab", "CHERRY_SLAB", "", "4", "Building Blocks", ""},
                {"Cherry Stairs", "CHERRY_STAIRS", "", "4", "Building Blocks", ""},
                {"Cherry Trapdoor", "CHERRY_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Cherry Wood", "CHERRY_WOOD", "", "4", "Building Blocks", ""},
                {"Chest", "CHEST", "", "1", "Functional Blocks", ""},
                {"Chipped Anvil", "CHIPPED_ANVIL", "", "3", "Functional Blocks", ""},
                {"Chiseled Bookshelf", "CHISELED_BOOKSHELF", "", "1", "Functional Blocks", ""},
                {"Chiseled Copper", "CHISELED_COPPER", "", "2", "Building Blocks", ""},
                {"Chiseled Deepslate", "CHISELED_DEEPSLATE", "", "2", "Building Blocks", ""},
                {"Chiseled Nether Bricks", "CHISELED_NETHER_BRICKS", "", "2", "Building Blocks", ""},
                {"Chiseled Polished Blackstone", "CHISELED_POLISHED_BLACKSTONE", "", "3", "Building Blocks", ""},
                {"Chiseled Quartz Block", "CHISELED_QUARTZ_BLOCK", "", "2", "Building Blocks", ""},
                {"Chiseled Red Sandstone", "CHISELED_RED_SANDSTONE", "", "4", "Building Blocks", ""},
                {"Chiseled Resin Bricks", "CHISELED_RESIN_BRICKS", "", "4", "Building Blocks", ""},
                {"Chiseled Sandstone", "CHISELED_SANDSTONE", "", "1", "Building Blocks", ""},
                {"Chiseled Stone Bricks", "CHISELED_STONE_BRICKS", "", "1", "Building Blocks", ""},
                {"Chiseled Tuff", "CHISELED_TUFF", "", "2", "Building Blocks", ""},
                {"Chiseled Tuff Bricks", "CHISELED_TUFF_BRICKS", "", "2", "Building Blocks", ""},
                {"Chorus Flower", "CHORUS_FLOWER", "", "6", "Natural Blocks", ""},
                {"Chorus Fruit", "CHORUS_FRUIT", "", "6", "Food & Drinks", ""},
                {"Chorus Plant", "CHORUS_PLANT", "", "6", "Natural Blocks", ""},
                {"Clay", "CLAY", "", "1", "Natural Blocks", ""},
                {"Clay Ball", "CLAY_BALL", "", "1", "Ingidients", ""},
                {"Clock", "CLOCK", "", "2", "Tools & Utilities", ""},
                {"Closed Eyeblossom", "CLOSED_EYEBLOSSOM", "", "4", "Natural Blocks", ""},
                {"Coal", "COAL", "", "1", "Ingidients", ""},
                {"Coal Ore", "COAL_ORE", "", "4", "Natural Blocks", ""},
                {"Coarse Dirt", "COARSE_DIRT", "", "1", "Natural Blocks", ""},
                {"Coast Armour Trim", "COAST_ARMOR_TRIM_SMITHING_TEMPLATE", "", "3", "Ingidients", ""},
                {"Cobbled Deepslate", "COBBLED_DEEPSLATE", "", "2", "Building Blocks", ""},
                {"Cobbled Deepslate Slab", "COBBLED_DEEPSLATE_SLAB", "", "2", "Building Blocks", ""},
                {"Cobbled Deepslate Stairs", "COBBLED_DEEPSLATE_STAIRS", "", "2", "Building Blocks", ""},
                {"Cobbled Deepslate Wall", "COBBLED_DEEPSLATE_WALL", "", "2", "Building Blocks", ""},
                {"Cobblestone", "COBBLESTONE", "", "1", "Building Blocks", ""},
                {"Cobblestone Slab", "COBBLESTONE_SLAB", "", "1", "Building Blocks", ""},
                {"Cobblestone Stairs", "COBBLESTONE_STAIRS", "", "1", "Building Blocks", ""},
                {"Cobblestone Wall", "COBBLESTONE_WALL", "", "1", "Building Blocks", ""},
                {"Cobweb", "COBWEB", "", "3", "Natural Blocks", ""},
                {"Cocoa Beans", "COCOA_BEANS", "", "4", "Natural Blocks", ""},
                {"Compass", "COMPASS", "", "2", "Tools & Utilities", ""},
                {"Composter", "COMPOSTER", "", "1", "Functional Blocks", ""},
                {"Conduit", "CONDUIT", "", "6", "Functional Blocks", ""},
                {"Cooked Cod", "COOKED_COD", "", "1", "Food & Drinks", ""},
                {"Cooked Mutton", "COOKED_MUTTON", "", "1", "Food & Drinks", ""},
                {"Cooked Porkchop", "COOKED_PORKCHOP", "", "1", "Food & Drinks", ""},
                {"Cooked Rabbit", "COOKED_RABBIT", "", "3", "Food & Drinks", ""},
                {"Cooked Salmon", "COOKED_SALMON", "", "1", "Food & Drinks", ""},
                {"Copper Bulb", "COPPER_BULB", "", "4", "Building Blocks", ""},
                {"Copper Door", "COPPER_DOOR", "", "1", "Building Blocks", ""},
                {"Copper Grate", "COPPER_GRATE", "", "1", "Building Blocks", ""},
                {"Copper Ingot", "COPPER_INGOT", "", "1", "Ingidients", ""},
                {"Copper Ore", "COPPER_ORE", "", "4", "Natural Blocks", ""},
                {"Copper Trapdoor", "COPPER_TRAPDOOR", "", "1", "Building Blocks", ""},
                {"Cornflower", "CORNFLOWER", "", "1", "Natural Blocks", ""},
                {"Cracked Deepslate Bricks", "CRACKED_DEEPSLATE_BRICKS", "", "2", "Building Blocks", ""},
                {"Cracked Deepslate Tiles", "CRACKED_DEEPSLATE_TILES", "", "2", "Building Blocks", ""},
                {"Cracked Nether Bricks", "CRACKED_NETHER_BRICKS", "", "2", "Building Blocks", ""},
                {"Cracked Polished Blackstone Bricks", "CRACKED_POLISHED_BLACKSTONE_BRICKS", "", "4", "Building Blocks", ""},
                {"Cracked Stone Bricks", "CRACKED_STONE_BRICKS", "", "1", "Building Blocks", ""},
                {"Crafter", "CRAFTER", "", "2", "Redstone Blocks", ""},
                {"Crafting Table", "CRAFTING_TABLE", "", "1", "Functional Blocks", ""},
                {"Creeper Head", "CREEPER_HEAD", "", "6", "Functional Blocks", ""},
                {"Crimson Button", "CRIMSON_BUTTON", "", "4", "Building Blocks", ""},
                {"Crimson Door", "CRIMSON_DOOR", "", "4", "Building Blocks", ""},
                {"Crimson Fence", "CRIMSON_FENCE", "", "4", "Building Blocks", ""},
                {"Crimson Fence Gate", "CRIMSON_FENCE_GATE", "", "4", "Building Blocks", ""},
                {"Crimson Fungus", "CRIMSON_FUNGUS", "", "4", "Natural Blocks", ""},
                {"Crimson Hanging Sign", "CRIMSON_HANGING_SIGN", "", "4", "Functional Blocks", ""},
                {"Crimson Hyphae", "CRIMSON_HYPHAE", "", "4", "Building Blocks", ""},
                {"Crimson Nylium", "CRIMSON_NYLIUM", "", "5", "Natural Blocks", ""},
                {"Crimson Planks", "CRIMSON_PLANKS", "", "4", "Building Blocks", ""},
                {"Crimson Pressure Plate", "CRIMSON_PRESSURE_PLATE", "", "4", "Building Blocks", ""},
                {"Crimson Roots", "CRIMSON_ROOTS", "", "4", "Natural Blocks", ""},
                {"Crimson Sign", "CRIMSON_SIGN", "", "4", "Functional Blocks", ""},
                {"Crimson Slab", "CRIMSON_SLAB", "", "4", "Building Blocks", ""},
                {"Crimson Stairs", "CRIMSON_STAIRS", "", "4", "Building Blocks", ""},
                {"Crimson Stem", "CRIMSON_STEM", "", "4", "Building Blocks", ""},
                {"Crimson Trapdoor", "CRIMSON_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Crossbow", "CROSSBOW", "", "4", "Combat", ""},
                {"Crying Obsidian", "CRYING_OBSIDIAN", "", "4", "Natural Blocks", ""},
                {"Cut Copper", "CUT_COPPER", "", "1", "Building Blocks", ""},
                {"Cut Copper Slab", "CUT_COPPER_SLAB", "", "1", "Building Blocks", ""},
                {"Cut Copper Stairs", "CUT_COPPER_STAIRS", "", "1", "Building Blocks", ""},
                {"Cut Red Sandstone", "CUT_RED_SANDSTONE", "", "4", "Building Blocks", ""},
                {"Cut Red Sandstone Slab", "CUT_RED_SANDSTONE_SLAB", "", "4", "Building Blocks", ""},
                {"Cut Sandstone", "CUT_SANDSTONE", "", "1", "Building Blocks", ""},
                {"Cut Sandstone Slab", "CUT_SANDSTONE_SLAB", "", "1", "Building Blocks", ""},
                {"Cyan Banner", "CYAN_BANNER", "", "4", "Colored Blocks", ""},
                {"Cyan Bed", "CYAN_BED", "", "4", "Colored Blocks", ""},
                {"Cyan Bundle", "CYAN_BUNDLE", "", "4", "Tools & Utilities", ""},
                {"Cyan Candle", "CYAN_CANDLE", "", "4", "Colored Blocks", ""},
                {"Cyan Carpet", "CYAN_CARPET", "", "4", "Colored Blocks", ""},
                {"Cyan Concrete", "CYAN_CONCRETE", "", "4", "Colored Blocks", ""},
                {"Cyan Concrete Powder", "CYAN_CONCRETE_POWDER", "", "4", "Colored Blocks", ""},
                {"Cyan Dye", "CYAN_DYE", "", "4", "Ingidients", ""},
                {"Cyan Glazed Terracotta", "CYAN_GLAZED_TERRACOTTA", "", "4", "Colored Blocks", ""},
                {"Cyan Shulker Box", "CYAN_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Cyan Stained Glass", "CYAN_STAINED_GLASS", "", "4", "Colored Blocks", ""},
                {"Cyan Stained Glass Pane", "CYAN_STAINED_GLASS_PANE", "", "4", "Colored Blocks", ""},
                {"Cyan Terracotta", "CYAN_TERRACOTTA", "", "4", "Colored Blocks", ""},
                {"Cyan Wool", "CYAN_WOOL", "", "4", "Colored Blocks", ""},
                {"Damaged Anvil", "DAMAGED_ANVIL", "", "3", "Functional Blocks", ""},
                {"Dandelion", "DANDELION", "", "1", "Natural Blocks", ""},
                {"Danger Pottery Sherd", "DANGER_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Dark Oak Boat", "DARK_OAK_BOAT", "", "3", "Tools & Utilities", ""},
                {"Dark Oak Boat with Chest", "DARK_OAK_CHEST_BOAT", "", "3", "Tools & Utilities", ""},
                {"Dark Oak Button", "DARK_OAK_BUTTON", "", "3", "Building Blocks", ""},
                {"Dark Oak Door", "DARK_OAK_DOOR", "", "3", "Building Blocks", ""},
                {"Dark Oak Fence", "DARK_OAK_FENCE", "", "3", "Building Blocks", ""},
                {"Dark Oak Fence Gate", "DARK_OAK_FENCE_GATE", "", "3", "Building Blocks", ""},
                {"Dark Oak Hanging Sign", "DARK_OAK_HANGING_SIGN", "", "3", "Functional Blocks", ""},
                {"Dark Oak Leaves", "DARK_OAK_LEAVES", "", "4", "Natural Blocks", ""},
                {"Dark Oak Log", "DARK_OAK_LOG", "", "3", "Building Blocks", ""},
                {"Dark Oak Planks", "DARK_OAK_PLANKS", "", "3", "Building Blocks", ""},
                {"Dark Oak Pressure Plate", "DARK_OAK_PRESSURE_PLATE", "", "3", "Building Blocks", ""},
                {"Dark Oak Sapling", "DARK_OAK_SAPLING", "", "4", "Natural Blocks", ""},
                {"Dark Oak Sign", "DARK_OAK_SIGN", "", "3", "Functional Blocks", ""},
                {"Dark Oak Slab", "DARK_OAK_SLAB", "", "3", "Building Blocks", ""},
                {"Dark Oak Stairs", "DARK_OAK_STAIRS", "", "3", "Building Blocks", ""},
                {"Dark Oak Trapdoor", "DARK_OAK_TRAPDOOR", "", "3", "Building Blocks", ""},
                {"Dark Oak Wood", "DARK_OAK_WOOD", "", "3", "Building Blocks", ""},
                {"Dark Prismarine", "DARK_PRISMARINE", "", "4", "Building Blocks", ""},
                {"Dark Prismarine Slab", "DARK_PRISMARINE_SLAB", "", "4", "Building Blocks", ""},
                {"Dark Prismarine Stairs", "DARK_PRISMARINE_STAIRS", "", "4", "Building Blocks", ""},
                {"Daylight Detector", "DAYLIGHT_DETECTOR", "", "2", "Redstone Blocks", ""},
                {"Dead Brain Coral", "DEAD_BRAIN_CORAL", "", "4", "Natural Blocks", ""},
                {"Dead Brain Coral Block", "DEAD_BRAIN_CORAL_BLOCK", "", "4", "Natural Blocks", ""},
                {"Dead Brain Coral Fan", "DEAD_BRAIN_CORAL_FAN", "", "4", "Natural Blocks", ""},
                {"Dead Bubble Coral", "DEAD_BUBBLE_CORAL", "", "4", "Natural Blocks", ""},
                {"Dead Bubble Coral Block", "DEAD_BUBBLE_CORAL_BLOCK", "", "4", "Natural Blocks", ""},
                {"Dead Bubble Coral Fan", "DEAD_BUBBLE_CORAL_FAN", "", "4", "Natural Blocks", ""},
                {"Dead Bush", "DEAD_BUSH", "", "4", "Natural Blocks", ""},
                {"Dead Fire Coral", "DEAD_FIRE_CORAL", "", "4", "Natural Blocks", ""},
                {"Dead Fire Coral Block", "DEAD_FIRE_CORAL_BLOCK", "", "4", "Natural Blocks", ""},
                {"Dead Fire Coral Fan", "DEAD_FIRE_CORAL_FAN", "", "4", "Natural Blocks", ""},
                {"Dead Horn Coral", "DEAD_HORN_CORAL", "", "4", "Natural Blocks", ""},
                {"Dead Horn Coral Block", "DEAD_HORN_CORAL_BLOCK", "", "4", "Natural Blocks", ""},
                {"Dead Horn Coral Fan", "DEAD_HORN_CORAL_FAN", "", "4", "Natural Blocks", ""},
                {"Dead Tube Coral", "DEAD_TUBE_CORAL", "", "4", "Natural Blocks", ""},
                {"Dead Tube Coral Block", "DEAD_TUBE_CORAL_BLOCK", "", "4", "Natural Blocks", ""},
                {"Dead Tube Coral Fan", "DEAD_TUBE_CORAL_FAN", "", "4", "Natural Blocks", ""},
                {"Decorated Pot", "DECORATED_POT", "", "3", "Functional Blocks", ""},
                {"Deepslate", "DEEPSLATE", "", "2", "Building Blocks", ""},
                {"Deepslate Brick Slab", "DEEPSLATE_BRICK_SLAB", "", "2", "Building Blocks", ""},
                {"Deepslate Brick Stairs", "DEEPSLATE_BRICK_STAIRS", "", "2", "Building Blocks", ""},
                {"Deepslate Brick Wall", "DEEPSLATE_BRICK_WALL", "", "2", "Building Blocks", ""},
                {"Deepslate Bricks", "DEEPSLATE_BRICKS", "", "2", "Building Blocks", ""},
                {"Deepslate Coal Ore", "DEEPSLATE_COAL_ORE", "", "5", "Natural Blocks", ""},
                {"Deepslate Copper Ore", "DEEPSLATE_COPPER_ORE", "", "4", "Natural Blocks", ""},
                {"Deepslate Diamond Ore", "DEEPSLATE_DIAMOND_ORE", "", "4", "Natural Blocks", ""},
                {"Deepslate Emerald Ore", "DEEPSLATE_EMERALD_ORE", "", "5", "Natural Blocks", ""},
                {"Deepslate Gold Ore", "DEEPSLATE_GOLD_ORE", "", "4", "Natural Blocks", ""},
                {"Deepslate Iron Ore", "DEEPSLATE_IRON_ORE", "", "4", "Natural Blocks", ""},
                {"Deepslate Lapis Lazuli Ore", "DEEPSLATE_LAPIS_ORE", "", "4", "Natural Blocks", ""},
                {"Deepslate Redstone Ore", "DEEPSLATE_REDSTONE_ORE", "", "4", "Natural Blocks", ""},
                {"Deepslate Tile Slab", "DEEPSLATE_TILE_SLAB", "", "2", "Building Blocks", ""},
                {"Deepslate Tile Stairs", "DEEPSLATE_TILE_STAIRS", "", "2", "Building Blocks", ""},
                {"Deepslate Tile Wall", "DEEPSLATE_TILE_WALL", "", "2", "Building Blocks", ""},
                {"Deepslate Tiles", "DEEPSLATE_TILES", "", "2", "Building Blocks", ""},
                {"Detector Rail", "DETECTOR_RAIL", "", "2", "Redstone Blocks", ""},
                {"Diamond", "DIAMOND", "", "3", "Ingidients", ""},
                {"Diamond Axe", "DIAMOND_AXE", "", "3", "Combat", ""},
                {"Diamond Boots", "DIAMOND_BOOTS", "", "3", "Combat", ""},
                {"Diamond Chestplate", "DIAMOND_CHESTPLATE", "", "3", "Combat", ""},
                {"Diamond Helmet", "DIAMOND_HELMET", "", "3", "Combat", ""},
                {"Diamond Hoe", "DIAMOND_HOE", "", "3", "Tools & Utilities", ""},
                {"Diamond Horse Armor", "DIAMOND_HORSE_ARMOR", "", "3", "Combat", ""},
                {"Diamond Leggings", "DIAMOND_LEGGINGS", "", "3", "Combat", ""},
                {"Diamond Ore", "DIAMOND_ORE", "", "6", "Natural Blocks", ""},
                {"Diamond Pickaxe", "DIAMOND_PICKAXE", "", "3", "Tools & Utilities", ""},
                {"Diamond Shovel", "DIAMOND_SHOVEL", "", "3", "Tools & Utilities", ""},
                {"Diamond Sword", "DIAMOND_SWORD", "", "3", "Combat", ""},
                {"Diorite", "DIORITE", "", "2", "Building Blocks", ""},
                {"Diorite Slab", "DIORITE_SLAB", "", "2", "Building Blocks", ""},
                {"Diorite Stairs", "DIORITE_STAIRS", "", "2", "Building Blocks", ""},
                {"Diorite Wall", "DIORITE_WALL", "", "2", "Building Blocks", ""},
                {"Dirt", "DIRT", "", "1", "Natural Blocks", ""},
                {"Dirt Path", "DIRT_PATH", "", "0", "Natural Blocks", ""},
                {"Disc Fragment - Music Disc - 5", "DISC_FRAGMENT_5", "", "3", "Tools & Utilities", "Music Disks"},
                {"Dispenser", "DISPENSER", "", "2", "Redstone Blocks", ""},
                {"Dragon Egg", "DRAGON_EGG", "", "6", "Functional Blocks", ""},
                {"Dragon Head", "DRAGON_HEAD", "", "6", "Functional Blocks", ""},
                {"Dragon's Breath", "DRAGON_BREATH", "", "6", "Ingidients", ""},
                {"Dried Kelp", "DRIED_KELP", "", "2", "Food & Drinks", ""},
                {"Dried Kelp Block", "DRIED_KELP_BLOCK", "", "2", "Natural Blocks", ""},
                {"Dripstone Block", "DRIPSTONE_BLOCK", "", "3", "Natural Blocks", ""},
                {"Dropper", "DROPPER", "", "2", "Redstone Blocks", ""},
                {"Dune Armour Trim", "DUNE_ARMOR_TRIM_SMITHING_TEMPLATE", "", "5", "Ingidients", ""},
                {"Echo Shard", "ECHO_SHARD", "", "6", "Ingidients", ""},
                {"Egg", "EGG", "", "2", "Combat", ""},
                {"Elytra", "ELYTRA", "", "6", "Tools & Utilities", ""},
                {"Emerald", "EMERALD", "", "3", "Ingidients", ""},
                {"Emerald Ore", "EMERALD_ORE", "", "5", "Natural Blocks", ""},
                {"Empty Map", "MAP", "", "2", "Tools & Utilities", ""},
                {"Enchanted Book", "ENCHANTED_BOOK", "", "3", "Ingidients", ""},
                {"Enchanted Golden Apple", "ENCHANTED_GOLDEN_APPLE", "", "4", "Food & Drinks", ""},
                {"Enchanting Table", "ENCHANTING_TABLE", "", "3", "Functional Blocks", ""},
                {"End Crystal", "END_CRYSTAL", "", "5", "Combat", ""},
                {"End Rod", "END_ROD", "", "6", "Functional Blocks", ""},
                {"End Stone", "END_STONE", "", "5", "Building Blocks", ""},
                {"End Stone Brick Slab", "END_STONE_BRICK_SLAB", "", "5", "Building Blocks", ""},
                {"End Stone Brick Stairs", "END_STONE_BRICK_STAIRS", "", "5", "Building Blocks", ""},
                {"End Stone Brick Wall", "END_STONE_BRICK_WALL", "", "5", "Building Blocks", ""},
                {"End Stone Bricks", "END_STONE_BRICKS", "", "5", "Building Blocks", ""},
                {"Ender Chest", "ENDER_CHEST", "", "4", "Functional Blocks", ""},
                {"Ender Pearl", "ENDER_PEARL", "", "3", "Tools & Utilities", ""},
                {"Explorer Pottery Sherd", "EXPLORER_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Exposed Chiseled Copper", "EXPOSED_CHISELED_COPPER", "", "2", "Building Blocks", ""},
                {"Exposed Copper", "EXPOSED_COPPER", "", "2", "Building Blocks", ""},
                {"Exposed Copper Bulb", "EXPOSED_COPPER_BULB", "", "2", "Building Blocks", ""},
                {"Exposed Copper Door", "EXPOSED_COPPER_DOOR", "", "2", "Building Blocks", ""},
                {"Exposed Copper Grate", "EXPOSED_COPPER_GRATE", "", "2", "Building Blocks", ""},
                {"Exposed Copper Trapdoor", "EXPOSED_COPPER_TRAPDOOR", "", "2", "Building Blocks", ""},
                {"Exposed Cut Copper", "EXPOSED_CUT_COPPER", "", "2", "Building Blocks", ""},
                {"Exposed Cut Copper Slab", "EXPOSED_CUT_COPPER_SLAB", "", "2", "Building Blocks", ""},
                {"Exposed Cut Copper Stairs", "EXPOSED_CUT_COPPER_STAIRS", "", "2", "Building Blocks", ""},
                {"Eye Armour Trim", "EYE_ARMOR_TRIM_SMITHING_TEMPLATE", "", "3", "Ingidients", ""},
                {"Eye of Ender", "ENDER_EYE", "", "3", "Tools & Utilities", ""},
                {"Farmland", "FARMLAND", "", "0", "Natural Blocks", ""},
                {"Feather", "FEATHER", "", "1", "Ingidients", ""},
                {"Fermented Spider Eye", "FERMENTED_SPIDER_EYE", "", "2", "Ingidients", ""},
                {"Fern", "FERN", "", "2", "Natural Blocks", ""},
                {"Fire Charge", "FIRE_CHARGE", "", "3", "Tools & Utilities", ""},
                {"Fire Coral", "FIRE_CORAL", "", "4", "Natural Blocks", ""},
                {"Fire Coral Block", "FIRE_CORAL_BLOCK", "", "4", "Natural Blocks", ""},
                {"Fire Coral Fan", "FIRE_CORAL_FAN", "", "4", "Natural Blocks", ""},
                {"Firefly Bush", "FIREFLY_BUSH", "", "2", "Natural Blocks", ""},
                {"Firework Rocket", "FIREWORK_ROCKET", "", "3", "Combat", ""},
                {"Firework Star", "FIREWORK_STAR", "", "2", "Ingidients", ""},
                {"Fishing Rod", "FISHING_ROD", "", "2", "Tools & Utilities", ""},
                {"Fletching Table", "FLETCHING_TABLE", "", "1", "Functional Blocks", ""},
                {"Flint", "FLINT", "", "1", "Ingidients", ""},
                {"Flint and Steel", "FLINT_AND_STEEL", "", "2", "Tools & Utilities", ""},
                {"Flow Armour Trim", "FLOW_ARMOR_TRIM_SMITHING_TEMPLATE", "", "4", "Ingidients", ""},
                {"Flow Pottery Sherd", "FLOW_POTTERY_SHERD", "", "4", "Ingidients", ""},
                {"Flower Pot", "FLOWER_POT", "", "1", "Functional Blocks", ""},
                {"Flowering Azalea", "FLOWERING_AZALEA", "", "3", "Natural Blocks", ""},
                {"Flowering Azalea Leaves", "FLOWERING_AZALEA_LEAVES", "", "3", "Natural Blocks", ""},
                {"Friend Pottery Sherd", "FRIEND_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Frogspawn", "FROGSPAWN", "", "0", "Natural Blocks", ""},
                {"Furnace", "FURNACE", "", "1", "Functional Blocks", ""},
                {"Ghast Tear", "GHAST_TEAR", "", "3", "Ingidients", ""},
                {"Gilded Blackstone", "GILDED_BLACKSTONE", "", "4", "Building Blocks", ""},
                {"Glass", "GLASS", "", "2", "Colored Blocks", ""},
                {"Glass Bottle", "GLASS_BOTTLE", "", "2", "Ingidients", ""},
                {"Glass Pane", "GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Glistering Melon Slice", "GLISTERING_MELON_SLICE", "", "3", "Ingidients", ""},
                {"Glow Berries", "GLOW_BERRIES", "", "3", "Natural Blocks", ""},
                {"Glow Ink Sac", "GLOW_INK_SAC", "", "3", "Ingidients", ""},
                {"Glow Item Frame", "GLOW_ITEM_FRAME", "", "3", "Functional Blocks", ""},
                {"Glow Lichen", "GLOW_LICHEN", "", "2", "Natural Blocks", ""},
                {"Glowstone", "GLOWSTONE", "", "3", "Natural Blocks", ""},
                {"Glowstone Dust", "GLOWSTONE_DUST", "", "3", "Ingidients", ""},
                {"Goat Horn", "GOAT_HORN", "", "3", "Tools & Utilities", "Music Disks"},
                {"Gold Ingot", "GOLD_INGOT", "", "2", "Ingidients", ""},
                {"Gold Ore", "GOLD_ORE", "", "4", "Natural Blocks", ""},
                {"Golden Apple", "GOLDEN_APPLE", "", "3", "Food & Drinks", ""},
                {"Golden Axe", "GOLDEN_AXE", "", "2", "Combat", ""},
                {"Golden Boots", "GOLDEN_BOOTS", "", "2", "Combat", ""},
                {"Golden Carrot", "GOLDEN_CARROT", "", "3", "Food & Drinks", ""},
                {"Golden Chestplate", "GOLDEN_CHESTPLATE", "", "2", "Combat", ""},
                {"Golden Helmet", "GOLDEN_HELMET", "", "2", "Combat", ""},
                {"Golden Hoe", "GOLDEN_HOE", "", "2", "Tools & Utilities", ""},
                {"Golden Horse Armor", "GOLDEN_HORSE_ARMOR", "", "2", "Combat", ""},
                {"Golden Leggings", "GOLDEN_LEGGINGS", "", "2", "Combat", ""},
                {"Golden Nugget", "GOLD_NUGGET", "", "2", "Ingidients", ""},
                {"Golden Pickaxe", "GOLDEN_PICKAXE", "", "2", "Tools & Utilities", ""},
                {"Golden Shovel", "GOLDEN_SHOVEL", "", "2", "Tools & Utilities", ""},
                {"Golden Sword", "GOLDEN_SWORD", "", "2", "Combat", ""},
                {"Granite", "GRANITE", "", "2", "Building Blocks", ""},
                {"Granite Slab", "GRANITE_SLAB", "", "2", "Building Blocks", ""},
                {"Granite Stairs", "GRANITE_STAIRS", "", "2", "Building Blocks", ""},
                {"Granite Wall", "GRANITE_WALL", "", "2", "Building Blocks", ""},
                {"Grass", "SHORT_GRASS", "", "2", "Natural Blocks", ""},
                {"Grass Block", "GRASS_BLOCK", "", "4", "Natural Blocks", ""},
                {"Gravel", "GRAVEL", "", "1", "Natural Blocks", ""},
                {"Gray Banner", "GRAY_BANNER", "", "2", "Colored Blocks", ""},
                {"Gray Bed", "GRAY_BED", "", "2", "Colored Blocks", ""},
                {"Gray Bundle", "GRAY_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Gray Candle", "GRAY_CANDLE", "", "3", "Colored Blocks", ""},
                {"Gray Carpet", "GRAY_CARPET", "", "2", "Colored Blocks", ""},
                {"Gray Concrete", "GRAY_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Gray Concrete Powder", "GRAY_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Gray Dye", "GRAY_DYE", "", "1", "Ingidients", ""},
                {"Gray Glazed Terracotta", "GRAY_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Gray Shulker Box", "GRAY_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Gray Stained Glass", "GRAY_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Gray Stained Glass Pane", "GRAY_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Gray Terracotta", "GRAY_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Gray Wool", "GRAY_WOOL", "", "2", "Colored Blocks", ""},
                {"Green Banner", "GREEN_BANNER", "", "4", "Colored Blocks", ""},
                {"Green Bed", "GREEN_BED", "", "4", "Colored Blocks", ""},
                {"Green Bundle", "GREEN_BUNDLE", "", "4", "Tools & Utilities", ""},
                {"Green Candle", "GREEN_CANDLE", "", "4", "Colored Blocks", ""},
                {"Green Carpet", "GREEN_CARPET", "", "4", "Colored Blocks", ""},
                {"Green Concrete", "GREEN_CONCRETE", "", "4", "Colored Blocks", ""},
                {"Green Concrete Powder", "GREEN_CONCRETE_POWDER", "", "4", "Colored Blocks", ""},
                {"Green Dye", "GREEN_DYE", "", "4", "Ingidients", ""},
                {"Green Glazed Terracotta", "GREEN_GLAZED_TERRACOTTA", "", "4", "Colored Blocks", ""},
                {"Green Shulker Box", "GREEN_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Green Stained Glass", "GREEN_STAINED_GLASS", "", "4", "Colored Blocks", ""},
                {"Green Stained Glass Pane", "GREEN_STAINED_GLASS_PANE", "", "4", "Colored Blocks", ""},
                {"Green Terracotta", "GREEN_TERRACOTTA", "", "4", "Colored Blocks", ""},
                {"Green Wool", "GREEN_WOOL", "", "4", "Colored Blocks", ""},
                {"Grindstone", "GRINDSTONE", "", "1", "Functional Blocks", ""},
                {"Gunpowder", "GUNPOWDER", "", "2", "Ingidients", ""},
                {"Guster Pottery Sherd", "GUSTER_POTTERY_SHERD", "", "4", "Ingidients", ""},
                {"Hanging Roots", "HANGING_ROOTS", "", "3", "Natural Blocks", ""},
                {"Hay Bale", "HAY_BLOCK", "", "2", "Natural Blocks", ""},
                {"Heart of the Sea", "HEART_OF_THE_SEA", "", "5", "Ingidients", ""},
                {"Heart Pottery Sherd", "HEART_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Heartbreak Pottery Sherd", "HEARTBREAK_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Heavy Core", "HEAVY_CORE", "", "6", "Ingidients", ""},
                {"Heavy Weighted Pressure Plate", "HEAVY_WEIGHTED_PRESSURE_PLATE", "", "2", "Building Blocks", ""},
                {"Honey Block", "HONEY_BLOCK", "", "5", "Natural Blocks", ""},
                {"Honey Bottle", "HONEY_BOTTLE", "", "3", "Food & Drinks", ""},
                {"Honeycomb", "HONEYCOMB", "", "3", "Ingidients", ""},
                {"Honeycomb Block", "HONEYCOMB_BLOCK", "", "4", "Natural Blocks", ""},
                {"Hopper", "HOPPER", "", "2", "Redstone Blocks", ""},
                {"Horn Coral", "HORN_CORAL", "", "4", "Natural Blocks", ""},
                {"Horn Coral Block", "HORN_CORAL_BLOCK", "", "4", "Natural Blocks", ""},
                {"Horn Coral Fan", "HORN_CORAL_FAN", "", "4", "Natural Blocks", ""},
                {"Host Armour Trim", "HOST_ARMOR_TRIM_SMITHING_TEMPLATE", "", "5", "Ingidients", ""},
                {"Howl Pottery Sherd", "HOWL_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Ice", "ICE", "", "4", "Natural Blocks", ""},
                {"Infested Chiseled Stone Bricks", "INFESTED_CHISELED_STONE_BRICKS", "", "0", "Functional Blocks", ""},
                {"Infested Cobblestone", "INFESTED_COBBLESTONE", "", "0", "Functional Blocks", ""},
                {"Infested Cracked Stone Bricks", "INFESTED_CRACKED_STONE_BRICKS", "", "0", "Functional Blocks", ""},
                {"Infested Deepslate", "INFESTED_DEEPSLATE", "", "0", "Functional Blocks", ""},
                {"Infested Mossy Stone Bricks", "INFESTED_MOSSY_STONE_BRICKS", "", "0", "Functional Blocks", ""},
                {"Infested Stone", "INFESTED_STONE", "", "0", "Functional Blocks", ""},
                {"Infested Stone Bricks", "INFESTED_STONE_BRICKS", "", "0", "Functional Blocks", ""},
                {"Ink Sac", "INK_SAC", "", "1", "Ingidients", ""},
                {"Iron Axe", "IRON_AXE", "", "2", "Combat", ""},
                {"Iron Bars", "IRON_BARS", "", "2", "Building Blocks", ""},
                {"Iron Boots", "IRON_BOOTS", "", "2", "Combat", ""},
                {"Iron Chestplate", "IRON_CHESTPLATE", "", "2", "Combat", ""},
                {"Iron Door", "IRON_DOOR", "", "2", "Building Blocks", ""},
                {"Iron Helmet", "IRON_HELMET", "", "2", "Combat", ""},
                {"Iron Hoe", "IRON_HOE", "", "2", "Tools & Utilities", ""},
                {"Iron Horse Armor", "IRON_HORSE_ARMOR", "", "2", "Combat", ""},
                {"Iron Ingot", "IRON_INGOT", "", "2", "Ingidients", ""},
                {"Iron Leggings", "IRON_LEGGINGS", "", "2", "Combat", ""},
                {"Iron Nugget", "IRON_NUGGET", "", "2", "Ingidients", ""},
                {"Iron Ore", "IRON_ORE", "", "4", "Natural Blocks", ""},
                {"Iron Pickaxe", "IRON_PICKAXE", "", "2", "Tools & Utilities", ""},
                {"Iron Shovel", "IRON_SHOVEL", "", "2", "Tools & Utilities", ""},
                {"Iron Sword", "IRON_SWORD", "", "2", "Combat", ""},
                {"Iron Trapdoor", "IRON_TRAPDOOR", "", "2", "Building Blocks", ""},
                {"Item Frame", "ITEM_FRAME", "", "1", "Functional Blocks", ""},
                {"Jack o'Lantern", "JACK_O_LANTERN", "", "2", "Natural Blocks", ""},
                {"Jukebox", "JUKEBOX", "", "3", "Functional Blocks", ""},
                {"Jungle Boat", "JUNGLE_BOAT", "", "4", "Tools & Utilities", ""},
                {"Jungle Boat with Chest", "JUNGLE_CHEST_BOAT", "", "4", "Tools & Utilities", ""},
                {"Jungle Button", "JUNGLE_BUTTON", "", "4", "Building Blocks", ""},
                {"Jungle Door", "JUNGLE_DOOR", "", "4", "Building Blocks", ""},
                {"Jungle Fence", "JUNGLE_FENCE", "", "4", "Building Blocks", ""},
                {"Jungle Fence Gate", "JUNGLE_FENCE_GATE", "", "4", "Building Blocks", ""},
                {"Jungle Hanging Sign", "JUNGLE_HANGING_SIGN", "", "4", "Functional Blocks", ""},
                {"Jungle Leaves", "JUNGLE_LEAVES", "", "4", "Natural Blocks", ""},
                {"Jungle Log", "JUNGLE_LOG", "", "4", "Building Blocks", ""},
                {"Jungle Planks", "JUNGLE_PLANKS", "", "4", "Building Blocks", ""},
                {"Jungle Pressure Plate", "JUNGLE_PRESSURE_PLATE", "", "4", "Building Blocks", ""},
                {"Jungle Sapling", "JUNGLE_SAPLING", "", "4", "Natural Blocks", ""},
                {"Jungle Sign", "JUNGLE_SIGN", "", "4", "Functional Blocks", ""},
                {"Jungle Slab", "JUNGLE_SLAB", "", "4", "Building Blocks", ""},
                {"Jungle Stairs", "JUNGLE_STAIRS", "", "4", "Building Blocks", ""},
                {"Jungle Trapdoor", "JUNGLE_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Jungle Wood", "JUNGLE_WOOD", "", "4", "Building Blocks", ""},
                {"Kelp", "KELP", "", "2", "Natural Blocks", ""},
                {"Ladder", "LADDER", "", "1", "Functional Blocks", ""},
                {"Lantern", "LANTERN", "", "2", "Functional Blocks", ""},
                {"Lapis Lazuli Ore", "LAPIS_ORE", "", "4", "Natural Blocks", ""},
                {"Lapiz Lazuli", "LAPIS_LAZULI", "", "2", "Ingidients", ""},
                {"Large Amethyst Bud", "LARGE_AMETHYST_BUD", "", "5", "Natural Blocks", ""},
                {"Large Fern", "LARGE_FERN", "", "0", "Natural Blocks", ""},
                {"Lava Bucket", "LAVA_BUCKET", "", "2", "Tools & Utilities", ""},
                {"Lead", "LEAD", "", "2", "Tools & Utilities", ""},
                {"Leaf Litter", "LEAF_LITTER", "", "1", "Natural Blocks", ""},
                {"Leather", "LEATHER", "", "1", "Ingidients", ""},
                {"Leather Boots", "LEATHER_BOOTS", "", "1", "Combat", ""},
                {"Leather Cap", "LEATHER_HELMET", "", "1", "Combat", ""},
                {"Leather Horse Armor", "LEATHER_HORSE_ARMOR", "", "1", "Combat", ""},
                {"Leather Pants", "LEATHER_LEGGINGS", "", "1", "Combat", ""},
                {"Leather Tunic", "LEATHER_CHESTPLATE", "", "1", "Combat", ""},
                {"Lectern", "LECTERN", "", "1", "Functional Blocks", ""},
                {"Lever", "LEVER", "", "1", "Redstone Blocks", ""},
                {"Light Blue Banner", "LIGHT_BLUE_BANNER", "", "2", "Colored Blocks", ""},
                {"Light Blue Bed", "LIGHT_BLUE_BED", "", "2", "Colored Blocks", ""},
                {"Light Blue Bundle", "LIGHT_BLUE_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Light Blue Candle", "LIGHT_BLUE_CANDLE", "", "3", "Colored Blocks", ""},
                {"Light Blue Carpet", "LIGHT_BLUE_CARPET", "", "2", "Colored Blocks", ""},
                {"Light Blue Concrete", "LIGHT_BLUE_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Light Blue Concrete Powder", "LIGHT_BLUE_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Light Blue Dye", "LIGHT_BLUE_DYE", "", "1", "Ingidients", ""},
                {"Light Blue Glazed Terracotta", "LIGHT_BLUE_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Light Blue Shulker Box", "LIGHT_BLUE_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Light Blue Stained Glass", "LIGHT_BLUE_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Light Blue Stained Glass Pane", "LIGHT_BLUE_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Light Blue Terracotta", "LIGHT_BLUE_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Light Blue Wool", "LIGHT_BLUE_WOOL", "", "2", "Colored Blocks", ""},
                {"Light Gray Banner", "LIGHT_GRAY_BANNER", "", "2", "Colored Blocks", ""},
                {"Light Gray Bed", "LIGHT_GRAY_BED", "", "2", "Colored Blocks", ""},
                {"Light Gray Bundle", "LIGHT_GRAY_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Light Gray Candle", "LIGHT_GRAY_CANDLE", "", "3", "Colored Blocks", ""},
                {"Light Gray Carpet", "LIGHT_GRAY_CARPET", "", "2", "Colored Blocks", ""},
                {"Light Gray Concrete", "LIGHT_GRAY_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Light Gray Concrete Powder", "LIGHT_GRAY_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Light Gray Dye", "LIGHT_GRAY_DYE", "", "1", "Ingidients", ""},
                {"Light Gray Glazed Terracotta", "LIGHT_GRAY_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Light Gray Shulker Box", "LIGHT_GRAY_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Light Gray Stained Glass", "LIGHT_GRAY_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Light Gray Stained Glass Pane", "LIGHT_GRAY_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Light Gray Terracotta", "LIGHT_GRAY_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Light Gray Wool", "LIGHT_GRAY_WOOL", "", "2", "Colored Blocks", ""},
                {"Light Weighted Pressure Plate", "LIGHT_WEIGHTED_PRESSURE_PLATE", "", "2", "Building Blocks", ""},
                {"Lightning Rod", "LIGHTNING_ROD", "", "1", "Functional Blocks", ""},
                {"Lilac", "LILAC", "", "1", "Natural Blocks", ""},
                {"Lily of the Valley", "LILY_OF_THE_VALLEY", "", "2", "Natural Blocks", ""},
                {"Lily Pad", "LILY_PAD", "", "3", "Natural Blocks", ""},
                {"Lime Banner", "LIME_BANNER", "", "4", "Colored Blocks", ""},
                {"Lime Bed", "LIME_BED", "", "4", "Colored Blocks", ""},
                {"Lime Bundle", "LIME_BUNDLE", "", "4", "Tools & Utilities", ""},
                {"Lime Candle", "LIME_CANDLE", "", "4", "Colored Blocks", ""},
                {"Lime Carpet", "LIME_CARPET", "", "4", "Colored Blocks", ""},
                {"Lime Concrete", "LIME_CONCRETE", "", "4", "Colored Blocks", ""},
                {"Lime Concrete Powder", "LIME_CONCRETE_POWDER", "", "4", "Colored Blocks", ""},
                {"Lime Dye", "LIME_DYE", "", "4", "Ingidients", ""},
                {"Lime Glazed Terracotta", "LIME_GLAZED_TERRACOTTA", "", "4", "Colored Blocks", ""},
                {"Lime Shulker Box", "LIME_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Lime Stained Glass", "LIME_STAINED_GLASS", "", "4", "Colored Blocks", ""},
                {"Lime Stained Glass Pane", "LIME_STAINED_GLASS_PANE", "", "4", "Colored Blocks", ""},
                {"Lime Terracotta", "LIME_TERRACOTTA", "", "4", "Colored Blocks", ""},
                {"Lime Wool", "LIME_WOOL", "", "4", "Colored Blocks", ""},
                {"Lodestone", "LODESTONE", "", "2", "Functional Blocks", ""},
                {"Loom", "LOOM", "", "2", "Functional Blocks", ""},
                {"Mace", "MACE", "", "5", "Combat", ""},
                {"Magenta Banner", "MAGENTA_BANNER", "", "2", "Colored Blocks", ""},
                {"Magenta Bed", "MAGENTA_BED", "", "2", "Colored Blocks", ""},
                {"Magenta Bundle", "MAGENTA_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Magenta Candle", "MAGENTA_CANDLE", "", "3", "Colored Blocks", ""},
                {"Magenta Carpet", "MAGENTA_CARPET", "", "2", "Colored Blocks", ""},
                {"Magenta Concrete", "MAGENTA_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Magenta Concrete Powder", "MAGENTA_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Magenta Dye", "MAGENTA_DYE", "", "1", "Ingidients", ""},
                {"Magenta Glazed Terracotta", "MAGENTA_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Magenta Shulker Box", "MAGENTA_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Magenta Stained Glass", "MAGENTA_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Magenta Stained Glass Pane", "MAGENTA_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Magenta Terracotta", "MAGENTA_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Magenta Wool", "MAGENTA_WOOL", "", "2", "Colored Blocks", ""},
                {"Magma Block", "MAGMA_BLOCK", "", "2", "Natural Blocks", ""},
                {"Magma Cream", "MAGMA_CREAM", "", "3", "Ingidients", ""},
                {"Mangrove Boat", "MANGROVE_BOAT", "", "4", "Tools & Utilities", ""},
                {"Mangrove Boat with Chest", "MANGROVE_CHEST_BOAT", "", "4", "Tools & Utilities", ""},
                {"Mangrove Button", "MANGROVE_BUTTON", "", "4", "Building Blocks", ""},
                {"Mangrove Door", "MANGROVE_DOOR", "", "4", "Building Blocks", ""},
                {"Mangrove Fence", "MANGROVE_FENCE", "", "4", "Building Blocks", ""},
                {"Mangrove Fence Gate", "MANGROVE_FENCE_GATE", "", "4", "Building Blocks", ""},
                {"Mangrove Hanging Sign", "MANGROVE_HANGING_SIGN", "", "4", "Functional Blocks", ""},
                {"Mangrove Leaves", "MANGROVE_LEAVES", "", "4", "Natural Blocks", ""},
                {"Mangrove Log", "MANGROVE_LOG", "", "4", "Building Blocks", ""},
                {"Mangrove Planks", "MANGROVE_PLANKS", "", "4", "Building Blocks", ""},
                {"Mangrove Pressure Plate", "MANGROVE_PRESSURE_PLATE", "", "4", "Building Blocks", ""},
                {"Mangrove Propagule", "MANGROVE_PROPAGULE", "", "4", "Natural Blocks", ""},
                {"Mangrove Roots", "MANGROVE_ROOTS", "", "4", "Natural Blocks", ""},
                {"Mangrove Sign", "MANGROVE_SIGN", "", "4", "Functional Blocks", ""},
                {"Mangrove Slab", "MANGROVE_SLAB", "", "4", "Building Blocks", ""},
                {"Mangrove Stairs", "MANGROVE_STAIRS", "", "4", "Building Blocks", ""},
                {"Mangrove Trapdoor", "MANGROVE_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Mangrove Wood", "MANGROVE_WOOD", "", "4", "Building Blocks", ""},
                {"Map", "FILLED_MAP", "", "2", "Tools & Utilities", ""},
                {"Medium Amethyst Bud", "MEDIUM_AMETHYST_BUD", "", "5", "Natural Blocks", ""},
                {"Melon", "MELON", "", "4", "Natural Blocks", ""},
                {"Melon Seeds", "MELON_SEEDS", "", "4", "Natural Blocks", ""},
                {"Melon Slice", "MELON_SLICE", "", "3", "Food & Drinks", ""},
                {"Milk Bucket", "MILK_BUCKET", "", "2", "Food & Drinks", ""},
                {"Milk Bucket", "MILK_BUCKET", "", "2", "Tools & Utilities", ""},
                {"Minecart", "MINECART", "", "2", "Redstone Blocks", ""},
                {"Minecart with Chest", "CHEST_MINECART", "", "2", "Redstone Blocks", ""},
                {"Minecart with Command Block", "COMMAND_BLOCK_MINECART", "", "0", "Redstone Blocks", ""},
                {"Minecart with Furnace", "FURNACE_MINECART", "", "2", "Redstone Blocks", ""},
                {"Minecart with Hopper", "HOPPER_MINECART", "", "2", "Redstone Blocks", ""},
                {"Minecart with TNT", "TNT_MINECART", "", "3", "Redstone Blocks", ""},
                {"Miner Pottery Sherd", "MINER_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Moss Block", "MOSS_BLOCK", "", "3", "Natural Blocks", ""},
                {"Moss Carpet", "MOSS_CARPET", "", "3", "Natural Blocks", ""},
                {"Mossy Cobblestone", "MOSSY_COBBLESTONE", "", "3", "Building Blocks", ""},
                {"Mossy Cobblestone Slab", "MOSSY_COBBLESTONE_SLAB", "", "3", "Building Blocks", ""},
                {"Mossy Cobblestone Stairs", "MOSSY_COBBLESTONE_STAIRS", "", "3", "Building Blocks", ""},
                {"Mossy Cobblestone Wall", "MOSSY_COBBLESTONE_WALL", "", "3", "Building Blocks", ""},
                {"Mossy Stone Brick Slab", "MOSSY_STONE_BRICK_SLAB", "", "3", "Building Blocks", ""},
                {"Mossy Stone Brick Stairs", "MOSSY_STONE_BRICK_STAIRS", "", "3", "Building Blocks", ""},
                {"Mossy Stone Brick Wall", "MOSSY_STONE_BRICK_WALL", "", "3", "Building Blocks", ""},
                {"Mossy Stone Bricks", "MOSSY_STONE_BRICKS", "", "3", "Building Blocks", ""},
                {"Mourner Pottery Sherd", "MOURNER_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Mud", "MUD", "", "2", "Natural Blocks", ""},
                {"Mud Brick Slab", "MUD_BRICK_SLAB", "", "2", "Building Blocks", ""},
                {"Mud Brick Stairs", "MUD_BRICK_STAIRS", "", "2", "Building Blocks", ""},
                {"Mud Brick Wall", "MUD_BRICK_WALL", "", "2", "Building Blocks", ""},
                {"Mud Bricks", "MUD_BRICKS", "", "2", "Building Blocks", ""},
                {"Muddy Mangrove Roots", "MUDDY_MANGROVE_ROOTS", "", "2", "Natural Blocks", ""},
                {"Mushroom Stem", "MUSHROOM_STEM", "", "4", "Natural Blocks", ""},
                {"Mushroom Stew", "MUSHROOM_STEW", "", "2", "Food & Drinks", ""},
                {"Music Disc -  - creator", "MUSIC_DISC_CREATOR", "", "4", "Tools & Utilities", "Music Disks"},
                {"Music Disc -  - creator music box", "MUSIC_DISC_CREATOR_MUSIC_BOX", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc -  - precipice", "MUSIC_DISC_PRECIPICE", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc -  - relic", "MUSIC_DISC_RELIC", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - 11", "MUSIC_DISC_11", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - 13", "MUSIC_DISC_13", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - blocks", "MUSIC_DISC_BLOCKS", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - cat", "MUSIC_DISC_CAT", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - chirp", "MUSIC_DISC_CHIRP", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - far", "MUSIC_DISC_FAR", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - mall", "MUSIC_DISC_MALL", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - mellohi", "MUSIC_DISC_MELLOHI", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - stal", "MUSIC_DISC_STAL", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - strad", "MUSIC_DISC_STRAD", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - wait", "MUSIC_DISC_WAIT", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - C418 - ward", "MUSIC_DISC_WARD", "", "3", "Tools & Utilities", "Music Disks"},
                {"Music Disc - Lena Raine - otherside", "MUSIC_DISC_OTHERSIDE", "", "4", "Tools & Utilities", "Music Disks"},
                {"Music Disc - Lena Raine - Pigstep", "MUSIC_DISC_PIGSTEP", "", "4", "Tools & Utilities", "Music Disks"},
                {"Music Disc - Samuel Åberg - 5", "MUSIC_DISC_5", "", "3", "Tools & Utilities", "Music Disks"},
                {"Mycelium", "MYCELIUM", "", "6", "Natural Blocks", ""},
                {"Name Tag", "NAME_TAG", "", "4", "Tools & Utilities", ""},
                {"Nautilus Shell", "NAUTILUS_SHELL", "", "5", "Ingidients", ""},
                {"Nether Brick", "NETHER_BRICK", "", "2", "Ingidients", ""},
                {"Nether Brick Fence", "NETHER_BRICK_FENCE", "", "2", "Building Blocks", ""},
                {"Nether Brick Slab", "NETHER_BRICK_SLAB", "", "2", "Building Blocks", ""},
                {"Nether Brick Stairs", "NETHER_BRICK_STAIRS", "", "2", "Building Blocks", ""},
                {"Nether Brick Wall", "NETHER_BRICK_WALL", "", "2", "Building Blocks", ""},
                {"Nether Bricks", "NETHER_BRICKS", "", "2", "Building Blocks", ""},
                {"Nether Gold Ore", "NETHER_GOLD_ORE", "", "5", "Natural Blocks", ""},
                {"Nether Quartz", "QUARTZ", "", "3", "Ingidients", ""},
                {"Nether Quartz Ore", "NETHER_QUARTZ_ORE", "", "5", "Natural Blocks", ""},
                {"Nether Sprouts", "NETHER_SPROUTS", "", "4", "Natural Blocks", ""},
                {"Nether Star", "NETHER_STAR", "", "6", "Ingidients", ""},
                {"Nether Wart", "NETHER_WART", "", "4", "Ingidients", ""},
                {"Nether Wart Block", "NETHER_WART_BLOCK", "", "4", "Natural Blocks", ""},
                {"Netherite Axe", "NETHERITE_AXE", "", "5", "Combat", ""},
                {"Netherite Boots", "NETHERITE_BOOTS", "", "5", "Combat", ""},
                {"Netherite Chestplate", "NETHERITE_CHESTPLATE", "", "5", "Combat", ""},
                {"Netherite Helmet", "NETHERITE_HELMET", "", "5", "Combat", ""},
                {"Netherite Hoe", "NETHERITE_HOE", "", "5", "Tools & Utilities", ""},
                {"Netherite Ingot", "NETHERITE_INGOT", "", "5", "Ingidients", ""},
                {"Netherite Leggings", "NETHERITE_LEGGINGS", "", "5", "Combat", ""},
                {"Netherite Pickaxe", "NETHERITE_PICKAXE", "", "5", "Tools & Utilities", ""},
                {"Netherite Scrap", "NETHERITE_SCRAP", "", "5", "Ingidients", ""},
                {"Netherite Shovel", "NETHERITE_SHOVEL", "", "5", "Tools & Utilities", ""},
                {"Netherite Sword", "NETHERITE_SWORD", "", "5", "Combat", ""},
                {"Netherite Upgrade", "NETHERITE_UPGRADE_SMITHING_TEMPLATE", "", "6", "Ingidients", ""},
                {"Netherrack", "NETHERRACK", "", "2", "Building Blocks", ""},
                {"Note Block", "NOTE_BLOCK", "", "3", "Functional Blocks", ""},
                {"Oak Boat", "OAK_BOAT", "", "1", "Tools & Utilities", ""},
                {"Oak Boat with Chest", "OAK_CHEST_BOAT", "", "1", "Tools & Utilities", ""},
                {"Oak Button", "OAK_BUTTON", "", "1", "Building Blocks", ""},
                {"Oak Door", "OAK_DOOR", "", "1", "Building Blocks", ""},
                {"Oak Fence", "OAK_FENCE", "", "1", "Building Blocks", ""},
                {"Oak Fence Gate", "OAK_FENCE_GATE", "", "1", "Building Blocks", ""},
                {"Oak Hanging Sign", "OAK_HANGING_SIGN", "", "1", "Functional Blocks", ""},
                {"Oak Leaves", "OAK_LEAVES", "", "2", "Natural Blocks", ""},
                {"Oak Log", "OAK_LOG", "", "1", "Building Blocks", ""},
                {"Oak Planks", "OAK_PLANKS", "", "1", "Building Blocks", ""},
                {"Oak Pressure Plate", "OAK_PRESSURE_PLATE", "", "1", "Building Blocks", ""},
                {"Oak Sapling", "OAK_SAPLING", "", "1", "Natural Blocks", ""},
                {"Oak Sign", "OAK_SIGN", "", "1", "Functional Blocks", ""},
                {"Oak Slab", "OAK_SLAB", "", "1", "Building Blocks", ""},
                {"Oak Stairs", "OAK_STAIRS", "", "1", "Building Blocks", ""},
                {"Oak Trapdoor", "OAK_TRAPDOOR", "", "1", "Building Blocks", ""},
                {"Oak Wood", "OAK_WOOD", "", "1", "Building Blocks", ""},
                {"Observer", "OBSERVER", "", "2", "Redstone Blocks", ""},
                {"Obsidian", "OBSIDIAN", "", "3", "Natural Blocks", ""},
                {"Ochre Froglight", "OCHRE_FROGLIGHT", "", "6", "Natural Blocks", ""},
                {"Ominous Trial Key", "OMINOUS_TRIAL_KEY", "", "5", "Ingidients", ""},
                {"Open Eyeblossom", "OPEN_EYEBLOSSOM", "", "4", "Natural Blocks", ""},
                {"Orange Banner", "ORANGE_BANNER", "", "2", "Colored Blocks", ""},
                {"Orange Bed", "ORANGE_BED", "", "2", "Colored Blocks", ""},
                {"Orange Bundle", "ORANGE_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Orange Candle", "ORANGE_CANDLE", "", "3", "Colored Blocks", ""},
                {"Orange Carpet", "ORANGE_CARPET", "", "2", "Colored Blocks", ""},
                {"Orange Concrete", "ORANGE_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Orange Concrete Powder", "ORANGE_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Orange Dye", "ORANGE_DYE", "", "1", "Ingidients", ""},
                {"Orange Glazed Terracotta", "ORANGE_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Orange Shulker Box", "ORANGE_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Orange Stained Glass", "ORANGE_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Orange Stained Glass Pane", "ORANGE_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Orange Terracotta", "ORANGE_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Orange Tulip", "ORANGE_TULIP", "", "2", "Natural Blocks", ""},
                {"Orange Wool", "ORANGE_WOOL", "", "2", "Colored Blocks", ""},
                {"Oxeye Daisy", "OXEYE_DAISY", "", "1", "Natural Blocks", ""},
                {"Oxidized Chiseled Copper", "OXIDIZED_CHISELED_COPPER", "", "4", "Building Blocks", ""},
                {"Oxidized Copper", "OXIDIZED_COPPER", "", "4", "Building Blocks", ""},
                {"Oxidized Copper Bulb", "OXIDIZED_COPPER_BULB", "", "4", "Building Blocks", ""},
                {"Oxidized Copper Door", "OXIDIZED_COPPER_DOOR", "", "4", "Building Blocks", ""},
                {"Oxidized Copper Grate", "OXIDIZED_COPPER_GRATE", "", "4", "Building Blocks", ""},
                {"Oxidized Copper Trapdoor", "OXIDIZED_COPPER_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Oxidized Cut Copper", "OXIDIZED_CUT_COPPER", "", "4", "Building Blocks", ""},
                {"Oxidized Cut Copper Slab", "OXIDIZED_CUT_COPPER_SLAB", "", "4", "Building Blocks", ""},
                {"Oxidized Cut Copper Stairs", "OXIDIZED_CUT_COPPER_STAIRS", "", "4", "Building Blocks", ""},
                {"Packed Ice", "PACKED_ICE", "", "4", "Natural Blocks", ""},
                {"Packed Mud", "PACKED_MUD", "", "2", "Building Blocks", ""},
                {"Painting", "PAINTING", "", "1", "Functional Blocks", ""},
                {"Pale Hanging Moss", "PALE_HANGING_MOSS", "", "4", "Natural Blocks", ""},
                {"Pale Moss Block", "PALE_MOSS_BLOCK", "", "4", "Natural Blocks", ""},
                {"Pale Moss Carpet", "PALE_MOSS_CARPET", "", "4", "Natural Blocks", ""},
                {"Pale Oak Boat", "PALE_OAK_BOAT", "", "4", "Tools & Utilities", ""},
                {"Pale Oak Boat with Chest", "PALE_OAK_CHEST_BOAT", "", "4", "Tools & Utilities", ""},
                {"Pale Oak Button", "PALE_OAK_BUTTON", "", "4", "Building Blocks", ""},
                {"Pale Oak Door", "PALE_OAK_DOOR", "", "4", "Building Blocks", ""},
                {"Pale Oak Fence", "PALE_OAK_FENCE", "", "4", "Building Blocks", ""},
                {"Pale Oak Fence Gate", "PALE_OAK_FENCE_GATE", "", "4", "Building Blocks", ""},
                {"Pale Oak Hanging Sign", "PALE_OAK_HANGING_SIGN", "", "4", "Functional Blocks", ""},
                {"Pale Oak Leaves", "PALE_OAK_LEAVES", "", "4", "Natural Blocks", ""},
                {"Pale Oak Log", "PALE_OAK_LOG", "", "4", "Building Blocks", ""},
                {"Pale Oak Planks", "PALE_OAK_PLANKS", "", "4", "Building Blocks", ""},
                {"Pale Oak Pressure Plate", "PALE_OAK_PRESSURE_PLATE", "", "4", "Building Blocks", ""},
                {"Pale Oak Sapling", "PALE_OAK_SAPLING", "", "4", "Natural Blocks", ""},
                {"Pale Oak Sign", "PALE_OAK_SIGN", "", "4", "Functional Blocks", ""},
                {"Pale Oak Slab", "PALE_OAK_SLAB", "", "4", "Building Blocks", ""},
                {"Pale Oak Stairs", "PALE_OAK_STAIRS", "", "4", "Building Blocks", ""},
                {"Pale Oak Trapdoor", "PALE_OAK_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Pale Oak Wood", "PALE_OAK_WOOD", "", "4", "Building Blocks", ""},
                {"Paper", "PAPER", "", "1", "Ingidients", ""},
                {"Pearlescent Froglight", "PEARLESCENT_FROGLIGHT", "", "6", "Natural Blocks", ""},
                {"Peony", "PEONY", "", "1", "Natural Blocks", ""},
                {"Phantom Membrane", "PHANTOM_MEMBRANE", "", "0", "Ingidients", ""},
                {"Piglin Head", "PIGLIN_HEAD", "", "6", "Functional Blocks", ""},
                {"Pink Banner", "PINK_BANNER", "", "2", "Colored Blocks", ""},
                {"Pink Bed", "PINK_BED", "", "2", "Colored Blocks", ""},
                {"Pink Bundle", "PINK_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Pink Candle", "PINK_CANDLE", "", "3", "Colored Blocks", ""},
                {"Pink Carpet", "PINK_CARPET", "", "2", "Colored Blocks", ""},
                {"Pink Concrete", "PINK_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Pink Concrete Powder", "PINK_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Pink Dye", "PINK_DYE", "", "1", "Ingidients", ""},
                {"Pink Glazed Terracotta", "PINK_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Pink Petals", "PINK_PETALS", "", "4", "Natural Blocks", ""},
                {"Pink Shulker Box", "PINK_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Pink Stained Glass", "PINK_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Pink Stained Glass Pane", "PINK_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Pink Terracotta", "PINK_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Pink Tulip", "PINK_TULIP", "", "2", "Natural Blocks", ""},
                {"Pink Wool", "PINK_WOOL", "", "2", "Colored Blocks", ""},
                {"Piston", "PISTON", "", "2", "Redstone Blocks", ""},
                {"Pitcher Plant", "PITCHER_PLANT", "", "6", "Natural Blocks", ""},
                {"Pitcher Pod", "PITCHER_POD", "", "6", "Natural Blocks", ""},
                {"Player Head", "PLAYER_HEAD", "", "0", "Functional Blocks", ""},
                {"Plenty Pottery Sherd", "PLENTY_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Podzol", "PODZOL", "", "4", "Natural Blocks", ""},
                {"Pointed Dripstone", "POINTED_DRIPSTONE", "", "3", "Natural Blocks", ""},
                {"Poisonous Potato", "POISONOUS_POTATO", "", "3", "Food & Drinks", ""},
                {"Polished Andesite", "POLISHED_ANDESITE", "", "2", "Building Blocks", ""},
                {"Polished Andesite Slab", "POLISHED_ANDESITE_SLAB", "", "2", "Building Blocks", ""},
                {"Polished Andesite Stairs", "POLISHED_ANDESITE_STAIRS", "", "2", "Building Blocks", ""},
                {"Polished Basalt", "POLISHED_BASALT", "", "3", "Building Blocks", ""},
                {"Polished Blackstone", "POLISHED_BLACKSTONE", "", "3", "Building Blocks", ""},
                {"Polished Blackstone Brick Slab", "POLISHED_BLACKSTONE_BRICK_SLAB", "", "3", "Building Blocks", ""},
                {"Polished Blackstone Brick Stairs", "POLISHED_BLACKSTONE_BRICK_STAIRS", "", "3", "Building Blocks", ""},
                {"Polished Blackstone Brick Wall", "POLISHED_BLACKSTONE_BRICK_WALL", "", "3", "Building Blocks", ""},
                {"Polished Blackstone Bricks", "POLISHED_BLACKSTONE_BRICKS", "", "3", "Building Blocks", ""},
                {"Polished Blackstone Button", "POLISHED_BLACKSTONE_BUTTON", "", "3", "Building Blocks", ""},
                {"Polished Blackstone Pressure Plate", "POLISHED_BLACKSTONE_PRESSURE_PLATE", "", "3", "Building Blocks", ""},
                {"Polished Blackstone Slab", "POLISHED_BLACKSTONE_SLAB", "", "3", "Building Blocks", ""},
                {"Polished Blackstone Stairs", "POLISHED_BLACKSTONE_STAIRS", "", "3", "Building Blocks", ""},
                {"Polished Blackstone Wall", "POLISHED_BLACKSTONE_WALL", "", "3", "Building Blocks", ""},
                {"Polished Deepslate", "POLISHED_DEEPSLATE", "", "2", "Building Blocks", ""},
                {"Polished Deepslate Slab", "POLISHED_DEEPSLATE_SLAB", "", "2", "Building Blocks", ""},
                {"Polished Deepslate Stairs", "POLISHED_DEEPSLATE_STAIRS", "", "2", "Building Blocks", ""},
                {"Polished Deepslate Wall", "POLISHED_DEEPSLATE_WALL", "", "2", "Building Blocks", ""},
                {"Polished Diorite", "POLISHED_DIORITE", "", "2", "Building Blocks", ""},
                {"Polished Diorite Slab", "POLISHED_DIORITE_SLAB", "", "2", "Building Blocks", ""},
                {"Polished Diorite Stairs", "POLISHED_DIORITE_STAIRS", "", "2", "Building Blocks", ""},
                {"Polished Granite", "POLISHED_GRANITE", "", "2", "Building Blocks", ""},
                {"Polished Granite Slab", "POLISHED_GRANITE_SLAB", "", "2", "Building Blocks", ""},
                {"Polished Granite Stairs", "POLISHED_GRANITE_STAIRS", "", "2", "Building Blocks", ""},
                {"Polished Tuff", "POLISHED_TUFF", "", "2", "Building Blocks", ""},
                {"Polished Tuff Slab", "POLISHED_TUFF_SLAB", "", "2", "Building Blocks", ""},
                {"Polished Tuff Stairs", "POLISHED_TUFF_STAIRS", "", "2", "Building Blocks", ""},
                {"Polished Tuff Wall", "POLISHED_TUFF_WALL", "", "2", "Building Blocks", ""},
                {"Popped Chorus Fruit", "POPPED_CHORUS_FRUIT", "", "6", "Ingidients", ""},
                {"Poppy", "POPPY", "", "1", "Natural Blocks", ""},
                {"Potato", "POTATO", "", "3", "Food & Drinks", ""},
                {"Powder Snow Bucket", "POWDER_SNOW_BUCKET", "", "3", "Tools & Utilities", ""},
                {"Powered Rail", "POWERED_RAIL", "", "2", "Redstone Blocks", ""},
                {"Prismarine", "PRISMARINE", "", "4", "Building Blocks", ""},
                {"Prismarine Brick Slab", "PRISMARINE_BRICK_SLAB", "", "4", "Building Blocks", ""},
                {"Prismarine Brick Stairs", "PRISMARINE_BRICK_STAIRS", "", "4", "Building Blocks", ""},
                {"Prismarine Bricks", "PRISMARINE_BRICKS", "", "4", "Building Blocks", ""},
                {"Prismarine Crystals", "PRISMARINE_CRYSTALS", "", "4", "Ingidients", ""},
                {"Prismarine Shard", "PRISMARINE_SHARD", "", "4", "Ingidients", ""},
                {"Prismarine Slab", "PRISMARINE_SLAB", "", "4", "Building Blocks", ""},
                {"Prismarine Stairs", "PRISMARINE_STAIRS", "", "4", "Building Blocks", ""},
                {"Prismarine Wall", "PRISMARINE_WALL", "", "4", "Building Blocks", ""},
                {"Prize Pottery Sherd", "PRIZE_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Pufferfish", "PUFFERFISH", "", "4", "Food & Drinks", ""},
                {"Pumpkin", "PUMPKIN", "", "2", "Natural Blocks", ""},
                {"Pumpkin Pie", "PUMPKIN_PIE", "", "2", "Food & Drinks", ""},
                {"Pumpkin Seeds", "PUMPKIN_SEEDS", "", "2", "Natural Blocks", ""},
                {"Purple Banner", "PURPLE_BANNER", "", "2", "Colored Blocks", ""},
                {"Purple Bed", "PURPLE_BED", "", "2", "Colored Blocks", ""},
                {"Purple Bundle", "PURPLE_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Purple Candle", "PURPLE_CANDLE", "", "3", "Colored Blocks", ""},
                {"Purple Carpet", "PURPLE_CARPET", "", "2", "Colored Blocks", ""},
                {"Purple Concrete", "PURPLE_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Purple Concrete Powder", "PURPLE_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Purple Dye", "PURPLE_DYE", "", "1", "Ingidients", ""},
                {"Purple Glazed Terracotta", "PURPLE_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Purple Shulker Box", "PURPLE_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Purple Stained Glass", "PURPLE_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Purple Stained Glass Pane", "PURPLE_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Purple Terracotta", "PURPLE_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Purple Wool", "PURPLE_WOOL", "", "2", "Colored Blocks", ""},
                {"Purpur Block", "PURPUR_BLOCK", "", "6", "Building Blocks", ""},
                {"Purpur Pillar", "PURPUR_PILLAR", "", "6", "Building Blocks", ""},
                {"Purpur Slab", "PURPUR_SLAB", "", "6", "Building Blocks", ""},
                {"Purpur Stairs", "PURPUR_STAIRS", "", "6", "Building Blocks", ""},
                {"Quartz Bricks", "QUARTZ_BRICKS", "", "2", "Building Blocks", ""},
                {"Quartz Pillar", "QUARTZ_PILLAR", "", "2", "Building Blocks", ""},
                {"Quartz Slab", "QUARTZ_SLAB", "", "2", "Building Blocks", ""},
                {"Quartz Stairs", "QUARTZ_STAIRS", "", "2", "Building Blocks", ""},
                {"Rabbit Hide", "RABBIT_HIDE", "", "3", "Ingidients", ""},
                {"Rabbit Stew", "RABBIT_STEW", "", "3", "Food & Drinks", ""},
                {"Rabbt's Foot", "RABBIT_FOOT", "", "5", "Ingidients", ""},
                {"Rail", "RAIL", "", "2", "Redstone Blocks", ""},
                {"Raiser Armour Trim", "RAISER_ARMOR_TRIM_SMITHING_TEMPLATE", "", "3", "Ingidients", ""},
                {"Raw Beef", "BEEF", "", "1", "Food & Drinks", ""},
                {"Raw Chicken", "CHICKEN", "", "1", "Food & Drinks", ""},
                {"Raw Cod", "COD", "", "1", "Food & Drinks", ""},
                {"Raw Copper", "RAW_COPPER", "", "1", "Ingidients", ""},
                {"Raw Gold", "RAW_GOLD", "", "2", "Ingidients", ""},
                {"Raw Iron", "RAW_IRON", "", "2", "Ingidients", ""},
                {"Raw Mutton", "MUTTON", "", "1", "Food & Drinks", ""},
                {"Raw Porkchop", "PORKCHOP", "", "1", "Food & Drinks", ""},
                {"Raw Rabbit", "RABBIT", "", "3", "Food & Drinks", ""},
                {"Raw Salmon", "SALMON", "", "1", "Food & Drinks", ""},
                {"Recovery Compass", "RECOVERY_COMPASS", "", "5", "Tools & Utilities", ""},
                {"Red Banner", "RED_BANNER", "", "2", "Colored Blocks", ""},
                {"Red Bed", "RED_BED", "", "2", "Colored Blocks", ""},
                {"Red Bundle", "RED_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Red Candle", "RED_CANDLE", "", "3", "Colored Blocks", ""},
                {"Red Carpet", "RED_CARPET", "", "2", "Colored Blocks", ""},
                {"Red Concrete", "RED_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Red Concrete Powder", "RED_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Red Dye", "RED_DYE", "", "1", "Ingidients", ""},
                {"Red Glazed Terracotta", "RED_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Red Mushroom", "RED_MUSHROOM", "", "2", "Natural Blocks", ""},
                {"Red Mushroom Block", "RED_MUSHROOM_BLOCK", "", "4", "Natural Blocks", ""},
                {"Red Nether Brick Slab", "RED_NETHER_BRICK_SLAB", "", "4", "Building Blocks", ""},
                {"Red Nether Brick Stairs", "RED_NETHER_BRICK_STAIRS", "", "4", "Building Blocks", ""},
                {"Red Nether Brick Wall", "RED_NETHER_BRICK_WALL", "", "4", "Building Blocks", ""},
                {"Red Nether Bricks", "RED_NETHER_BRICKS", "", "4", "Building Blocks", ""},
                {"Red Sand", "RED_SAND", "", "4", "Natural Blocks", ""},
                {"Red Sandstone", "RED_SANDSTONE", "", "4", "Building Blocks", ""},
                {"Red Sandstone Slab", "RED_SANDSTONE_SLAB", "", "4", "Building Blocks", ""},
                {"Red Sandstone Stairs", "RED_SANDSTONE_STAIRS", "", "4", "Building Blocks", ""},
                {"Red Sandstone Wall", "RED_SANDSTONE_WALL", "", "4", "Building Blocks", ""},
                {"Red Shulker Box", "RED_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Red Stained Glass", "RED_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Red Stained Glass Pane", "RED_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Red Terracotta", "RED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Red Tulip", "RED_TULIP", "", "2", "Natural Blocks", ""},
                {"Red Wool", "RED_WOOL", "", "2", "Colored Blocks", ""},
                {"Redstone Comparator", "COMPARATOR", "", "2", "Redstone Blocks", ""},
                {"Redstone Dust", "REDSTONE", "", "3", "Ingidients", ""},
                {"Redstone Lamp", "REDSTONE_LAMP", "", "3", "Functional Blocks", ""},
                {"Redstone Ore", "REDSTONE_ORE", "", "4", "Natural Blocks", ""},
                {"Redstone Repeater", "REPEATER", "", "2", "Redstone Blocks", ""},
                {"Redstone Torch", "REDSTONE_TORCH", "", "3", "Functional Blocks", ""},
                {"Reinforced Deepslate", "REINFORCED_DEEPSLATE", "", "0", "Building Blocks", ""},
                {"Resin Brick", "RESIN_BRICK", "", "4", "Ingidients", ""},
                {"Resin Brick Slab", "RESIN_BRICK_SLAB", "", "4", "Building Blocks", ""},
                {"Resin Brick Stairs", "RESIN_BRICK_STAIRS", "", "4", "Building Blocks", ""},
                {"Resin Brick Wall", "RESIN_BRICK_WALL", "", "4", "Building Blocks", ""},
                {"Resin Bricks", "RESIN_BRICKS", "", "4", "Building Blocks", ""},
                {"Resin Clump", "RESIN_CLUMP", "", "4", "Ingidients", ""},
                {"Respawn Anchor", "RESPAWN_ANCHOR", "", "4", "Functional Blocks", ""},
                {"Rib Armour Trim", "RIB_ARMOR_TRIM_SMITHING_TEMPLATE", "", "3", "Ingidients", ""},
                {"Roast Chicken", "COOKED_CHICKEN", "", "1", "Food & Drinks", ""},
                {"Rooted Dirt", "ROOTED_DIRT", "", "3", "Natural Blocks", ""},
                {"Rose Bush", "ROSE_BUSH", "", "1", "Natural Blocks", ""},
                {"Rotten Flesh", "ROTTEN_FLESH", "", "2", "Food & Drinks", ""},
                {"Saddle", "SADDLE", "", "3", "Tools & Utilities", ""},
                {"Sand", "SAND", "", "1", "Natural Blocks", ""},
                {"Sandstone", "SANDSTONE", "", "1", "Building Blocks", ""},
                {"Sandstone Slab", "SANDSTONE_SLAB", "", "1", "Building Blocks", ""},
                {"Sandstone Stairs", "SANDSTONE_STAIRS", "", "1", "Building Blocks", ""},
                {"Sandstone Wall", "SANDSTONE_WALL", "", "1", "Building Blocks", ""},
                {"Scaffolding", "SCAFFOLDING", "", "4", "Functional Blocks", ""},
                {"Scrape Pottery Sherd", "SCRAPE_POTTERY_SHERD", "", "4", "Ingidients", ""},
                {"Sculk", "SCULK", "", "5", "Natural Blocks", ""},
                {"Sculk Catalyst", "SCULK_CATALYST", "", "5", "Natural Blocks", ""},
                {"Sculk Sensor", "SCULK_SENSOR", "", "5", "Natural Blocks", ""},
                {"Sculk Shrieker", "SCULK_SHRIEKER", "", "5", "Natural Blocks", ""},
                {"Sculk Vein", "SCULK_VEIN", "", "5", "Natural Blocks", ""},
                {"Sea Lantern", "SEA_LANTERN", "", "4", "Building Blocks", ""},
                {"Sea Pickle", "SEA_PICKLE", "", "4", "Natural Blocks", ""},
                {"Seagrass", "SEAGRASS", "", "2", "Natural Blocks", ""},
                {"Sentry Armour Trim", "SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE", "", "3", "Ingidients", ""},
                {"Shaper Armour Trim", "SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE", "", "3", "Ingidients", ""},
                {"Sheaf Pottery Sherd", "SHEAF_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Shears", "SHEARS", "", "2", "Tools & Utilities", ""},
                {"Shelter Pottery Sherd", "SHELTER_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Shield", "SHIELD", "", "2", "Combat", ""},
                {"Short Dry Grass", "SHORT_DRY_GRASS", "", "4", "Natural Blocks", ""},
                {"Shroomlight", "SHROOMLIGHT", "", "3", "Natural Blocks", ""},
                {"Shulker Box", "SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Shulker Shell", "SHULKER_SHELL", "", "6", "Ingidients", ""},
                {"Silence Armour Trim", "SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE", "", "6", "Ingidients", ""},
                {"Skeleton Skull", "SKELETON_SKULL", "", "6", "Functional Blocks", ""},
                {"Skull Pottery Sherd", "SKULL_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Slime Block", "SLIME_BLOCK", "", "3", "Natural Blocks", ""},
                {"Slimeball", "SLIME_BALL", "", "3", "Ingidients", ""},
                {"Small Amethyst Bud", "SMALL_AMETHYST_BUD", "", "5", "Natural Blocks", ""},
                {"Small Dripleaf", "SMALL_DRIPLEAF", "", "0", "Natural Blocks", ""},
                {"Smithing Table", "SMITHING_TABLE", "", "2", "Functional Blocks", ""},
                {"Smoker", "SMOKER", "", "2", "Functional Blocks", ""},
                {"Smooth Basalt", "SMOOTH_BASALT", "", "3", "Building Blocks", ""},
                {"Smooth Quartz Block", "SMOOTH_QUARTZ", "", "2", "Building Blocks", ""},
                {"Smooth Quartz Slab", "SMOOTH_QUARTZ_SLAB", "", "2", "Building Blocks", ""},
                {"Smooth Quartz Stairs", "SMOOTH_QUARTZ_STAIRS", "", "2", "Building Blocks", ""},
                {"Smooth Red Sandstone", "SMOOTH_RED_SANDSTONE", "", "4", "Building Blocks", ""},
                {"Smooth Red Sandstone Slab", "SMOOTH_RED_SANDSTONE_SLAB", "", "4", "Building Blocks", ""},
                {"Smooth Red Sandstone Stairs", "SMOOTH_RED_SANDSTONE_STAIRS", "", "4", "Building Blocks", ""},
                {"Smooth Sandstone", "SMOOTH_SANDSTONE", "", "1", "Building Blocks", ""},
                {"Smooth Sandstone Slab", "SMOOTH_SANDSTONE_SLAB", "", "1", "Building Blocks", ""},
                {"Smooth Sandstone Stairs", "SMOOTH_SANDSTONE_STAIRS", "", "1", "Building Blocks", ""},
                {"Smooth Stone", "SMOOTH_STONE", "", "1", "Building Blocks", ""},
                {"Smooth Stone Slab", "SMOOTH_STONE_SLAB", "", "1", "Building Blocks", ""},
                {"Sniffer Egg", "SNIFFER_EGG", "", "5", "Natural Blocks", ""},
                {"Snort Pottery Sherd", "SNORT_POTTERY_SHERD", "", "5", "Ingidients", ""},
                {"Snout Armour Trim", "SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE", "", "5", "Ingidients", ""},
                {"Snow", "SNOW", "", "3", "Natural Blocks", ""},
                {"Snow Block", "SNOW_BLOCK", "", "3", "Natural Blocks", ""},
                {"Snowball", "SNOWBALL", "", "3", "Ingidients", ""},
                {"Snowball", "SNOWBALL", "", "3", "Combat", ""},
                {"Soul Campfire", "SOUL_CAMPFIRE", "", "3", "Functional Blocks", ""},
                {"Soul Lantern", "SOUL_LANTERN", "", "3", "Functional Blocks", ""},
                {"Soul Sand", "SOUL_SAND", "", "3", "Natural Blocks", ""},
                {"Soul Soil", "SOUL_SOIL", "", "3", "Natural Blocks", ""},
                {"Soul Torch", "SOUL_TORCH", "", "3", "Functional Blocks", ""},
                {"Spectral Arrow", "SPECTRAL_ARROW", "", "3", "Combat", ""},
                {"Spider Eye", "SPIDER_EYE", "", "2", "Ingidients", ""},
                {"Spire Armour Trim", "SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE", "", "6", "Ingidients", ""},
                {"Sponge", "SPONGE", "", "4", "Natural Blocks", ""},
                {"Spore Blossom", "SPORE_BLOSSOM", "", "3", "Natural Blocks", ""},
                {"Spruce Boat", "SPRUCE_BOAT", "", "2", "Tools & Utilities", ""},
                {"Spruce Boat with Chest", "SPRUCE_CHEST_BOAT", "", "2", "Tools & Utilities", ""},
                {"Spruce Button", "SPRUCE_BUTTON", "", "3", "Building Blocks", ""},
                {"Spruce Door", "SPRUCE_DOOR", "", "3", "Building Blocks", ""},
                {"Spruce Fence", "SPRUCE_FENCE", "", "3", "Building Blocks", ""},
                {"Spruce Fence Gate", "SPRUCE_FENCE_GATE", "", "3", "Building Blocks", ""},
                {"Spruce Hanging Sign", "SPRUCE_HANGING_SIGN", "", "2", "Functional Blocks", ""},
                {"Spruce Leaves", "SPRUCE_LEAVES", "", "2", "Natural Blocks", ""},
                {"Spruce Log", "SPRUCE_LOG", "", "3", "Building Blocks", ""},
                {"Spruce Planks", "SPRUCE_PLANKS", "", "3", "Building Blocks", ""},
                {"Spruce Pressure Plate", "SPRUCE_PRESSURE_PLATE", "", "3", "Building Blocks", ""},
                {"Spruce Sapling", "SPRUCE_SAPLING", "", "2", "Natural Blocks", ""},
                {"Spruce Sign", "SPRUCE_SIGN", "", "2", "Functional Blocks", ""},
                {"Spruce Slab", "SPRUCE_SLAB", "", "3", "Building Blocks", ""},
                {"Spruce Stairs", "SPRUCE_STAIRS", "", "3", "Building Blocks", ""},
                {"Spruce Trapdoor", "SPRUCE_TRAPDOOR", "", "3", "Building Blocks", ""},
                {"Spruce Wood", "SPRUCE_WOOD", "", "3", "Building Blocks", ""},
                {"Spyglass", "SPYGLASS", "", "4", "Tools & Utilities", ""},
                {"Steak", "COOKED_BEEF", "", "1", "Food & Drinks", ""},
                {"Stick", "STICK", "", "1", "Ingidients", ""},
                {"Sticky Piston", "STICKY_PISTON", "", "3", "Redstone Blocks", ""},
                {"Stone", "STONE", "", "1", "Building Blocks", ""},
                {"Stone Axe", "STONE_AXE", "", "1", "Combat", ""},
                {"Stone Brick Slab", "STONE_BRICK_SLAB", "", "1", "Building Blocks", ""},
                {"Stone Brick Stairs", "STONE_BRICK_STAIRS", "", "1", "Building Blocks", ""},
                {"Stone Brick Wall", "STONE_BRICK_WALL", "", "1", "Building Blocks", ""},
                {"Stone Bricks", "STONE_BRICKS", "", "1", "Building Blocks", ""},
                {"Stone Button", "STONE_BUTTON", "", "1", "Building Blocks", ""},
                {"Stone Hoe", "STONE_HOE", "", "1", "Tools & Utilities", ""},
                {"Stone Pickaxe", "STONE_PICKAXE", "", "1", "Tools & Utilities", ""},
                {"Stone Pressure Plate", "STONE_PRESSURE_PLATE", "", "1", "Building Blocks", ""},
                {"Stone Shovel", "STONE_SHOVEL", "", "1", "Tools & Utilities", ""},
                {"Stone Slab", "STONE_SLAB", "", "1", "Building Blocks", ""},
                {"Stone Stairs", "STONE_STAIRS", "", "1", "Building Blocks", ""},
                {"Stone Sword", "STONE_SWORD", "", "1", "Combat", ""},
                {"Stonecutter", "STONECUTTER", "", "2", "Functional Blocks", ""},
                {"String", "STRING", "", "2", "Ingidients", ""},
                {"Stripped Acacia Log", "STRIPPED_ACACIA_LOG", "", "3", "Building Blocks", ""},
                {"Stripped Acacia Wood", "STRIPPED_ACACIA_WOOD", "", "3", "Building Blocks", ""},
                {"Stripped Birch Log", "STRIPPED_BIRCH_LOG", "", "1", "Building Blocks", ""},
                {"Stripped Birch Wood", "STRIPPED_BIRCH_WOOD", "", "1", "Building Blocks", ""},
                {"Stripped Cherry Log", "STRIPPED_CHERRY_LOG", "", "4", "Building Blocks", ""},
                {"Stripped Cherry Wood", "STRIPPED_CHERRY_WOOD", "", "4", "Building Blocks", ""},
                {"Stripped Crimson Hyphae", "STRIPPED_CRIMSON_HYPHAE", "", "4", "Building Blocks", ""},
                {"Stripped Crimson Stem", "STRIPPED_CRIMSON_STEM", "", "4", "Building Blocks", ""},
                {"Stripped Dark Oak Log", "STRIPPED_DARK_OAK_LOG", "", "3", "Building Blocks", ""},
                {"Stripped Dark Oak Wood", "STRIPPED_DARK_OAK_WOOD", "", "3", "Building Blocks", ""},
                {"Stripped Jungle Log", "STRIPPED_JUNGLE_LOG", "", "4", "Building Blocks", ""},
                {"Stripped Jungle Wood", "STRIPPED_JUNGLE_WOOD", "", "4", "Building Blocks", ""},
                {"Stripped Mangrove Log", "STRIPPED_MANGROVE_LOG", "", "4", "Building Blocks", ""},
                {"Stripped Mangrove Wood", "STRIPPED_MANGROVE_WOOD", "", "4", "Building Blocks", ""},
                {"Stripped Oak Log", "STRIPPED_OAK_LOG", "", "1", "Building Blocks", ""},
                {"Stripped Oak Wood", "STRIPPED_OAK_WOOD", "", "1", "Building Blocks", ""},
                {"Stripped Pale Oak Log", "STRIPPED_PALE_OAK_LOG", "", "4", "Building Blocks", ""},
                {"Stripped Pale Oak Wood", "STRIPPED_PALE_OAK_WOOD", "", "4", "Building Blocks", ""},
                {"Stripped Spruce Log", "STRIPPED_SPRUCE_LOG", "", "3", "Building Blocks", ""},
                {"Stripped Spruce Wood", "STRIPPED_SPRUCE_WOOD", "", "3", "Building Blocks", ""},
                {"Stripped Warped Hyphae", "STRIPPED_WARPED_HYPHAE", "", "4", "Building Blocks", ""},
                {"Stripped Warped Stem", "STRIPPED_WARPED_STEM", "", "4", "Building Blocks", ""},
                {"Sugar", "SUGAR", "", "1", "Ingidients", ""},
                {"Sugar Cane", "SUGAR_CANE", "", "1", "Natural Blocks", ""},
                {"Sunflower", "SUNFLOWER", "", "3", "Natural Blocks", ""},
                {"Suspicious Gravel", "SUSPICIOUS_GRAVEL", "", "0", "Functional Blocks", ""},
                {"Suspicious Sand", "SUSPICIOUS_SAND", "", "0", "Functional Blocks", ""},
                {"Suspicious Stew", "SUSPICIOUS_STEW", "", "2", "Food & Drinks", ""},
                {"Sweet Berries", "SWEET_BERRIES", "", "2", "Natural Blocks", ""},
                {"Tall Dry Grass", "TALL_DRY_GRASS", "", "4", "Natural Blocks", ""},
                {"Tall Grass", "TALL_GRASS", "", "0", "Natural Blocks", ""},
                {"Target", "TARGET", "", "2", "Redstone Blocks", ""},
                {"Terracotta", "TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Tide Armour Trim", "TIDE_ARMOR_TRIM_SMITHING_TEMPLATE", "", "6", "Ingidients", ""},
                {"Tinted Glass", "TINTED_GLASS", "", "4", "Colored Blocks", ""},
                {"Tipped Arrow", "TIPPED_ARROW", "", "0", "Combat", ""},
                {"TNT", "TNT", "", "3", "Combat", ""},
                {"Torch", "TORCH", "", "2", "Functional Blocks", ""},
                {"Torchflower", "TORCHFLOWER", "", "6", "Natural Blocks", ""},
                {"Torchflower Seeds", "TORCHFLOWER_SEEDS", "", "6", "Natural Blocks", ""},
                {"Totem of Undying", "TOTEM_OF_UNDYING", "", "5", "Combat", ""},
                {"Trapped Chest", "TRAPPED_CHEST", "", "2", "Redstone Blocks", ""},
                {"Trial Key", "TRIAL_KEY", "", "4", "Ingidients", ""},
                {"Trident", "TRIDENT", "", "5", "Combat", ""},
                {"Tripwire Hook", "TRIPWIRE_HOOK", "", "2", "Redstone Blocks", ""},
                {"Tropical Fish", "TROPICAL_FISH", "", "4", "Food & Drinks", ""},
                {"Tube Coral", "TUBE_CORAL", "", "4", "Natural Blocks", ""},
                {"Tube Coral Block", "TUBE_CORAL_BLOCK", "", "4", "Natural Blocks", ""},
                {"Tube Coral Fan", "TUBE_CORAL_FAN", "", "4", "Natural Blocks", ""},
                {"Tuff", "TUFF", "", "2", "Building Blocks", ""},
                {"Tuff Brick Slab", "TUFF_BRICK_SLAB", "", "2", "Building Blocks", ""},
                {"Tuff Brick Stairs", "TUFF_BRICK_STAIRS", "", "2", "Building Blocks", ""},
                {"Tuff Brick Wall", "TUFF_BRICK_WALL", "", "2", "Building Blocks", ""},
                {"Tuff Bricks", "TUFF_BRICKS", "", "2", "Building Blocks", ""},
                {"Tuff Slab", "TUFF_SLAB", "", "2", "Building Blocks", ""},
                {"Tuff Stairs", "TUFF_STAIRS", "", "2", "Building Blocks", ""},
                {"Tuff Wall", "TUFF_WALL", "", "2", "Building Blocks", ""},
                {"Turtle Egg", "TURTLE_EGG", "", "4", "Natural Blocks", ""},
                {"Turtle Scute", "TURTLE_SCUTE", "", "4", "Ingidients", ""},
                {"Turtle Shell", "TURTLE_HELMET", "", "6", "Combat", ""},
                {"Twisting Vines", "TWISTING_VINES", "", "4", "Natural Blocks", ""},
                {"Verdant Froglight", "VERDANT_FROGLIGHT", "", "6", "Natural Blocks", ""},
                {"Vex Armour Trim", "VEX_ARMOR_TRIM_SMITHING_TEMPLATE", "", "4", "Ingidients", ""},
                {"Vines", "VINE", "", "2", "Natural Blocks", ""},
                {"Ward Armour Trim", "WARD_ARMOR_TRIM_SMITHING_TEMPLATE", "", "6", "Ingidients", ""},
                {"Warped Button", "WARPED_BUTTON", "", "4", "Building Blocks", ""},
                {"Warped Door", "WARPED_DOOR", "", "4", "Building Blocks", ""},
                {"Warped Fence", "WARPED_FENCE", "", "4", "Building Blocks", ""},
                {"Warped Fence Gate", "WARPED_FENCE_GATE", "", "4", "Building Blocks", ""},
                {"Warped Fungus", "WARPED_FUNGUS", "", "4", "Natural Blocks", ""},
                {"Warped Fungus on a Stick", "WARPED_FUNGUS_ON_A_STICK", "", "3", "Tools & Utilities", ""},
                {"Warped Hanging Sign", "WARPED_HANGING_SIGN", "", "4", "Functional Blocks", ""},
                {"Warped Hyphae", "WARPED_HYPHAE", "", "4", "Building Blocks", ""},
                {"Warped Nylium", "WARPED_NYLIUM", "", "5", "Natural Blocks", ""},
                {"Warped Planks", "WARPED_PLANKS", "", "4", "Building Blocks", ""},
                {"Warped Pressure Plate", "WARPED_PRESSURE_PLATE", "", "4", "Building Blocks", ""},
                {"Warped Roots", "WARPED_ROOTS", "", "4", "Natural Blocks", ""},
                {"Warped Sign", "WARPED_SIGN", "", "4", "Functional Blocks", ""},
                {"Warped Slab", "WARPED_SLAB", "", "4", "Building Blocks", ""},
                {"Warped Stairs", "WARPED_STAIRS", "", "4", "Building Blocks", ""},
                {"Warped Stem", "WARPED_STEM", "", "4", "Building Blocks", ""},
                {"Warped Trapdoor", "WARPED_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Warped Wart Block", "WARPED_WART_BLOCK", "", "4", "Natural Blocks", ""},
                {"Water Bucket", "WATER_BUCKET", "", "2", "Tools & Utilities", ""},
                {"Waxed Block of Copper", "WAXED_COPPER_BLOCK", "", "3", "Building Blocks", ""},
                {"Waxed Chiseled Copper", "WAXED_CHISELED_COPPER", "", "3", "Building Blocks", ""},
                {"Waxed Copper Bulb", "WAXED_COPPER_BULB", "", "3", "Building Blocks", ""},
                {"Waxed Copper Door", "WAXED_COPPER_DOOR", "", "3", "Building Blocks", ""},
                {"Waxed Copper Grate", "WAXED_COPPER_GRATE", "", "3", "Building Blocks", ""},
                {"Waxed Copper Trapdoor", "WAXED_COPPER_TRAPDOOR", "", "3", "Building Blocks", ""},
                {"Waxed Cut Copper", "WAXED_CUT_COPPER", "", "3", "Building Blocks", ""},
                {"Waxed Cut Copper Slab", "WAXED_CUT_COPPER_SLAB", "", "3", "Building Blocks", ""},
                {"Waxed Cut Copper Stairs", "WAXED_CUT_COPPER_STAIRS", "", "3", "Building Blocks", ""},
                {"Waxed Exposed Chiseled Copper", "WAXED_EXPOSED_CHISELED_COPPER", "", "3", "Building Blocks", ""},
                {"Waxed Exposed Copper", "WAXED_EXPOSED_COPPER", "", "3", "Building Blocks", ""},
                {"Waxed Exposed Copper Bulb", "WAXED_EXPOSED_COPPER_BULB", "", "3", "Building Blocks", ""},
                {"Waxed Exposed Copper Door", "WAXED_EXPOSED_COPPER_DOOR", "", "3", "Building Blocks", ""},
                {"Waxed Exposed Copper Grate", "WAXED_EXPOSED_COPPER_GRATE", "", "3", "Building Blocks", ""},
                {"Waxed Exposed Copper Trapdoor", "WAXED_EXPOSED_COPPER_TRAPDOOR", "", "3", "Building Blocks", ""},
                {"Waxed Exposed Cut Copper", "WAXED_EXPOSED_CUT_COPPER", "", "3", "Building Blocks", ""},
                {"Waxed Exposed Cut Copper Slab", "WAXED_EXPOSED_CUT_COPPER_SLAB", "", "3", "Building Blocks", ""},
                {"Waxed Exposed Cut Copper Stairs", "WAXED_EXPOSED_CUT_COPPER_STAIRS", "", "3", "Building Blocks", ""},
                {"Waxed Oxidized Chiseled Copper", "WAXED_OXIDIZED_CHISELED_COPPER", "", "4", "Building Blocks", ""},
                {"Waxed Oxidized Copper", "WAXED_OXIDIZED_COPPER", "", "4", "Building Blocks", ""},
                {"Waxed Oxidized Copper Bulb", "WAXED_OXIDIZED_COPPER_BULB", "", "4", "Building Blocks", ""},
                {"Waxed Oxidized Copper Door", "WAXED_OXIDIZED_COPPER_DOOR", "", "4", "Building Blocks", ""},
                {"Waxed Oxidized Copper Grate", "WAXED_OXIDIZED_COPPER_GRATE", "", "4", "Building Blocks", ""},
                {"Waxed Oxidized Copper Trapdoor", "WAXED_OXIDIZED_COPPER_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Waxed Oxidized Cut Copper", "WAXED_OXIDIZED_CUT_COPPER", "", "4", "Building Blocks", ""},
                {"Waxed Oxidized Cut Copper Slab", "WAXED_OXIDIZED_CUT_COPPER_SLAB", "", "4", "Building Blocks", ""},
                {"Waxed Oxidized Cut Copper Stairs", "WAXED_OXIDIZED_CUT_COPPER_STAIRS", "", "4", "Building Blocks", ""},
                {"Waxed Weathered Chiseled Copper", "WAXED_WEATHERED_CHISELED_COPPER", "", "4", "Building Blocks", ""},
                {"Waxed Weathered Copper", "WAXED_WEATHERED_COPPER", "", "4", "Building Blocks", ""},
                {"Waxed Weathered Copper Bulb", "WAXED_WEATHERED_COPPER_BULB", "", "4", "Building Blocks", ""},
                {"Waxed Weathered Copper Door", "WAXED_WEATHERED_COPPER_DOOR", "", "4", "Building Blocks", ""},
                {"Waxed Weathered Copper Grate", "WAXED_WEATHERED_COPPER_GRATE", "", "4", "Building Blocks", ""},
                {"Waxed Weathered Copper Trapdoor", "WAXED_WEATHERED_COPPER_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Waxed Weathered Cut Copper", "WAXED_WEATHERED_CUT_COPPER", "", "4", "Building Blocks", ""},
                {"Waxed Weathered Cut Copper Slab", "WAXED_WEATHERED_CUT_COPPER_SLAB", "", "4", "Building Blocks", ""},
                {"Waxed Weathered Cut Copper Stairs", "WAXED_WEATHERED_CUT_COPPER_STAIRS", "", "4", "Building Blocks", ""},
                {"Wayfinder Armour Trim", "WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE", "", "5", "Ingidients", ""},
                {"Weathered Chiseled Copper", "WEATHERED_CHISELED_COPPER", "", "4", "Building Blocks", ""},
                {"Weathered Copper", "WEATHERED_COPPER", "", "4", "Building Blocks", ""},
                {"Weathered Copper Bulb", "WEATHERED_COPPER_BULB", "", "4", "Building Blocks", ""},
                {"Weathered Copper Door", "WEATHERED_COPPER_DOOR", "", "4", "Building Blocks", ""},
                {"Weathered Copper Grate", "WEATHERED_COPPER_GRATE", "", "4", "Building Blocks", ""},
                {"Weathered Copper Trapdoor", "WEATHERED_COPPER_TRAPDOOR", "", "4", "Building Blocks", ""},
                {"Weathered Cut Copper", "WEATHERED_CUT_COPPER", "", "4", "Building Blocks", ""},
                {"Weathered Cut Copper Slab", "WEATHERED_CUT_COPPER_SLAB", "", "4", "Building Blocks", ""},
                {"Weathered Cut Copper Stairs", "WEATHERED_CUT_COPPER_STAIRS", "", "4", "Building Blocks", ""},
                {"Weeping Vines", "WEEPING_VINES", "", "4", "Natural Blocks", ""},
                {"Wet Sponge", "WET_SPONGE", "", "4", "Natural Blocks", ""},
                {"Wheat", "WHEAT", "", "2", "Ingidients", ""},
                {"Wheat Seeds", "WHEAT_SEEDS", "", "1", "Natural Blocks", ""},
                {"White Banner", "WHITE_BANNER", "", "2", "Colored Blocks", ""},
                {"White Bed", "WHITE_BED", "", "2", "Colored Blocks", ""},
                {"White Bundle", "WHITE_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"White Candle", "WHITE_CANDLE", "", "3", "Colored Blocks", ""},
                {"White Carpet", "WHITE_CARPET", "", "2", "Colored Blocks", ""},
                {"White Concrete", "WHITE_CONCRETE", "", "2", "Colored Blocks", ""},
                {"White Concrete Powder", "WHITE_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"White Dye", "WHITE_DYE", "", "1", "Ingidients", ""},
                {"White Glazed Terracotta", "WHITE_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"White Shulker Box", "WHITE_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"White Stained Glass", "WHITE_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"White Stained Glass Pane", "WHITE_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"White Terracotta", "WHITE_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"White Tulip", "WHITE_TULIP", "", "2", "Natural Blocks", ""},
                {"White Wool", "WHITE_WOOL", "", "2", "Colored Blocks", ""},
                {"Wild Armour Trim", "WILD_ARMOR_TRIM_SMITHING_TEMPLATE", "", "4", "Ingidients", ""},
                {"Wildflowers", "WILDFLOWERS", "", "2", "Natural Blocks", ""},
                {"Wind Charge", "WIND_CHARGE", "", "4", "Combat", ""},
                {"Wither Rose", "WITHER_ROSE", "", "6", "Natural Blocks", ""},
                {"Wither Skeleton Skull", "WITHER_SKELETON_SKULL", "", "5", "Functional Blocks", ""},
                {"Wolf Armor", "WOLF_ARMOR", "", "3", "Combat", ""},
                {"Wooden Axe", "WOODEN_AXE", "", "1", "Combat", ""},
                {"Wooden Hoe", "WOODEN_HOE", "", "1", "Tools & Utilities", ""},
                {"Wooden Pickaxe", "WOODEN_PICKAXE", "", "1", "Tools & Utilities", ""},
                {"Wooden Shovel", "WOODEN_SHOVEL", "", "1", "Tools & Utilities", ""},
                {"Wooden Sword", "WOODEN_SWORD", "", "1", "Combat", ""},
                {"Yellow Banner", "YELLOW_BANNER", "", "2", "Colored Blocks", ""},
                {"Yellow Bed", "YELLOW_BED", "", "2", "Colored Blocks", ""},
                {"Yellow Bundle", "YELLOW_BUNDLE", "", "2", "Tools & Utilities", ""},
                {"Yellow Candle", "YELLOW_CANDLE", "", "3", "Colored Blocks", ""},
                {"Yellow Carpet", "YELLOW_CARPET", "", "2", "Colored Blocks", ""},
                {"Yellow Concrete", "YELLOW_CONCRETE", "", "2", "Colored Blocks", ""},
                {"Yellow Concrete Powder", "YELLOW_CONCRETE_POWDER", "", "2", "Colored Blocks", ""},
                {"Yellow Dye", "YELLOW_DYE", "", "1", "Ingidients", ""},
                {"Yellow Glazed Terracotta", "YELLOW_GLAZED_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Yellow Shulker Box", "YELLOW_SHULKER_BOX", "", "6", "Colored Blocks", ""},
                {"Yellow Stained Glass", "YELLOW_STAINED_GLASS", "", "2", "Colored Blocks", ""},
                {"Yellow Stained Glass Pane", "YELLOW_STAINED_GLASS_PANE", "", "2", "Colored Blocks", ""},
                {"Yellow Terracotta", "YELLOW_TERRACOTTA", "", "2", "Colored Blocks", ""},
                {"Yellow Wool", "YELLOW_WOOL", "", "2", "Colored Blocks", ""},
                {"Zombie Head", "ZOMBIE_HEAD", "", "6", "Functional Blocks", ""}
        };

    }
    public List<String> fillItems(){
        List<String> items = new ArrayList<>();
        items.add("Birch Button");
        items.add("Birch Door");
        items.add("Birch Fence");
        items.add("Birch Fence Gate");
        items.add("Birch Log");
        items.add("Birch Planks");
        items.add("Birch Pressure Plate");
        items.add("Birch Slab");
        items.add("Birch Stairs");
        items.add("Birch Trapdoor");
        items.add("Birch Wood");
        items.add("Chiseled Sandstone");
        items.add("Chiseled Stone Bricks");
        items.add("Block of Coal");
        items.add("Cobblestone");
        items.add("Cobblestone Slab");
        items.add("Cobblestone Stairs");
        items.add("Cobblestone Wall");
        items.add("Block of Copper");
        items.add("Copper Door");
        items.add("Copper Grate");
        items.add("Copper Trapdoor");
        items.add("Cracked Stone Bricks");
        items.add("Cut Copper");
        items.add("Cut Copper Slab");
        items.add("Cut Copper Stairs");
        items.add("Cut Sandstone");
        items.add("Cut Sandstone Slab");
        items.add("Oak Button");
        items.add("Oak Door");
        items.add("Oak Fence");
        items.add("Oak Fence Gate");
        items.add("Oak Log");
        items.add("Oak Planks");
        items.add("Oak Pressure Plate");
        items.add("Oak Slab");
        items.add("Oak Stairs");
        items.add("Oak Trapdoor");
        items.add("Oak Wood");
        items.add("Sandstone");
        items.add("Sandstone Slab");
        items.add("Sandstone Stairs");
        items.add("Sandstone Wall");
        items.add("Smooth Sandstone");
        items.add("Smooth Sandstone Slab");
        items.add("Smooth Sandstone Stairs");
        items.add("Smooth Stone");
        items.add("Smooth Stone Slab");
        items.add("Stone");
        items.add("Stone Brick Slab");
        items.add("Stone Brick Stairs");
        items.add("Stone Brick Wall");
        items.add("Stone Bricks");
        items.add("Stone Button");
        items.add("Stone Pressure Plate");
        items.add("Stone Slab");
        items.add("Stone Stairs");
        items.add("Stripped Birch Log");
        items.add("Stripped Birch Wood");
        items.add("Stripped Oak Log");
        items.add("Stripped Oak Wood");
        items.add("Allium");
        items.add("Azure Bluet");
        items.add("Birch Sapling");
        items.add("Clay");
        items.add("Coarse Dirt");
        items.add("Cornflower");
        items.add("Dandelion");
        items.add("Dirt");
        items.add("Gravel");
        items.add("Leaf Litter");
        items.add("Lilac");
        items.add("Oak Sapling");
        items.add("Oxeye Daisy");
        items.add("Peony");
        items.add("Poppy");
        items.add("Rose Bush");
        items.add("Sand");
        items.add("Sugar Cane");
        items.add("Wheat Seeds");
        items.add("Barrel");
        items.add("Birch Hanging Sign");
        items.add("Birch Sign");
        items.add("Campfire");
        items.add("Cartography Table");
        items.add("Chest");
        items.add("Chiseled Bookshelf");
        items.add("Composter");
        items.add("Crafting Table");
        items.add("Fletching Table");
        items.add("Flower Pot");
        items.add("Furnace");
        items.add("Grindstone");
        items.add("Item Frame");
        items.add("Ladder");
        items.add("Lectern");
        items.add("Lightning Rod");
        items.add("Oak Hanging Sign");
        items.add("Oak Sign");
        items.add("Painting");
        items.add("Lever");
        items.add("Birch Boat");
        items.add("Birch Boat with Chest");
        items.add("Oak Boat");
        items.add("Oak Boat with Chest");
        items.add("Stone Hoe");
        items.add("Stone Pickaxe");
        items.add("Stone Shovel");
        items.add("Wooden Hoe");
        items.add("Wooden Pickaxe");
        items.add("Wooden Shovel");
        items.add("Leather Boots");
        items.add("Leather Tunic");
        items.add("Leather Cap");
        items.add("Leather Horse Armor");
        items.add("Leather Pants");
        items.add("Stone Axe");
        items.add("Stone Sword");
        items.add("Wooden Axe");
        items.add("Wooden Sword");
        items.add("Apple");
        items.add("Raw Beef");
        items.add("Raw Chicken");
        items.add("Raw Cod");
        items.add("Raw Mutton");
        items.add("Raw Porkchop");
        items.add("Raw Salmon");
        items.add("Steak");
        items.add("Cooked Porkchop");
        items.add("Cooked Mutton");
        items.add("Roast Chicken");
        items.add("Cooked Cod");
        items.add("Cooked Salmon");
        items.add("Black Dye");
        items.add("Blue Dye");
        items.add("Bowl");
        items.add("Brick");
        items.add("Charcoal");
        items.add("Clay Ball");
        items.add("Coal");
        items.add("Copper Ingot");
        items.add("Feather");
        items.add("Flint");
        items.add("Gray Dye");
        items.add("Ink Sac");
        items.add("Leather");
        items.add("Light Blue Dye");
        items.add("Light Gray Dye");
        items.add("Magenta Dye");
        items.add("Orange Dye");
        items.add("Paper");
        items.add("Pink Dye");
        items.add("Purple Dye");
        items.add("Raw Copper");
        items.add("Red Dye");
        items.add("Stick");
        items.add("Sugar");
        items.add("White Dye");
        items.add("Yellow Dye");
        items.add("Andesite");
        items.add("Andesite Slab");
        items.add("Andesite Stairs");
        items.add("Andesite Wall");
        items.add("Brick Slab");
        items.add("Brick Stairs");
        items.add("Brick Wall");
        items.add("Bricks");
        items.add("Chain");
        items.add("Chiseled Copper");
        items.add("Chiseled Deepslate");
        items.add("Chiseled Nether Bricks");
        items.add("Chiseled Quartz Block");
        items.add("Chiseled Tuff");
        items.add("Chiseled Tuff Bricks");
        items.add("Cobbled Deepslate");
        items.add("Cobbled Deepslate Slab");
        items.add("Cobbled Deepslate Stairs");
        items.add("Cobbled Deepslate Wall");
        items.add("Cracked Deepslate Bricks");
        items.add("Cracked Deepslate Tiles");
        items.add("Cracked Nether Bricks");
        items.add("Deepslate");
        items.add("Deepslate Brick Slab");
        items.add("Deepslate Brick Stairs");
        items.add("Deepslate Brick Wall");
        items.add("Deepslate Bricks");
        items.add("Deepslate Tile Slab");
        items.add("Deepslate Tile Stairs");
        items.add("Deepslate Tile Wall");
        items.add("Deepslate Tiles");
        items.add("Diorite");
        items.add("Diorite Slab");
        items.add("Diorite Stairs");
        items.add("Diorite Wall");
        items.add("Exposed Chiseled Copper");
        items.add("Exposed Copper");
        items.add("Exposed Copper Bulb");
        items.add("Exposed Copper Door");
        items.add("Exposed Copper Grate");
        items.add("Exposed Copper Trapdoor");
        items.add("Exposed Cut Copper");
        items.add("Exposed Cut Copper Slab");
        items.add("Exposed Cut Copper Stairs");
        items.add("Block of Gold");
        items.add("Granite");
        items.add("Granite Slab");
        items.add("Granite Stairs");
        items.add("Granite Wall");
        items.add("Heavy Weighted Pressure Plate");
        items.add("Iron Bars");
        items.add("Block of Iron");
        items.add("Iron Door");
        items.add("Iron Trapdoor");
        items.add("Light Weighted Pressure Plate");
        items.add("Mud Brick Slab");
        items.add("Mud Brick Stairs");
        items.add("Mud Brick Wall");
        items.add("Mud Bricks");
        items.add("Nether Brick Fence");
        items.add("Nether Brick Slab");
        items.add("Nether Brick Stairs");
        items.add("Nether Brick Wall");
        items.add("Nether Bricks");
        items.add("Netherrack");
        items.add("Packed Mud");
        items.add("Polished Andesite");
        items.add("Polished Andesite Slab");
        items.add("Polished Andesite Stairs");
        items.add("Polished Deepslate");
        items.add("Polished Deepslate Slab");
        items.add("Polished Deepslate Stairs");
        items.add("Polished Deepslate Wall");
        items.add("Polished Diorite");
        items.add("Polished Diorite Slab");
        items.add("Polished Diorite Stairs");
        items.add("Polished Granite");
        items.add("Polished Granite Slab");
        items.add("Polished Granite Stairs");
        items.add("Polished Tuff");
        items.add("Polished Tuff Slab");
        items.add("Polished Tuff Stairs");
        items.add("Polished Tuff Wall");
        items.add("Block of Quartz");
        items.add("Quartz Bricks");
        items.add("Quartz Pillar");
        items.add("Quartz Slab");
        items.add("Quartz Stairs");
        items.add("Block of Redstone");
        items.add("Smooth Quartz Block");
        items.add("Smooth Quartz Slab");
        items.add("Smooth Quartz Stairs");
        items.add("Tuff");
        items.add("Tuff Brick Slab");
        items.add("Tuff Brick Stairs");
        items.add("Tuff Brick Wall");
        items.add("Tuff Bricks");
        items.add("Tuff Slab");
        items.add("Tuff Stairs");
        items.add("Tuff Wall");
        items.add("Black Banner");
        items.add("Black Bed");
        items.add("Black Carpet");
        items.add("Black Concrete");
        items.add("Black Concrete Powder");
        items.add("Black Glazed Terracotta");
        items.add("Black Stained Glass");
        items.add("Black Stained Glass Pane");
        items.add("Black Terracotta");
        items.add("Black Wool");
        items.add("Blue Banner");
        items.add("Blue Bed");
        items.add("Blue Carpet");
        items.add("Blue Concrete");
        items.add("Blue Concrete Powder");
        items.add("Blue Glazed Terracotta");
        items.add("Blue Stained Glass");
        items.add("Blue Stained Glass Pane");
        items.add("Blue Terracotta");
        items.add("Blue Wool");
        items.add("Glass");
        items.add("Glass Pane");
        items.add("Gray Banner");
        items.add("Gray Bed");
        items.add("Gray Carpet");
        items.add("Gray Concrete");
        items.add("Gray Concrete Powder");
        items.add("Gray Glazed Terracotta");
        items.add("Gray Stained Glass");
        items.add("Gray Stained Glass Pane");
        items.add("Gray Terracotta");
        items.add("Gray Wool");
        items.add("Light Blue Banner");
        items.add("Light Blue Bed");
        items.add("Light Blue Carpet");
        items.add("Light Blue Concrete");
        items.add("Light Blue Concrete Powder");
        items.add("Light Blue Glazed Terracotta");
        items.add("Light Blue Stained Glass");
        items.add("Light Blue Stained Glass Pane");
        items.add("Light Blue Terracotta");
        items.add("Light Blue Wool");
        items.add("Light Gray Banner");
        items.add("Light Gray Bed");
        items.add("Light Gray Carpet");
        items.add("Light Gray Concrete");
        items.add("Light Gray Concrete Powder");
        items.add("Light Gray Glazed Terracotta");
        items.add("Light Gray Stained Glass");
        items.add("Light Gray Stained Glass Pane");
        items.add("Light Gray Terracotta");
        items.add("Light Gray Wool");
        items.add("Magenta Banner");
        items.add("Magenta Bed");
        items.add("Magenta Carpet");
        items.add("Magenta Concrete");
        items.add("Magenta Concrete Powder");
        items.add("Magenta Glazed Terracotta");
        items.add("Magenta Stained Glass");
        items.add("Magenta Stained Glass Pane");
        items.add("Magenta Terracotta");
        items.add("Magenta Wool");
        items.add("Orange Banner");
        items.add("Orange Bed");
        items.add("Orange Carpet");
        items.add("Orange Concrete");
        items.add("Orange Concrete Powder");
        items.add("Orange Glazed Terracotta");
        items.add("Orange Stained Glass");
        items.add("Orange Stained Glass Pane");
        items.add("Orange Terracotta");
        items.add("Orange Wool");
        items.add("Pink Banner");
        items.add("Pink Bed");
        items.add("Pink Carpet");
        items.add("Pink Concrete");
        items.add("Pink Concrete Powder");
        items.add("Pink Glazed Terracotta");
        items.add("Pink Stained Glass");
        items.add("Pink Stained Glass Pane");
        items.add("Pink Terracotta");
        items.add("Pink Wool");
        items.add("Purple Banner");
        items.add("Purple Bed");
        items.add("Purple Carpet");
        items.add("Purple Concrete");
        items.add("Purple Concrete Powder");
        items.add("Purple Glazed Terracotta");
        items.add("Purple Stained Glass");
        items.add("Purple Stained Glass Pane");
        items.add("Purple Terracotta");
        items.add("Purple Wool");
        items.add("Red Banner");
        items.add("Red Bed");
        items.add("Red Carpet");
        items.add("Red Concrete");
        items.add("Red Concrete Powder");
        items.add("Red Glazed Terracotta");
        items.add("Red Stained Glass");
        items.add("Red Stained Glass Pane");
        items.add("Red Terracotta");
        items.add("Red Wool");
        items.add("Terracotta");
        items.add("White Banner");
        items.add("White Bed");
        items.add("White Carpet");
        items.add("White Concrete");
        items.add("White Concrete Powder");
        items.add("White Glazed Terracotta");
        items.add("White Stained Glass");
        items.add("White Stained Glass Pane");
        items.add("White Terracotta");
        items.add("White Wool");
        items.add("Yellow Banner");
        items.add("Yellow Bed");
        items.add("Yellow Carpet");
        items.add("Yellow Concrete");
        items.add("Yellow Concrete Powder");
        items.add("Yellow Glazed Terracotta");
        items.add("Yellow Stained Glass");
        items.add("Yellow Stained Glass Pane");
        items.add("Yellow Terracotta");
        items.add("Yellow Wool");
        items.add("Birch Leaves");
        items.add("Bone Block");
        items.add("Brown Mushroom");
        items.add("Bush");
        items.add("Carved Pumpkin");
        items.add("Dried Kelp Block");
        items.add("Fern");
        items.add("Firefly Bush");
        items.add("Glow Lichen");
        items.add("Hay Bale");
        items.add("Jack o'Lantern");
        items.add("Kelp");
        items.add("Lily of the Valley");
        items.add("Magma Block");
        items.add("Mud");
        items.add("Muddy Mangrove Roots");
        items.add("Oak Leaves");
        items.add("Orange Tulip");
        items.add("Pink Tulip");
        items.add("Pumpkin");
        items.add("Pumpkin Seeds");
        items.add("Block of Raw Copper");
        items.add("Block of Raw Iron");
        items.add("Red Mushroom");
        items.add("Red Tulip");
        items.add("Seagrass");
        items.add("Grass");
        items.add("Spruce Leaves");
        items.add("Spruce Sapling");
        items.add("Sweet Berries");
        items.add("Vines");
        items.add("White Tulip");
        items.add("Wildflowers");
        items.add("Armor Stand");
        items.add("Blast Furnace");
        items.add("Bookshelf");
        items.add("Cauldron");
        items.add("Lantern");
        items.add("Lodestone");
        items.add("Loom");
        items.add("Smithing Table");
        items.add("Smoker");
        items.add("Spruce Hanging Sign");
        items.add("Spruce Sign");
        items.add("Stonecutter");
        items.add("Torch");
        items.add("Activator Rail");
        items.add("Minecart with Chest");
        items.add("Redstone Comparator");
        items.add("Crafter");
        items.add("Daylight Detector");
        items.add("Detector Rail");
        items.add("Dispenser");
        items.add("Dropper");
        items.add("Minecart with Furnace");
        items.add("Hopper");
        items.add("Minecart with Hopper");
        items.add("Minecart");
        items.add("Observer");
        items.add("Piston");
        items.add("Powered Rail");
        items.add("Rail");
        items.add("Redstone Repeater");
        items.add("Target");
        items.add("Trapped Chest");
        items.add("Tripwire Hook");
        items.add("Black Bundle");
        items.add("Blue Bundle");
        items.add("Bone Meal");
        items.add("Brush");
        items.add("Bucket");
        items.add("Bundle");
        items.add("Clock");
        items.add("Bucket of Cod");
        items.add("Compass");
        items.add("Map");
        items.add("Fishing Rod");
        items.add("Flint and Steel");
        items.add("Golden Hoe");
        items.add("Golden Pickaxe");
        items.add("Golden Shovel");
        items.add("Gray Bundle");
        items.add("Iron Hoe");
        items.add("Iron Pickaxe");
        items.add("Iron Shovel");
        items.add("Lava Bucket");
        items.add("Lead");
        items.add("Light Blue Bundle");
        items.add("Light Gray Bundle");
        items.add("Magenta Bundle");
        items.add("Empty Map");
        items.add("Milk Bucket");
        items.add("Orange Bundle");
        items.add("Pink Bundle");
        items.add("Purple Bundle");
        items.add("Red Bundle");
        items.add("Bucket of Salmon");
        items.add("Shears");
        items.add("Spruce Boat");
        items.add("Spruce Boat with Chest");
        items.add("Water Bucket");
        items.add("White Bundle");
        items.add("Book and Quill");
        items.add("Yellow Bundle");
        items.add("Arrow");
        items.add("Bow");
        items.add("Egg");
        items.add("Golden Axe");
        items.add("Golden Boots");
        items.add("Golden Chestplate");
        items.add("Golden Helmet");
        items.add("Golden Horse Armor");
        items.add("Golden Leggings");
        items.add("Golden Sword");
        items.add("Iron Axe");
        items.add("Iron Boots");
        items.add("Iron Chestplate");
        items.add("Iron Helmet");
        items.add("Iron Horse Armor");
        items.add("Iron Leggings");
        items.add("Iron Sword");
        items.add("Shield");
        items.add("Dried Kelp");
        items.add("Bread");
        items.add("Cake");
        items.add("Pumpkin Pie");
        items.add("Rotten Flesh");
        items.add("Mushroom Stew");
        items.add("Suspicious Stew");
        items.add("Milk Bucket");
        items.add("Bone");
        items.add("Book");
        items.add("Fermented Spider Eye");
        items.add("Firework Star");
        items.add("Glass Bottle");
        items.add("Gold Ingot");
        items.add("Golden Nugget");
        items.add("Gunpowder");
        items.add("Iron Ingot");
        items.add("Iron Nugget");
        items.add("Lapiz Lazuli");
        items.add("Nether Brick");
        items.add("Raw Gold");
        items.add("Raw Iron");
        items.add("Spider Eye");
        items.add("String");
        items.add("Wheat");
        items.add("Acacia Button");
        items.add("Acacia Door");
        items.add("Acacia Fence");
        items.add("Acacia Fence Gate");
        items.add("Acacia Log");
        items.add("Acacia Planks");
        items.add("Acacia Pressure Plate");
        items.add("Acacia Slab");
        items.add("Acacia Stairs");
        items.add("Acacia Trapdoor");
        items.add("Acacia Wood");
        items.add("Basalt");
        items.add("Blackstone");
        items.add("Blackstone Slab");
        items.add("Blackstone Stairs");
        items.add("Blackstone Wall");
        items.add("Chiseled Polished Blackstone");
        items.add("Dark Oak Button");
        items.add("Dark Oak Door");
        items.add("Dark Oak Fence");
        items.add("Dark Oak Fence Gate");
        items.add("Dark Oak Log");
        items.add("Dark Oak Planks");
        items.add("Dark Oak Pressure Plate");
        items.add("Dark Oak Slab");
        items.add("Dark Oak Stairs");
        items.add("Dark Oak Trapdoor");
        items.add("Dark Oak Wood");
        items.add("Block of Diamond");
        items.add("Block of Emerald");
        items.add("Block of Lapis Lazuli");
        items.add("Mossy Cobblestone");
        items.add("Mossy Cobblestone Slab");
        items.add("Mossy Cobblestone Stairs");
        items.add("Mossy Cobblestone Wall");
        items.add("Mossy Stone Brick Slab");
        items.add("Mossy Stone Brick Stairs");
        items.add("Mossy Stone Brick Wall");
        items.add("Mossy Stone Bricks");
        items.add("Polished Basalt");
        items.add("Polished Blackstone");
        items.add("Polished Blackstone Brick Slab");
        items.add("Polished Blackstone Brick Stairs");
        items.add("Polished Blackstone Brick Wall");
        items.add("Polished Blackstone Bricks");
        items.add("Polished Blackstone Button");
        items.add("Polished Blackstone Pressure Plate");
        items.add("Polished Blackstone Slab");
        items.add("Polished Blackstone Stairs");
        items.add("Polished Blackstone Wall");
        items.add("Smooth Basalt");
        items.add("Spruce Button");
        items.add("Spruce Door");
        items.add("Spruce Fence");
        items.add("Spruce Fence Gate");
        items.add("Spruce Log");
        items.add("Spruce Planks");
        items.add("Spruce Pressure Plate");
        items.add("Spruce Slab");
        items.add("Spruce Stairs");
        items.add("Spruce Trapdoor");
        items.add("Spruce Wood");
        items.add("Stripped Acacia Log");
        items.add("Stripped Acacia Wood");
        items.add("Stripped Dark Oak Log");
        items.add("Stripped Dark Oak Wood");
        items.add("Stripped Spruce Log");
        items.add("Stripped Spruce Wood");
        items.add("Waxed Chiseled Copper");
        items.add("Waxed Block of Copper");
        items.add("Waxed Copper Bulb");
        items.add("Waxed Copper Door");
        items.add("Waxed Copper Grate");
        items.add("Waxed Copper Trapdoor");
        items.add("Waxed Cut Copper");
        items.add("Waxed Cut Copper Slab");
        items.add("Waxed Cut Copper Stairs");
        items.add("Waxed Exposed Chiseled Copper");
        items.add("Waxed Exposed Copper");
        items.add("Waxed Exposed Copper Bulb");
        items.add("Waxed Exposed Copper Door");
        items.add("Waxed Exposed Copper Grate");
        items.add("Waxed Exposed Copper Trapdoor");
        items.add("Waxed Exposed Cut Copper");
        items.add("Waxed Exposed Cut Copper Slab");
        items.add("Waxed Exposed Cut Copper Stairs");
        items.add("Black Candle");
        items.add("Blue Candle");
        items.add("Candle");
        items.add("Gray Candle");
        items.add("Light Blue Candle");
        items.add("Light Gray Candle");
        items.add("Magenta Candle");
        items.add("Orange Candle");
        items.add("Pink Candle");
        items.add("Purple Candle");
        items.add("Red Candle");
        items.add("White Candle");
        items.add("Yellow Candle");
        items.add("Acacia Leaves");
        items.add("Acacia Sapling");
        items.add("Azalea");
        items.add("Azalea Leaves");
        items.add("Beetroot Seeds");
        items.add("Big Dripleaf");
        items.add("Blue Orchid");
        items.add("Cobweb");
        items.add("Dripstone Block");
        items.add("Flowering Azalea");
        items.add("Flowering Azalea Leaves");
        items.add("Glow Berries");
        items.add("Glowstone");
        items.add("Hanging Roots");
        items.add("Lily Pad");
        items.add("Moss Block");
        items.add("Moss Carpet");
        items.add("Obsidian");
        items.add("Pointed Dripstone");
        items.add("Block of Raw Gold");
        items.add("Rooted Dirt");
        items.add("Shroomlight");
        items.add("Slime Block");
        items.add("Snow");
        items.add("Snow Block");
        items.add("Soul Sand");
        items.add("Soul Soil");
        items.add("Spore Blossom");
        items.add("Sunflower");
        items.add("Acacia Hanging Sign");
        items.add("Acacia Sign");
        items.add("Anvil");
        items.add("Beehive");
        items.add("Bell");
        items.add("Brewing Stand");
        items.add("Chipped Anvil");
        items.add("Damaged Anvil");
        items.add("Dark Oak Hanging Sign");
        items.add("Dark Oak Sign");
        items.add("Decorated Pot");
        items.add("Enchanting Table");
        items.add("Glow Item Frame");
        items.add("Jukebox");
        items.add("Note Block");
        items.add("Redstone Lamp");
        items.add("Redstone Torch");
        items.add("Soul Campfire");
        items.add("Soul Lantern");
        items.add("Soul Torch");
        items.add("Sticky Piston");
        items.add("Minecart with TNT");
        items.add("Acacia Boat");
        items.add("Acacia Boat with Chest");
        items.add("Carrot on a Stick");
        items.add("Dark Oak Boat");
        items.add("Dark Oak Boat with Chest");
        items.add("Diamond Hoe");
        items.add("Diamond Pickaxe");
        items.add("Diamond Shovel");
        items.add("Eye of Ender");
        items.add("Ender Pearl");
        items.add("Fire Charge");
        items.add("Powder Snow Bucket");
        items.add("Saddle");
        items.add("Bucket of Tropical Fish");
        items.add("Warped Fungus on a Stick");
        items.add("Brown Egg");
        items.add("Diamond Axe");
        items.add("Diamond Boots");
        items.add("Diamond Chestplate");
        items.add("Diamond Helmet");
        items.add("Diamond Horse Armor");
        items.add("Diamond Leggings");
        items.add("Diamond Sword");
        items.add("Firework Rocket");
        items.add("Snowball");
        items.add("Spectral Arrow");
        items.add("TNT");
        items.add("Wolf Armor");
        items.add("Golden Apple");
        items.add("Melon Slice");
        items.add("Carrot");
        items.add("Golden Carrot");
        items.add("Baked Potato");
        items.add("Poisonous Potato");
        items.add("Potato");
        items.add("Beetroot");
        items.add("Raw Rabbit");
        items.add("Cooked Rabbit");
        items.add("Beetroot Soup");
        items.add("Rabbit Stew");
        items.add("Honey Bottle");
        items.add("Armadillo Scute");
        items.add("Blaze Powder");
        items.add("Blaze Rod");
        items.add("Coast Armour Trim");
        items.add("Diamond");
        items.add("Emerald");
        items.add("Enchanted Book");
        items.add("Eye Armour Trim");
        items.add("Ghast Tear");
        items.add("Glistering Melon Slice");
        items.add("Glow Ink Sac");
        items.add("Glowstone Dust");
        items.add("Honeycomb");
        items.add("Magma Cream");
        items.add("Nether Quartz");
        items.add("Rabbit Hide");
        items.add("Raiser Armour Trim");
        items.add("Redstone Dust");
        items.add("Rib Armour Trim");
        items.add("Sentry Armour Trim");
        items.add("Shaper Armour Trim");
        items.add("Slimeball");
        items.add("Snowball");
        items.add("Music Disc - C418 - 11");
        items.add("Music Disc - C418 - 13");
        items.add("Music Disc - C418 - blocks");
        items.add("Music Disc - C418 - cat");
        items.add("Music Disc - C418 - chirp");
        items.add("Music Disc - C418 - far");
        items.add("Music Disc - C418 - mall");
        items.add("Music Disc - C418 - mellohi");
        items.add("Music Disc - C418 - stal");
        items.add("Music Disc - C418 - strad");
        items.add("Music Disc - C418 - wait");
        items.add("Music Disc - C418 - ward");
        items.add("Disc Fragment - Music Disc - 5");
        items.add("Music Disc - Samuel Åberg - 5");
        items.add("Music Disc -  - creator music box");
        items.add("Music Disc -  - relic");
        items.add("Music Disc -  - precipice");
        items.add("Goat Horn");
        items.add("Block of Amethyst");
        items.add("Block of Bamboo");
        items.add("Bamboo Button");
        items.add("Bamboo Door");
        items.add("Bamboo Fence");
        items.add("Bamboo Fence Gate");
        items.add("Bamboo Mosaic");
        items.add("Bamboo Mosaic Slab");
        items.add("Bamboo Mosaic Stairs");
        items.add("Bamboo Planks");
        items.add("Bamboo Pressure Plate");
        items.add("Bamboo Slab");
        items.add("Bamboo Stairs");
        items.add("Bamboo Trapdoor");
        items.add("Cherry Button");
        items.add("Cherry Door");
        items.add("Cherry Fence");
        items.add("Cherry Fence Gate");
        items.add("Cherry Log");
        items.add("Cherry Planks");
        items.add("Cherry Pressure Plate");
        items.add("Cherry Slab");
        items.add("Cherry Stairs");
        items.add("Cherry Trapdoor");
        items.add("Cherry Wood");
        items.add("Chiseled Red Sandstone");
        items.add("Chiseled Resin Bricks");
        items.add("Copper Bulb");
        items.add("Cracked Polished Blackstone Bricks");
        items.add("Crimson Button");
        items.add("Crimson Door");
        items.add("Crimson Fence");
        items.add("Crimson Fence Gate");
        items.add("Crimson Hyphae");
        items.add("Crimson Planks");
        items.add("Crimson Pressure Plate");
        items.add("Crimson Slab");
        items.add("Crimson Stairs");
        items.add("Crimson Stem");
        items.add("Crimson Trapdoor");
        items.add("Cut Red Sandstone");
        items.add("Cut Red Sandstone Slab");
        items.add("Dark Prismarine");
        items.add("Dark Prismarine Slab");
        items.add("Dark Prismarine Stairs");
        items.add("Gilded Blackstone");
        items.add("Jungle Button");
        items.add("Jungle Door");
        items.add("Jungle Fence");
        items.add("Jungle Fence Gate");
        items.add("Jungle Log");
        items.add("Jungle Planks");
        items.add("Jungle Pressure Plate");
        items.add("Jungle Slab");
        items.add("Jungle Stairs");
        items.add("Jungle Trapdoor");
        items.add("Jungle Wood");
        items.add("Mangrove Button");
        items.add("Mangrove Door");
        items.add("Mangrove Fence");
        items.add("Mangrove Fence Gate");
        items.add("Mangrove Log");
        items.add("Mangrove Planks");
        items.add("Mangrove Pressure Plate");
        items.add("Mangrove Slab");
        items.add("Mangrove Stairs");
        items.add("Mangrove Trapdoor");
        items.add("Mangrove Wood");
        items.add("Oxidized Chiseled Copper");
        items.add("Oxidized Copper");
        items.add("Oxidized Copper Bulb");
        items.add("Oxidized Copper Door");
        items.add("Oxidized Copper Grate");
        items.add("Oxidized Copper Trapdoor");
        items.add("Oxidized Cut Copper");
        items.add("Oxidized Cut Copper Slab");
        items.add("Oxidized Cut Copper Stairs");
        items.add("Pale Oak Button");
        items.add("Pale Oak Door");
        items.add("Pale Oak Fence");
        items.add("Pale Oak Fence Gate");
        items.add("Pale Oak Log");
        items.add("Pale Oak Planks");
        items.add("Pale Oak Pressure Plate");
        items.add("Pale Oak Slab");
        items.add("Pale Oak Stairs");
        items.add("Pale Oak Trapdoor");
        items.add("Pale Oak Wood");
        items.add("Prismarine");
        items.add("Prismarine Brick Slab");
        items.add("Prismarine Brick Stairs");
        items.add("Prismarine Bricks");
        items.add("Prismarine Slab");
        items.add("Prismarine Stairs");
        items.add("Prismarine Wall");
        items.add("Red Nether Brick Slab");
        items.add("Red Nether Brick Stairs");
        items.add("Red Nether Brick Wall");
        items.add("Red Nether Bricks");
        items.add("Red Sandstone");
        items.add("Red Sandstone Slab");
        items.add("Red Sandstone Stairs");
        items.add("Red Sandstone Wall");
        items.add("Resin Brick Slab");
        items.add("Resin Brick Stairs");
        items.add("Resin Brick Wall");
        items.add("Resin Bricks");
        items.add("Sea Lantern");
        items.add("Smooth Red Sandstone");
        items.add("Smooth Red Sandstone Slab");
        items.add("Smooth Red Sandstone Stairs");
        items.add("Block of Stripped Bamboo");
        items.add("Stripped Cherry Log");
        items.add("Stripped Cherry Wood");
        items.add("Stripped Crimson Hyphae");
        items.add("Stripped Crimson Stem");
        items.add("Stripped Jungle Log");
        items.add("Stripped Jungle Wood");
        items.add("Stripped Mangrove Log");
        items.add("Stripped Mangrove Wood");
        items.add("Stripped Pale Oak Log");
        items.add("Stripped Pale Oak Wood");
        items.add("Stripped Warped Hyphae");
        items.add("Stripped Warped Stem");
        items.add("Warped Button");
        items.add("Warped Door");
        items.add("Warped Fence");
        items.add("Warped Fence Gate");
        items.add("Warped Hyphae");
        items.add("Warped Planks");
        items.add("Warped Pressure Plate");
        items.add("Warped Slab");
        items.add("Warped Stairs");
        items.add("Warped Stem");
        items.add("Warped Trapdoor");
        items.add("Waxed Oxidized Chiseled Copper");
        items.add("Waxed Oxidized Copper");
        items.add("Waxed Oxidized Copper Bulb");
        items.add("Waxed Oxidized Copper Door");
        items.add("Waxed Oxidized Copper Grate");
        items.add("Waxed Oxidized Copper Trapdoor");
        items.add("Waxed Oxidized Cut Copper");
        items.add("Waxed Oxidized Cut Copper Slab");
        items.add("Waxed Oxidized Cut Copper Stairs");
        items.add("Waxed Weathered Chiseled Copper");
        items.add("Waxed Weathered Copper");
        items.add("Waxed Weathered Copper Bulb");
        items.add("Waxed Weathered Copper Door");
        items.add("Waxed Weathered Copper Grate");
        items.add("Waxed Weathered Copper Trapdoor");
        items.add("Waxed Weathered Cut Copper");
        items.add("Waxed Weathered Cut Copper Slab");
        items.add("Waxed Weathered Cut Copper Stairs");
        items.add("Weathered Chiseled Copper");
        items.add("Weathered Copper");
        items.add("Weathered Copper Bulb");
        items.add("Weathered Copper Door");
        items.add("Weathered Copper Grate");
        items.add("Weathered Copper Trapdoor");
        items.add("Weathered Cut Copper");
        items.add("Weathered Cut Copper Slab");
        items.add("Weathered Cut Copper Stairs");
        items.add("Brown Banner");
        items.add("Brown Bed");
        items.add("Brown Candle");
        items.add("Brown Carpet");
        items.add("Brown Concrete");
        items.add("Brown Concrete Powder");
        items.add("Brown Glazed Terracotta");
        items.add("Brown Stained Glass");
        items.add("Brown Stained Glass Pane");
        items.add("Brown Terracotta");
        items.add("Brown Wool");
        items.add("Cyan Banner");
        items.add("Cyan Bed");
        items.add("Cyan Candle");
        items.add("Cyan Carpet");
        items.add("Cyan Concrete");
        items.add("Cyan Concrete Powder");
        items.add("Cyan Glazed Terracotta");
        items.add("Cyan Stained Glass");
        items.add("Cyan Stained Glass Pane");
        items.add("Cyan Terracotta");
        items.add("Cyan Wool");
        items.add("Green Banner");
        items.add("Green Bed");
        items.add("Green Candle");
        items.add("Green Carpet");
        items.add("Green Concrete");
        items.add("Green Concrete Powder");
        items.add("Green Glazed Terracotta");
        items.add("Green Stained Glass");
        items.add("Green Stained Glass Pane");
        items.add("Green Terracotta");
        items.add("Green Wool");
        items.add("Lime Banner");
        items.add("Lime Bed");
        items.add("Lime Candle");
        items.add("Lime Carpet");
        items.add("Lime Concrete");
        items.add("Lime Concrete Powder");
        items.add("Lime Glazed Terracotta");
        items.add("Lime Stained Glass");
        items.add("Lime Stained Glass Pane");
        items.add("Lime Terracotta");
        items.add("Lime Wool");
        items.add("Tinted Glass");
        items.add("Bamboo");
        items.add("Bee Nest");
        items.add("Blue Ice");
        items.add("Brain Coral");
        items.add("Brain Coral Block");
        items.add("Brain Coral Fan");
        items.add("Brown Mushroom Block");
        items.add("Bubble Coral");
        items.add("Bubble Coral Block");
        items.add("Bubble Coral Fan");
        items.add("Cactus");
        items.add("Cactus Flower");
        items.add("Calcite");
        items.add("Cherry Leaves");
        items.add("Cherry Sapling");
        items.add("Closed Eyeblossom");
        items.add("Coal Ore");
        items.add("Cocoa Beans");
        items.add("Copper Ore");
        items.add("Crimson Fungus");
        items.add("Crimson Roots");
        items.add("Crying Obsidian");
        items.add("Dark Oak Leaves");
        items.add("Dark Oak Sapling");
        items.add("Dead Brain Coral");
        items.add("Dead Brain Coral Block");
        items.add("Dead Brain Coral Fan");
        items.add("Dead Bubble Coral");
        items.add("Dead Bubble Coral Block");
        items.add("Dead Bubble Coral Fan");
        items.add("Dead Bush");
        items.add("Dead Fire Coral");
        items.add("Dead Fire Coral Block");
        items.add("Dead Fire Coral Fan");
        items.add("Dead Horn Coral");
        items.add("Dead Horn Coral Block");
        items.add("Dead Horn Coral Fan");
        items.add("Dead Tube Coral");
        items.add("Dead Tube Coral Block");
        items.add("Dead Tube Coral Fan");
        items.add("Deepslate Copper Ore");
        items.add("Deepslate Diamond Ore");
        items.add("Deepslate Gold Ore");
        items.add("Deepslate Iron Ore");
        items.add("Deepslate Lapis Lazuli Ore");
        items.add("Deepslate Redstone Ore");
        items.add("Fire Coral");
        items.add("Fire Coral Block");
        items.add("Fire Coral Fan");
        items.add("Gold Ore");
        items.add("Grass Block");
        items.add("Honeycomb Block");
        items.add("Horn Coral");
        items.add("Horn Coral Block");
        items.add("Horn Coral Fan");
        items.add("Ice");
        items.add("Iron Ore");
        items.add("Jungle Leaves");
        items.add("Jungle Sapling");
        items.add("Lapis Lazuli Ore");
        items.add("Mangrove Leaves");
        items.add("Mangrove Propagule");
        items.add("Mangrove Roots");
        items.add("Melon");
        items.add("Melon Seeds");
        items.add("Mushroom Stem");
        items.add("Nether Sprouts");
        items.add("Nether Wart Block");
        items.add("Open Eyeblossom");
        items.add("Packed Ice");
        items.add("Pale Hanging Moss");
        items.add("Pale Moss Block");
        items.add("Pale Moss Carpet");
        items.add("Pale Oak Leaves");
        items.add("Pale Oak Sapling");
        items.add("Pink Petals");
        items.add("Podzol");
        items.add("Red Mushroom Block");
        items.add("Red Sand");
        items.add("Redstone Ore");
        items.add("Block of Resin");
        items.add("Sea Pickle");
        items.add("Short Dry Grass");
        items.add("Sponge");
        items.add("Tall Dry Grass");
        items.add("Tube Coral");
        items.add("Tube Coral Block");
        items.add("Tube Coral Fan");
        items.add("Turtle Egg");
        items.add("Twisting Vines");
        items.add("Warped Fungus");
        items.add("Warped Roots");
        items.add("Warped Wart Block");
        items.add("Weeping Vines");
        items.add("Wet Sponge");
        items.add("Bamboo Hanging Sign");
        items.add("Bamboo Sign");
        items.add("Cherry Hanging Sign");
        items.add("Cherry Sign");
        items.add("Crimson Hanging Sign");
        items.add("Crimson Sign");
        items.add("Ender Chest");
        items.add("Jungle Hanging Sign");
        items.add("Jungle Sign");
        items.add("Mangrove Hanging Sign");
        items.add("Mangrove Sign");
        items.add("Pale Oak Hanging Sign");
        items.add("Pale Oak Sign");
        items.add("Respawn Anchor");
        items.add("Scaffolding");
        items.add("Warped Hanging Sign");
        items.add("Warped Sign");
        items.add("Calibrated Sculk Sensor");
        items.add("Bucket of Axolotl");
        items.add("Bamboo Raft with Chest");
        items.add("Bamboo Raft");
        items.add("Brown Bundle");
        items.add("Cherry Boat");
        items.add("Cherry Boat with Chest");
        items.add("Cyan Bundle");
        items.add("Green Bundle");
        items.add("Jungle Boat");
        items.add("Jungle Boat with Chest");
        items.add("Lime Bundle");
        items.add("Mangrove Boat");
        items.add("Mangrove Boat with Chest");
        items.add("Name Tag");
        items.add("Pale Oak Boat");
        items.add("Pale Oak Boat with Chest");
        items.add("Spyglass");
        items.add("Bucket of Tadpole");
        items.add("Blue Egg");
        items.add("Crossbow");
        items.add("Wind Charge");
        items.add("Enchanted Golden Apple");
        items.add("Tropical Fish");
        items.add("Pufferfish");
        items.add("Biscuit");
        items.add("Amethyst Shard");
        items.add("Bolt Armour Trim");
        items.add("Breeze Rod");
        items.add("Brown Dye");
        items.add("Burn Pottery Sherd");
        items.add("Cyan Dye");
        items.add("Flow Armour Trim");
        items.add("Flow Pottery Sherd");
        items.add("Green Dye");
        items.add("Guster Pottery Sherd");
        items.add("Lime Dye");
        items.add("Nether Wart");
        items.add("Prismarine Crystals");
        items.add("Prismarine Shard");
        items.add("Resin Brick");
        items.add("Resin Clump");
        items.add("Scrape Pottery Sherd");
        items.add("Trial Key");
        items.add("Turtle Scute");
        items.add("Vex Armour Trim");
        items.add("Wild Armour Trim");
        items.add("Music Disc - Lena Raine - Pigstep");
        items.add("Music Disc - Lena Raine - otherside");
        items.add("Music Disc -  - creator");
        items.add("End Stone");
        items.add("End Stone Brick Slab");
        items.add("End Stone Brick Stairs");
        items.add("End Stone Brick Wall");
        items.add("End Stone Bricks");
        items.add("Block of Netherite");
        items.add("Amethyst Cluster");
        items.add("Ancient Debris");
        items.add("Crimson Nylium");
        items.add("Deepslate Coal Ore");
        items.add("Deepslate Emerald Ore");
        items.add("Emerald Ore");
        items.add("Honey Block");
        items.add("Large Amethyst Bud");
        items.add("Medium Amethyst Bud");
        items.add("Nether Gold Ore");
        items.add("Nether Quartz Ore");
        items.add("Sculk");
        items.add("Sculk Catalyst");
        items.add("Sculk Sensor");
        items.add("Sculk Shrieker");
        items.add("Sculk Vein");
        items.add("Small Amethyst Bud");
        items.add("Sniffer Egg");
        items.add("Warped Nylium");
        items.add("Wither Skeleton Skull");
        items.add("Netherite Hoe");
        items.add("Netherite Pickaxe");
        items.add("Netherite Shovel");
        items.add("Bucket of Pufferfish");
        items.add("Recovery Compass");
        items.add("Chainmail Boots");
        items.add("Chainmail Chestplate");
        items.add("Chainmail Helmet");
        items.add("Chainmail Leggins");
        items.add("End Crystal");
        items.add("Mace");
        items.add("Netherite Axe");
        items.add("Netherite Boots");
        items.add("Netherite Chestplate");
        items.add("Netherite Helmet");
        items.add("Netherite Leggings");
        items.add("Netherite Sword");
        items.add("Tipped Arrow");
        items.add("Totem of Undying");
        items.add("Trident");
        items.add("Angler Pottery Sherd");
        items.add("Archer Pottery Sherd");
        items.add("Blade Pottery Sherd");
        items.add("Danger Pottery Sherd");
        items.add("Dune Armour Trim");
        items.add("Bottle o' Enchanting");
        items.add("Explorer Pottery Sherd");
        items.add("Friend Pottery Sherd");
        items.add("Heart of the Sea");
        items.add("Heart Pottery Sherd");
        items.add("Heartbreak Pottery Sherd");
        items.add("Host Armour Trim");
        items.add("Howl Pottery Sherd");
        items.add("Miner Pottery Sherd");
        items.add("Mourner Pottery Sherd");
        items.add("Nautilus Shell");
        items.add("Netherite Ingot");
        items.add("Netherite Scrap");
        items.add("Ominous Trial Key");
        items.add("Plenty Pottery Sherd");
        items.add("Prize Pottery Sherd");
        items.add("Rabbt's Foot");
        items.add("Sheaf Pottery Sherd");
        items.add("Shelter Pottery Sherd");
        items.add("Skull Pottery Sherd");
        items.add("Snort Pottery Sherd");
        items.add("Snout Armour Trim");
        items.add("Wayfinder Armour Trim");
        items.add("Purpur Block");
        items.add("Purpur Pillar");
        items.add("Purpur Slab");
        items.add("Purpur Stairs");
        items.add("Black Shulker Box");
        items.add("Blue Shulker Box");
        items.add("Brown Shulker Box");
        items.add("Cyan Shulker Box");
        items.add("Gray Shulker Box");
        items.add("Green Shulker Box");
        items.add("Light Blue Shulker Box");
        items.add("Light Gray Shulker Box");
        items.add("Lime Shulker Box");
        items.add("Magenta Shulker Box");
        items.add("Orange Shulker Box");
        items.add("Pink Shulker Box");
        items.add("Purple Shulker Box");
        items.add("Red Shulker Box");
        items.add("Shulker Box");
        items.add("White Shulker Box");
        items.add("Yellow Shulker Box");
        items.add("Chorus Flower");
        items.add("Chorus Plant");
        items.add("Diamond Ore");
        items.add("Mycelium");
        items.add("Ochre Froglight");
        items.add("Pearlescent Froglight");
        items.add("Pitcher Plant");
        items.add("Pitcher Pod");
        items.add("Torchflower");
        items.add("Torchflower Seeds");
        items.add("Verdant Froglight");
        items.add("Wither Rose");
        items.add("Beacon");
        items.add("Conduit");
        items.add("Creeper Head");
        items.add("Dragon Egg");
        items.add("Dragon Head");
        items.add("End Rod");
        items.add("Piglin Head");
        items.add("Skeleton Skull");
        items.add("Zombie Head");
        items.add("Elytra");
        items.add("Turtle Shell");
        items.add("Chorus Fruit");
        items.add("Arms Up Pottery Sherd");
        items.add("Brewer Pottery Sherd");
        items.add("Dragon's Breath");
        items.add("Echo Shard");
        items.add("Heavy Core");
        items.add("Nether Star");
        items.add("Netherite Upgrade");
        items.add("Popped Chorus Fruit");
        items.add("Shulker Shell");
        items.add("Silence Armour Trim");
        items.add("Spire Armour Trim");
        items.add("Tide Armour Trim");
        items.add("Ward Armour Trim");
        return items;
    }

    public List<Integer> fillQualities(){
        List<Integer> items = new ArrayList<>();
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(0);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(1);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(2);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(3);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(4);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        items.add(5);
        return items;
    }

    public List<String> fillMaterials(){
        List<String> items = new ArrayList<>();
        items.add("BIRCH_BUTTON");
        items.add("BIRCH_DOOR");
        items.add("BIRCH_FENCE");
        items.add("BIRCH_FENCE_GATE");
        items.add("BIRCH_LOG");
        items.add("BIRCH_PLANKS");
        items.add("BIRCH_PRESSURE_PLATE");
        items.add("BIRCH_SLAB");
        items.add("BIRCH_STAIRS");
        items.add("BIRCH_TRAPDOOR");
        items.add("BIRCH_WOOD");
        items.add("CHISELED_SANDSTONE");
        items.add("CHISELED_STONE_BRICKS");
        items.add("COAL_BLOCK");
        items.add("COBBLESTONE");
        items.add("COBBLESTONE_SLAB");
        items.add("COBBLESTONE_STAIRS");
        items.add("COBBLESTONE_WALL");
        items.add("COPPER_BLOCK");
        items.add("COPPER_DOOR");
        items.add("COPPER_GRATE");
        items.add("COPPER_TRAPDOOR");
        items.add("CRACKED_STONE_BRICKS");
        items.add("CUT_COPPER");
        items.add("CUT_COPPER_SLAB");
        items.add("CUT_COPPER_STAIRS");
        items.add("CUT_SANDSTONE");
        items.add("CUT_SANDSTONE_SLAB");
        items.add("OAK_BUTTON");
        items.add("OAK_DOOR");
        items.add("OAK_FENCE");
        items.add("OAK_FENCE_GATE");
        items.add("OAK_LOG");
        items.add("OAK_PLANKS");
        items.add("OAK_PRESSURE_PLATE");
        items.add("OAK_SLAB");
        items.add("OAK_STAIRS");
        items.add("OAK_TRAPDOOR");
        items.add("OAK_WOOD");
        items.add("SANDSTONE");
        items.add("SANDSTONE_SLAB");
        items.add("SANDSTONE_STAIRS");
        items.add("SANDSTONE_WALL");
        items.add("SMOOTH_SANDSTONE");
        items.add("SMOOTH_SANDSTONE_SLAB");
        items.add("SMOOTH_SANDSTONE_STAIRS");
        items.add("SMOOTH_STONE");
        items.add("SMOOTH_STONE_SLAB");
        items.add("STONE");
        items.add("STONE_BRICK_SLAB");
        items.add("STONE_BRICK_STAIRS");
        items.add("STONE_BRICK_WALL");
        items.add("STONE_BRICKS");
        items.add("STONE_BUTTON");
        items.add("STONE_PRESSURE_PLATE");
        items.add("STONE_SLAB");
        items.add("STONE_STAIRS");
        items.add("STRIPPED_BIRCH_LOG");
        items.add("STRIPPED_BIRCH_WOOD");
        items.add("STRIPPED_OAK_LOG");
        items.add("STRIPPED_OAK_WOOD");
        items.add("ALLIUM");
        items.add("AZURE_BLUET");
        items.add("BIRCH_SAPLING");
        items.add("CLAY");
        items.add("COARSE_DIRT");
        items.add("CORNFLOWER");
        items.add("DANDELION");
        items.add("DIRT");
        items.add("GRAVEL");
        items.add("LEAF_LITTER");
        items.add("LILAC");
        items.add("OAK_SAPLING");
        items.add("OXEYE_DAISY");
        items.add("PEONY");
        items.add("POPPY");
        items.add("ROSE_BUSH");
        items.add("SAND");
        items.add("SUGAR_CANE");
        items.add("WHEAT_SEEDS");
        items.add("BARREL");
        items.add("BIRCH_HANGING_SIGN");
        items.add("BIRCH_SIGN");
        items.add("CAMPFIRE");
        items.add("CARTOGRAPHY_TABLE");
        items.add("CHEST");
        items.add("CHISELED_BOOKSHELF");
        items.add("COMPOSTER");
        items.add("CRAFTING_TABLE");
        items.add("FLETCHING_TABLE");
        items.add("FLOWER_POT");
        items.add("FURNACE");
        items.add("GRINDSTONE");
        items.add("ITEM_FRAME");
        items.add("LADDER");
        items.add("LECTERN");
        items.add("LIGHTNING_ROD");
        items.add("OAK_HANGING_SIGN");
        items.add("OAK_SIGN");
        items.add("PAINTING");
        items.add("LEVER");
        items.add("BIRCH_BOAT");
        items.add("BIRCH_CHEST_BOAT");
        items.add("OAK_BOAT");
        items.add("OAK_CHEST_BOAT");
        items.add("STONE_HOE");
        items.add("STONE_PICKAXE");
        items.add("STONE_SHOVEL");
        items.add("WOODEN_HOE");
        items.add("WOODEN_PICKAXE");
        items.add("WOODEN_SHOVEL");
        items.add("LEATHER_BOOTS");
        items.add("LEATHER_CHESTPLATE");
        items.add("LEATHER_HELMET");
        items.add("LEATHER_HORSE_ARMOR");
        items.add("LEATHER_LEGGINGS");
        items.add("STONE_AXE");
        items.add("STONE_SWORD");
        items.add("WOODEN_AXE");
        items.add("WOODEN_SWORD");
        items.add("APPLE");
        items.add("BEEF");
        items.add("CHICKEN");
        items.add("COD");
        items.add("MUTTON");
        items.add("PORKCHOP");
        items.add("SALMON");
        items.add("COOKED_BEEF");
        items.add("COOKED_PORKCHOP");
        items.add("COOKED_MUTTON");
        items.add("COOKED_CHICKEN");
        items.add("COOKED_COD");
        items.add("COOKED_SALMON");
        items.add("BLACK_DYE");
        items.add("BLUE_DYE");
        items.add("BOWL");
        items.add("BRICK");
        items.add("CHARCOAL");
        items.add("CLAY_BALL");
        items.add("COAL");
        items.add("COPPER_INGOT");
        items.add("FEATHER");
        items.add("FLINT");
        items.add("GRAY_DYE");
        items.add("INK_SAC");
        items.add("LEATHER");
        items.add("LIGHT_BLUE_DYE");
        items.add("LIGHT_GRAY_DYE");
        items.add("MAGENTA_DYE");
        items.add("ORANGE_DYE");
        items.add("PAPER");
        items.add("PINK_DYE");
        items.add("PURPLE_DYE");
        items.add("RAW_COPPER");
        items.add("RED_DYE");
        items.add("STICK");
        items.add("SUGAR");
        items.add("WHITE_DYE");
        items.add("YELLOW_DYE");
        items.add("ANDESITE");
        items.add("ANDESITE_SLAB");
        items.add("ANDESITE_STAIRS");
        items.add("ANDESITE_WALL");
        items.add("BRICK_SLAB");
        items.add("BRICK_STAIRS");
        items.add("BRICK_WALL");
        items.add("BRICKS");
        items.add("CHAIN");
        items.add("CHISELED_COPPER");
        items.add("CHISELED_DEEPSLATE");
        items.add("CHISELED_NETHER_BRICKS");
        items.add("CHISELED_QUARTZ_BLOCK");
        items.add("CHISELED_TUFF");
        items.add("CHISELED_TUFF_BRICKS");
        items.add("COBBLED_DEEPSLATE");
        items.add("COBBLED_DEEPSLATE_SLAB");
        items.add("COBBLED_DEEPSLATE_STAIRS");
        items.add("COBBLED_DEEPSLATE_WALL");
        items.add("CRACKED_DEEPSLATE_BRICKS");
        items.add("CRACKED_DEEPSLATE_TILES");
        items.add("CRACKED_NETHER_BRICKS");
        items.add("DEEPSLATE");
        items.add("DEEPSLATE_BRICK_SLAB");
        items.add("DEEPSLATE_BRICK_STAIRS");
        items.add("DEEPSLATE_BRICK_WALL");
        items.add("DEEPSLATE_BRICKS");
        items.add("DEEPSLATE_TILE_SLAB");
        items.add("DEEPSLATE_TILE_STAIRS");
        items.add("DEEPSLATE_TILE_WALL");
        items.add("DEEPSLATE_TILES");
        items.add("DIORITE");
        items.add("DIORITE_SLAB");
        items.add("DIORITE_STAIRS");
        items.add("DIORITE_WALL");
        items.add("EXPOSED_CHISELED_COPPER");
        items.add("EXPOSED_COPPER");
        items.add("EXPOSED_COPPER_BULB");
        items.add("EXPOSED_COPPER_DOOR");
        items.add("EXPOSED_COPPER_GRATE");
        items.add("EXPOSED_COPPER_TRAPDOOR");
        items.add("EXPOSED_CUT_COPPER");
        items.add("EXPOSED_CUT_COPPER_SLAB");
        items.add("EXPOSED_CUT_COPPER_STAIRS");
        items.add("GOLD_BLOCK");
        items.add("GRANITE");
        items.add("GRANITE_SLAB");
        items.add("GRANITE_STAIRS");
        items.add("GRANITE_WALL");
        items.add("HEAVY_WEIGHTED_PRESSURE_PLATE");
        items.add("IRON_BARS");
        items.add("IRON_BLOCK");
        items.add("IRON_DOOR");
        items.add("IRON_TRAPDOOR");
        items.add("LIGHT_WEIGHTED_PRESSURE_PLATE");
        items.add("MUD_BRICK_SLAB");
        items.add("MUD_BRICK_STAIRS");
        items.add("MUD_BRICK_WALL");
        items.add("MUD_BRICKS");
        items.add("NETHER_BRICK_FENCE");
        items.add("NETHER_BRICK_SLAB");
        items.add("NETHER_BRICK_STAIRS");
        items.add("NETHER_BRICK_WALL");
        items.add("NETHER_BRICKS");
        items.add("NETHERRACK");
        items.add("PACKED_MUD");
        items.add("POLISHED_ANDESITE");
        items.add("POLISHED_ANDESITE_SLAB");
        items.add("POLISHED_ANDESITE_STAIRS");
        items.add("POLISHED_DEEPSLATE");
        items.add("POLISHED_DEEPSLATE_SLAB");
        items.add("POLISHED_DEEPSLATE_STAIRS");
        items.add("POLISHED_DEEPSLATE_WALL");
        items.add("POLISHED_DIORITE");
        items.add("POLISHED_DIORITE_SLAB");
        items.add("POLISHED_DIORITE_STAIRS");
        items.add("POLISHED_GRANITE");
        items.add("POLISHED_GRANITE_SLAB");
        items.add("POLISHED_GRANITE_STAIRS");
        items.add("POLISHED_TUFF");
        items.add("POLISHED_TUFF_SLAB");
        items.add("POLISHED_TUFF_STAIRS");
        items.add("POLISHED_TUFF_WALL");
        items.add("QUARTZ_BLOCK");
        items.add("QUARTZ_BRICKS");
        items.add("QUARTZ_PILLAR");
        items.add("QUARTZ_SLAB");
        items.add("QUARTZ_STAIRS");
        items.add("REDSTONE_BLOCK");
        items.add("SMOOTH_QUARTZ");
        items.add("SMOOTH_QUARTZ_SLAB");
        items.add("SMOOTH_QUARTZ_STAIRS");
        items.add("TUFF");
        items.add("TUFF_BRICK_SLAB");
        items.add("TUFF_BRICK_STAIRS");
        items.add("TUFF_BRICK_WALL");
        items.add("TUFF_BRICKS");
        items.add("TUFF_SLAB");
        items.add("TUFF_STAIRS");
        items.add("TUFF_WALL");
        items.add("BLACK_BANNER");
        items.add("BLACK_BED");
        items.add("BLACK_CARPET");
        items.add("BLACK_CONCRETE");
        items.add("BLACK_CONCRETE_POWDER");
        items.add("BLACK_GLAZED_TERRACOTTA");
        items.add("BLACK_STAINED_GLASS");
        items.add("BLACK_STAINED_GLASS_PANE");
        items.add("BLACK_TERRACOTTA");
        items.add("BLACK_WOOL");
        items.add("BLUE_BANNER");
        items.add("BLUE_BED");
        items.add("BLUE_CARPET");
        items.add("BLUE_CONCRETE");
        items.add("BLUE_CONCRETE_POWDER");
        items.add("BLUE_GLAZED_TERRACOTTA");
        items.add("BLUE_STAINED_GLASS");
        items.add("BLUE_STAINED_GLASS_PANE");
        items.add("BLUE_TERRACOTTA");
        items.add("BLUE_WOOL");
        items.add("GLASS");
        items.add("GLASS_PANE");
        items.add("GRAY_BANNER");
        items.add("GRAY_BED");
        items.add("GRAY_CARPET");
        items.add("GRAY_CONCRETE");
        items.add("GRAY_CONCRETE_POWDER");
        items.add("GRAY_GLAZED_TERRACOTTA");
        items.add("GRAY_STAINED_GLASS");
        items.add("GRAY_STAINED_GLASS_PANE");
        items.add("GRAY_TERRACOTTA");
        items.add("GRAY_WOOL");
        items.add("LIGHT_BLUE_BANNER");
        items.add("LIGHT_BLUE_BED");
        items.add("LIGHT_BLUE_CARPET");
        items.add("LIGHT_BLUE_CONCRETE");
        items.add("LIGHT_BLUE_CONCRETE_POWDER");
        items.add("LIGHT_BLUE_GLAZED_TERRACOTTA");
        items.add("LIGHT_BLUE_STAINED_GLASS");
        items.add("LIGHT_BLUE_STAINED_GLASS_PANE");
        items.add("LIGHT_BLUE_TERRACOTTA");
        items.add("LIGHT_BLUE_WOOL");
        items.add("LIGHT_GRAY_BANNER");
        items.add("LIGHT_GRAY_BED");
        items.add("LIGHT_GRAY_CARPET");
        items.add("LIGHT_GRAY_CONCRETE");
        items.add("LIGHT_GRAY_CONCRETE_POWDER");
        items.add("LIGHT_GRAY_GLAZED_TERRACOTTA");
        items.add("LIGHT_GRAY_STAINED_GLASS");
        items.add("LIGHT_GRAY_STAINED_GLASS_PANE");
        items.add("LIGHT_GRAY_TERRACOTTA");
        items.add("LIGHT_GRAY_WOOL");
        items.add("MAGENTA_BANNER");
        items.add("MAGENTA_BED");
        items.add("MAGENTA_CARPET");
        items.add("MAGENTA_CONCRETE");
        items.add("MAGENTA_CONCRETE_POWDER");
        items.add("MAGENTA_GLAZED_TERRACOTTA");
        items.add("MAGENTA_STAINED_GLASS");
        items.add("MAGENTA_STAINED_GLASS_PANE");
        items.add("MAGENTA_TERRACOTTA");
        items.add("MAGENTA_WOOL");
        items.add("ORANGE_BANNER");
        items.add("ORANGE_BED");
        items.add("ORANGE_CARPET");
        items.add("ORANGE_CONCRETE");
        items.add("ORANGE_CONCRETE_POWDER");
        items.add("ORANGE_GLAZED_TERRACOTTA");
        items.add("ORANGE_STAINED_GLASS");
        items.add("ORANGE_STAINED_GLASS_PANE");
        items.add("ORANGE_TERRACOTTA");
        items.add("ORANGE_WOOL");
        items.add("PINK_BANNER");
        items.add("PINK_BED");
        items.add("PINK_CARPET");
        items.add("PINK_CONCRETE");
        items.add("PINK_CONCRETE_POWDER");
        items.add("PINK_GLAZED_TERRACOTTA");
        items.add("PINK_STAINED_GLASS");
        items.add("PINK_STAINED_GLASS_PANE");
        items.add("PINK_TERRACOTTA");
        items.add("PINK_WOOL");
        items.add("PURPLE_BANNER");
        items.add("PURPLE_BED");
        items.add("PURPLE_CARPET");
        items.add("PURPLE_CONCRETE");
        items.add("PURPLE_CONCRETE_POWDER");
        items.add("PURPLE_GLAZED_TERRACOTTA");
        items.add("PURPLE_STAINED_GLASS");
        items.add("PURPLE_STAINED_GLASS_PANE");
        items.add("PURPLE_TERRACOTTA");
        items.add("PURPLE_WOOL");
        items.add("RED_BANNER");
        items.add("RED_BED");
        items.add("RED_CARPET");
        items.add("RED_CONCRETE");
        items.add("RED_CONCRETE_POWDER");
        items.add("RED_GLAZED_TERRACOTTA");
        items.add("RED_STAINED_GLASS");
        items.add("RED_STAINED_GLASS_PANE");
        items.add("RED_TERRACOTTA");
        items.add("RED_WOOL");
        items.add("TERRACOTTA");
        items.add("WHITE_BANNER");
        items.add("WHITE_BED");
        items.add("WHITE_CARPET");
        items.add("WHITE_CONCRETE");
        items.add("WHITE_CONCRETE_POWDER");
        items.add("WHITE_GLAZED_TERRACOTTA");
        items.add("WHITE_STAINED_GLASS");
        items.add("WHITE_STAINED_GLASS_PANE");
        items.add("WHITE_TERRACOTTA");
        items.add("WHITE_WOOL");
        items.add("YELLOW_BANNER");
        items.add("YELLOW_BED");
        items.add("YELLOW_CARPET");
        items.add("YELLOW_CONCRETE");
        items.add("YELLOW_CONCRETE_POWDER");
        items.add("YELLOW_GLAZED_TERRACOTTA");
        items.add("YELLOW_STAINED_GLASS");
        items.add("YELLOW_STAINED_GLASS_PANE");
        items.add("YELLOW_TERRACOTTA");
        items.add("YELLOW_WOOL");
        items.add("BIRCH_LEAVES");
        items.add("BONE_BLOCK");
        items.add("BROWN_MUSHROOM");
        items.add("BUSH");
        items.add("CARVED_PUMPKIN");
        items.add("DRIED_KELP_BLOCK");
        items.add("FERN");
        items.add("FIREFLY_BUSH");
        items.add("GLOW_LICHEN");
        items.add("HAY_BLOCK");
        items.add("JACK_O_LANTERN");
        items.add("KELP");
        items.add("LILY_OF_THE_VALLEY");
        items.add("MAGMA_BLOCK");
        items.add("MUD");
        items.add("MUDDY_MANGROVE_ROOTS");
        items.add("OAK_LEAVES");
        items.add("ORANGE_TULIP");
        items.add("PINK_TULIP");
        items.add("PUMPKIN");
        items.add("PUMPKIN_SEEDS");
        items.add("RAW_COPPER_BLOCK");
        items.add("RAW_IRON_BLOCK");
        items.add("RED_MUSHROOM");
        items.add("RED_TULIP");
        items.add("SEAGRASS");
        items.add("SHORT_GRASS");
        items.add("SPRUCE_LEAVES");
        items.add("SPRUCE_SAPLING");
        items.add("SWEET_BERRIES");
        items.add("VINE");
        items.add("WHITE_TULIP");
        items.add("WILDFLOWERS");
        items.add("ARMOR_STAND");
        items.add("BLAST_FURNACE");
        items.add("BOOKSHELF");
        items.add("CAULDRON");
        items.add("LANTERN");
        items.add("LODESTONE");
        items.add("LOOM");
        items.add("SMITHING_TABLE");
        items.add("SMOKER");
        items.add("SPRUCE_HANGING_SIGN");
        items.add("SPRUCE_SIGN");
        items.add("STONECUTTER");
        items.add("TORCH");
        items.add("ACTIVATOR_RAIL");
        items.add("CHEST_MINECART");
        items.add("COMPARATOR");
        items.add("CRAFTER");
        items.add("DAYLIGHT_DETECTOR");
        items.add("DETECTOR_RAIL");
        items.add("DISPENSER");
        items.add("DROPPER");
        items.add("FURNACE_MINECART");
        items.add("HOPPER");
        items.add("HOPPER_MINECART");
        items.add("MINECART");
        items.add("OBSERVER");
        items.add("PISTON");
        items.add("POWERED_RAIL");
        items.add("RAIL");
        items.add("REPEATER");
        items.add("TARGET");
        items.add("TRAPPED_CHEST");
        items.add("TRIPWIRE_HOOK");
        items.add("BLACK_BUNDLE");
        items.add("BLUE_BUNDLE");
        items.add("BONE_MEAL");
        items.add("BRUSH");
        items.add("BUCKET");
        items.add("BUNDLE");
        items.add("CLOCK");
        items.add("COD_BUCKET");
        items.add("COMPASS");
        items.add("FILLED_MAP");
        items.add("FISHING_ROD");
        items.add("FLINT_AND_STEEL");
        items.add("GOLDEN_HOE");
        items.add("GOLDEN_PICKAXE");
        items.add("GOLDEN_SHOVEL");
        items.add("GRAY_BUNDLE");
        items.add("IRON_HOE");
        items.add("IRON_PICKAXE");
        items.add("IRON_SHOVEL");
        items.add("LAVA_BUCKET");
        items.add("LEAD");
        items.add("LIGHT_BLUE_BUNDLE");
        items.add("LIGHT_GRAY_BUNDLE");
        items.add("MAGENTA_BUNDLE");
        items.add("MAP");
        items.add("MILK_BUCKET");
        items.add("ORANGE_BUNDLE");
        items.add("PINK_BUNDLE");
        items.add("PURPLE_BUNDLE");
        items.add("RED_BUNDLE");
        items.add("SALMON_BUCKET");
        items.add("SHEARS");
        items.add("SPRUCE_BOAT");
        items.add("SPRUCE_CHEST_BOAT");
        items.add("WATER_BUCKET");
        items.add("WHITE_BUNDLE");
        items.add("WRITABLE_BOOK");
        items.add("YELLOW_BUNDLE");
        items.add("ARROW");
        items.add("BOW");
        items.add("EGG");
        items.add("GOLDEN_AXE");
        items.add("GOLDEN_BOOTS");
        items.add("GOLDEN_CHESTPLATE");
        items.add("GOLDEN_HELMET");
        items.add("GOLDEN_HORSE_ARMOR");
        items.add("GOLDEN_LEGGINGS");
        items.add("GOLDEN_SWORD");
        items.add("IRON_AXE");
        items.add("IRON_BOOTS");
        items.add("IRON_CHESTPLATE");
        items.add("IRON_HELMET");
        items.add("IRON_HORSE_ARMOR");
        items.add("IRON_LEGGINGS");
        items.add("IRON_SWORD");
        items.add("SHIELD");
        items.add("DRIED_KELP");
        items.add("BREAD");
        items.add("CAKE");
        items.add("PUMPKIN_PIE");
        items.add("ROTTEN_FLESH");
        items.add("MUSHROOM_STEW");
        items.add("SUSPICIOUS_STEW");
        items.add("MILK_BUCKET");
        items.add("BONE");
        items.add("BOOK");
        items.add("FERMENTED_SPIDER_EYE");
        items.add("FIREWORK_STAR");
        items.add("GLASS_BOTTLE");
        items.add("GOLD_INGOT");
        items.add("GOLD_NUGGET");
        items.add("GUNPOWDER");
        items.add("IRON_INGOT");
        items.add("IRON_NUGGET");
        items.add("LAPIS_LAZULI");
        items.add("NETHER_BRICK");
        items.add("RAW_GOLD");
        items.add("RAW_IRON");
        items.add("SPIDER_EYE");
        items.add("STRING");
        items.add("WHEAT");
        items.add("ACACIA_BUTTON");
        items.add("ACACIA_DOOR");
        items.add("ACACIA_FENCE");
        items.add("ACACIA_FENCE_GATE");
        items.add("ACACIA_LOG");
        items.add("ACACIA_PLANKS");
        items.add("ACACIA_PRESSURE_PLATE");
        items.add("ACACIA_SLAB");
        items.add("ACACIA_STAIRS");
        items.add("ACACIA_TRAPDOOR");
        items.add("ACACIA_WOOD");
        items.add("BASALT");
        items.add("BLACKSTONE");
        items.add("BLACKSTONE_SLAB");
        items.add("BLACKSTONE_STAIRS");
        items.add("BLACKSTONE_WALL");
        items.add("CHISELED_POLISHED_BLACKSTONE");
        items.add("DARK_OAK_BUTTON");
        items.add("DARK_OAK_DOOR");
        items.add("DARK_OAK_FENCE");
        items.add("DARK_OAK_FENCE_GATE");
        items.add("DARK_OAK_LOG");
        items.add("DARK_OAK_PLANKS");
        items.add("DARK_OAK_PRESSURE_PLATE");
        items.add("DARK_OAK_SLAB");
        items.add("DARK_OAK_STAIRS");
        items.add("DARK_OAK_TRAPDOOR");
        items.add("DARK_OAK_WOOD");
        items.add("DIAMOND_BLOCK");
        items.add("EMERALD_BLOCK");
        items.add("LAPIS_BLOCK");
        items.add("MOSSY_COBBLESTONE");
        items.add("MOSSY_COBBLESTONE_SLAB");
        items.add("MOSSY_COBBLESTONE_STAIRS");
        items.add("MOSSY_COBBLESTONE_WALL");
        items.add("MOSSY_STONE_BRICK_SLAB");
        items.add("MOSSY_STONE_BRICK_STAIRS");
        items.add("MOSSY_STONE_BRICK_WALL");
        items.add("MOSSY_STONE_BRICKS");
        items.add("POLISHED_BASALT");
        items.add("POLISHED_BLACKSTONE");
        items.add("POLISHED_BLACKSTONE_BRICK_SLAB");
        items.add("POLISHED_BLACKSTONE_BRICK_STAIRS");
        items.add("POLISHED_BLACKSTONE_BRICK_WALL");
        items.add("POLISHED_BLACKSTONE_BRICKS");
        items.add("POLISHED_BLACKSTONE_BUTTON");
        items.add("POLISHED_BLACKSTONE_PRESSURE_PLATE");
        items.add("POLISHED_BLACKSTONE_SLAB");
        items.add("POLISHED_BLACKSTONE_STAIRS");
        items.add("POLISHED_BLACKSTONE_WALL");
        items.add("SMOOTH_BASALT");
        items.add("SPRUCE_BUTTON");
        items.add("SPRUCE_DOOR");
        items.add("SPRUCE_FENCE");
        items.add("SPRUCE_FENCE_GATE");
        items.add("SPRUCE_LOG");
        items.add("SPRUCE_PLANKS");
        items.add("SPRUCE_PRESSURE_PLATE");
        items.add("SPRUCE_SLAB");
        items.add("SPRUCE_STAIRS");
        items.add("SPRUCE_TRAPDOOR");
        items.add("SPRUCE_WOOD");
        items.add("STRIPPED_ACACIA_LOG");
        items.add("STRIPPED_ACACIA_WOOD");
        items.add("STRIPPED_DARK_OAK_LOG");
        items.add("STRIPPED_DARK_OAK_WOOD");
        items.add("STRIPPED_SPRUCE_LOG");
        items.add("STRIPPED_SPRUCE_WOOD");
        items.add("WAXED_CHISELED_COPPER");
        items.add("WAXED_COPPER_BLOCK");
        items.add("WAXED_COPPER_BULB");
        items.add("WAXED_COPPER_DOOR");
        items.add("WAXED_COPPER_GRATE");
        items.add("WAXED_COPPER_TRAPDOOR");
        items.add("WAXED_CUT_COPPER");
        items.add("WAXED_CUT_COPPER_SLAB");
        items.add("WAXED_CUT_COPPER_STAIRS");
        items.add("WAXED_EXPOSED_CHISELED_COPPER");
        items.add("WAXED_EXPOSED_COPPER");
        items.add("WAXED_EXPOSED_COPPER_BULB");
        items.add("WAXED_EXPOSED_COPPER_DOOR");
        items.add("WAXED_EXPOSED_COPPER_GRATE");
        items.add("WAXED_EXPOSED_COPPER_TRAPDOOR");
        items.add("WAXED_EXPOSED_CUT_COPPER");
        items.add("WAXED_EXPOSED_CUT_COPPER_SLAB");
        items.add("WAXED_EXPOSED_CUT_COPPER_STAIRS");
        items.add("BLACK_CANDLE");
        items.add("BLUE_CANDLE");
        items.add("CANDLE");
        items.add("GRAY_CANDLE");
        items.add("LIGHT_BLUE_CANDLE");
        items.add("LIGHT_GRAY_CANDLE");
        items.add("MAGENTA_CANDLE");
        items.add("ORANGE_CANDLE");
        items.add("PINK_CANDLE");
        items.add("PURPLE_CANDLE");
        items.add("RED_CANDLE");
        items.add("WHITE_CANDLE");
        items.add("YELLOW_CANDLE");
        items.add("ACACIA_LEAVES");
        items.add("ACACIA_SAPLING");
        items.add("AZALEA");
        items.add("AZALEA_LEAVES");
        items.add("BEETROOT_SEEDS");
        items.add("BIG_DRIPLEAF");
        items.add("BLUE_ORCHID");
        items.add("COBWEB");
        items.add("DRIPSTONE_BLOCK");
        items.add("FLOWERING_AZALEA");
        items.add("FLOWERING_AZALEA_LEAVES");
        items.add("GLOW_BERRIES");
        items.add("GLOWSTONE");
        items.add("HANGING_ROOTS");
        items.add("LILY_PAD");
        items.add("MOSS_BLOCK");
        items.add("MOSS_CARPET");
        items.add("OBSIDIAN");
        items.add("POINTED_DRIPSTONE");
        items.add("RAW_GOLD_BLOCK");
        items.add("ROOTED_DIRT");
        items.add("SHROOMLIGHT");
        items.add("SLIME_BLOCK");
        items.add("SNOW");
        items.add("SNOW_BLOCK");
        items.add("SOUL_SAND");
        items.add("SOUL_SOIL");
        items.add("SPORE_BLOSSOM");
        items.add("SUNFLOWER");
        items.add("ACACIA_HANGING_SIGN");
        items.add("ACACIA_SIGN");
        items.add("ANVIL");
        items.add("BEEHIVE");
        items.add("BELL");
        items.add("BREWING_STAND");
        items.add("CHIPPED_ANVIL");
        items.add("DAMAGED_ANVIL");
        items.add("DARK_OAK_HANGING_SIGN");
        items.add("DARK_OAK_SIGN");
        items.add("DECORATED_POT");
        items.add("ENCHANTING_TABLE");
        items.add("GLOW_ITEM_FRAME");
        items.add("JUKEBOX");
        items.add("NOTE_BLOCK");
        items.add("REDSTONE_LAMP");
        items.add("REDSTONE_TORCH");
        items.add("SOUL_CAMPFIRE");
        items.add("SOUL_LANTERN");
        items.add("SOUL_TORCH");
        items.add("STICKY_PISTON");
        items.add("TNT_MINECART");
        items.add("ACACIA_BOAT");
        items.add("ACACIA_CHEST_BOAT");
        items.add("CARROT_ON_A_STICK");
        items.add("DARK_OAK_BOAT");
        items.add("DARK_OAK_CHEST_BOAT");
        items.add("DIAMOND_HOE");
        items.add("DIAMOND_PICKAXE");
        items.add("DIAMOND_SHOVEL");
        items.add("ENDER_EYE");
        items.add("ENDER_PEARL");
        items.add("FIRE_CHARGE");
        items.add("POWDER_SNOW_BUCKET");
        items.add("SADDLE");
        items.add("TROPICAL_FISH_BUCKET");
        items.add("WARPED_FUNGUS_ON_A_STICK");
        items.add("BROWN_EGG");
        items.add("DIAMOND_AXE");
        items.add("DIAMOND_BOOTS");
        items.add("DIAMOND_CHESTPLATE");
        items.add("DIAMOND_HELMET");
        items.add("DIAMOND_HORSE_ARMOR");
        items.add("DIAMOND_LEGGINGS");
        items.add("DIAMOND_SWORD");
        items.add("FIREWORK_ROCKET");
        items.add("SNOWBALL");
        items.add("SPECTRAL_ARROW");
        items.add("TNT");
        items.add("WOLF_ARMOR");
        items.add("GOLDEN_APPLE");
        items.add("MELON_SLICE");
        items.add("CARROT");
        items.add("GOLDEN_CARROT");
        items.add("BAKED_POTATO");
        items.add("POISONOUS_POTATO");
        items.add("POTATO");
        items.add("BEETROOT");
        items.add("RABBIT");
        items.add("COOKED_RABBIT");
        items.add("BEETROOT_SOUP");
        items.add("RABBIT_STEW");
        items.add("HONEY_BOTTLE");
        items.add("ARMADILLO_SCUTE");
        items.add("BLAZE_POWDER");
        items.add("BLAZE_ROD");
        items.add("COAST_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("DIAMOND");
        items.add("EMERALD");
        items.add("ENCHANTED_BOOK");
        items.add("EYE_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("GHAST_TEAR");
        items.add("GLISTERING_MELON_SLICE");
        items.add("GLOW_INK_SAC");
        items.add("GLOWSTONE_DUST");
        items.add("HONEYCOMB");
        items.add("MAGMA_CREAM");
        items.add("QUARTZ");
        items.add("RABBIT_HIDE");
        items.add("RAISER_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("REDSTONE");
        items.add("RIB_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("SLIME_BALL");
        items.add("SNOWBALL");
        items.add("MUSIC_DISC_11");
        items.add("MUSIC_DISC_13");
        items.add("MUSIC_DISC_BLOCKS");
        items.add("MUSIC_DISC_CAT");
        items.add("MUSIC_DISC_CHIRP");
        items.add("MUSIC_DISC_FAR");
        items.add("MUSIC_DISC_MALL");
        items.add("MUSIC_DISC_MELLOHI");
        items.add("MUSIC_DISC_STAL");
        items.add("MUSIC_DISC_STRAD");
        items.add("MUSIC_DISC_WAIT");
        items.add("MUSIC_DISC_WARD");
        items.add("DISC_FRAGMENT_5");
        items.add("MUSIC_DISC_5");
        items.add("MUSIC_DISC_CREATOR_MUSIC_BOX");
        items.add("MUSIC_DISC_RELIC");
        items.add("MUSIC_DISC_PRECIPICE");
        items.add("GOAT_HORN");
        items.add("AMETHYST_BLOCK");
        items.add("BAMBOO_BLOCK");
        items.add("BAMBOO_BUTTON");
        items.add("BAMBOO_DOOR");
        items.add("BAMBOO_FENCE");
        items.add("BAMBOO_FENCE_GATE");
        items.add("BAMBOO_MOSAIC");
        items.add("BAMBOO_MOSAIC_SLAB");
        items.add("BAMBOO_MOSAIC_STAIRS");
        items.add("BAMBOO_PLANKS");
        items.add("BAMBOO_PRESSURE_PLATE");
        items.add("BAMBOO_SLAB");
        items.add("BAMBOO_STAIRS");
        items.add("BAMBOO_TRAPDOOR");
        items.add("CHERRY_BUTTON");
        items.add("CHERRY_DOOR");
        items.add("CHERRY_FENCE");
        items.add("CHERRY_FENCE_GATE");
        items.add("CHERRY_LOG");
        items.add("CHERRY_PLANKS");
        items.add("CHERRY_PRESSURE_PLATE");
        items.add("CHERRY_SLAB");
        items.add("CHERRY_STAIRS");
        items.add("CHERRY_TRAPDOOR");
        items.add("CHERRY_WOOD");
        items.add("CHISELED_RED_SANDSTONE");
        items.add("CHISELED_RESIN_BRICKS");
        items.add("COPPER_BULB");
        items.add("CRACKED_POLISHED_BLACKSTONE_BRICKS");
        items.add("CRIMSON_BUTTON");
        items.add("CRIMSON_DOOR");
        items.add("CRIMSON_FENCE");
        items.add("CRIMSON_FENCE_GATE");
        items.add("CRIMSON_HYPHAE");
        items.add("CRIMSON_PLANKS");
        items.add("CRIMSON_PRESSURE_PLATE");
        items.add("CRIMSON_SLAB");
        items.add("CRIMSON_STAIRS");
        items.add("CRIMSON_STEM");
        items.add("CRIMSON_TRAPDOOR");
        items.add("CUT_RED_SANDSTONE");
        items.add("CUT_RED_SANDSTONE_SLAB");
        items.add("DARK_PRISMARINE");
        items.add("DARK_PRISMARINE_SLAB");
        items.add("DARK_PRISMARINE_STAIRS");
        items.add("GILDED_BLACKSTONE");
        items.add("JUNGLE_BUTTON");
        items.add("JUNGLE_DOOR");
        items.add("JUNGLE_FENCE");
        items.add("JUNGLE_FENCE_GATE");
        items.add("JUNGLE_LOG");
        items.add("JUNGLE_PLANKS");
        items.add("JUNGLE_PRESSURE_PLATE");
        items.add("JUNGLE_SLAB");
        items.add("JUNGLE_STAIRS");
        items.add("JUNGLE_TRAPDOOR");
        items.add("JUNGLE_WOOD");
        items.add("MANGROVE_BUTTON");
        items.add("MANGROVE_DOOR");
        items.add("MANGROVE_FENCE");
        items.add("MANGROVE_FENCE_GATE");
        items.add("MANGROVE_LOG");
        items.add("MANGROVE_PLANKS");
        items.add("MANGROVE_PRESSURE_PLATE");
        items.add("MANGROVE_SLAB");
        items.add("MANGROVE_STAIRS");
        items.add("MANGROVE_TRAPDOOR");
        items.add("MANGROVE_WOOD");
        items.add("OXIDIZED_CHISELED_COPPER");
        items.add("OXIDIZED_COPPER");
        items.add("OXIDIZED_COPPER_BULB");
        items.add("OXIDIZED_COPPER_DOOR");
        items.add("OXIDIZED_COPPER_GRATE");
        items.add("OXIDIZED_COPPER_TRAPDOOR");
        items.add("OXIDIZED_CUT_COPPER");
        items.add("OXIDIZED_CUT_COPPER_SLAB");
        items.add("OXIDIZED_CUT_COPPER_STAIRS");
        items.add("PALE_OAK_BUTTON");
        items.add("PALE_OAK_DOOR");
        items.add("PALE_OAK_FENCE");
        items.add("PALE_OAK_FENCE_GATE");
        items.add("PALE_OAK_LOG");
        items.add("PALE_OAK_PLANKS");
        items.add("PALE_OAK_PRESSURE_PLATE");
        items.add("PALE_OAK_SLAB");
        items.add("PALE_OAK_STAIRS");
        items.add("PALE_OAK_TRAPDOOR");
        items.add("PALE_OAK_WOOD");
        items.add("PRISMARINE");
        items.add("PRISMARINE_BRICK_SLAB");
        items.add("PRISMARINE_BRICK_STAIRS");
        items.add("PRISMARINE_BRICKS");
        items.add("PRISMARINE_SLAB");
        items.add("PRISMARINE_STAIRS");
        items.add("PRISMARINE_WALL");
        items.add("RED_NETHER_BRICK_SLAB");
        items.add("RED_NETHER_BRICK_STAIRS");
        items.add("RED_NETHER_BRICK_WALL");
        items.add("RED_NETHER_BRICKS");
        items.add("RED_SANDSTONE");
        items.add("RED_SANDSTONE_SLAB");
        items.add("RED_SANDSTONE_STAIRS");
        items.add("RED_SANDSTONE_WALL");
        items.add("RESIN_BRICK_SLAB");
        items.add("RESIN_BRICK_STAIRS");
        items.add("RESIN_BRICK_WALL");
        items.add("RESIN_BRICKS");
        items.add("SEA_LANTERN");
        items.add("SMOOTH_RED_SANDSTONE");
        items.add("SMOOTH_RED_SANDSTONE_SLAB");
        items.add("SMOOTH_RED_SANDSTONE_STAIRS");
        items.add("STRIPPED_BAMBOO_BLOCK");
        items.add("STRIPPED_CHERRY_LOG");
        items.add("STRIPPED_CHERRY_WOOD");
        items.add("STRIPPED_CRIMSON_HYPHAE");
        items.add("STRIPPED_CRIMSON_STEM");
        items.add("STRIPPED_JUNGLE_LOG");
        items.add("STRIPPED_JUNGLE_WOOD");
        items.add("STRIPPED_MANGROVE_LOG");
        items.add("STRIPPED_MANGROVE_WOOD");
        items.add("STRIPPED_PALE_OAK_LOG");
        items.add("STRIPPED_PALE_OAK_WOOD");
        items.add("STRIPPED_WARPED_HYPHAE");
        items.add("STRIPPED_WARPED_STEM");
        items.add("WARPED_BUTTON");
        items.add("WARPED_DOOR");
        items.add("WARPED_FENCE");
        items.add("WARPED_FENCE_GATE");
        items.add("WARPED_HYPHAE");
        items.add("WARPED_PLANKS");
        items.add("WARPED_PRESSURE_PLATE");
        items.add("WARPED_SLAB");
        items.add("WARPED_STAIRS");
        items.add("WARPED_STEM");
        items.add("WARPED_TRAPDOOR");
        items.add("WAXED_OXIDIZED_CHISELED_COPPER");
        items.add("WAXED_OXIDIZED_COPPER");
        items.add("WAXED_OXIDIZED_COPPER_BULB");
        items.add("WAXED_OXIDIZED_COPPER_DOOR");
        items.add("WAXED_OXIDIZED_COPPER_GRATE");
        items.add("WAXED_OXIDIZED_COPPER_TRAPDOOR");
        items.add("WAXED_OXIDIZED_CUT_COPPER");
        items.add("WAXED_OXIDIZED_CUT_COPPER_SLAB");
        items.add("WAXED_OXIDIZED_CUT_COPPER_STAIRS");
        items.add("WAXED_WEATHERED_CHISELED_COPPER");
        items.add("WAXED_WEATHERED_COPPER");
        items.add("WAXED_WEATHERED_COPPER_BULB");
        items.add("WAXED_WEATHERED_COPPER_DOOR");
        items.add("WAXED_WEATHERED_COPPER_GRATE");
        items.add("WAXED_WEATHERED_COPPER_TRAPDOOR");
        items.add("WAXED_WEATHERED_CUT_COPPER");
        items.add("WAXED_WEATHERED_CUT_COPPER_SLAB");
        items.add("WAXED_WEATHERED_CUT_COPPER_STAIRS");
        items.add("WEATHERED_CHISELED_COPPER");
        items.add("WEATHERED_COPPER");
        items.add("WEATHERED_COPPER_BULB");
        items.add("WEATHERED_COPPER_DOOR");
        items.add("WEATHERED_COPPER_GRATE");
        items.add("WEATHERED_COPPER_TRAPDOOR");
        items.add("WEATHERED_CUT_COPPER");
        items.add("WEATHERED_CUT_COPPER_SLAB");
        items.add("WEATHERED_CUT_COPPER_STAIRS");
        items.add("BROWN_BANNER");
        items.add("BROWN_BED");
        items.add("BROWN_CANDLE");
        items.add("BROWN_CARPET");
        items.add("BROWN_CONCRETE");
        items.add("BROWN_CONCRETE_POWDER");
        items.add("BROWN_GLAZED_TERRACOTTA");
        items.add("BROWN_STAINED_GLASS");
        items.add("BROWN_STAINED_GLASS_PANE");
        items.add("BROWN_TERRACOTTA");
        items.add("BROWN_WOOL");
        items.add("CYAN_BANNER");
        items.add("CYAN_BED");
        items.add("CYAN_CANDLE");
        items.add("CYAN_CARPET");
        items.add("CYAN_CONCRETE");
        items.add("CYAN_CONCRETE_POWDER");
        items.add("CYAN_GLAZED_TERRACOTTA");
        items.add("CYAN_STAINED_GLASS");
        items.add("CYAN_STAINED_GLASS_PANE");
        items.add("CYAN_TERRACOTTA");
        items.add("CYAN_WOOL");
        items.add("GREEN_BANNER");
        items.add("GREEN_BED");
        items.add("GREEN_CANDLE");
        items.add("GREEN_CARPET");
        items.add("GREEN_CONCRETE");
        items.add("GREEN_CONCRETE_POWDER");
        items.add("GREEN_GLAZED_TERRACOTTA");
        items.add("GREEN_STAINED_GLASS");
        items.add("GREEN_STAINED_GLASS_PANE");
        items.add("GREEN_TERRACOTTA");
        items.add("GREEN_WOOL");
        items.add("LIME_BANNER");
        items.add("LIME_BED");
        items.add("LIME_CANDLE");
        items.add("LIME_CARPET");
        items.add("LIME_CONCRETE");
        items.add("LIME_CONCRETE_POWDER");
        items.add("LIME_GLAZED_TERRACOTTA");
        items.add("LIME_STAINED_GLASS");
        items.add("LIME_STAINED_GLASS_PANE");
        items.add("LIME_TERRACOTTA");
        items.add("LIME_WOOL");
        items.add("TINTED_GLASS");
        items.add("BAMBOO");
        items.add("BEE_NEST");
        items.add("BLUE_ICE");
        items.add("BRAIN_CORAL");
        items.add("BRAIN_CORAL_BLOCK");
        items.add("BRAIN_CORAL_FAN");
        items.add("BROWN_MUSHROOM_BLOCK");
        items.add("BUBBLE_CORAL");
        items.add("BUBBLE_CORAL_BLOCK");
        items.add("BUBBLE_CORAL_FAN");
        items.add("CACTUS");
        items.add("CACTUS_FLOWER");
        items.add("CALCITE");
        items.add("CHERRY_LEAVES");
        items.add("CHERRY_SAPLING");
        items.add("CLOSED_EYEBLOSSOM");
        items.add("COAL_ORE");
        items.add("COCOA_BEANS");
        items.add("COPPER_ORE");
        items.add("CRIMSON_FUNGUS");
        items.add("CRIMSON_ROOTS");
        items.add("CRYING_OBSIDIAN");
        items.add("DARK_OAK_LEAVES");
        items.add("DARK_OAK_SAPLING");
        items.add("DEAD_BRAIN_CORAL");
        items.add("DEAD_BRAIN_CORAL_BLOCK");
        items.add("DEAD_BRAIN_CORAL_FAN");
        items.add("DEAD_BUBBLE_CORAL");
        items.add("DEAD_BUBBLE_CORAL_BLOCK");
        items.add("DEAD_BUBBLE_CORAL_FAN");
        items.add("DEAD_BUSH");
        items.add("DEAD_FIRE_CORAL");
        items.add("DEAD_FIRE_CORAL_BLOCK");
        items.add("DEAD_FIRE_CORAL_FAN");
        items.add("DEAD_HORN_CORAL");
        items.add("DEAD_HORN_CORAL_BLOCK");
        items.add("DEAD_HORN_CORAL_FAN");
        items.add("DEAD_TUBE_CORAL");
        items.add("DEAD_TUBE_CORAL_BLOCK");
        items.add("DEAD_TUBE_CORAL_FAN");
        items.add("DEEPSLATE_COPPER_ORE");
        items.add("DEEPSLATE_DIAMOND_ORE");
        items.add("DEEPSLATE_GOLD_ORE");
        items.add("DEEPSLATE_IRON_ORE");
        items.add("DEEPSLATE_LAPIS_ORE");
        items.add("DEEPSLATE_REDSTONE_ORE");
        items.add("FIRE_CORAL");
        items.add("FIRE_CORAL_BLOCK");
        items.add("FIRE_CORAL_FAN");
        items.add("GOLD_ORE");
        items.add("GRASS_BLOCK");
        items.add("HONEYCOMB_BLOCK");
        items.add("HORN_CORAL");
        items.add("HORN_CORAL_BLOCK");
        items.add("HORN_CORAL_FAN");
        items.add("ICE");
        items.add("IRON_ORE");
        items.add("JUNGLE_LEAVES");
        items.add("JUNGLE_SAPLING");
        items.add("LAPIS_ORE");
        items.add("MANGROVE_LEAVES");
        items.add("MANGROVE_PROPAGULE");
        items.add("MANGROVE_ROOTS");
        items.add("MELON");
        items.add("MELON_SEEDS");
        items.add("MUSHROOM_STEM");
        items.add("NETHER_SPROUTS");
        items.add("NETHER_WART_BLOCK");
        items.add("OPEN_EYEBLOSSOM");
        items.add("PACKED_ICE");
        items.add("PALE_HANGING_MOSS");
        items.add("PALE_MOSS_BLOCK");
        items.add("PALE_MOSS_CARPET");
        items.add("PALE_OAK_LEAVES");
        items.add("PALE_OAK_SAPLING");
        items.add("PINK_PETALS");
        items.add("PODZOL");
        items.add("RED_MUSHROOM_BLOCK");
        items.add("RED_SAND");
        items.add("REDSTONE_ORE");
        items.add("RESIN_BLOCK");
        items.add("SEA_PICKLE");
        items.add("SHORT_DRY_GRASS");
        items.add("SPONGE");
        items.add("TALL_DRY_GRASS");
        items.add("TUBE_CORAL");
        items.add("TUBE_CORAL_BLOCK");
        items.add("TUBE_CORAL_FAN");
        items.add("TURTLE_EGG");
        items.add("TWISTING_VINES");
        items.add("WARPED_FUNGUS");
        items.add("WARPED_ROOTS");
        items.add("WARPED_WART_BLOCK");
        items.add("WEEPING_VINES");
        items.add("WET_SPONGE");
        items.add("BAMBOO_HANGING_SIGN");
        items.add("BAMBOO_SIGN");
        items.add("CHERRY_HANGING_SIGN");
        items.add("CHERRY_SIGN");
        items.add("CRIMSON_HANGING_SIGN");
        items.add("CRIMSON_SIGN");
        items.add("ENDER_CHEST");
        items.add("JUNGLE_HANGING_SIGN");
        items.add("JUNGLE_SIGN");
        items.add("MANGROVE_HANGING_SIGN");
        items.add("MANGROVE_SIGN");
        items.add("PALE_OAK_HANGING_SIGN");
        items.add("PALE_OAK_SIGN");
        items.add("RESPAWN_ANCHOR");
        items.add("SCAFFOLDING");
        items.add("WARPED_HANGING_SIGN");
        items.add("WARPED_SIGN");
        items.add("CALIBRATED_SCULK_SENSOR");
        items.add("AXOLOTL_BUCKET");
        items.add("BAMBOO_CHEST_RAFT");
        items.add("BAMBOO_RAFT");
        items.add("BROWN_BUNDLE");
        items.add("CHERRY_BOAT");
        items.add("CHERRY_CHEST_BOAT");
        items.add("CYAN_BUNDLE");
        items.add("GREEN_BUNDLE");
        items.add("JUNGLE_BOAT");
        items.add("JUNGLE_CHEST_BOAT");
        items.add("LIME_BUNDLE");
        items.add("MANGROVE_BOAT");
        items.add("MANGROVE_CHEST_BOAT");
        items.add("NAME_TAG");
        items.add("PALE_OAK_BOAT");
        items.add("PALE_OAK_CHEST_BOAT");
        items.add("SPYGLASS");
        items.add("TADPOLE_BUCKET");
        items.add("BLUE_EGG");
        items.add("CROSSBOW");
        items.add("WIND_CHARGE");
        items.add("ENCHANTED_GOLDEN_APPLE");
        items.add("TROPICAL_FISH");
        items.add("PUFFERFISH");
        items.add("COOKIE");
        items.add("AMETHYST_SHARD");
        items.add("BOLT_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("BREEZE_ROD");
        items.add("BROWN_DYE");
        items.add("BURN_POTTERY_SHERD");
        items.add("CYAN_DYE");
        items.add("FLOW_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("FLOW_POTTERY_SHERD");
        items.add("GREEN_DYE");
        items.add("GUSTER_POTTERY_SHERD");
        items.add("LIME_DYE");
        items.add("NETHER_WART");
        items.add("PRISMARINE_CRYSTALS");
        items.add("PRISMARINE_SHARD");
        items.add("RESIN_BRICK");
        items.add("RESIN_CLUMP");
        items.add("SCRAPE_POTTERY_SHERD");
        items.add("TRIAL_KEY");
        items.add("TURTLE_SCUTE");
        items.add("VEX_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("WILD_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("MUSIC_DISC_PIGSTEP");
        items.add("MUSIC_DISC_OTHERSIDE");
        items.add("MUSIC_DISC_CREATOR");
        items.add("END_STONE");
        items.add("END_STONE_BRICK_SLAB");
        items.add("END_STONE_BRICK_STAIRS");
        items.add("END_STONE_BRICK_WALL");
        items.add("END_STONE_BRICKS");
        items.add("NETHERITE_BLOCK");
        items.add("AMETHYST_CLUSTER");
        items.add("ANCIENT_DEBRIS");
        items.add("CRIMSON_NYLIUM");
        items.add("DEEPSLATE_COAL_ORE");
        items.add("DEEPSLATE_EMERALD_ORE");
        items.add("EMERALD_ORE");
        items.add("HONEY_BLOCK");
        items.add("LARGE_AMETHYST_BUD");
        items.add("MEDIUM_AMETHYST_BUD");
        items.add("NETHER_GOLD_ORE");
        items.add("NETHER_QUARTZ_ORE");
        items.add("SCULK");
        items.add("SCULK_CATALYST");
        items.add("SCULK_SENSOR");
        items.add("SCULK_SHRIEKER");
        items.add("SCULK_VEIN");
        items.add("SMALL_AMETHYST_BUD");
        items.add("SNIFFER_EGG");
        items.add("WARPED_NYLIUM");
        items.add("WITHER_SKELETON_SKULL");
        items.add("NETHERITE_HOE");
        items.add("NETHERITE_PICKAXE");
        items.add("NETHERITE_SHOVEL");
        items.add("PUFFERFISH_BUCKET");
        items.add("RECOVERY_COMPASS");
        items.add("CHAINMAIL_BOOTS");
        items.add("CHAINMAIL_CHESTPLATE");
        items.add("CHAINMAIL_HELMET");
        items.add("CHAINMAIL_LEGGINGS");
        items.add("END_CRYSTAL");
        items.add("MACE");
        items.add("NETHERITE_AXE");
        items.add("NETHERITE_BOOTS");
        items.add("NETHERITE_CHESTPLATE");
        items.add("NETHERITE_HELMET");
        items.add("NETHERITE_LEGGINGS");
        items.add("NETHERITE_SWORD");
        items.add("TIPPED_ARROW");
        items.add("TOTEM_OF_UNDYING");
        items.add("TRIDENT");
        items.add("ANGLER_POTTERY_SHERD");
        items.add("ARCHER_POTTERY_SHERD");
        items.add("BLADE_POTTERY_SHERD");
        items.add("DANGER_POTTERY_SHERD");
        items.add("DUNE_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("EXPERIENCE_BOTTLE");
        items.add("EXPLORER_POTTERY_SHERD");
        items.add("FRIEND_POTTERY_SHERD");
        items.add("HEART_OF_THE_SEA");
        items.add("HEART_POTTERY_SHERD");
        items.add("HEARTBREAK_POTTERY_SHERD");
        items.add("HOST_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("HOWL_POTTERY_SHERD");
        items.add("MINER_POTTERY_SHERD");
        items.add("MOURNER_POTTERY_SHERD");
        items.add("NAUTILUS_SHELL");
        items.add("NETHERITE_INGOT");
        items.add("NETHERITE_SCRAP");
        items.add("OMINOUS_TRIAL_KEY");
        items.add("PLENTY_POTTERY_SHERD");
        items.add("PRIZE_POTTERY_SHERD");
        items.add("RABBIT_FOOT");
        items.add("SHEAF_POTTERY_SHERD");
        items.add("SHELTER_POTTERY_SHERD");
        items.add("SKULL_POTTERY_SHERD");
        items.add("SNORT_POTTERY_SHERD");
        items.add("SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("PURPUR_BLOCK");
        items.add("PURPUR_PILLAR");
        items.add("PURPUR_SLAB");
        items.add("PURPUR_STAIRS");
        items.add("BLACK_SHULKER_BOX");
        items.add("BLUE_SHULKER_BOX");
        items.add("BROWN_SHULKER_BOX");
        items.add("CYAN_SHULKER_BOX");
        items.add("GRAY_SHULKER_BOX");
        items.add("GREEN_SHULKER_BOX");
        items.add("LIGHT_BLUE_SHULKER_BOX");
        items.add("LIGHT_GRAY_SHULKER_BOX");
        items.add("LIME_SHULKER_BOX");
        items.add("MAGENTA_SHULKER_BOX");
        items.add("ORANGE_SHULKER_BOX");
        items.add("PINK_SHULKER_BOX");
        items.add("PURPLE_SHULKER_BOX");
        items.add("RED_SHULKER_BOX");
        items.add("SHULKER_BOX");
        items.add("WHITE_SHULKER_BOX");
        items.add("YELLOW_SHULKER_BOX");
        items.add("CHORUS_FLOWER");
        items.add("CHORUS_PLANT");
        items.add("DIAMOND_ORE");
        items.add("MYCELIUM");
        items.add("OCHRE_FROGLIGHT");
        items.add("PEARLESCENT_FROGLIGHT");
        items.add("PITCHER_PLANT");
        items.add("PITCHER_POD");
        items.add("TORCHFLOWER");
        items.add("TORCHFLOWER_SEEDS");
        items.add("VERDANT_FROGLIGHT");
        items.add("WITHER_ROSE");
        items.add("BEACON");
        items.add("CONDUIT");
        items.add("CREEPER_HEAD");
        items.add("DRAGON_EGG");
        items.add("DRAGON_HEAD");
        items.add("END_ROD");
        items.add("PIGLIN_HEAD");
        items.add("SKELETON_SKULL");
        items.add("ZOMBIE_HEAD");
        items.add("ELYTRA");
        items.add("TURTLE_HELMET");
        items.add("CHORUS_FRUIT");
        items.add("ARMS_UP_POTTERY_SHERD");
        items.add("BREWER_POTTERY_SHERD");
        items.add("DRAGON_BREATH");
        items.add("ECHO_SHARD");
        items.add("HEAVY_CORE");
        items.add("NETHER_STAR");
        items.add("NETHERITE_UPGRADE_SMITHING_TEMPLATE");
        items.add("POPPED_CHORUS_FRUIT");
        items.add("SHULKER_SHELL");
        items.add("SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("TIDE_ARMOR_TRIM_SMITHING_TEMPLATE");
        items.add("WARD_ARMOR_TRIM_SMITHING_TEMPLATE");
        return items;
    }

}
