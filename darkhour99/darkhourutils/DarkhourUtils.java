package darkhour99.darkhourutils;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import darkhour99.darkhourutils.items.DU_Items;
import darkhour99.darkhourutils.lib.DU_Constants;

@Mod(modid = DU_Constants.MODID, name = DU_Constants.MODNAME, version = DU_Constants.VERSION)
public class DarkhourUtils 
{
	@Instance(DU_Constants.MODID)
	public static DarkhourUtils instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Adding blocks, items, worldgen etc
		DU_Items.preinit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Adding tile entities, events, renderers
		if(event.getSide() == Side.CLIENT)
			DU_Items.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//Adding addons for other mods
	}
}
