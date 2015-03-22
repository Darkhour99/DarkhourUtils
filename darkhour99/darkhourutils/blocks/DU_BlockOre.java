package darkhour99.darkhourutils.blocks;

import java.util.Random;

import darkhour99.darkhourutils.lib.DU_Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DU_BlockOre extends Block
{
	private final String name;
	private final String itemToDrop;
	private final int leastCanDrop, mostCanDrop;
	
	public DU_BlockOre(String unlocName, int harvest, int hardness
			,int resistance, String drop, int leastDrop, int mostDrop)
	{
		super(Material.rock);
		this.name = unlocName;
		GameRegistry.registerBlock(this,name);
		this.setUnlocalizedName(unlocName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		
		this.itemToDrop = drop;
		this.leastCanDrop = leastDrop;
		this.mostCanDrop = mostDrop;
		
		this.setHarvestLevel("pickaxe", harvest);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}
	
	public DU_BlockOre(String unlocName, int harvest, int hardness, int resistance)
	{
		this(unlocName, harvest, hardness, resistance, "", 1, 1);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(this.itemToDrop == "")
			return Item.getItemFromBlock(this);
		return GameRegistry.findItem(DU_Constants.MODID, itemToDrop);
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		if (this.leastCanDrop >= this.mostCanDrop)
			return (fortune > 0 ? 1 + (this.mostCanDrop * random.nextInt(fortune)) : this.mostCanDrop);
		if (fortune > 0)
			return this.leastCanDrop
					+ random.nextInt(this.mostCanDrop - this.leastCanDrop + 1)
					+ random.nextInt(fortune
							* (this.mostCanDrop - this.leastCanDrop));
		return this.leastCanDrop
				+ random.nextInt(this.mostCanDrop - this.leastCanDrop + 1);
	}

	public String getName()
	{
		return this.name;
	}
}
