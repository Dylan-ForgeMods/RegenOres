package com.danilafe.regenoresrevival.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class DormantOre extends Block {

	public DormantOre(Material materialIn) {
		super(materialIn);
		
		setBlockUnbreakable();
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(Block.soundTypeStone);
		setUnlocalizedName("dormantOre");
	}

}
