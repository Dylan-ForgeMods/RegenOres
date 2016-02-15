package com.danilafe.regenoresrevival;

import com.danilafe.regenoresrevival.proxies.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = RegenOres.MODID, version = RegenOres.VERSION)
public class RegenOres {

	public static final String MODID = "regen_ores_revival";
	public static final String VERSION = "v0.1";
	
	@SidedProxy(clientSide="com.danilafe.regenoresrevival.proxies.ClientProxy", serverSide="com.danilafe.regenoresrevival.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
	}
	
}
