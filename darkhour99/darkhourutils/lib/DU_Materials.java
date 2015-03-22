package darkhour99.darkhourutils.lib;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class DU_Materials {
	public static ToolMaterial TITANIUM_T = EnumHelper.addToolMaterial("TITANIUM",2,1200,9.0F,7.0F,11);
	public static ToolMaterial MITHRIL_T = EnumHelper.addToolMaterial("MITHRIL", 5, 800, 14F, 10F, 17);
	public static ToolMaterial URU_T = EnumHelper.addToolMaterial("URU", 9, 4000, 10F, 14F, 19);
	public static ToolMaterial AMBER_T = EnumHelper.addToolMaterial("AMBER", 3, 1300, 7F, 8F, 11);

	public static ArmorMaterial TITANIUM_A = EnumHelper.addArmorMaterial("TITANIUM",DU_Constants.MODID + ":titanium", 20,new int[]{4,7,5,2},17);
	public static ArmorMaterial AMBER_A = EnumHelper.addArmorMaterial("AMBER",DU_Constants.MODID + ":amber",20,new int[]{4,7,5,2},17);
}
