package am2.items;

import am2.texture.ResourceManager;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.monster.IMob;
import net.minecraft.init.Items;

public class ItemMobFocus extends ItemFilterFocus{

	protected ItemMobFocus(){
		super();
	}

	@Override
	public Class getFilterClass(){
		return IMob.class;
	}

	@Override
	public Object[] getRecipeItems(){
		return new Object[]{
				"R",
				"F",
				"E",
				Character.valueOf('R'), Items.rotten_flesh,
				Character.valueOf('F'), ItemsCommonProxy.standardFocus,
				Character.valueOf('E'), Items.spider_eye
		};
	}

	@Override
	public String getInGameName(){
		return "Monster Focus";
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister){
		this.itemIcon = ResourceManager.RegisterTexture("focus_seer_monster", par1IconRegister);
	}

}
