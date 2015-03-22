package darkhour99.darkhourutils.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import darkhour99.darkhourutils.lib.DU_Constants;

public final class DU_Items 
{
	public static Item titaniumDust;
	public static Item titaniumIngot;
	
	public static Item uruDust;
	public static Item uruIngot;
	
	
	public static void preinit()
	{
		titaniumDust = new DU_ItemDust("titaniumDust");
		titaniumIngot = new DU_ItemIngot("titaniumIngot");
		
		uruDust = new DU_ItemDust("uruDust");
		uruIngot = new DU_ItemIngot("uruIngot");
		
	}
	
	public static void init()
	{
		RenderItem renderTitaniumDust = Minecraft.getMinecraft().getRenderItem();	
		renderTitaniumDust.getItemModelMesher().register(titaniumDust, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemDust) titaniumDust).getName(), "inventory"));
		
		RenderItem renderTitaniumIngot = Minecraft.getMinecraft().getRenderItem();	
		renderTitaniumIngot.getItemModelMesher().register(titaniumIngot, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemIngot) titaniumIngot).getName(), "inventory"));

		
		RenderItem renderUruDust = Minecraft.getMinecraft().getRenderItem();	
		renderUruDust.getItemModelMesher().register(uruDust, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemDust) uruDust).getName(), "inventory"));
		
		RenderItem renderUruIngot = Minecraft.getMinecraft().getRenderItem();	
		renderUruIngot.getItemModelMesher().register(uruIngot, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemIngot) uruIngot).getName(), "inventory"));

	}
}
