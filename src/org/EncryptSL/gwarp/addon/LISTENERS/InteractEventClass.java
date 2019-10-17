package org.EncryptSL.gwarp.addon.LISTENERS;

import org.EncryptSL.gwarp.addon.GWarpSign;
import org.EncryptSL.gwarp.addon.HOOKS.GWarpHook;
import org.EncryptSL.gwarp.addon.UTILS.MessageColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEventClass implements Listener {
	
	   private GWarpSign main;
	   private GWarpHook gWarp;

	   public InteractEventClass(GWarpSign main) {
	      this.main = main;
	      this.gWarp = new GWarpHook(main);
	   }

	   @EventHandler(priority = EventPriority.LOWEST)
	   public void onInteract(PlayerInteractEvent event) {
	      Player player = event.getPlayer();
	      if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getClickedBlock().getType().name().endsWith("_SIGN")) {
	         Sign sign = (Sign)event.getClickedBlock().getState();
	         if (sign.getLine(0).equalsIgnoreCase(MessageColor.replaceColor(main.getConfig().getString("setup.signReplaceHeader")))) {
	            if (sign.getLine(1) != null && !sign.getLine(1).equals("")) {
	               if (gWarp.getWarps().contains("Warps." + sign.getLine(1) + ".name")) {
	                  if (!gWarp.getWarps().getBoolean("Warps." + sign.getLine(1) + ".lock")) {
	                     String warpName = sign.getLine(1).toLowerCase();
	                     double x = gWarp.getWarps().getDouble("Warps." + warpName + ".loc.x");
	                     double y = gWarp.getWarps().getDouble("Warps." + warpName + ".loc.y");
	                     double z = gWarp.getWarps().getDouble("Warps." + warpName + ".loc.z");
	                     World worldName = Bukkit.getWorld(gWarp.getWarps().getString("Warps." + warpName + ".loc.world"));
	                     player.teleport(new Location(worldName, x, y, z));
	                     player.sendMessage(MessageColor.replaceColor(main.getConfig().getString("messages.playerSuccessWarp").replace("%warpName%", warpName)));
	                  } else {
	                     player.sendMessage(MessageColor.replaceColor(main.getConfig().getString("messages.playerLockedWarp").replace("%warpName%", sign.getLine(1))));
	                  }
	               } else {
	                  player.sendMessage(MessageColor.replaceColor(main.getConfig().getString("messages.playerNoExistWarp")));
	               }
	            } else {
	               player.sendMessage(MessageColor.replaceColor(main.getConfig().getString("messages.signRequireError")));
	            }
	         }
	      }

	   }
}
