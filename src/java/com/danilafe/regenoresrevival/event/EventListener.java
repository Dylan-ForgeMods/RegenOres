package com.danilafe.regenoresrevival.event;

import java.util.ArrayList;

import com.danilafe.regenoresrevival.RegenOres;
import com.danilafe.regenoresrevival.block.DormantOreTileEntity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class EventListener {
	
	ArrayList<DormantOreData> oresToPlace = new ArrayList<DormantOreData>();
	
	@SubscribeEvent
	public void blockBreak(BlockEvent.BreakEvent event) {
		String[] oreNames = OreDictionary.getOreNames();
		boolean isOre = false;
		String registryName = event.state.getBlock().getRegistryName();
		String oreName = event.state.getBlock().getUnlocalizedName();
		oreName = oreName.substring(oreName.indexOf('.') + 1);
		if(oreName.contains(":")) oreName = oreName.substring(oreName.indexOf(':') + 1);
		
		for(String on : oreNames) {
			System.out.println(on);
			if(on.toLowerCase().contains("ore") && on.equals(oreName)) {
				isOre = true;
			}
		}
		
		if(!isOre) return;
		
		DormantOreData data = new DormantOreData();
		data.blockPos = event.pos;
		data.registryName = registryName;
		data.world = event.world;
		
		oresToPlace.add(data);
		
	}
	
	@SubscribeEvent
	public void tickEvent(TickEvent event){
		for(int i = 0; i < oresToPlace.size(); i++) {
			DormantOreData d = oresToPlace.get(i);
			d.world.setBlockState(d.blockPos, RegenOres.instance.dormantOre.getDefaultState());
			((DormantOreTileEntity) d.world.getTileEntity(d.blockPos)).setBlockId(d.registryName);
		}
		oresToPlace.clear();
	}
	
}
