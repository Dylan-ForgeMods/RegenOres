package com.danilafe.regenoresrevival;

import com.danilafe.regenoresrevival.block.DormantOre;
import com.danilafe.regenoresrevival.event.EventListener;
import com.danilafe.regenoresrevival.proxies.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = RegenOres.MODID, version = RegenOres.VERSION)
public class RegenOres {

	public static final String MODID = "regen_ores_revival";
	public static final String VERSION = "v0.1";
	
	@SidedProxy(clientSide="com.danilafe.regenoresrevival.proxies.ClientProxy", serverSide="com.danilafe.regenoresrevival.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	public static Block dormantOre = new DormantOre(Material.rock);
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		
		GameRegistry.registerBlock(dormantOre, "dormantOre");	
		MinecraftForge.EVENT_BUS.register(new EventListener());
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
	}
	
}
