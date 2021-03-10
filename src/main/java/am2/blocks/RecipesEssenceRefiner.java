package am2.blocks;

import am2.items.ItemsCommonProxy;
import am2.items.RecipesArsMagica;
import com.dunk.tfc.BlockSetup;
import com.dunk.tfc.ItemSetup;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class RecipesEssenceRefiner extends RecipesArsMagica{
	private static final RecipesEssenceRefiner essenceExtractorRecipesBase = new RecipesEssenceRefiner();

	public static final RecipesEssenceRefiner essenceRefinement(){
		return essenceExtractorRecipesBase;
	}

	private RecipesEssenceRefiner(){
		RecipeList = new HashMap();
		InitRecipes();
	}

	private void InitRecipes(){
		//arcane essence
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ARCANE));
		//earth essence
		//TODO Any stone type in any slot
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemSetup.brick),
						new ItemStack(ItemSetup.brick),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemSetup.brick),
						new ItemStack(ItemSetup.brick)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_EARTH));
		//air essence
		AddRecipe(new ItemStack[]{
						new ItemStack(Items.feather),
						new ItemStack(BlockSetup.flowers),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(BlockSetup.flowers),
						new ItemStack(Items.feather)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_AIR));
		AddRecipe(new ItemStack[]{
						new ItemStack(BlockSetup.flowers),
						new ItemStack(Items.feather),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(Items.feather),
						new ItemStack(BlockSetup.flowers)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_AIR));
		//fire essence
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemSetup.coal,1,1),
						new ItemStack(ItemSetup.coal),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemSetup.coal),
						new ItemStack(ItemSetup.coal,1,1)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_FIRE));
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemSetup.coal),
						new ItemStack(ItemSetup.coal,1,1),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemSetup.coal,1,1),
						new ItemStack(ItemSetup.coal)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_FIRE));
		AddRecipe(new ItemStack[]{
						new ItemStack(BlockSetup.peat),
						new ItemStack(ItemSetup.coal,1,1),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemSetup.coal,1,1),
						new ItemStack(BlockSetup.peat)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_FIRE));
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemSetup.coal,1,1),
						new ItemStack(BlockSetup.peat),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(BlockSetup.peat),
						new ItemStack(ItemSetup.coal,1,1)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_FIRE));
		//water essence
		AddRecipe(new ItemStack[]{
						new ItemStack(BlockSetup.lilyPad),
						new ItemStack(ItemSetup.waterBottle),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemSetup.waterBottle),
						new ItemStack(BlockSetup.lilyPad)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_WATER));

		AddRecipe(new ItemStack[]{
						new ItemStack(ItemSetup.waterBottle),
						new ItemStack(BlockSetup.lilyPad),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(BlockSetup.lilyPad),
						new ItemStack(ItemSetup.waterBottle)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_WATER));
		//ice essence
		//TODO replace ice with something else as ice is not easily harvested
		AddRecipe(new ItemStack[]{
						new ItemStack(Blocks.snow),
						new ItemStack(BlockSetup.ice),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(BlockSetup.ice),
						new ItemStack(Blocks.snow)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ICE));
		AddRecipe(new ItemStack[]{
						new ItemStack(Blocks.ice),
						new ItemStack(Blocks.snow),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(Blocks.snow),
						new ItemStack(Blocks.ice)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ICE));
		//lightning essence
		AddRecipe(new ItemStack[]{
						new ItemStack(Items.redstone),
						new ItemStack(ItemSetup.magneticNeedle),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemSetup.magneticNeedle),
						new ItemStack(Items.redstone),
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_LIGHTNING));
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemSetup.magneticNeedle),
						new ItemStack(Items.redstone),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(Items.redstone),
						new ItemStack(ItemSetup.magneticNeedle),
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_LIGHTNING));
		//plant essence
		//TODO Any combo of flowers or flowers2
		AddRecipe(new ItemStack[]{
						new ItemStack(BlockSetup.leaves, 1, -1),
						new ItemStack(BlockSetup.flowers2, 1,-1),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(BlockSetup.flowers,1,-1),
						new ItemStack(BlockSetup.tallGrass,1,-1)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_NATURE));
		//life essence
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemSetup.sterileBandage),
						new ItemStack(ItemSetup.woodenBucketHoney),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemSetup.woodenBucketHoney),
						new ItemStack(ItemSetup.sterileBandage)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_LIFE));
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemSetup.woodenBucketHoney),
						new ItemStack(ItemSetup.sterileBandage),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemSetup.sterileBandage),
						new ItemStack(ItemSetup.woodenBucketHoney),
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_LIFE));
		//ender essence
		AddRecipe(new ItemStack[]{
						new ItemStack(Items.ender_pearl),
						new ItemStack(Items.ender_eye),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(Items.ender_eye),
						new ItemStack(Items.ender_pearl)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ENDER));
		AddRecipe(new ItemStack[]{
						new ItemStack(Items.ender_eye),
						new ItemStack(Items.ender_pearl),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(Items.ender_pearl),
						new ItemStack(Items.ender_eye)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ENDER));

		//base essence core
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_AIR),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_WATER),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_FIRE),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_EARTH)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_BASE_CORE));
		//high essence core
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_LIGHTNING),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ICE),
						new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_NATURE),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ARCANE)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_HIGH_CORE));
		//pure essence
		AddRecipe(new ItemStack[]{
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_HIGH_CORE),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_LIFE),
						new ItemStack(ItemSetup.gemDiamond,1,-1),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ENDER),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_BASE_CORE)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_PURE));

		AddRecipe(new ItemStack[]{
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_HIGH_CORE),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ENDER),
						new ItemStack(ItemSetup.gemDiamond,1,2),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_LIFE),
						new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_BASE_CORE)
				},
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_PURE));

		//deficit crystal
		AddRecipe(new ItemStack[]{
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ENDER),
				new ItemStack(Items.gunpowder),
				new ItemStack(ItemSetup.gemEmerald,1,2),
				new ItemStack(ItemSetup.leadIngot),
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ENDER),
		}, new ItemStack(ItemsCommonProxy.deficitCrystal));

		AddRecipe(new ItemStack[]{
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ENDER),
				new ItemStack(ItemSetup.leadIngot),
				new ItemStack(ItemSetup.gemEmerald),
				new ItemStack(Items.gunpowder),
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_ENDER),
		}, new ItemStack(ItemsCommonProxy.deficitCrystal));
		//gem upgrading

		//TODO 2 chipped, 3 vinteum = 1 flawed
		// 2 flawed, 2 vinteum, 1 arcane ash = 1 normal
		// 2 normal, 2 arcane ash, 1 pure vinteum = 1 flawless
		// 2 flawless, 3 pure vinteum = 1 exquisite

		//agate
		AddRecipe(new ItemStack[]{
				new ItemStack(ItemSetup.gemAgate,1,0),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_VINTEUMDUST),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_VINTEUMDUST),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_VINTEUMDUST),
				new ItemStack(ItemSetup.gemAgate,1,0),
		}, new ItemStack(ItemSetup.gemAgate,1,1));

		AddRecipe(new ItemStack[]{
				new ItemStack(ItemSetup.gemAgate,1,1),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_VINTEUMDUST),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_ARCANEASH),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_VINTEUMDUST),
				new ItemStack(ItemSetup.gemAgate,1,1),
		}, new ItemStack(ItemSetup.gemAgate,1,2));

		AddRecipe(new ItemStack[]{
				new ItemStack(ItemSetup.gemAgate,1,2),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_ARCANEASH),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_PURIFIEDVINTEUM),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_ARCANEASH),
				new ItemStack(ItemSetup.gemAgate,1,2),
		}, new ItemStack(ItemSetup.gemAgate,1,3));

		AddRecipe(new ItemStack[]{
				new ItemStack(ItemSetup.gemAgate,1,3),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_PURIFIEDVINTEUM),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_PURIFIEDVINTEUM),
				new ItemStack(ItemsCommonProxy.itemOre,1,ItemsCommonProxy.itemOre.META_PURIFIEDVINTEUM),
				new ItemStack(ItemSetup.gemAgate,1,3),
		}, new ItemStack(ItemSetup.gemAgate,1,4));
		//amethyst

		//beryl

		//diamond

		//emerald

		//garnet

		//jade

		//jasper

		//opal

		//ruby

		//sapphire

		//topaz

		//tourmaline
	}
}
