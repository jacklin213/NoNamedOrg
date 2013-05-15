package me.jacklin213.nonamedorg;

import java.util.logging.Logger;

import me.jacklin213.nonamedorg.commands.DevMe;
import me.jacklin213.nonamedorg.commands.Flex;
import me.jacklin213.nonamedorg.commands.Hex;
import me.jacklin213.nonamedorg.commands.Nno;
import me.jacklin213.nonamedorg.commands.ShutdownCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class NoNamedOrg extends JavaPlugin {
	
	public NoNamedOrg plugin;
	public Flex flex = new Flex(this);
	public Hex hex = new Hex(this);
	public DevMe devme = new DevMe(this);
	public Nno nno = new Nno(this);
	public ShutdownCommand shutdown = new ShutdownCommand(this);
	
	public Logger log = Logger.getLogger("Minecraft");

	public void onEnable() {
		getCommand("flex").setExecutor(flex);
		getCommand("hex").setExecutor(hex);
		getCommand("devme").setExecutor(devme);
		getCommand("nno").setExecutor(nno);
		getCommand("shutdown").setExecutor(shutdown);
		log.info(String.format("[%s] Version: %s by Jacklin213 has been Enabled!", getDescription().getName(), getDescription().getVersion()));
	}
	
	public void onDisable() {
		log.info(String.format("[%s] Has been Disabled!", getDescription().getName()));
	}
	
}
