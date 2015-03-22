package darkhour99.darkhourutils.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DU_GrinderRecipes 
{
	private static final DU_GrinderRecipes grindingBase = new DU_GrinderRecipes();
	
	private Map shreddingList = new HashMap();
	private Map dustingList = new HashMap();
	
	public static DU_GrinderRecipes grinding()
	{
		return grindingBase;
	}
	
	private DU_GrinderRecipes()
	{
		//Dusting Recipes
		//this.addToDustList(DU_Blocks.titaniumOre, new ItemStack(DU_Items.titaniumDust,2,0));
		
		
		//Shredding Recipes
//		for(int i = 0; i < DU_EMariBlossomStrain.getLength(); ++i){
//			this.addToShredList(new ItemStack(DU_Items.mariBlossom, 1, i ), new ItemStack(DU_Items.mariBlossomGrind, 2, i)); 
//		}
	}
	
	public void addToShredList(Block input, ItemStack output)
	{
		this.addToShredList(Item.getItemFromBlock(input), output);
	}
	
	public void addToShredList(Item input, ItemStack output)
	{
		this.addToShredList(new ItemStack(input,1,32767), output);
	}
	
	public void addToShredList(ItemStack input, ItemStack output)
	{
		this.shreddingList.put(input, output);
	}
	
	public void addToDustList(Block input, ItemStack output)
	{
		this.addToDustList(Item.getItemFromBlock(input), output);
	}
	
	public void addToDustList(Item input, ItemStack output)
	{
		this.addToDustList(new ItemStack(input,1,32767), output);
	}
	
	public void addToDustList(ItemStack input, ItemStack output)
	{
		this.dustingList.put(input, output);
	}
	
	public ItemStack getDustResult(ItemStack stack)
	{
		Iterator iterator = this.dustingList.entrySet().iterator();
		Entry entry;
		do
		{
			if(!iterator.hasNext())
			{
				return null;
			}
			
			entry = (Entry)iterator.next();
		}
		while(!this.isStacksEqual(stack, (ItemStack)entry.getKey()));
		
		return (ItemStack)entry.getValue();
	}
	
	public ItemStack getShredResult(ItemStack stack)
	{
		Iterator iterator = this.shreddingList.entrySet().iterator();
		Entry entry;
		do
		{
			if(!iterator.hasNext())
			{
				return null;
			}
			
			entry = (Entry)iterator.next();
		}
		while(!this.isStacksEqual(stack, (ItemStack)entry.getKey()));
		
		return (ItemStack)entry.getValue();
	}
	
	private boolean isStacksEqual(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack1.getItemDamage());
	}
	
	public Map getDustingList()
	{
		return this.dustingList;
	}
	
	public Map getShreddingList()
	{
		return this.shreddingList;
	}
}
