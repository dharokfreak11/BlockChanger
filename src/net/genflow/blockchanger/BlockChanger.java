package net.genflow.blockchanger;

import java.util.HashMap;

import net.genflow.blockchanger.events.BlockChangeEventListener;
import net.genflow.blockchanger.handlers.ItemHandler;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockChanger extends JavaPlugin implements CommandExecutor{


	private HashMap<Player, Boolean> isPlayerToggledMap = new HashMap<Player, Boolean>();


	private static BlockChanger instance;

	// Allows access to the main class
	public static BlockChanger getInstance() {
		return instance;
	}


	@Override
	public void onEnable(){
		getLogger().info("Version " + getDescription().getVersion() + " has been enabled!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new BlockChangeEventListener(this), this);
	}

	@Override
	public void onDisable(){
		getLogger().info("Version " + getDescription().getVersion() + " has been disabled!");
	}

	//On command
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		ItemHandler itemHandler = new ItemHandler(this);
		//If sender is instance of a player
		if(sender instanceof Player){
			Player player = (Player) sender;

			//If the command label is "testplugin".
			if(commandLabel.equalsIgnoreCase("Blockchanger")){

				//If the arguments are equal to 0.
				if(args.length == 0){

					//If hashmap contains the player.
					if(isPlayerToggledMap.containsKey(player)){
						toggle(player);
					}else{
						create(player);
					}
				}else{
					if(args[0].equalsIgnoreCase("list")){
						for(String s : itemHandler.getItemList()){
							player.sendMessage(s);
						}
					}else{
						if(itemHandler.isItemValid(args[0])){
							BlockChangeEventListener.item = args[0];
							player.sendMessage("===[" + ChatColor.AQUA + "Blockchanger" + ChatColor.WHITE + "]===\n" + ChatColor.GOLD + "Set blockchanger to " + args[0] + "!");
						}else{
							player.sendMessage("===[" + ChatColor.AQUA + "Blockchanger" + ChatColor.WHITE + "]===\n" + ChatColor.DARK_RED + "[ERROR] - Not a valid item!");
						}
					}
				}
			}
		}else{
			sender.sendMessage("===[" + ChatColor.AQUA + "Blockchanger" + ChatColor.WHITE + "]===\n" + ChatColor.DARK_RED + "[ERROR] - You must be a player!");
		}
		return true;

	}

	//On creation on player hashmap.
	private void create(Player player){
		isPlayerToggledMap.put(player, true);
		player.sendMessage("===[" + ChatColor.AQUA + "Blockchanger" + ChatColor.WHITE + "]===\n" + "Toggled blockchanger to true!");
	}

	//Toggles the player mode.
	private void toggle(Player player){
		if(isToggled(player)){
			isPlayerToggledMap.remove(player);
			isPlayerToggledMap.put(player, false);
			player.sendMessage("===[" + ChatColor.AQUA + "Blockchanger" + ChatColor.WHITE + "]===\n" + "Toggled blockchanger to false!");
		}else{
			isPlayerToggledMap.remove(player);
			isPlayerToggledMap.put(player, true);
			player.sendMessage("===[" + ChatColor.AQUA + "Blockchanger" + ChatColor.WHITE + "]===\n" + "Toggled blockchanger to true!");
		}
	}

	//Returns player mode.
	public boolean isToggled(Player player){
		if(isPlayerToggledMap.containsKey(player)){
			return isPlayerToggledMap.get(player);
		}else{
			return false;
		}
		
	}


}
