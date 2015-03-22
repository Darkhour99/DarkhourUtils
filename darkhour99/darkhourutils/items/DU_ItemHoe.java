package darkhour99.darkhourutils.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import darkhour99.darkhourutils.lib.DU_Constants;

public class DU_ItemHoe extends ItemHoe 
{
	private final String name;
	
	public DU_ItemHoe(String unlocName, ToolMaterial tMat)
	{
		super(tMat);
		this.name = unlocName;
		GameRegistry.registerItem(this,name);
		this.setUnlocalizedName(DU_Constants.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	public String getName()
	{
		return this.name;
	}
}
