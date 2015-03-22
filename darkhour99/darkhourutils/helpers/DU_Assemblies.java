package darkhour99.darkhourutils.helpers;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import darkhour99.darkhourutils.helpers.DU_OreAsm.EOreType;

public class DU_Assemblies {
	public static DU_OreAsm titaniumAssembly  = new DU_OreAsm("titanium", EOreType.METAL, DU_OreAsm.hasTools + DU_OreAsm.hasArmor, DU_Materials.TITANIUM_T, DU_Materials.TITANIUM_A);
	public static DU_OreAsm mithrilAssembly = new DU_OreAsm("mythril", EOreType.METAL, DU_OreAsm.hasTools, DU_Materials.MITHRIL_T, (ArmorMaterial) null);

}
