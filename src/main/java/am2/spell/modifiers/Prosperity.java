package am2.spell.modifiers;

import am2.api.spell.component.interfaces.ISpellModifier;
import am2.api.spell.enums.SpellModifiers;
import am2.items.ItemsCommonProxy;
import com.dunk.tfc.ItemSetup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.EnumSet;

//TODO Make new fortune effect that gives a chance at doubling and increases gem drop rates from stone

public class Prosperity implements ISpellModifier{
	@Override
	public EnumSet<SpellModifiers> getAspectsModified(){
		return EnumSet.of(SpellModifiers.FORTUNE_LEVEL);
	}

	@Override
	public float getModifier(SpellModifiers type, EntityLivingBase caster, Entity target, World world, byte[] metadata){
		return 1;
	}

	@Override
	public int getID(){
		return 16;
	}

	@Override
	public Object[] getRecipeItems(){
		return new Object[]{
				ItemSetup.goldIngot,
				new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_BASE_CORE),
				ItemSetup.silverIngot
		};
	}

	@Override
	public float getManaCostMultiplier(ItemStack spellStack, int stage, int quantity){
		return 1.25f * quantity;
	}

	@Override
	public byte[] getModifierMetadata(ItemStack[] matchedRecipe){
		return null;
	}
}
