package darkhour99.darkhourutils.blocks;

import net.minecraft.block.Block;
import darkhour99.darkhourutils.helpers.DU_Assemblies;

public class DU_Blocks 
{
	public static Block titaniumOre;
	
	public static void preinit()
	{
		DU_Assemblies.titaniumAssembly.preinitBlocks();
		DU_Assemblies.mithrilAssembly.preinitBlocks();
		DU_Assemblies.amberAssembly.preinitBlocks();
		
		DU_Assemblies.mariBlossomAssembly.preinitBlocks();
	}

}
