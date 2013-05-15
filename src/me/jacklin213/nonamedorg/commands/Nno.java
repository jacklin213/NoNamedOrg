package me.jacklin213.nonamedorg.commands;

import me.jacklin213.nonamedorg.NoNamedOrg;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Nno implements CommandExecutor {
	
	public NoNamedOrg plugin;
	
	public Nno(NoNamedOrg instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if (commandLabel.equalsIgnoreCase("nno")){
			if (sender.hasPermission("nonamedorg.nno")){
				sender.sendMessage(String.format("[%s] Version: %s by %s - %s", plugin.getDescription().getName(), plugin.getDescription().getVersion(), plugin.getDescription().getAuthors(), plugin.getDescription().getDescription()));
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "You do not have the permissions to use this command!");
				return true;
			}
		}
		return false;
	}

}