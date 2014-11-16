package com.dylanpdx.RegenOres;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class dormantQuartz_block extends BlockContainer {
	protected dormantQuartz_block() {
		super(Material.rock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new QuartsTE();
	}
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		int lol = par5Random.nextInt(RegenOres_Main.QuartzChance);
		if (Math.floor(lol) == 0){
			par1World.setBlock(par2, par3, par4, Blocks.quartz_ore);
		}
	}
}
