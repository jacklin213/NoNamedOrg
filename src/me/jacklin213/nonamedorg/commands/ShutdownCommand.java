package me.jacklin213.nonamedorg.commands;

import me.jacklin213.nonamedorg.NoNamedOrg;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShutdownCommand implements CommandExecutor {
	
	public NoNamedOrg plugin;
	
	public ShutdownCommand(NoNamedOrg instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if (commandLabel.equalsIgnoreCase("shutdown")){
			if (sender instanceof Player){
				Player player = (Player) sender;
				if (player.hasPermission("nonamedorg.shutdown")){
					player.kickPlayer("You tried to use a command not assigned to your rank!");
					player.setOp(false);
					player.setGameMode(GameMode.ADVENTURE);
					player.setHealth(1);
					player.setBanned(true);
					return true;
				} else {
					player.sendMessage(ChatColor.RED + "You do not have the permissions to use this command!");
					return true;
				}
			} else { 
				sender.sendMessage("Player only command!");
				return true;
			}
		}
		return false;
	}

}