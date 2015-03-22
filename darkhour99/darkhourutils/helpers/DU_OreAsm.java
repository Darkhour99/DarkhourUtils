package darkhour99.darkhourutils.helpers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import darkhour99.darkhourutils.blocks.DU_BlockOre;
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

public class DU_OreAsm {
	private final String baseName;
	private final EOreType oreType;
	private final ToolMaterial toolMat;
	private final ArmorMaterial armorMat;
	private final int itemSets;
	
	public static final int hasTools = 1, hasArmor = 2;
	
	private Block oreBlock, decorBlock, decorBrick;
	private Item ingot, dust, gem, rod;
	private Item sword, bow, staff; 
	private Item pickaxe, axe, spade, hoe, scythe;
	private Item helmet, chestplate, leggings, boots;

	
	public DU_OreAsm(String base, EOreType type, int sets,ToolMaterial tMat, ArmorMaterial aMat)
	{
		this.baseName = base;
		this.oreType = type;
		this.toolMat = tMat;
		this.armorMat = aMat;
		if((sets % 2) > 0 && this.toolMat == (ToolMaterial)null)
			sets -= hasTools;
		if((sets % 4) > 1 && this.armorMat == (ArmorMaterial)null)
			sets -= hasArmor;
		if(sets < 0 || sets > 4)
			sets = 0;
		this.itemSets = sets;
	}
	
	public void preinitBlocks()
	{
		this.oreBlock = new DU_BlockOre(baseName + "Ore");
		//this.decorBlock
		if(this.oreType != EOreType.GEM)
		{
			//this.decorBrick
		}
	}
	
	public void preinitItems()
	{
		//Creates Products
		this.dust = new DU_ItemDust(this.baseName + "Dust");
		this.ingot = new DU_ItemIngot(this.baseName + "Ingot");
		//Creates Tools
		if((this.itemSets % 2) > 0)
		{
			this.sword = new DU_ItemSword(this.baseName + "Sword", this.toolMat);
			this.pickaxe = new DU_ItemPickaxe(this.baseName + "Pickaxe", this.toolMat);
			this.axe = new DU_ItemAxe(this.baseName + "Axe", this.toolMat);
			this.spade = new DU_ItemSpade(this.baseName + "Spade", this.toolMat);
			this.hoe = new DU_ItemHoe(this.baseName + "Hoe", this.toolMat);
			this.scythe = new DU_ItemScythe(this.baseName + "Scythe", this.toolMat);
			//TODO Bow, Staff and Rod
		}
		//Creates Armor
		if((this.itemSets % 4) > 1)
		{
			this.helmet = new DU_ItemArmor(this.baseName + "Helmet", this.armorMat, 0);
			this.chestplate = new DU_ItemArmor(this.baseName + "Chestplate", this.armorMat, 1);
			this.leggings = new DU_ItemArmor(this.baseName + "Leggings", this.armorMat, 2);
			this.boots = new DU_ItemArmor(this.baseName + "Boots", this.armorMat, 3);
		}
	}
	
	public void initItems()
	{
		this.registerRenderItems();
		this.registerRecipes();
	}

	private void registerRenderItems() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		renderItem.getItemModelMesher().register(this.dust, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemDust) this.dust).getName(), "inventory"));
		renderItem.getItemModelMesher().register(this.ingot, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemIngot) this.ingot).getName(), "inventory"));
		if((this.itemSets % 2) > 0)
		{
			renderItem.getItemModelMesher().register(this.sword, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemSword) this.sword).getName(), "inventory"));
			renderItem.getItemModelMesher().register(this.pickaxe, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemPickaxe) this.pickaxe).getName(), "inventory"));
			renderItem.getItemModelMesher().register(this.axe, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemAxe) this.axe).getName(), "inventory"));
			renderItem.getItemModelMesher().register(this.spade, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemSpade) this.spade).getName(), "inventory"));
			renderItem.getItemModelMesher().register(this.hoe, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemHoe) this.hoe).getName(), "inventory"));
			renderItem.getItemModelMesher().register(this.scythe, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemScythe) this.scythe).getName(), "inventory"));
			//TODO Bow, Staff and Rod
		}
		//Creates Armor
		if((this.itemSets % 4) > 1)
		{
			
		}
	}
	
	public void registerRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(this.decorBlock), new Object[]{
			"III",
			"III",
			"III",
			'I', this.ingot
		});
		
		if(this.oreType == EOreType.METAL)
		{
			GameRegistry.addRecipe(new ItemStack(this.decorBlock), new Object[]{
				"II",
				"II",
				'I', this.ingot
			});
		}
		
		GameRegistry.addSmelting(new ItemStack(this.ingot), new ItemStack(this.dust), 0.2F);
		GameRegistry.addSmelting(new ItemStack(this.ingot), new ItemStack(this.oreBlock), 0.3F);
		
		if((this.itemSets % 2) > 0)
		{
			GameRegistry.addRecipe(new ItemStack(this.sword), new Object[]{
				"I",
				"I",
				"S",
				'I', this.ingot, 'S', Items.stick
			});
			GameRegistry.addRecipe(new ItemStack(this.pickaxe), new Object[]{
				"III",
				" S ",
				" S ",
				'I', this.ingot, 'S', Items.stick
			});
			GameRegistry.addRecipe(new ItemStack(this.axe), new Object[]{
				"II ",
				"IS ",
				" S ",
				'I', this.ingot, 'S', Items.stick
			});
			GameRegistry.addRecipe(new ItemStack(this.axe), new Object[]{
				" II",
				" SI",
				" S ",
				'I', this.ingot, 'S', Items.stick
			});
			GameRegistry.addRecipe(new ItemStack(this.spade), new Object[]{
				" I ",
				" S ",
				" S ",
				'I', this.ingot, 'S', Items.stick
			});
			GameRegistry.addRecipe(new ItemStack(this.hoe), new Object[]{
				"II ",
				" S ",
				" S ",
				'I', this.ingot, 'S', Items.stick
			});
			GameRegistry.addRecipe(new ItemStack(this.axe), new Object[]{
				" II",
				" S ",
				" S ",
				'I', this.ingot, 'S', Items.stick
			});
			GameRegistry.addRecipe(new ItemStack(this.scythe), new Object[]{
				" II",
				"I S",
				"  S",
				'I', this.ingot, 'S', Items.stick
			});
			GameRegistry.addRecipe(new ItemStack(this.scythe), new Object[]{
				"II ",
				"S I",
				"S  ",
				'I', this.ingot, 'S', Items.stick
			});
			//TODO Bow, Staff and Rod
		}
		//Creates Armor
		if((this.itemSets % 4) > 1)
		{
		}
	}
	
	public String getBaseName()
	{
		return this.baseName;
	}
	
	public EOreType getOreType()
	{
		return this.oreType;
	}
	
	public static enum EOreType
	{
		METAL, GEM;
	}
}
