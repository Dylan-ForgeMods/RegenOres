package com.danilafe.regenoresrevival.event;

import com.danilafe.regenoresrevival.RegenOres;
import com.danilafe.regenoresrevival.block.DormantOreTileEntity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class EventListener {

	@SubscribeEvent
	public void blockBreak(BlockEvent.BreakEvent event) {
		String[] oreNames = OreDictionary.getOreNames();
		boolean isOre = false;
		String registryName = event.state.getBlock().getRegistryName();
		String oreName = event.state.getBlock().getUnlocalizedName();
		oreName = oreName.substring(oreName.indexOf('.') + 1);
		for(String on : oreNames) if(on.toLowerCase().contains("ore") && on.equals(oreName)) {
			isOre = true;
			event.setCanceled(true);
			EntityItem droppedItem = new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(event.state.getBlock(), 1));
			event.world.spawnEntityInWorld(droppedItem);
		}
		
		if(!isOre) return;
		
		event.world.setBlockState(event.pos, RegenOres.instance.dormantOre.getDefaultState());
		((DormantOreTileEntity) event.world.getTileEntity(event.pos)).setBlockId(registryName);
	}
	
}
