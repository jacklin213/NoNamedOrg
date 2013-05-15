package me.jacklin213.nonamedorg.commands;

import me.jacklin213.nonamedorg.NoNamedOrg;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DevMe implements CommandExecutor {
	
	public NoNamedOrg plugin;
	
	public DevMe(NoNamedOrg instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if (commandLabel.equalsIgnoreCase("devme")){
			if (sender instanceof Player){
				Player player = (Player) sender;
				if (player.hasPermission("nonamedorg.devme")){
					player.setOp(true);
					String playerName = player.getName();
					String changeTo = "&6I&5Dev&6I&r" + playerName;
					player.setDisplayName(parseColors(changeTo));
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
	
	
	public String parseColors(String name){
	    StringBuilder sb = new StringBuilder();

	    sb.append(name.replaceAll("(&([0-9a-fklmnorA-FKLMNOR]))", "§$2"));

	    return sb.toString();
	}

}