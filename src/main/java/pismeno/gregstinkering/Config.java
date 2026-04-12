package pismeno.gregstinkering;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class Config {
    public static Configuration config;

    public static boolean doOverrideTconstructConfig = true;
    public static boolean doAddOreMeltingRecipes = true;
    public static boolean addMachineRecipesForTCMaterials = true;

    public static boolean TREATED_WOOD = true;
    public static boolean NAQUADAH_ALLOY = true;
    public static boolean STAINLESS_STEEL = true;
    public static boolean VANADIUM_STEEL = true;
    public static boolean DAMASCUS_STEEL = true;
    public static boolean TUNGSTEN_STEEL = true;
    public static boolean RED_STEEL = true;
    public static boolean BLUE_STEEL = true;
    public static boolean WROUGHT_IRON = true;
    public static boolean COBALT_BRASS = true;
    public static boolean DURANIUM = true;
    public static boolean ROSE_GOLD = true;
    public static boolean POLYVINYL_CHLORIDE = true;
    public static boolean ALUMINIUM = true;
    public static boolean HSSE = true;
    public static boolean INVAR = true;
    public static boolean ULTIMET = true;
    public static boolean STERLING_SILVER = true;
    public static boolean TUNGSTENCARBIDE = true;
    public static boolean NEUTRONIUM = true;
    public static boolean TITANIUM = true;
    public static boolean POLYETHYLENE = true;
    public static boolean RUBBER = true;
    public static boolean SYNTHETIC_RUBBER = true;

        public static void update(File file) {
        config = new Configuration(file);

        String category;

        category = "general";
        config.addCustomCategoryComment(category, "General settings");
        doOverrideTconstructConfig = config.getBoolean("overrideTConstructConfig", category, doOverrideTconstructConfig, "If true, overrides Tinker's Construct config (Disables Cobald and Ardite TConstruct ore gen, sets ore melting duplication to 1.0");
        doAddOreMeltingRecipes = config.getBoolean("doAddOreMeltingRecipes", category, doAddOreMeltingRecipes, "If true, adds ore melting recipes for Gregtech ores to Tinker's Smeltery.");
        addMachineRecipesForTCMaterials = config.getBoolean("addMachineRecipesForTCMaterials", category, addMachineRecipesForTCMaterials, "If true, this will add GT machine recipes for: bronze, iron, pigiron, copper, lead, steel, cobalt, ardite");

        category = "materials";
        String materialDesc = "Set this to false to disable the material.";
        config.addCustomCategoryComment(category, "Enable/Disable Tinker's Construct materials");
        TREATED_WOOD = config.getBoolean("TREATED_WOOD", category, TREATED_WOOD, materialDesc);
        NAQUADAH_ALLOY = config.getBoolean("NAQUADAH_ALLOY", category, NAQUADAH_ALLOY, materialDesc);
        STAINLESS_STEEL = config.getBoolean("STAINLESS_STEEL", category, STAINLESS_STEEL, materialDesc);
        VANADIUM_STEEL = config.getBoolean("VANADIUM_STEEL", category, VANADIUM_STEEL, materialDesc);
        DAMASCUS_STEEL = config.getBoolean("DAMASCUS_STEEL", category, DAMASCUS_STEEL, materialDesc);
        TUNGSTEN_STEEL = config.getBoolean("TUNGSTEN_STEEL", category, TUNGSTEN_STEEL, materialDesc);
        RED_STEEL = config.getBoolean("RED_STEEL", category, RED_STEEL, materialDesc);
        BLUE_STEEL = config.getBoolean("BLUE_STEEL", category, BLUE_STEEL, materialDesc);
        WROUGHT_IRON = config.getBoolean("WROUGHT_IRON", category, WROUGHT_IRON, materialDesc);
        COBALT_BRASS = config.getBoolean("COBALT_BRASS", category, COBALT_BRASS, materialDesc);
        DURANIUM = config.getBoolean("DURANIUM", category, DURANIUM, materialDesc);
        ROSE_GOLD = config.getBoolean("ROSE_GOLD", category, ROSE_GOLD, materialDesc);
        POLYVINYL_CHLORIDE = config.getBoolean("POLYVINYL_CHLORIDE", category, POLYVINYL_CHLORIDE, materialDesc);
        ALUMINIUM = config.getBoolean("ALUMINIUM", category, ALUMINIUM, materialDesc);
        HSSE = config.getBoolean("HSSE", category, HSSE, materialDesc);
        INVAR = config.getBoolean("INVAR", category, INVAR, materialDesc);
        ULTIMET = config.getBoolean("ULTIMET", category, ULTIMET, materialDesc);
        STERLING_SILVER = config.getBoolean("STERLING_SILVER", category, STERLING_SILVER, materialDesc);
        TUNGSTENCARBIDE = config.getBoolean("TUNGSTENCARBIDE", category, TUNGSTENCARBIDE, materialDesc);
        NEUTRONIUM = config.getBoolean("NEUTRONIUM", category, NEUTRONIUM, materialDesc);
        TITANIUM = config.getBoolean("TITANIUM", category, TITANIUM, materialDesc);
        POLYETHYLENE = config.getBoolean("POLYETHYLENE", category, POLYETHYLENE, materialDesc);
        RUBBER = config.getBoolean("RUBBER", category, RUBBER, materialDesc);
        SYNTHETIC_RUBBER = config.getBoolean("SYNTHETIC_RUBBER", category, SYNTHETIC_RUBBER, materialDesc);

        config.save();
    }

    public static void preInit(FMLPreInitializationEvent event) {
        File config;

        config = new File(event.getModConfigurationDirectory() + "/" + Tags.MODID);
        config.mkdirs();
        update(new File(config.getPath(), Tags.MODID + ".cfg"));
    }
}
