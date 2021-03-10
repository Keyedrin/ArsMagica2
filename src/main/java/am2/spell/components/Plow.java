package am2.spell.components;

import am2.AMCore;
import am2.api.ArsMagicaApi;
import am2.api.spell.component.interfaces.ISpellComponent;
import am2.api.spell.enums.Affinity;
import am2.items.ItemsCommonProxy;
import am2.particles.AMParticle;
import com.dunk.tfc.BlockSetup;
import com.dunk.tfc.Blocks.Flora.BlockFlower;
import com.dunk.tfc.Blocks.Flora.BlockFlower2;
import com.dunk.tfc.Core.Player.FoodStatsTFC;
import com.dunk.tfc.Core.TFC_Core;
import com.dunk.tfc.ItemSetup;
import com.dunk.tfc.TileEntities.TEFarmland;
import com.dunk.tfc.api.TFCBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.Random;

public class Plow implements ISpellComponent{

	@Override
	public boolean applyEffectBlock(ItemStack stack, World world, int blockx, int blocky, int blockz, int blockFace, double impactX, double impactY, double impactZ, EntityLivingBase caster){
		Block block = world.getBlock(blockx, blocky, blockz);
		Block blockAbove = world.getBlock(blockx, blocky + 1, blockz);

		boolean isDirt = TFC_Core.isDirt(block);
		boolean isFarmland = TFC_Core.isFarmland(block);
		if (blockFace == 1 && blockAbove.isAir(world, blockx, blocky + 1, blockz) && (TFC_Core.isGrass(block) || isDirt || isFarmland)){
			Block var10 = block != TFCBlocks.dirt && block != TFCBlocks.grass && block != TFCBlocks.dryGrass ? (block != TFCBlocks.dirt2 && block != TFCBlocks.grass2 && block != TFCBlocks.dryGrass2 ? null : TFCBlocks.dirt2) : TFCBlocks.dirt;
			if (var10 != null){
				int meta = world.getBlockMetadata(blockx, blocky, blockz);
				TEFarmland te;
				if (var10 == TFCBlocks.dirt){
					world.playSoundEffect((double)((float)blockx + 0.5F), (double)((float)blocky + 0.5F), (double)((float)blockz + 0.5F), var10.stepSound.getStepResourcePath(), (var10.stepSound.getVolume() + 1.0F) / 2.0F, var10.stepSound.getPitch() * 0.8F);
					if (world.isRemote){
						return true;
					}
					world.setBlock(blockx, blocky, blockz, TFCBlocks.tilledSoil, meta, 2);
					world.markBlockForUpdate(blockx, blocky, blockz);
					if (isDirt){
						te = (TEFarmland)world.getTileEntity(blockx, blocky, blockz);
						te.nutrients[0] = 100;
						te.nutrients[1] = 100;
						te.nutrients[2] = 100;
					}

					return true;
				}
				if (var10 == TFCBlocks.dirt2) {
					world.playSoundEffect((double)((float)blockx + 0.5F), (double)((float)blocky + 0.5F), (double)((float)blockz + 0.5F), var10.stepSound.getStepResourcePath(), (var10.stepSound.getVolume() + 1.0F) / 2.0F, var10.stepSound.getPitch() * 0.8F);
					if (world.isRemote) {
						return true;
					}

					world.setBlock(blockx, blocky, blockz, TFCBlocks.tilledSoil2, meta, 2);
					world.markBlockForUpdate(blockx, blocky, blockz);
					if (isDirt) {
						te = (TEFarmland)world.getTileEntity(blockx, blocky, blockz);
						te.nutrients[0] = 100;
						te.nutrients[1] = 100;
						te.nutrients[2] = 100;
					}

					return true;
				}
			} else if (isFarmland) {
				TEFarmland te = (TEFarmland)world.getTileEntity(blockx, blocky, blockz);
				if (te.fallow) {
					if (world.isRemote) {
						return true;
					}

					world.playSoundEffect((double)((float)blockx + 0.5F), (double)((float)blocky + 0.5F), (double)((float)blockz + 0.5F), block.stepSound.getStepResourcePath(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
					te.tillFallowLand();
				}
			}

			return false;
		} else {
			return false;
		}
	}


//		if ((block == Blocks.dirt || block == Blocks.grass)){
//			if (!(blockAbove == BlockSetup.tallGrass || blockAbove == BlockSetup.flowers || blockAbove == BlockSetup.flowers2)){
//				return false;
//			}
//			blockAbove.breakBlock(world, blockx, blocky+1, blockz, blockAbove, 0);
//			world.setBlock(blockx, blocky+1, blockz, Blocks.air);
//			if (!world.isRemote){
//				world.setBlock(blockx, blocky, blockz, Blocks.farmland);
//			}

	@Override
	public boolean applyEffectEntity(ItemStack stack, World world, EntityLivingBase caster, Entity target){
		return false;
	}

	@Override
	public float manaCost(EntityLivingBase caster){
		return 75;
	}

	@Override
	public float burnout(EntityLivingBase caster){
		return ArsMagicaApi.getBurnoutFromMana(manaCost(caster));
	}

	@Override
	public ItemStack[] reagents(EntityLivingBase caster){
		return null;
	}

	@Override
	public void spawnParticles(World world, double x, double y, double z, EntityLivingBase caster, Entity target, Random rand, int colorModifier){
		for (int i = 0; i < 10; ++i){
			AMParticle particle = (AMParticle)AMCore.proxy.particleManager.spawn(world, "rock", x, y + 1, z);
			if (particle != null){
				particle.addRandomOffset(1, 1, 1);
				particle.addVelocity(rand.nextDouble() * 0.2 - 0.1, 0.2f, rand.nextDouble() * 0.2 - 0.1);
				particle.setDontRequireControllers();
				particle.setAffectedByGravity();
				particle.setMaxAge(20);
				particle.setParticleScale(0.05f);
				if (colorModifier > -1){
					particle.setRGBColorF(((colorModifier >> 16) & 0xFF) / 255.0f, ((colorModifier >> 8) & 0xFF) / 255.0f, (colorModifier & 0xFF) / 255.0f);
				}
			}
		}
	}

	@Override
	public EnumSet<Affinity> getAffinity(){
		return EnumSet.of(Affinity.EARTH);
	}

	@Override
	public int getID(){
		return 42;
	}

	@Override
	public Object[] getRecipeItems(){
		return new Object[]{
				new ItemStack(ItemsCommonProxy.rune, 1, ItemsCommonProxy.rune.META_GREEN),
				ItemSetup.copperHoe,
				new ItemStack(ItemSetup.gemJade,1,2)
		};
	}

	@Override
	public float getAffinityShift(Affinity affinity){
		return 0.01f;
	}
}
