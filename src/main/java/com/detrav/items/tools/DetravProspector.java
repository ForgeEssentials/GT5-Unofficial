package com.detrav.items.tools;

import com.detrav.enums.Textures01;
import com.detrav.items.behaviours.BehaviourDetravToolProspector;

import gregtech.api.interfaces.IIconContainer;
import gregtech.api.items.GT_MetaGenerated_Tool;
import net.minecraft.item.ItemStack;

public class DetravProspector extends DetravToolElectricProspectorBase {
	
		private final int tier;
	
		public DetravProspector(int tier) {
			this.tier=tier;
		}
	
	 	public int getBaseQuality() {
	        return tier;
	    }
	    public float getMaxDurabilityMultiplier() {
	    	double x = tier + 1;
	    	return (float) (((float) 0.005D+Math.tanh(Math.pow(x,(x/8D))/25D)*(x/6D))*1.25);
	    }

	    public IIconContainer getIcon(boolean aIsToolHead, ItemStack aStack) {
	        return Textures01.mTextures[0];
	    }
	    
	    public void onStatsAddedToTool(GT_MetaGenerated_Tool aItem, int aID) {
	        aItem.addItemBehavior(aID, new BehaviourDetravToolProspector(15));
	    }
}
