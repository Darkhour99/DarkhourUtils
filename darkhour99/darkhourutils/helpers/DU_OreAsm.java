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
import darkhour99.darkhourutils.blocks.DU_BlockCompBrick;
import darkhour99.darkhourutils.blocks.DU_BlockCompressed;
import darkhour99.darkhourutils.blocks.DU_BlockOre;
import darkhour99.darkhourutils.items.DU_ItemArmor;
import darkhour99.darkhourutils.items.DU_ItemAxe;
import darkhour99.darkhourutils.items.DU_ItemDust;
import darkhour99.darkhourutils.items.DU_ItemGem;
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
	private final int blockHarvestLvl, blockHardness, blockResistance;
	private final String oreDrop;
	private final int leastOreDrop, mostOreDrop;
	private final ToolMaterial toolMat;
	private final ArmorMaterial armorMat;
	private final int itemSets;
	
	public static final int hasTools = 1, hasArmor = 2;
	
	private Block oreBlock, compressedBlock, compressedBrick;
	private Item ingot, dust, gem, rod;
	private Item sword, bow, staff; 
	private Item pickaxe, axe, spade, hoe, scythe;
	private Item helmet, chestplate, leggings, boots;

	/**
	 * Creates an assembly that contains all the items, blocks and recipes
	 * related to a specified metal or gem type
	 * 
	 * @param base base name for ore type (titanium, mithril, amber, etc)
	 * @param type whether its a gem or metal ore
	 * @param sets does it have tool or armor sets (refer to hasTools and hasArmor)
	 * @param tMat the toolMaterial
	 * @param aMat the armorMaterial
	 * @param harvest harvest level for the ore block, comp block and comp bricks
	 * @param hardness same as harvest but for block hardness
	 * @param resistance same as harvest but for explosive resistance
	 * @param drop name of the special drop from ore (usually gems) if one is to exist
	 * @param leastDrop least amount of drop an ore can drop
	 * @param mostDrop most amount of drop an ore can drop (not including fortune)
	 */
	public DU_OreAsm(String base, EOreType type, int sets,ToolMaterial tMat, ArmorMaterial aMat
			, int harvest, int hardness, int resistance, String drop, int leastDrop, int mostDrop)
	{
		this.baseName = base;
		this.oreType = type;
		this.toolMat = tMat;
		this.armorMat = aMat;
		
		this.blockHarvestLvl = harvest;
		this.blockHardness = hardness;
		this.blockResistance = resistance;
		
		this.oreDrop = drop;
		this.leastOreDrop = leastDrop;
		this.mostOreDrop = mostDrop;
		
		if((sets % 2) > 0 && this.toolMat == (ToolMaterial)null)
			sets -= hasTools;
		if((sets % 4) > 1 && this.armorMat == (ArmorMaterial)null)
			sets -= hasArmor;
		if(sets < 0 || sets > 4)
			sets = 0;
		this.itemSets = sets;
	}
	
	/**
	 * Simplified constructor for ore types with none special drops
	 * 
	 * @param base base name for ore type (titanium, mithril, amber, etc)
	 * @param type whether its a gem or metal ore
	 * @param sets does it have tool or armor sets (refer to hasTools and hasArmor)
	 * @param tMat the toolMaterial
	 * @param aMat the armorMaterial
	 * @param harvest harvest level for the ore block, comp block and comp bricks
	 * @param hardness same as harvest but for block hardness
	 * @param resistance same as harvest but for explosive resistance
	 */
	public DU_OreAsm(String base, EOreType type, int sets,ToolMaterial tMat, ArmorMaterial aMat
			, int harvest, int hardness, int resistance)
	{
		this(base, type, sets, tMat, aMat, harvest, hardness, resistance, "", 1, 1);
	}
	
	/**
	 * Pre initilize for blocks
	 * To be called during mod preinitializing
	 * Does the actual block construction and instantiation
	 */
	public void preinitBlocks()
	{
		this.oreBlock = new DU_BlockOre(baseName + "Ore",this.blockHarvestLvl, this.blockHardness
				, this.blockResistance,this.oreDrop, this.leastOreDrop, this.mostOreDrop);
		this.compressedBlock = new DU_BlockCompressed(baseName + "Block");
		if(this.oreType != EOreType.GEM)
		{
			this.compressedBrick = new DU_BlockCompBrick(this.baseName + "Brick");
		}
	}
	
	/**
	 * Pre initilize for items
	 * To be called during mod preinitializing
	 * Does the actual item construction and instantiation
	 */
	public void preinitItems()
	{
		//Creates Products

		if(this.oreType == EOreType.METAL)
		{
			this.dust = new DU_ItemDust(this.baseName + "Dust");
			this.ingot = new DU_ItemIngot(this.baseName + "Ingot");
		}
		else
		{
			this.gem = new DU_ItemGem(this.baseName + "Gem");
		}
		
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
	
	/**
	 * Initialize for items
	 * To be called during mod initializing
	 * Registers render items and recipes
	 */
	public void initItems()
	{
		this.registerRenderItems();
		this.registerRecipes();
	}

	private void registerRenderItems() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		//Products
		if(this.oreType == EOreType.METAL)
		{
			renderItem.getItemModelMesher().register(this.dust, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemDust) this.dust).getName(), "inventory"));
			renderItem.getItemModelMesher().register(this.ingot, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemIngot) this.ingot).getName(), "inventory"));
		}
		else
		{
			renderItem.getItemModelMesher().register(this.gem, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemGem) this.gem).getName(), "inventory"));
		}
		
		//Block Items
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(this.oreBlock), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_BlockOre) this.oreBlock).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(this.compressedBlock), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_BlockCompressed) this.compressedBlock).getName(), "inventory"));
		if(this.oreType == EOreType.METAL)
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(this.compressedBrick), 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_BlockCompBrick) this.compressedBrick).getName(), "inventory"));
		
		//Tools
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
		
		//Armor
		if((this.itemSets % 4) > 1)
		{
			renderItem.getItemModelMesher().register(this.helmet, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemArmor) this.helmet).getName(), "inventory"));
			renderItem.getItemModelMesher().register(this.chestplate, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemArmor) this.chestplate).getName(), "inventory"));
			renderItem.getItemModelMesher().register(this.leggings, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemArmor) this.leggings).getName(), "inventory"));
			renderItem.getItemModelMesher().register(this.boots, 0, new ModelResourceLocation(DU_Constants.MODID + ":" + ((DU_ItemArmor) this.boots).getName(), "inventory"));
		}
	}
	
	private void registerRecipes()
	{

		registerBlockRecipes();

		if((this.itemSets % 2) > 0)
			registerToolRecipes(this.oreType == EOreType.METAL ? this.ingot : this.gem);
		//Creates Armor
		if((this.itemSets % 4) > 1)
			registerArmorRecipes(this.oreType == EOreType.METAL ? this.ingot : this.gem);
	}
	
	private void registerBlockRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(this.compressedBlock), new Object[]{
			"III",
			"III",
			"III",
			'I', this.oreType == EOreType.METAL ? this.ingot : this.gem
		});
		
		if(this.oreType == EOreType.METAL)
		{
			GameRegistry.addRecipe(new ItemStack(this.compressedBlock), new Object[]{
				"II",
				"II",
				'I', this.ingot
			});
			//By definition these don't belong in this method, but its more efficient
			GameRegistry.addSmelting(new ItemStack(this.dust), new ItemStack(this.ingot), 0.2F);
			GameRegistry.addSmelting(new ItemStack(this.oreBlock), new ItemStack(this.ingot), 0.3F);

		}
	}

	private void registerToolRecipes(Item materialItem) {
		GameRegistry.addRecipe(new ItemStack(this.sword), new Object[]{
			"I",
			"I",
			"S",
			'I', materialItem, 'S', Items.stick
		});
		GameRegistry.addRecipe(new ItemStack(this.pickaxe), new Object[]{
			"III",
			" S ",
			" S ",
			'I', materialItem, 'S', Items.stick
		});
		GameRegistry.addRecipe(new ItemStack(this.axe), new Object[]{
			"II ",
			"IS ",
			" S ",
			'I', materialItem, 'S', Items.stick
		});
		GameRegistry.addRecipe(new ItemStack(this.axe), new Object[]{
			" II",
			" SI",
			" S ",
			'I', materialItem, 'S', Items.stick
		});
		GameRegistry.addRecipe(new ItemStack(this.spade), new Object[]{
			" I ",
			" S ",
			" S ",
			'I', materialItem, 'S', Items.stick
		});
		GameRegistry.addRecipe(new ItemStack(this.hoe), new Object[]{
			"II ",
			" S ",
			" S ",
			'I', materialItem, 'S', Items.stick
		});
		GameRegistry.addRecipe(new ItemStack(this.axe), new Object[]{
			" II",
			" S ",
			" S ",
			'I', materialItem, 'S', Items.stick
		});
		GameRegistry.addRecipe(new ItemStack(this.scythe), new Object[]{
			" II",
			"I S",
			"  S",
			'I', materialItem, 'S', Items.stick
		});
		GameRegistry.addRecipe(new ItemStack(this.scythe), new Object[]{
			"II ",
			"S I",
			"S  ",
			'I', materialItem, 'S', Items.stick
		});
		//TODO Bow, Staff and Rod
	}
	
	private void registerArmorRecipes(Item materialItem)
	{
		
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
