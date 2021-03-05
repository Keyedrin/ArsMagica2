package am2.spell.components;

import am2.api.spell.component.interfaces.ISpellComponent;
import am2.api.spell.enums.Affinity;
import am2.api.spell.enums.SpellModifiers;
import am2.buffs.BuffEffectSilence;
import am2.buffs.BuffList;
import am2.items.ItemsCommonProxy;
import am2.spell.SpellUtils;
import com.dunk.tfc.ItemSetup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.Random;

public class Silence implements ISpellComponent{

	@Override
	public Object[] getRecipeItems(){
		return new Object[]{
				ItemSetup.silkCloth,
				new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_ARCANEASH),
				ItemSetup.leatherHelmet,
				ItemSetup.woolCloth
		};
	}

	@Override
	public int getID(){
		return 73;
	}

	@Override
	public boolean applyEffectBlock(ItemStack stack, World world, int blockx, int blocky, int blockz, int blockFace, double impactX, double impactY, double impactZ, EntityLivingBase caster){
		return false;
	}

	@Override
	public boolean applyEffectEntity(ItemStack stack, World world, EntityLivingBase caster, Entity target){
		if (target instanceof EntityLivingBase && !(target instanceof IBossDisplayData)){
			if (!world.isRemote)
				((EntityLivingBase)target).addPotionEffect(new BuffEffectSilence(BuffList.default_buff_duration, SpellUtils.instance.countModifiers(SpellModifiers.BUFF_POWER, stack, 0)));
			return true;
		}
		return false;
	}

	@Override
	public float manaCost(EntityLivingBase caster){
		return 800;
	}

	@Override
	public float burnout(EntityLivingBase caster){
		return 25;
	}

	@Override
	public ItemStack[] reagents(EntityLivingBase caster){
		return new ItemStack[]{
				new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_PURIFIEDVINTEUM)
		};
	}

	@Override
	public void spawnParticles(World world, double x, double y, double z,
							   EntityLivingBase caster, Entity target, Random rand,
							   int colorModifier){

	}

	@Override
	public EnumSet<Affinity> getAffinity(){
		return EnumSet.of(Affinity.WATER, Affinity.ENDER);
	}

	@Override
	public float getAffinityShift(Affinity affinity){
		return 0.01f;
	}

}
