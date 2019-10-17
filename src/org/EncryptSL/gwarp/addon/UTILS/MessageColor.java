package org.EncryptSL.gwarp.addon.UTILS;

import org.bukkit.ChatColor;

public class MessageColor {
	
	  public static String replaceColor(String message) {
		     return ChatColor.translateAlternateColorCodes('&', message);
	  }
}
