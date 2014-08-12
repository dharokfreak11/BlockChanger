package net.genflow.blockchanger.config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import net.genflow.blockchanger.BlockChanger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager{

	static BlockChanger testplugin;
	

	// Default Config
	public static FileConfiguration getDefaultConfig(BlockChanger plugin) {
		String fileName = "config" + ".yml";
		File dataFolder = new File(BlockChanger.getInstance().getDataFolder(), "Settings");
		File configFile = new File(dataFolder, fileName);
		return YamlConfiguration.loadConfiguration(configFile);
	}

	// Default Config
	public static void saveDefaultConfig(BlockChanger plugin, FileConfiguration cfg) {
		String fileName = "config" + ".yml";
		File dataFolder = new File(BlockChanger.getInstance().getDataFolder(), "Settings");
		dataFolder.mkdirs();
		File configFile = new File(dataFolder, fileName);
		try{
			cfg.save(configFile);
		} catch(IOException ex){
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex);
		}
	}


}
