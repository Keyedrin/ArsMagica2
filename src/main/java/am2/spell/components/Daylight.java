package am2.spell.components;

import am2.api.spell.component.interfaces.ISpellComponent;
import am2.api.spell.enums.Affinity;
import am2.items.ItemsCommonProxy;
import com.dunk.tfc.Core.TFC_Time;
import com.dunk.tfc.ItemSetup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.EnumSet;
import java.util.Random;

public class Daylight implements ISpellComponent{

	@Override
	public Object[] getRecipeItems(){
		return new Object[]{
				new ItemStack(ItemSetup.gemTopaz, 1, 4),
				ItemSetup.brassClock,
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_PURE)
		};
	}

	@Override
	public int getID(){
		return 64;
	}

	private boolean setDayTime(World world){
		if (world.isDaytime())
			return false;
		if (!world.isRemote){
			long currentTime = TFC_Time.getTotalTicks();
			int day = (int)(currentTime + (24000L - currentTime % 24000L));
			for(int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j) {
				MinecraftServer.getServer().worldServers[j].setWorldTime((long)day);
			}
		}
		return true;
	}

	@Override
	public boolean applyEffectBlock(ItemStack stack, World world, int blockx, int blocky, int blockz, int blockFace, double impactX, double impactY, double impactZ, EntityLivingBase caster){
		return setDayTime(world);
	}

	@Override
	public boolean applyEffectEntity(ItemStack stack, World world, EntityLivingBase caster, Entity target){
		return setDayTime(world);
	}

	@Override
	public float manaCost(EntityLivingBase caster){
		return 25000;
	}

	@Override
	public float burnout(EntityLivingBase caster){
		return 800;
	}

	@Override
	public ItemStack[] reagents(EntityLivingBase caster){
		return null;
	}

	@Override
	public void spawnParticles(World world, double x, double y, double z, EntityLivingBase caster, Entity target, Random rand, int colorModifier){

	}

	@Override
	public EnumSet<Affinity> getAffinity(){
		return EnumSet.of(Affinity.NONE);
	}

	@Override
	public float getAffinityShift(Affinity affinity){
		return 0;
	}

}
