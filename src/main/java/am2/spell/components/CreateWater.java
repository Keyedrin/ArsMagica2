package am2.spell.components;

import am2.api.spell.component.interfaces.ISpellComponent;
import am2.api.spell.enums.Affinity;
import am2.items.ItemsCommonProxy;
import com.dunk.tfc.BlockSetup;
import com.dunk.tfc.ItemSetup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.Random;

public class CreateWater implements ISpellComponent{
	//TODO Split into Create Seawater and Create Fresh Water, add spell to create water in barrel/vessel before this
	@Override
	public boolean applyEffectBlock(ItemStack stack, World world, int blockx, int blocky, int blockz, int blockFace, double impactX, double impactY, double impactZ, EntityLivingBase caster){

		Block block = world.getBlock(blockx, blocky, blockz);

		if (block == Blocks.cauldron){
			world.setBlockMetadataWithNotify(blockx, blocky, blockz, 3, 2);
			world.notifyBlockChange(blockx, blocky, blockz, block);
			return true;
		}

		switch (blockFace){
		case 5:
			blockx++;
			break;
		case 2:
			blockz--;
			break;
		case 3:
			blockz++;
			break;
		case 4:
			blockx--;
			break;
		case 0:
			blocky--;
			break;
		case 1:
			blocky++;
			break;
		}

		block = world.getBlock(blockx, blocky, blockz);
		if (world.isAirBlock(blockx, blocky, blockz) || block == Blocks.snow || block == BlockSetup.freshWaterStationary || block == BlockSetup.freshWaterStationary || block instanceof BlockFlower){
			world.setBlock(blockx, blocky, blockz, BlockSetup.freshWaterStationary);
			BlockSetup.freshWaterStationary.onNeighborBlockChange(world, blockx, blocky, blockz, Blocks.air);
			return true;
		}
		return false;
	}

	@Override
	public boolean applyEffectEntity(ItemStack stack, World world, EntityLivingBase caster, Entity target){
		return false;
	}

	@Override
	public float manaCost(EntityLivingBase caster){
		return 25;
	}

	@Override
	public float burnout(EntityLivingBase caster){
		return 30;
	}

	@Override
	public ItemStack[] reagents(EntityLivingBase caster){
		return null;
	}

	@Override
	public void spawnParticles(World world, double x, double y, double z, EntityLivingBase caster, Entity target, Random rand, int colorModifier){
		for (int i = 0; i < 15; ++i){
			world.spawnParticle("splash", x - 0.5 + rand.nextDouble(), y, z - 0.5 + rand.nextDouble(), 0.5 - rand.nextDouble(), 0.1, 0.5 - rand.nextDouble());
		}
	}

	@Override
	public EnumSet<Affinity> getAffinity(){
		return EnumSet.of(Affinity.WATER);
	}

	@Override
	public int getID(){
		return 7;
	}

	@Override
	public Object[] getRecipeItems(){
		return new Object[]{
				new ItemStack(ItemsCommonProxy.rune, 1, ItemsCommonProxy.rune.META_BLUE),
				ItemSetup.redSteelBucketWater
		};
	}

	@Override
	public float getAffinityShift(Affinity affinity){
		return 0.001f;
	}
}
