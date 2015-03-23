package darkhour99.darkhourutils.helpers;

import net.minecraft.potion.PotionEffect;

public interface DU_IHasStrains {
	public abstract int getLength();
	public abstract DU_IHasStrains getStrainFromIndex(int index);
	public abstract PotionEffect[] getStrainEffects();
	public abstract String getStrainName();
	public abstract String toString();
	//public abstract int getStrainType();
	public abstract int getStrainIndex();
}
