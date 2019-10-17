package org.EncryptSL.gwarp.addon.LISTENERS;

import org.EncryptSL.gwarp.addon.GWarpSign;
import org.EncryptSL.gwarp.addon.UTILS.MessageColor;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakClass implements Listener {
	
	private GWarpSign main;

	public BlockBreakClass(GWarpSign main) {
	     this.main = main;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBreakGWarpSign(BlockBreakEvent e) {
	   Player player = e.getPlayer();
	   Block b = e.getBlock();
	    if (b.getType().name().endsWith("_SIGN")) {
	       Sign sign = (Sign)b.getState();
	       if (sign.getLine(0).contains(MessageColor.replaceColor(main.getConfig().getString("setup.signReplaceHeader"))) && !player.hasPermission("gwarp.addon.sign.beak")) {
	           player.sendMessage(MessageColor.replaceColor(main.getConfig().getString("messages.playerPermissionsBreakError")));
	           e.setCancelled(true);
	       }
	    }

	}
}
