package net.genflow.blockchanger.events;

import net.genflow.blockchanger.BlockChanger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockChangeEventListener implements Listener{

	BlockChanger testPlugin;
	public static String item = "**";

	//Constructor
	public BlockChangeEventListener(BlockChanger testPlugin){
		this.testPlugin = testPlugin;
	}


	@EventHandler
	public void onBlockDamage(BlockBreakEvent event){
		Player player = event.getPlayer();
		Block block = event.getBlock();
		if(testPlugin.isToggled(player)){
			if(item.equalsIgnoreCase("**")){
				player.sendMessage("===[" + ChatColor.AQUA + "Blockchanger" + ChatColor.WHITE + "]===\n" + ChatColor.DARK_RED + "[ERROR] - You must select an item first!");
			}else{
				if(block.getType().equals(Material.getMaterial(item))){
					
				}else{
					block.setType(Material.getMaterial(item));
					event.setCancelled(true);
				}
			}
			
		}else{
			
		}
		
		
	}
	

}
