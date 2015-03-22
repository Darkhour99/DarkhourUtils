package darkhour99.darkhourutils.items;

import darkhour99.darkhourutils.lib.DU_Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DU_ItemPickaxe extends ItemPickaxe
{
	private final String name;
	
	public DU_ItemPickaxe(String unlocName, ToolMaterial tMat)
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
