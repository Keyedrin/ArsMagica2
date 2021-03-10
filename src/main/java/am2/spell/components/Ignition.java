package am2.spell.components;

import am2.AMCore;
import am2.api.spell.component.interfaces.ISpellComponent;
import am2.api.spell.enums.Affinity;
import am2.api.spell.enums.SpellModifiers;
import am2.items.ItemsCommonProxy;
import am2.particles.AMParticle;
import am2.spell.SpellUtils;
import com.dunk.tfc.Core.TFC_Core;
import com.dunk.tfc.ItemSetup;
import com.dunk.tfc.TileEntities.TEPottery;
import com.dunk.tfc.api.TFCBlocks;
import com.dunk.tfc.api.TFCItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ignition implements ISpellComponent{

	@Override
	public boolean applyEffectBlock(ItemStack stack, World world, int blockx, int blocky, int blockz, int blockFace, double impactX, double impactY, double impactZ, EntityLivingBase caster){

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
		}
		//Adds compat for the TFC+ fire starting
		if (!world.isRemote){
			Block block = world.getBlock(blockx, blocky, blockz);
			boolean surroundSolids = TFC_Core.isSurroundedSolid(world, blockx, blocky, blockz);
			if ((block != TFCBlocks.charcoal || world.getBlockMetadata(blockx, blocky, blockz) <= 6) && block != Blocks.coal_block){
				if (block == TFCBlocks.pottery && surroundSolids){
					TEPottery te = (TEPottery)world.getTileEntity(blockx, blocky, blockz);
					te.startPitFire();
					return true;
				}
				if (blockFace == 1 && TFC_Core.isTopFaceSolid(world, blockx, blocky, blockz) && world.isAirBlock(blockx, blocky + 1, blockz) && block.getMaterial() != Material.wood && block.getMaterial() != Material.cloth) {
					List list = world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox((double)blockx, (double)(blocky + 1), (double)blockz, (double)(blockx + 1), (double)(blocky + 2), (double)(blockz + 1)));
					int numsticks = 0;
					if (list != null && !list.isEmpty()) {
						Iterator iterator = list.iterator();

						EntityItem entity;
						while(iterator.hasNext()) {
							entity = (EntityItem)iterator.next();
							if (entity.getEntityItem().getItem() == TFCItems.stick) {
								numsticks += entity.getEntityItem().stackSize;
							}
						}

						if (numsticks >= 3) {
							iterator = list.iterator();

							while(true) {
								do {
									if (!iterator.hasNext()) {
										world.setBlock(blockx, blocky + 1, blockz, TFCBlocks.firepit, 1, 2);
										if (world.isRemote) {
											world.markBlockForUpdate(blockx, blocky + 1, blockz);
										}

										return true;
									}

									entity = (EntityItem)iterator.next();
								} while(entity.getEntityItem().getItem() != TFCItems.stick && entity.getEntityItem().getItem() != TFCItems.straw);

								entity.setDead();
							}
						}
					}
				}
			} else if (TFC_Core.isSurroundedStone(world, blockx, blocky, blockz) && surroundSolids) {
				world.setBlock(blockx, blocky, blockz, TFCBlocks.forge, 1, 2);
				return true;
			}
		}
		Block block = world.getBlock(blockx, blocky, blockz);
		if (world.isAirBlock(blockx, blocky, blockz) || block == Blocks.snow || block instanceof BlockFlower){
			if (!world.isRemote) world.setBlock(blockx, blocky, blockz, Blocks.fire);
			return true;
		}else{
			blocky++;
			block = world.getBlock(blockx, blocky, blockz);
			if (world.isAirBlock(blockx, blocky, blockz) || block == Blocks.snow || block instanceof BlockFlower){
				if (!world.isRemote) world.setBlock(blockx, blocky, blockz, Blocks.fire);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean applyEffectEntity(ItemStack stack, World world, EntityLivingBase caster, Entity target){
		int burnTime = SpellUtils.instance.getModifiedInt_Mul(3, stack, caster, target, world, 0, SpellModifiers.DURATION);
		burnTime = SpellUtils.instance.modifyDurationBasedOnArmor(caster, burnTime);
		if (target.isBurning()){
			return false;
		}
		target.setFire(burnTime);
		return true;
	}

	@Override
	public float manaCost(EntityLivingBase caster){
		return 35;
	}

	@Override
	public float burnout(EntityLivingBase caster){
		return 10;
	}

	@Override
	public ItemStack[] reagents(EntityLivingBase caster){
		return null;
	}

	@Override
	public void spawnParticles(World world, double x, double y, double z, EntityLivingBase caster, Entity target, Random rand, int colorModifier){
		for (int i = 0; i < 5; ++i){
			AMParticle particle = (AMParticle)AMCore.proxy.particleManager.spawn(world, "explosion_2", x + 0.5, y + 0.5, z + 0.5);
			if (particle != null){
				particle.addRandomOffset(1, 0.5, 1);
				particle.addVelocity(rand.nextDouble() * 0.2 - 0.1, 0.3, rand.nextDouble() * 0.2 - 0.1);
				particle.setAffectedByGravity();
				particle.setDontRequireControllers();
				particle.setMaxAge(5);
				particle.setParticleScale(0.1f);
				if (colorModifier > -1){
					particle.setRGBColorF(((colorModifier >> 16) & 0xFF) / 255.0f, ((colorModifier >> 8) & 0xFF) / 255.0f, (colorModifier & 0xFF) / 255.0f);
				}
			}
		}
	}

	@Override
	public EnumSet<Affinity> getAffinity(){
		return EnumSet.of(Affinity.FIRE);
	}

	@Override
	public int getID(){
		return 26;
	}

	@Override
	public Object[] getRecipeItems(){
		return new Object[]{
				new ItemStack(ItemsCommonProxy.rune, 1, ItemsCommonProxy.rune.META_ORANGE),
				ItemSetup.flintSteel
		};
	}

	@Override
	public float getAffinityShift(Affinity affinity){
		return 0.01f;
	}

}
