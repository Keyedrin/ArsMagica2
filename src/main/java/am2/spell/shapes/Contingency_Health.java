package am2.spell.shapes;

import am2.api.spell.ItemSpellBase;
import am2.api.spell.component.interfaces.ISpellShape;
import am2.api.spell.enums.Affinity;
import am2.api.spell.enums.ContingencyTypes;
import am2.api.spell.enums.SpellCastResult;
import am2.blocks.BlocksCommonProxy;
import am2.items.ItemsCommonProxy;
import am2.playerextensions.ExtendedProperties;
import am2.spell.SpellUtils;
import com.dunk.tfc.BlockSetup;
import com.dunk.tfc.ItemSetup;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Contingency_Health implements ISpellShape{

	@Override
	public int getID(){
		return 14;
	}

	@Override
	public Object[] getRecipeItems(){
		return new Object[]{
				ItemSetup.brassClock,
				ItemSetup.honeyBrandy,
				new ItemStack(BlockSetup.flowers,1,4),
				Items.redstone,
				"E:*", 5000,
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_LIFE)
		};
	}

	@Override
	public SpellCastResult beginStackStage(ItemSpellBase item, ItemStack stack, EntityLivingBase caster, EntityLivingBase target, World world, double x, double y, double z, int side, boolean giveXP, int useCount){
		ExtendedProperties.For(target != null ? target : caster).setContingency(ContingencyTypes.HEALTH_LOW, SpellUtils.instance.popStackStage(stack));
		return SpellCastResult.SUCCESS;
	}

	@Override
	public boolean isChanneled(){
		return false;
	}

	@Override
	public float manaCostMultiplier(ItemStack spellStack){
		return 10;
	}

	@Override
	public boolean isTerminusShape(){
		return false;
	}

	@Override
	public boolean isPrincipumShape(){
		return true;
	}

	@Override
	public String getSoundForAffinity(Affinity affinity, ItemStack stack, World world){
		return "arsmagica2:spell.contingency.contingency";
	}
}