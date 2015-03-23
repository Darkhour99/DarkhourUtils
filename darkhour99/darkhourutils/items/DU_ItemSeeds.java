package darkhour99.darkhourutils.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import darkhour99.darkhourutils.helpers.DU_IHasStrains;
import darkhour99.darkhourutils.lib.DU_Constants;

public class DU_ItemSeeds extends Item implements IPlantable
{
	private final String name;
	private final String cropName;
	private final DU_IHasStrains strainType;
	
	public DU_ItemSeeds(String unlocName, String crop, DU_IHasStrains strain)
	{
		this.name = unlocName;
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(DU_Constants.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabMisc);
		
		this.cropName = crop;
		this.strainType = strain;
		if(strain != (DU_IHasStrains)null)
		{
			this.setHasSubtypes(true);
		}
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) 
	{
		if(side != EnumFacing.UP)//must be top of the block
		{
			return false;
		}
		else if(playerIn.canPlayerEdit(pos, side, stack) && playerIn.canPlayerEdit(pos, side, stack))
		{
			if(worldIn.getBlockState(pos).getBlock().canSustainPlant(worldIn, pos, EnumFacing.UP, this))
			{
				worldIn.setBlockState(pos, this.getCrop(stack.getItemDamage()).getDefaultState());
				--stack.stackSize;
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		if(this.strainType != (DU_IHasStrains)null)
		{
			
			for(int i = 0; i < this.strainType.getLength(); ++i)
				list.add(new ItemStack(item, 1, i));
		}
		else
		{
			list.add(new ItemStack(item,1,0));
		}
	}

	private DU_IHasStrains getStrain(int damage)
	{
		return this.strainType != (DU_IHasStrains)null ? this.strainType.getStrainFromIndex(damage) : (DU_IHasStrains)null;
	}
	
	private Block getCrop(int itemDamage)
	{
		return Block.getBlockFromName(cropName);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return (IBlockState)null;
	}
}
