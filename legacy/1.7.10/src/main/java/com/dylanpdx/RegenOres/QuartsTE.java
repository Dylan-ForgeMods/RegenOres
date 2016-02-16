package com.dylanpdx.RegenOres;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
//import net.minecraft.network.packet.Packet132TileEntityData;

public class QuartsTE extends TileEntity {
	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
	}
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
	}
	
	/*@Override
	public Packet getDescriptionPacket(){
		NBTTagCompound tileTag = new NBTTagCompound();
		this.writeToNBT(tileTag);
		return new Packet132TileEntityData(this.xCoord,this.yCoord,this.zCoord,0,tileTag);
	}
	
	@Override
	public void onDataPacket(INetworkManager net,Packet132TileEntityData pkt){
		this.readFromNBT(pkt.customParam1);
	}
	*/
}


