package org.EncryptSL.gwarp.addon;

import org.EncryptSL.gwarp.addon.HOOKS.GWarpHook;
import org.EncryptSL.gwarp.addon.UTILS.MessageColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GWarpSign extends JavaPlugin {
	
	   private PluginManager pluginManager = Bukkit.getPluginManager();
	   private ConsoleCommandSender sender = this.getServer().getConsoleSender();
	   private HandlerManager manager = new HandlerManager(this);
	   private GWarpHook gWarp = new GWarpHook(this);

	   public void onEnable() {
	      this.sender.sendMessage(MessageColor.replaceColor(this.getConfig().getString("messages.pluginEnable")));
	      this.manager.registerListener();
	      this.gWarp.registerGWarp();
	      this.registerConfig();
	      this.getCommand("gWarpSignReload");
	   }

	   public void onDisable() {
	      this.sender.sendMessage(this.getConfig().getString("messages.pluginDisable"));
	      this.saveConfig();
	   }

	   public void registerConfig() {
	      this.getConfig().options().copyDefaults(true);
	      this.saveConfig();
	      this.reloadConfig();
	   }

	   public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
	      if (cmd.getName().equalsIgnoreCase("gWarpSignReload") && sender.hasPermission("gwarp.addon.sign.reload")) {
	         this.reloadConfig();
	         this.saveConfig();
	         sender.sendMessage(MessageColor.replaceColor(this.getConfig().getString("messages.pluginReload")));
	      }

	      return false;
	   }

	   public PluginManager getPluginManager() {
	      return this.pluginManager;
	   }
}
