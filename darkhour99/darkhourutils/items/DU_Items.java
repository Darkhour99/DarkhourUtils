package darkhour99.darkhourutils.items;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import darkhour99.darkhourutils.helpers.DU_OrePipeline;

public final class DU_Items 
{
	private final static int hasTools = 1, hasArmor = 2;
	
	public static ToolMaterial TITANIUM_T = EnumHelper.addToolMaterial("TITANIUM",2,1200,9.0F,7.0F,11);
	public static ToolMaterial MITHRIL_T = EnumHelper.addToolMaterial("MITHRIL", 5, 800, 14F, 10F, 17);
	public static ToolMaterial URU_T = EnumHelper.addToolMaterial("URU", 9, 4000, 10F, 14F, 19);

	public static ArmorMaterial TITANIUM_A = EnumHelper.addArmorMaterial("TITANIUM","fuck you", 20,new int[]{4,7,5,2},17);//XXX "fuck you"
	
//	public static Item titaniumDust;
//	public static Item titaniumIngot;
	
	public static Item uruDust;
	public static Item uruIngot;
	
	public static ArrayList<Item> mythrilItems = new ArrayList<Item>();
	public static ArrayList<Item> titaniumItems = new ArrayList<Item>();
	
	
	public static void preinit()
	{	
		DU_OrePipeline.orePreinit(titaniumItems, "titanium", hasTools + hasArmor, TITANIUM_T, TITANIUM_A);
		DU_OrePipeline.orePreinit(mythrilItems, "mythril", hasTools, MITHRIL_T, (ArmorMaterial)null);
	}
	
	public static void init()
	{

		
		DU_OrePipeline.oreInit(titaniumItems,hasTools + hasArmor);

	}
	
}
