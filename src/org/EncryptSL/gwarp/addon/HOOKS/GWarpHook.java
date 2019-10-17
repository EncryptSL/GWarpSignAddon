package org.EncryptSL.gwarp.addon.HOOKS;

import java.io.File;

import org.EncryptSL.gwarp.addon.GWarpSign;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class GWarpHook {
	
	   private GWarpSign main;
	   public static File file;
	   public static FileConfiguration config;

	   public GWarpHook(GWarpSign main) {
	      this.main = main;
	   }
	   
	   public void registerGWarp() {
	      Plugin plugin = this.main.getPluginManager().getPlugin("GWarp");
	      if (plugin != null) {
	         this.main.getSLF4JLogger().info("GWarp is found and now hooked !");
	      } else {
	         this.main.getSLF4JLogger().info("GWarp not found and now hooked !");
	         this.main.getSLF4JLogger().info(this.main.getConfig().getString("messages."));
	         Bukkit.getPluginManager().disablePlugin(this.main);
	      }
	   }

	   public FileConfiguration getWarps() {
	      file = new File(Bukkit.getPluginManager().getPlugin("GWarp").getDataFolder(), "Warps.data");
	      config = YamlConfiguration.loadConfiguration(file);
	      return config;
	   }
}
