package darkhour99.darkhourutils.items;

import darkhour99.darkhourutils.lib.DU_Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DU_ItemDust extends Item
{
	private final String name;
	
	public DU_ItemDust(String unlocName)
	{
		this.name = unlocName;
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(DU_Constants.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getName()
	{
		return this.name;
	}
}
