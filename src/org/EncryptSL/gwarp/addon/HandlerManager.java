package org.EncryptSL.gwarp.addon;

import org.EncryptSL.gwarp.addon.LISTENERS.BlockBreakClass;
import org.EncryptSL.gwarp.addon.LISTENERS.InteractEventClass;
import org.EncryptSL.gwarp.addon.LISTENERS.SignChangeClass;

public class HandlerManager {
	private GWarpSign main;

	public HandlerManager(GWarpSign main) {
	    this.main = main;
	}

	public void registerListener() {
	    main.getPluginManager().registerEvents(new BlockBreakClass(main), main);
	    main.getPluginManager().registerEvents(new InteractEventClass(main), main);
	    main.getPluginManager().registerEvents(new SignChangeClass(main), main);
	    main.getSLF4JLogger().info("Listeners register () -> status okay !");
	}
}
