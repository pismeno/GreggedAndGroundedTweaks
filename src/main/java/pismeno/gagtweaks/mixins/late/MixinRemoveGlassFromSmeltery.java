package pismeno.gagtweaks.mixins.late;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.gen.Invoker;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.smeltery.BucketCastingRecipe;
import slimeknights.tconstruct.library.smeltery.CastingRecipe;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import slimeknights.tconstruct.library.tinkering.MaterialItem;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.shared.TinkerCommons;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.shared.block.BlockSlime;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.smeltery.block.BlockSeared;
import slimeknights.tconstruct.smeltery.block.BlockSearedGlass;
import slimeknights.tconstruct.tools.TinkerMaterials;

import java.util.Set;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.*;
import static slimeknights.tconstruct.smeltery.TinkerSmeltery.registerToolpartMeltingCasting;

@Mixin(
        value = {TinkerSmeltery.class},
        remap = false
)
public class MixinRemoveGlassFromSmeltery {

    @Invoker("addKnownOreFluid")
    static void callAddKnownOreFluid(Fluid fluid, Set<Pair<String, Integer>> knownOres) {
        throw new AssertionError(); // Mixin will overwrite this at runtime
    }

    /**
     * @author PismenoK
     * @reason Removing Glass and Sand Melting Recipes.
     */
    @Overwrite
    private void registerMeltingCasting() {
        // used in several places to register fluids for the crafting recipe scan
        ImmutableSet.Builder<Pair<String, Integer>> builder;
        int bucket = Fluid.BUCKET_VOLUME;

        // bucket casting
        TinkerRegistry.registerTableCasting(new BucketCastingRecipe(Items.BUCKET));

        // Water
        Fluid water = FluidRegistry.WATER;
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(Blocks.ICE, bucket), water, 305));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(Blocks.PACKED_ICE, bucket * 2), water, 310));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(Blocks.SNOW, bucket), water, 305));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(Items.SNOWBALL, bucket / 8), water, 301));

        // bloooooood
        TinkerRegistry.registerMelting(Items.ROTTEN_FLESH, TinkerFluids.blood, 40);
        if(TinkerCommons.matSlimeBallBlood != null) {
            TinkerRegistry.registerTableCasting(TinkerCommons.matSlimeBallBlood.copy(), ItemStack.EMPTY, TinkerFluids.blood, 160);
        }

        // purple slime
        TinkerRegistry.registerMelting(TinkerCommons.matSlimeBallPurple, TinkerFluids.purpleSlime, Material.VALUE_SlimeBall);
        ItemStack slimeblock = new ItemStack(TinkerCommons.blockSlimeCongealed, 1, BlockSlime.SlimeType.PURPLE.meta);
        TinkerRegistry.registerMelting(slimeblock, TinkerFluids.purpleSlime, Material.VALUE_SlimeBall * 4);
        slimeblock = new ItemStack(TinkerCommons.blockSlime, 1, BlockSlime.SlimeType.PURPLE.meta);
        TinkerRegistry.registerMelting(slimeblock, TinkerFluids.purpleSlime, Material.VALUE_SlimeBall * 9);

        // seared stone, takes as long as a full block to melt, but gives less
        TinkerRegistry.registerMelting(MeltingRecipe.forAmount(RecipeMatch.of("stone", Material.VALUE_SearedMaterial),
                TinkerFluids.searedStone, Material.VALUE_Ore()));
        TinkerRegistry.registerMelting(MeltingRecipe.forAmount(RecipeMatch.of("cobblestone", Material.VALUE_SearedMaterial),
                TinkerFluids.searedStone, Material.VALUE_Ore()));

        // obsidian
        TinkerRegistry.registerMelting(MeltingRecipe.forAmount(RecipeMatch.of("obsidian", Material.VALUE_Ore()),
                TinkerFluids.obsidian, Material.VALUE_Ore()));
        // note that obsidian casting gives you 2 ingot value per obsidian, while part crafting only gives 1 per obsidian
        registerToolpartMeltingCasting(TinkerMaterials.obsidian);
        TinkerRegistry.registerBasinCasting(new ItemStack(Blocks.OBSIDIAN), ItemStack.EMPTY, TinkerFluids.obsidian, Material.VALUE_Ore());

        // gold is integrated via MaterialIntegration in TinkerIntegration now

        // special melting
        TinkerRegistry.registerMelting(Items.IRON_HORSE_ARMOR, TinkerFluids.iron, Material.VALUE_Ingot * 4);
        TinkerRegistry.registerMelting(Items.GOLDEN_HORSE_ARMOR, TinkerFluids.gold, Material.VALUE_Ingot * 4);

        // rails, some of these are caught through registerOredictMelting, but for consistency all are just registered here
        TinkerRegistry.registerMelting(Blocks.RAIL, TinkerFluids.iron, Material.VALUE_Ingot * 6 / 16);
        TinkerRegistry.registerMelting(Blocks.ACTIVATOR_RAIL, TinkerFluids.iron, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting(Blocks.DETECTOR_RAIL, TinkerFluids.iron, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting(Blocks.GOLDEN_RAIL, TinkerFluids.gold, Material.VALUE_Ingot);

        // register stone toolpart melting
        for(IToolPart toolPart : TinkerRegistry.getToolParts()) {
            if(toolPart.canBeCasted()) {
                if(toolPart instanceof MaterialItem) {
                    ItemStack stack = toolPart.getItemstackWithMaterial(TinkerMaterials.stone);
                    TinkerRegistry.registerMelting(MeltingRecipe.forAmount(
                            RecipeMatch.ofNBT(stack, (toolPart.getCost() * Material.VALUE_SearedMaterial) / Material.VALUE_Ingot),
                            TinkerFluids.searedStone, (int)(toolPart.getCost() * Config.oreToIngotRatio)));
                }
            }
        }

        // seared block casting and melting
        ItemStack blockSeared = new ItemStack(searedBlock);
        blockSeared.setItemDamage(BlockSeared.SearedType.STONE.getMeta());
        TinkerRegistry.registerTableCasting(TinkerCommons.searedBrick, castIngot, TinkerFluids.searedStone, Material.VALUE_SearedMaterial);
        TinkerRegistry.registerBasinCasting(blockSeared, ItemStack.EMPTY, TinkerFluids.searedStone, Material.VALUE_SearedBlock);

        ItemStack searedCobble = new ItemStack(searedBlock, 1, BlockSeared.SearedType.COBBLE.getMeta());
        TinkerRegistry.registerBasinCasting(new CastingRecipe(searedCobble, RecipeMatch.of("cobblestone"), TinkerFluids.searedStone, Material.VALUE_SearedBlock - Material.VALUE_SearedMaterial, true, false));

        // seared furnaces have an additional recipe above using a crafting table, to allow creation without a smeltery
        // this one is convenience for those with one
        TinkerRegistry.registerBasinCasting(new CastingRecipe(new ItemStack(searedFurnaceController),
                RecipeMatch.of(Blocks.FURNACE),
                new FluidStack(TinkerFluids.searedStone, Material.VALUE_SearedMaterial * 8),
                true, true));

        // seared glass convenience recipe
        TinkerRegistry.registerBasinCasting(new CastingRecipe(new ItemStack(searedGlass, 1, BlockSearedGlass.GlassType.GLASS.getMeta()),
                RecipeMatch.of("blockGlass"),
                new FluidStack(TinkerFluids.searedStone, Material.VALUE_SearedMaterial * 4),
                true, true));

        // basically a pseudo-oredict of the seared blocks to support wildcard value
        TinkerRegistry.registerMelting(searedBlock, TinkerFluids.searedStone, Material.VALUE_SearedBlock);
        TinkerRegistry.registerMelting(TinkerCommons.searedBrick, TinkerFluids.searedStone, Material.VALUE_SearedMaterial);
        TinkerRegistry.registerMelting(MeltingRecipe.forAmount(RecipeMatch.of(TinkerCommons.grout, Material.VALUE_SearedMaterial), TinkerFluids.searedStone, Material.VALUE_SearedMaterial / 3));

        // melt all the dirt into mud
        ItemStack stack = new ItemStack(Blocks.DIRT, 1, OreDictionary.WILDCARD_VALUE);
        RecipeMatch rm = new RecipeMatch.Item(stack, 1, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting(MeltingRecipe.forAmount(rm, TinkerFluids.dirt, Material.VALUE_BrickBlock));
        TinkerRegistry.registerTableCasting(TinkerCommons.mudBrick, castIngot, TinkerFluids.dirt, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting(TinkerCommons.mudBrick, TinkerFluids.dirt, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting(TinkerCommons.mudBrickBlock, TinkerFluids.dirt, Material.VALUE_BrickBlock);

        // hardened clay
        builder = ImmutableSet.builder();
        builder.add(Pair.of("clay", Material.VALUE_Ingot));
        builder.add(Pair.of("blockClay", Material.VALUE_BrickBlock));
        callAddKnownOreFluid(TinkerFluids.clay, builder.build());

        // decided against support for melting hardened clay. Once it's hardened, it stays hard. Same for bricks.
        //TinkerRegistry.registerMelting(Blocks.hardened_clay, TinkerFluids.clay, Material.VALUE_BrickBlock);
        //TinkerRegistry.registerMelting(Blocks.stained_hardened_clay, TinkerFluids.clay, Material.VALUE_BrickBlock);
        TinkerRegistry.registerBasinCasting(new ItemStack(Blocks.HARDENED_CLAY), ItemStack.EMPTY, TinkerFluids.clay, Material.VALUE_BrickBlock);
        // funny thing about hardened clay. If it's stained and you wash it with water, it turns back into regular hardened clay!
        TinkerRegistry.registerBasinCasting(new CastingRecipe(
                new ItemStack(Blocks.HARDENED_CLAY),
                RecipeMatch.of(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, OreDictionary.WILDCARD_VALUE)),
                new FluidStack(FluidRegistry.WATER, 250),
                150,
                true,
                false));
        // let's allow bricks because we're nice
        if(Config.castableBricks) {
            TinkerRegistry.registerTableCasting(new ItemStack(Items.BRICK), castIngot, TinkerFluids.clay, Material.VALUE_Ingot);
        }

        // emerald melting and casting
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of("oreEmerald", (int) (Material.VALUE_Gem * Config.oreToIngotRatio)), TinkerFluids.emerald));
        builder = ImmutableSet.builder();
        builder.add(Pair.of("gemEmerald", Material.VALUE_Gem));
        builder.add(Pair.of("blockEmerald", Material.VALUE_Gem * 9));
        callAddKnownOreFluid(TinkerFluids.emerald, builder.build());

        TinkerRegistry.registerTableCasting(new ItemStack(Items.EMERALD), castGem, TinkerFluids.emerald, Material.VALUE_Gem);
        TinkerRegistry.registerBasinCasting(new ItemStack(Blocks.EMERALD_BLOCK), ItemStack.EMPTY, TinkerFluids.emerald, Material.VALUE_Gem * 9);

        // lavawood
        TinkerRegistry.registerBasinCasting(new CastingRecipe(TinkerCommons.lavawood, RecipeMatch.of("plankWood"),
                new FluidStack(FluidRegistry.LAVA, 250),
                100, true, false));

        // red sand
        TinkerRegistry.registerBasinCasting(new CastingRecipe(new ItemStack(Blocks.SAND, 1, 1),
                RecipeMatch.of(new ItemStack(Blocks.SAND, 1, 0)),
                new FluidStack(TinkerFluids.blood, 10),
                true, false));

        // melt entities into a pulp
        TinkerRegistry.registerEntityMelting(EntityIronGolem.class, new FluidStack(TinkerFluids.iron, 18));
        TinkerRegistry.registerEntityMelting(EntitySnowman.class, new FluidStack(FluidRegistry.WATER, 100));
        TinkerRegistry.registerEntityMelting(EntityVillager.class, new FluidStack(TinkerFluids.emerald, 6));
        TinkerRegistry.registerEntityMelting(EntityVindicator.class, new FluidStack(TinkerFluids.emerald, 6));
        TinkerRegistry.registerEntityMelting(EntityEvoker.class, new FluidStack(TinkerFluids.emerald, 6));
        TinkerRegistry.registerEntityMelting(EntityIllusionIllager.class, new FluidStack(TinkerFluids.emerald, 6));
    }

}
