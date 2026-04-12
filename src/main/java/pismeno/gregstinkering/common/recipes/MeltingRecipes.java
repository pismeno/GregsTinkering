package pismeno.gregstinkering.common.recipes;

import java.util.*;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import pismeno.gregstinkering.Config;
import pismeno.gregstinkering.unification.GTCGregtechMaterials;
import slimeknights.tconstruct.library.TinkerRegistry;
import net.minecraft.item.ItemStack;

import static slimeknights.tconstruct.common.config.Config.oreToIngotRatio;

public class MeltingRecipes {
    public static void init() {
        if (Config.doAddOreMeltingRecipes) {
            addMeltingOres(tinOres, Materials.Tin.getFluid());
            addMeltingOres(copperOres, Materials.Copper.getFluid());
            addMeltingOres(leadOres, Materials.Lead.getFluid());
            addMeltingOres(silverOres, Materials.Silver.getFluid());
            addMeltingOres(goldOres, Materials.Gold.getFluid());
            addMeltingOres(nickelOres, Materials.Nickel.getFluid());
            addMeltingOres(ironOres, Materials.Iron.getFluid());
            addMeltingOres(arditeOres, GTCGregtechMaterials.Ardite.getFluid());
            addMeltingOres(cobaltOres, Materials.Cobalt.getFluid());
        }
    }

    private MeltingRecipes() {}

    private static final Map<Integer, List<Material>> tinOres = new HashMap<>() {{
        put(1, Arrays.asList(Materials.Tin));
        put(2, Arrays.asList(Materials.Cassiterite, Materials.CassiteriteSand));
    }};

    private static final Map<Integer, List<Material>> copperOres = new HashMap<>() {{
        put(1, Arrays.asList(
                Materials.Copper,
                Materials.Chalcopyrite,
                Materials.Tetrahedrite,
                Materials.Chalcocite,
                Materials.Malachite
        ));
    }};

    private static final Map<Integer, List<Material>> ironOres = new HashMap<>() {{
        put(1, Arrays.asList(
                Materials.Pyrite,
                Materials.BandedIron,
                Materials.BasalticMineralSand,
                Materials.GraniticMineralSand,
                Materials.Magnetite,
                Materials.BrownLimonite,
                Materials.YellowLimonite
        ));
    }};

    private static final Map<Integer, List<Material>> leadOres = new HashMap<>() {{
        put(1, Arrays.asList(Materials.Lead, Materials.Galena));
    }};

    private static final Map<Integer, List<Material>> goldOres = new HashMap<>() {{
        put(1, Arrays.asList(Materials.Gold));
    }};

    private static final Map<Integer, List<Material>> nickelOres = new HashMap<>() {{
        put(1, Arrays.asList(Materials.Nickel));
    }};

    private static final Map<Integer, List<Material>> silverOres = new HashMap<>() {{
        put(1, Arrays.asList(Materials.Silver));
    }};

    private static final Map<Integer, List<Material>> arditeOres = new HashMap<>() {{
        put(1, Arrays.asList(GTCGregtechMaterials.Ardite));
    }};

    private static final Map<Integer, List<Material>> cobaltOres = new HashMap<>() {{
        put(1, Arrays.asList(Materials.Cobalt));
    }};


    public static void addMeltingOres(Map<Integer, List<Material>> oreMap, Fluid fluid) {
        for (Map.Entry<Integer, List<Material>> entry : oreMap.entrySet()) {
            int key = entry.getKey();
            for (Material material : entry.getValue()) {
                double oreRatio = oreToIngotRatio;
                double dustRatio = 1.0; // All dusts now have a ratio of 1.0

                int oreAmount = (int) (oreRatio * 144 * key);
                int dustAmount = (int) (dustRatio * 144 * key);

                Item ore = OreDictUnifier.get(new UnificationEntry(OrePrefix.ore, material)).getItem();

                Map<OrePrefix, ItemStack> oreVariants = new HashMap<>();
                for (OrePrefix prefix : Arrays.asList(
                        OrePrefix.crushed, OrePrefix.crushedPurified, OrePrefix.dust,
                        OrePrefix.dustSmall, OrePrefix.dustTiny, OrePrefix.dustImpure,
                        OrePrefix.crushedCentrifuged)) {
                    oreVariants.put(prefix, OreDictUnifier.get(new UnificationEntry(prefix, material)));
                }

                TinkerRegistry.registerMelting(new ItemStack(ore, 1, 0), fluid, oreAmount);
                TinkerRegistry.registerMelting(new ItemStack(ore, 1, 1), fluid, oreAmount * 2);
                TinkerRegistry.registerMelting(new ItemStack(ore, 1, 2), fluid, oreAmount * 2);
                TinkerRegistry.registerMelting(oreVariants.get(OrePrefix.crushed), fluid, oreAmount);
                TinkerRegistry.registerMelting(oreVariants.get(OrePrefix.crushedPurified), fluid, oreAmount);

                TinkerRegistry.registerMelting(oreVariants.get(OrePrefix.dust), fluid, dustAmount);
                TinkerRegistry.registerMelting(oreVariants.get(OrePrefix.dustImpure), fluid, dustAmount);
                TinkerRegistry.registerMelting(oreVariants.get(OrePrefix.crushedCentrifuged), fluid, dustAmount);
                TinkerRegistry.registerMelting(oreVariants.get(OrePrefix.dustSmall), fluid, dustAmount / 4);
                TinkerRegistry.registerMelting(oreVariants.get(OrePrefix.dustTiny), fluid, dustAmount / 9);
            }
        }
    }
}
