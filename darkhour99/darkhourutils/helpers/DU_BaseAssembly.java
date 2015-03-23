package darkhour99.darkhourutils.helpers;

public abstract class DU_BaseAssembly {

	/**
	 * construct your blocks here
	 */
	public abstract void preinitBlocks();
	
	/**
	 * construct your items here
	 */
	public abstract void preinitItems();
	
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
	
	/**
	 * register your render items
	 */
	protected abstract void registerRenderItems();
	
	/**
	 * register your recipes
	 */
	protected abstract void registerRecipes();
}
