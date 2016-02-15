package com.danilafe.regenoresrevival.block;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class DormantOreTileEntity extends TileEntity {

	protected String blockId = "minecraft:stone";
	
	public String getBlockId() {
		return blockId;
	}

	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setString("blockId", this.blockId);
		super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		blockId = compound.getString("blockId");
		super.readFromNBT(compound);
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tagCompount = new NBTTagCompound();
		writeToNBT(tagCompount);
		return new S35PacketUpdateTileEntity(this.pos, this.getBlockMetadata(), tagCompount);
	}
	
}
