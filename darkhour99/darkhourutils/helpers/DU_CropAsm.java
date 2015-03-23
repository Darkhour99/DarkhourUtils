package darkhour99.darkhourutils.helpers;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import darkhour99.darkhourutils.blocks.DU_BlockCropTall;
import darkhour99.darkhourutils.items.DU_ItemSeeds;

public class DU_CropAsm extends DU_BaseAssembly{
	
	private final String baseName;
	
	private ArrayList<Block> cropBlock = new ArrayList<Block>();
	private Item seed, fruit;
	
	private final DU_IHasStrains strainType;
	
	public DU_CropAsm(String base, DU_IHasStrains type)
	{
		this.baseName = base;
		this.strainType = type;
	}

	@Override
	public void preinitBlocks() {
		for(int i = 0; i < strainType.getLength(); ++i)
		{
			cropBlock.add(new DU_BlockCropTall(this.baseName + "Crop", this.baseName + "Seeds",this.baseName + "Fruit",strainType.getStrainFromIndex(i)));
		}
	}

	@Override
	public void preinitItems() {
		// TODO Auto-generated method stub
		this.seed = new DU_ItemSeeds(this.baseName + "Seeds",this.baseName + "Crop", strainType);
		
	}

	@Override
	protected void registerRenderItems() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void registerRecipes() {
		// TODO Auto-generated method stub
		
	}
	

	
}
