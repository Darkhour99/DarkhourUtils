package darkhour99.darkhourutils.items;

import darkhour99.darkhourutils.helpers.DU_Assemblies;

public final class DU_Items 
{
		
	public static void preinit()
	{	
		DU_Assemblies.titaniumAssembly.preinitItems();
		DU_Assemblies.mithrilAssembly.preinitItems();
		DU_Assemblies.amberAssembly.preinitItems();
		
		DU_Assemblies.mariBlossomAssembly.preinitItems();
	}
	
	public static void init()
	{

		DU_Assemblies.titaniumAssembly.initItems();
		DU_Assemblies.mithrilAssembly.initItems();
		DU_Assemblies.amberAssembly.initItems();
		
		DU_Assemblies.mariBlossomAssembly.initItems();
	}
	
}
