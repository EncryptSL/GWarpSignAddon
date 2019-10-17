package org.EncryptSL.gwarp.addon.LISTENERS;

import org.EncryptSL.gwarp.addon.GWarpSign;
import org.EncryptSL.gwarp.addon.UTILS.MessageColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChangeClass implements Listener {
	
	private GWarpSign main;

	public SignChangeClass(GWarpSign main) {
	     this.main = main;
	}

	@EventHandler
	public void onChangeSign(SignChangeEvent e) {
		Player player = e.getPlayer();
		   if (e.getLine(0).contains(main.getConfig().getString("setup.signRequireHeader"))) {
				if(player.hasPermission("gwarp.addon.sign.place")) {
				  e.setLine(0, MessageColor.replaceColor(main.getConfig().getString("setup.signReplaceHeader")));
				  player.sendMessage(MessageColor.replaceColor(main.getConfig().getString("messages.playerSuccessCreate")));
				} else {
					   e.getBlock().breakNaturally();
					   player.sendMessage(MessageColor.replaceColor(main.getConfig().getString("messages.playerPermissionsPlaceError")));
				}
		   }
	}
}
