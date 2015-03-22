package darkhour99.darkhourutils.items;

import darkhour99.darkhourutils.lib.DU_Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DU_ItemSword extends ItemSword
{
	private final String name;
	
	public DU_ItemSword(String unlocName, ToolMaterial tMat)
	{
		super(tMat);
		this.name = unlocName;
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(DU_Constants.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public String getName()
	{
		return this.name;
	}
}
