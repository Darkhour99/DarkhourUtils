package darkhour99.darkhourutils.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import darkhour99.darkhourutils.helpers.DU_IHasStrains;
import darkhour99.darkhourutils.lib.DU_Constants;

public class DU_BlockCropTall extends BlockBush implements IGrowable 
{
	private final String name;
	private String fruitOfThis, seedOfThis;
	private final DU_IHasStrains strainType;
	
	public static final PropertyInteger GROWTH = PropertyInteger.create("growth", 0, 15);
	
	public DU_BlockCropTall(String unlocName, String seed, String fruit, DU_IHasStrains strain)
	{
		this.name = unlocName;
		this.seedOfThis = seed;
		this.fruitOfThis = seed;
		this.strainType = strain;
		
		this.setTickRandomly(true);
		this.setCreativeTab((CreativeTabs)null);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGlass);
		this.disableStats();
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, unlocName + (strainType != (DU_IHasStrains)null ? "_" + strainType.toString() : ""));
	}
	
	public DU_BlockCropTall(String unlocName, String seed, String fruit)
	{
		this(unlocName, seed, fruit, (DU_IHasStrains)null);
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block blockBelow) {
		return blockBelow == Blocks.farmland || blockBelow == this;
	}
	
	/**
	 * Returns distance block is from being the bottom
	 * block of the crop stalk
	 * @param world world the block is in
	 * @param pos pos of the block
	 * @return 0-2 (0 being bottom, 2 being top) or -1 for
	 * 		non valid positions (no farmland, too high etc)
	 */
	public int blocksFromBottom(World world, BlockPos pos)
	{
		for(int i = 1; i <= 3; ++i){
			if(world.getBlockState(pos).getBlock() == Blocks.farmland)
				return i - 1;
		}
		return -1;
	}
	

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos,
			IBlockState state, Block neighborBlock) 
	{
		this.checkAndDropBlock(worldIn, pos, state);
		int blocksFromBottom = this.blocksFromBottom(worldIn, pos);
		int metadata = ((Integer)state.getValue(GROWTH)).intValue();
		Block aboveBlock = worldIn.getBlockState(pos).getBlock();
		
		if(blocksFromBottom == 0 && metadata > 2 && aboveBlock != this)
		{
			//TODO drop fruit on break
			state.withProperty(GROWTH, 2);
		}
		else if(blocksFromBottom == 1 && metadata > 9 && aboveBlock != this)
		{
			//TODO drop fruit on break
			worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).withProperty(GROWTH, 4);
			state.withProperty(GROWTH, 9);
		}
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state,
			Random rand) {
		this.checkAndDropBlock(worldIn, pos, state);
		
		if(worldIn.getLight(pos) >= 9 && this.blocksFromBottom(worldIn, pos) == 0)
		{
			int metadata = ((Integer)state.getValue(GROWTH)).intValue();
			
			if(metadata < 2)
			{
				float growthPoints = this.getGrowthPoints(this,worldIn, pos);
				if(worldIn.rand.nextInt((int)(25.0F / growthPoints) + 1) == 0)
				{
					++metadata;
					state.withProperty(GROWTH, Integer.valueOf(metadata));
				}
			}
			else if(metadata == 2)
			{
				if(!worldIn.isAirBlock(pos.offset(EnumFacing.UP)))
					return;
				
				float growthPoints = this.getGrowthPoints(this,worldIn, pos);
				
				if(worldIn.rand.nextInt((int)(25.0F / growthPoints) + 1) == 0)
				{
					++metadata;
					state.withProperty(GROWTH, Integer.valueOf(metadata));
					worldIn.setBlockState(pos.offset(EnumFacing.UP), state.withProperty(GROWTH, Integer.valueOf(8)));
				}
				
			}
			else if(metadata < 4)
			{
				float growthPoints = this.getGrowthPoints(this,worldIn, pos);
				
				if(worldIn.rand.nextInt((int)(25.0F / growthPoints) + 1) == 0)
				{
					++metadata;
					state.withProperty(GROWTH, Integer.valueOf(metadata));
					worldIn.getBlockState(pos.offset(EnumFacing.UP)).withProperty(GROWTH, Integer.valueOf(metadata + 5));
				}
			}
			else if(metadata == 4)
			{
				if(!worldIn.isAirBlock(pos.offset(EnumFacing.UP)))
					return;
				
				float growthPoints = this.getGrowthPoints(this,worldIn, pos);
				
				if(worldIn.rand.nextInt((int)(25.0F / growthPoints) + 1) == 0)
				{
					++metadata;
					state.withProperty(GROWTH, Integer.valueOf(metadata));
					worldIn.getBlockState(pos.offset(EnumFacing.UP)).withProperty(GROWTH, Integer.valueOf(metadata + 5));
					worldIn.setBlockState(pos.offset(EnumFacing.UP,2), state.withProperty(GROWTH, Integer.valueOf(13)));
				}
			}
			else if(metadata < 7)
			{
				float growthPoints = this.getGrowthPoints(this,worldIn, pos);
				
				if(worldIn.rand.nextInt((int)(25.0F / growthPoints) + 1) == 0)
				{
					++metadata;
					state.withProperty(GROWTH, Integer.valueOf(metadata));
					worldIn.getBlockState(pos.offset(EnumFacing.UP)).withProperty(GROWTH, Integer.valueOf(metadata + 5));
					worldIn.getBlockState(pos.offset(EnumFacing.UP,2)).withProperty(GROWTH, Integer.valueOf(metadata + 8));
				}
			}
			else if(metadata == 7)
			{
				float growthPoints = this.getGrowthPoints(this,worldIn, pos);
				
				if(worldIn.rand.nextInt((int)(25.0F / growthPoints) + 1) == 0)
				{
					if(((Integer)worldIn.getBlockState(pos.offset(EnumFacing.UP)).getValue(GROWTH)).intValue() != 12)
						worldIn.getBlockState(pos.offset(EnumFacing.UP)).withProperty(GROWTH, Integer.valueOf(12));
					
					if(((Integer)worldIn.getBlockState(pos.offset(EnumFacing.UP,2)).getValue(GROWTH)).intValue() != 15)
						worldIn.getBlockState(pos.offset(EnumFacing.UP,2)).withProperty(GROWTH, Integer.valueOf(15));
				}
			}
		}
	}

	private float getGrowthPoints(Block blockIn, World worldIn, BlockPos pos)
	{
		float f = 1.0F;
        BlockPos blockpos1 = pos.down();

        for (int i = -1; i <= 1; ++i)
        {
            for (int j = -1; j <= 1; ++j)
            {
                float f1 = 0.0F;
                IBlockState iblockstate = worldIn.getBlockState(blockpos1.add(i, 0, j));

                if (iblockstate.getBlock().canSustainPlant(worldIn, blockpos1.add(i, 0, j), net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable)blockIn))
                {
                    f1 = 1.0F;

                    if (iblockstate.getBlock().isFertile(worldIn, blockpos1.add(i, 0, j)))
                    {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos2 = pos.north();
        BlockPos blockpos3 = pos.south();
        BlockPos blockpos4 = pos.west();
        BlockPos blockpos5 = pos.east();
        boolean flag = blockIn == worldIn.getBlockState(blockpos4).getBlock() || blockIn == worldIn.getBlockState(blockpos5).getBlock();
        boolean flag1 = blockIn == worldIn.getBlockState(blockpos2).getBlock() || blockIn == worldIn.getBlockState(blockpos3).getBlock();

        if (flag && flag1)
        {
            f /= 2.0F;
        }
        else
        {
            boolean flag2 = blockIn == worldIn.getBlockState(blockpos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos5.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos5.south()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock();

            if (flag2)
            {
                f /= 2.0F;
            }
        }

        return f;
	}
	
	@Override
	protected void checkAndDropBlock(World worldIn, BlockPos pos,
			IBlockState state) {
		if(!this.canBlockStay(worldIn, pos, state))
		{
			int metadata = ((Integer)state.getValue(GROWTH)).intValue();
			this.dropBlockAsItem(worldIn, pos, state, 0);
			if(metadata == 7 || metadata == 12 || metadata == 15)
				//TODO drop fruit
				
			worldIn.setBlockState(pos, Blocks.air.getDefaultState());
		}
	}

	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		Block belowBlock = worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock();
		
		if(this.canPlaceBlockOn(belowBlock))
		{
			return true;
		}
		return false;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Item.getByNameOrId(this.seedOfThis);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ) 
	{
		int metadata = ((Integer)state.getValue(GROWTH)).intValue();
		if(playerIn.inventory.getCurrentItem() != null)
		{
			return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
		}
		else if(metadata == 7 || metadata == 12 || metadata == 15)
		{
			int amtToDrop = metadata < 8 ? disadv(2) : metadata < 13 ? disadv(2) + 1 : disadv(3) + 1;
			if(playerIn.inventory.addItemStackToInventory(new ItemStack(fruitOfThis(),amtToDrop, this.metaOfItem())))
			{
				state.withProperty(GROWTH, metadata - 1);
				return true;
			}
		}
		return true;
	}
	
	private void dropFruitOnBreak(World worldIn, BlockPos pos)
	{
		//int blocksFromBottom = this.blocksFromBottom(world, pos)
	}
	
	private static int disadv(int max)
	{
		Random random = new Random();
		return Math.min(random.nextInt(max), random.nextInt(max)) + 1;
	}
	
	protected int metaOfItem()
	{
		if(strainType != (DU_IHasStrains)null)
			return this.strainType.getStrainIndex();
		return 0;
	}
	
	private Item seedOfThis()
	{
		return GameRegistry.findItem(DU_Constants.MODID, seedOfThis);
	}
	
	private Item fruitOfThis()
	{
		return GameRegistry.findItem(DU_Constants.MODID, fruitOfThis);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		super.setBlockBoundsBasedOnState(worldIn, pos);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos,
			IBlockState state, int fortune) {
		// TODO Auto-generated method stub
		return super.getDrops(world, pos, state, fortune);
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state,
			EntityPlayer player) {
		return false;
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state,
			boolean isClient) {
		int metadata = ((Integer)state.getValue(GROWTH)).intValue();
		return metadata != 7 && metadata != 12 && metadata != 15;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos,
			IBlockState state) {
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		//TODO this.forceGrow(worldIn, pos);
	}
}
