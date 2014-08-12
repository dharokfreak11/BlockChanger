package net.genflow.blockchanger.handlers;

import java.util.ArrayList;
import java.util.List;

import net.genflow.blockchanger.BlockChanger;

public class ItemHandler{

	BlockChanger blockChanger;
	
	//Constructor
	public ItemHandler(BlockChanger blockChanger){
		this.blockChanger = blockChanger;
	}

	//Returns whether the item is valid.
	public boolean isItemValid(String block){
		if(getItemList().contains(getItemMaterialName(block))){
			return true;
		}else{
			return false;
		}
	}
	
	//Returns the material name of an item.
	public String getItemMaterialName(String block){
		return block.toUpperCase();
	}
	
	//Returns the item list.
	public List<String> getItemList(){
		List<String> itemList = new ArrayList<>();
		itemList.add("LOG");
		itemList.add("LOG_2");
		itemList.add("COBBLESTONE");
		itemList.add("IRON_ORE");
		itemList.add("GOLD_ORE");
		itemList.add("DIAMOND_BLOCK");
		itemList.add("IRON_BLOCK");
		itemList.add("GOLD_BLOCK");
		itemList.add("GRAVEL");
		itemList.add("BRICK");
		itemList.add("STAINED_CLAY");
		itemList.add("CLAY_BLOCK");
		itemList.add("BEDROCK");
		itemList.add("CHEST");
		itemList.add("WORKBENCH");
		itemList.add("FURNACE");
		itemList.add("WATER");
		itemList.add("LAVA");
		itemList.add("FLOWER_POT");
		itemList.add("FENCE");
		itemList.add("SIGN_POST");
		itemList.add("WALL_SIGN");
		itemList.add("PLAYER_SKULL");
		itemList.add("SKULL");
		itemList.add("STONE");
		itemList.add("STONEBRICK");
		itemList.add("GLASS");
		itemList.add("WOOL");
		itemList.add("EMERALD_BLOCK");
		itemList.add("QUARTZ_BLOCK");
		itemList.add("HAY_BALE");
		itemList.add("GLOWSTONE_BLOCK");
		itemList.add("OBSIDIAN");
		itemList.add("REDSTONE_BLOCK");
		itemList.add("COAL_BLOCK");
		return itemList;
	}



}
