package darkhour99.darkhourutils.lib;

import darkhour99.darkhourutils.helpers.DU_IHasStrains;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public enum DU_EMariBlossomStrain implements DU_IHasStrains{
	//Afgoo, Critical Mass, Ogre, Grape Ape, Silver Unicorn, Ogre Fist, Blazing Blossom
	//Agent Orange, Chernobyl, Juicy Fruit, Alien OG, Space Queen, Witches Brew, Wither wuther
	//Amnesia, Harlequin, Acapulco Gold, Kali Mist, Jack The Ripper, Hobbit haze, Glistening Ghast-leaf
	
	//numeration, type, name, potion effects...
	GRANDDADDY_PURP(1,"Granddaddy Purp", "granddaddyPurp",
			new PotionEffect(Potion.moveSlowdown.id,600,0),
			new PotionEffect(Potion.resistance.id,600,0)),
	SUPER_SKUNK(1,"Super Skunk", "superSkunk",
			new PotionEffect(Potion.confusion.id,300,0),
			new PotionEffect(Potion.regeneration.id,200,0)),
	AFGHANI(1,"Afghani","afghani"),
	NORTHERN_LIGHTS(1,"Northern Lights","northernLights"),
	BLUE_CHEESE(1,"Blue Cheese","blueCheese"),
	HINDU_KUSH(1,"Hindu Kush","hinduKush"),
	WHITE_RHINO(1,"White Rhino","whiteRhino"),
	CREEPER_KUSH(1,"Creeper Kush", "creeperKush"),
	
	BLUE_DREAM(2,"Blue Dream","blueDream"),
	OG_KUSH(2,"OG Kush","ogKush"),
	GIRL_SCOUT_COOKIES(2,"Girl Scout Cookies","girlScoutCookies"),
	WHITE_WIDOW(2, "White Widow","whiteWidow"),
	TRAINWRECK(2,"Train Wreck","trainWreck"),
	PINEAPPLE_EXPRESS(2,"Pineapple Express","pineappleExpress"),
	CHEMDAWG(2,"Chemdawg","chemdawg"),
	WRECK_ROOT(2,"Wreck Root", "wreckRoot"),
	
	SOUR_DIESEL(3,"Sour Diesel","sourDiesel"),
	GREEN_CRACK(3,"Green Crack","greenCrack"),
	LEMON_HAZE(3,"Lemon Haze","lemonHaze"),
	DURBAN_POISON(3,"Durban Poison","durbanPoison"),
	MAUI_WAUI(3,"Maui Waui","mauiWaui"),
	CAT_PISS(3,"Cat Piss","catPiss"),
	ALASKAN_THUNDER_FUCK(3,"Alaskan Thunder Fuck","alaskanThunderFuck"),
	ENDER_PURP(3, "Ender Purp", "enderPurp");
	
	//Index for initialization and reference
	private final int strainIndex;
	
	//Indica 1, Hybrid 2, Sativa 3
	private final int strainType;
	
	///Full strain name
	private final String strainName;
	
	//Unlocalized strain name
	private final String unlocName;
	
	//Effects given when consumed
	private final PotionEffect[] strainEffects;
	
	private DU_EMariBlossomStrain(int type, String name, String unloc, PotionEffect... effects)
	{
		this.strainIndex = this.ordinal();
		if(type < 1 || type > 3)
			throw new IllegalArgumentException("Invalid strain type: " + type);
		this.strainType = type;
		this.strainName = name;
		this.unlocName = unloc;
		this.strainEffects = effects;
	}
	
	public int getStrainIndex()
	{
		return this.strainIndex;
	}
	
	public int getStrainType()
	{
		return this.strainType;
	}
	
	@Override
	public String toString()
	{
		return this.unlocName;
	}
	
	public String getStrainName()
	{
		return this.strainName;
	}
	
	public PotionEffect[] getStrainEffects()
	{
		return this.strainEffects;
	}
	
	public int getLength()
	{
		return DU_EMariBlossomStrain.values().length;
	}
	
	public static int getLengthStatic()
	{
		return DU_EMariBlossomStrain.values().length;
	}
	
	public DU_IHasStrains getStrainFromIndex(int index)
	{
		try{
			return DU_EMariBlossomStrain.values()[index];
		}
		catch( ArrayIndexOutOfBoundsException e){
			throw new IllegalArgumentException("Unknown index value :" + index);
		}
	}
	
	public DU_IHasStrains getStrainFromIndexStatic(int index)
	{
		try{
			return DU_EMariBlossomStrain.values()[index];
		}
		catch( ArrayIndexOutOfBoundsException e){
			throw new IllegalArgumentException("Unknown index value :" + index);
		}
	}
}
