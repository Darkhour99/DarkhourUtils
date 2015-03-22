package darkhour99.darkhourutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DU_BlockOre extends Block
{
	private final String name;
	public DU_BlockOre(String unlocName)
	{
		super(Material.rock);
		this.name = unlocName;
		GameRegistry.registerBlock(this,name);
		this.setUnlocalizedName(unlocName);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public String getName()
	{
		return this.name;
	}
}
