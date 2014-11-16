
package com.dylanpdx.RegenOres;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.transformers.ForgeAccessTransformer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * @author Dylan Grinberg (dylanpdx)
 * @category Ores
 * @version 1.0
 * 
 *
 */
@Mod(modid = "regen_ores", name = "Regen Ores", version = "1.2")
public class RegenOres_Main {
	
	// Defining Blocks
	
	public int ChangeChance;
	public static int CoalChance;
	public static  int DiamondChance;
	public static  int EmeraldChance;
	public static  int GoldChance;
	public static  int IronChance;
	public static  int QuartzChance;
	public static  int RedstoneChance;
	
	Block dormantCoal;
	Block dormantDiamond;
	Block dormantEmerald;
	Block dormantGold;
	Block dormantIron;
	Block dormantQuartz;
	Block dormantRedstone;
	
	@EventHandler
	public void Preinit(FMLPreInitializationEvent e) {
		
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());

		config.load();
		// Generating config file
		ChangeChance = config.getInt("DormantChance", "Chances", 3, 1, 50000, "Chance for any ore to turn dormant (1 in x chance)");
		CoalChance = config.getInt("CoalChance", "Chances", 10, 1, 50000, "Chance for Coal to regenerate randomly. Higher the number the more it will take");
		DiamondChance = config.getInt("DiamondChance", "Chances", 100, 1, 50000, "Chance for Diamond to regenerate randomly. Higher the number the more it will take");
		EmeraldChance = config.getInt("EmeraldChance", "Chances", 200, 1, 50000, "Chance for Emerald to regenerate randomly. Higher the number the more it will take");
		GoldChance = config.getInt("GoldChance", "Chances", 70, 1, 50000, "Chance for Gold to regenerate randomly. Higher the number the more it will take");
		IronChance = config.getInt("IronChance", "Chances", 30, 1, 50000, "Chance for Iron to regenerate randomly. Higher the number the more it will take");
		QuartzChance = config.getInt("QuartzChance", "Chances", 10, 1, 50000, "Chance for Quartz to regenerate randomly. Higher the number the more it will take");
		RedstoneChance = config.getInt("RedstoneChance", "Chances", 50, 1, 50000, "Chance for Redstone to regenerate randomly. Higher the number the more it will take");
		
		config.save();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		
		
		
		MinecraftForge.EVENT_BUS.register(this); // Making sure we get event calls
		// if we break a block
		
		// Making all blocks unbreakable and random ticking. Also registering them
		dormantCoal = new dormantCoal_block().setBlockUnbreakable().setBlockTextureName("regen_ores:dormant_coal_ore").setTickRandomly(true).setBlockName("dormantcoal");
		GameRegistry.registerBlock(dormantCoal, "DormantCoal");
		
		dormantDiamond = new dormantDiamond_block().setBlockUnbreakable().setBlockTextureName("regen_ores:dormant_diamond_ore").setTickRandomly(true).setBlockName("dormantdiamond");
		GameRegistry.registerBlock(dormantDiamond, "DormantDiamond");
		
		dormantEmerald = new dormantEmerald_block().setBlockUnbreakable().setBlockTextureName("regen_ores:dormant_emerald_ore").setTickRandomly(true).setBlockName("dormantemerald");
		GameRegistry.registerBlock(dormantEmerald, "DormantEmerald");
		
		dormantGold = new dormantGold_block().setBlockUnbreakable().setBlockTextureName("regen_ores:dormant_gold_ore").setTickRandomly(true).setBlockName("dormantgold");
		GameRegistry.registerBlock(dormantGold, "DormantGold");
		
		dormantIron = new dormantIron_block().setBlockUnbreakable().setBlockTextureName("regen_ores:dormant_iron_ore").setTickRandomly(true).setBlockName("dormantiron");
		GameRegistry.registerBlock(dormantIron, "DormantIron");
		
		dormantQuartz = new dormantQuartz_block().setBlockUnbreakable().setBlockTextureName("regen_ores:dormant_quartz_ore").setTickRandomly(true).setBlockName("dormantquartz");
		GameRegistry.registerBlock(dormantQuartz, "DormantQuartz");
		
		dormantRedstone = new dormantRedstone_block().setBlockUnbreakable().setBlockTextureName("regen_ores:dormant_redstone_ore").setTickRandomly(true).setBlockName("dormandredstone");
		GameRegistry.registerBlock(dormantRedstone, "DormantRedstone");
	}
	
	@SubscribeEvent
	public void breakblock(BlockEvent.HarvestDropsEvent e){ // If we break a block
		Random r = new Random();
		
		if (r.nextInt(this.ChangeChance) == 0){
			if (e.block.equals(Blocks.coal_ore)){
				e.world.setBlock(e.x,e.y,e.z,dormantCoal);
			}else if(e.block.equals(Blocks.diamond_ore)){
				e.world.setBlock(e.x,e.y,e.z,dormantDiamond);
			}else if(e.block.equals(Blocks.emerald_ore)){
				e.world.setBlock(e.x,e.y,e.z,dormantEmerald);
			}else if(e.block.equals(Blocks.gold_ore)){
				e.world.setBlock(e.x,e.y,e.z,dormantGold);
			}else if(e.block.equals(Blocks.iron_ore)){
				e.world.setBlock(e.x,e.y,e.z,dormantIron);
			}else if(e.block.equals(Blocks.redstone_ore)){ // For some reason redstone doesn't work
				e.world.setBlock(e.x,e.y,e.z,dormantRedstone); // Looking into it ;)
			}else if(e.block.equals(Blocks.quartz_ore)){
				e.world.setBlock(e.x,e.y,e.z,dormantQuartz);
			}
		}

	}
	

}