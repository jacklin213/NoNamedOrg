package me.jacklin213.nonamedorg.commands;

import me.jacklin213.nonamedorg.NoNamedOrg;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Flex implements CommandExecutor {
	
	public NoNamedOrg plugin;
	
	public Flex(NoNamedOrg instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if (commandLabel.equalsIgnoreCase("flex")){
			if (sender.hasPermission("nonamedorg.flex")){
				sender.sendMessage("You have flexed!");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "You do not have the permissions to use this command!");
				return true;
			}
		}
		return false;
	}

}
