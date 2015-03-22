package darkhour99.darkhourutils.helpers;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class DU_Materials {
	public static ToolMaterial TITANIUM_T = EnumHelper.addToolMaterial("TITANIUM",2,1200,9.0F,7.0F,11);
	public static ToolMaterial MITHRIL_T = EnumHelper.addToolMaterial("MITHRIL", 5, 800, 14F, 10F, 17);
	public static ToolMaterial URU_T = EnumHelper.addToolMaterial("URU", 9, 4000, 10F, 14F, 19);

	public static ArmorMaterial TITANIUM_A = EnumHelper.addArmorMaterial("TITANIUM","fuck you", 20,new int[]{4,7,5,2},17);//XXX "fuck you"

}
