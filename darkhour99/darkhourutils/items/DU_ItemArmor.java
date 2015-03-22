package darkhour99.darkhourutils.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DU_ItemArmor extends ItemArmor 
{
	private final String name;
	
	public DU_ItemArmor(String unlocName, ArmorMaterial aMat, int type)
	{
		super(aMat, 0, type);
		this.name = unlocName;// + (type == 0 ? "Helmet" : type == 1 ? "Chestplate" : type == 2 ? "Leggings" : "Boots");
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public String getName()
	{
		return this.name;
	}
}
