package darkhour99.darkhourutils.helpers;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import darkhour99.darkhourutils.helpers.DU_OreAsm.EOreType;
import darkhour99.darkhourutils.lib.DU_Materials;

public class DU_Assemblies {
	public static DU_OreAsm titaniumAssembly  = new DU_OreAsm("titanium", EOreType.METAL, DU_OreAsm.hasTools + DU_OreAsm.hasArmor, DU_Materials.TITANIUM_T, DU_Materials.TITANIUM_A,2,3,30);
	public static DU_OreAsm mithrilAssembly = new DU_OreAsm("mythril", EOreType.METAL, DU_OreAsm.hasTools, DU_Materials.MITHRIL_T, (ArmorMaterial) null,2,3,30);
	public static DU_OreAsm amberAssembly = new DU_OreAsm("amber", EOreType.GEM, DU_OreAsm.hasTools + DU_OreAsm.hasArmor, DU_Materials.AMBER_T, DU_Materials.AMBER_A, 3,3,30,"amberGem",1,1);
	
}
