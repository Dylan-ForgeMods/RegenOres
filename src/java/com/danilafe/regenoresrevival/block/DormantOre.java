package com.danilafe.regenoresrevival.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DormantOre extends BlockContainer {

	public DormantOre(Material materialIn) {
		super(materialIn);
		
		setBlockUnbreakable();
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(Block.soundTypeStone);
		setUnlocalizedName("dormantOre");
		setTickRandomly(true);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new DormantOreTileEntity();
	}
	
	@Override
	public int getRenderType() {
		return 3;
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		
		System.out.println("UPDATE!");
		
		DormantOreTileEntity tileEntity = (DormantOreTileEntity) worldIn.getTileEntity(pos);
		Block toSet = GameRegistry.findBlock(tileEntity.getBlockId().substring(0, tileEntity.getBlockId().indexOf(':')), tileEntity.getBlockId().substring(tileEntity.getBlockId().indexOf(':') + 1));
		worldIn.setBlockState(pos, toSet.getDefaultState());
	}

}
