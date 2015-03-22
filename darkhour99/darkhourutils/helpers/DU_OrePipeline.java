package darkhour99.darkhourutils.helpers;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import darkhour99.darkhourutils.items.DU_ItemArmor;
import darkhour99.darkhourutils.items.DU_ItemAxe;
import darkhour99.darkhourutils.items.DU_ItemDust;
import darkhour99.darkhourutils.items.DU_ItemHoe;
import darkhour99.darkhourutils.items.DU_ItemIngot;
import darkhour99.darkhourutils.items.DU_ItemPickaxe;
import darkhour99.darkhourutils.items.DU_ItemScythe;
import darkhour99.darkhourutils.items.DU_ItemSpade;
import darkhour99.darkhourutils.items.DU_ItemSword;
import darkhour99.darkhourutils.lib.DU_Constants;

public class DU_OrePipeline 
{
	private DU_OrePipeline(){}
	
	
	public static void orePreinit(ArrayList<Item> items, String baseName, int setsFlag, ToolMaterial tMat, ArmorMaterial aMat)
	{
		createOreProducts(items, baseName);
		if(setsFlag % 2 > 0)
			createToolSet(items, baseName, tMat);
		if(setsFlag % 4 > 1)
			createArmorSet(items, baseName, aMat);
	}
	
	public static void orePreinit(ArrayList<Item> items, String baseName)
	{
		//Create items
		createOreProducts(items, baseName);
	}
	
	public static void orePreinit(Block[] blocks)
	{
		
	}
	
	
	
	public static void oreInit(ArrayList<Item> items, int setsFlag)
	{
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		regOreProductsRenders(items, renderItem);
		if(setsFlag % 2 > 0)
		{
			regToolSetRenders(items, renderItem);
		}
		if(setsFlag % 4 > 1)
		{
			regArmorSetRenders(items, renderItem);
		}
	}
	
	
	
	private static void createOreProducts(ArrayList<Item> items, String baseName)
	{
		items.add(0, new DU_ItemDust(baseName + "Dust"));
		items.add(1, new DU_ItemIngot(baseName + "Ingot"));
	}
	
	private static void createToolSet(ArrayList<Item> items, String baseName, ToolMaterial tMat)
	{
		items.add(2, new DU_ItemSword(baseName + "Sword", tMat));
		items.add(3, new DU_ItemPickaxe(baseName + "Pickaxe", tMat));
		items.add(4, new DU_ItemAxe(baseName + "Axe", tMat));
		items.add(5, new DU_ItemSpade(baseName + "Shovel", tMat));
		items.add(6, new DU_ItemHoe(baseName + "Hoe",tMat));
		items.add(7, new DU_ItemScythe(baseName + "Scythe",tMat));
	}
	
	private static void createArmorSet(ArrayList<Item> items, String baseName, ArmorMaterial aMat)
	{
		items.add(8, new DU_ItemArmor(baseName + "Helmet", aMat,0));
		items.add(9, new DU_ItemArmor(baseName + "Chestplate", aMat,1));
		items.add(10, new DU_ItemArmor(baseName + "Leggings", aMat,2));
		items.add(11, new DU_ItemArmor(baseName + "Boots", aMat,3));
	}
	
	private static void regOreProductsRenders(ArrayList<Item> items, RenderItem renderItem)
	{
		renderItem.getItemModelMesher().register(items.get(0), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemDust) items.get(0)).getName(), "inventory"));
		renderItem.getItemModelMesher().register(items.get(1), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemIngot) items.get(1)).getName(), "inventory"));
	}
	
	private static void regToolSetRenders(ArrayList<Item> items, RenderItem renderItem)
	{
		renderItem.getItemModelMesher().register(items.get(2), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemSword) items.get(2)).getName(), "inventory"));
		renderItem.getItemModelMesher().register(items.get(3), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemPickaxe) items.get(3)).getName(), "inventory"));
		renderItem.getItemModelMesher().register(items.get(4), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemAxe) items.get(4)).getName(), "inventory"));
		renderItem.getItemModelMesher().register(items.get(5), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemSpade) items.get(5)).getName(), "inventory"));
		renderItem.getItemModelMesher().register(items.get(6), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemHoe) items.get(6)).getName(), "inventory"));
		renderItem.getItemModelMesher().register(items.get(7), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemScythe) items.get(7)).getName(), "inventory"));
	}
	
	private static void regArmorSetRenders(ArrayList<Item> items, RenderItem renderItem)
	{
		
	}
	
}
