package me.jacklin213.nonamedorg.commands;

import me.jacklin213.nonamedorg.NoNamedOrg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hex implements CommandExecutor {
	
	public NoNamedOrg plugin;
	
	public Hex(NoNamedOrg instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if(commandLabel.equalsIgnoreCase("hex")){
			if (sender instanceof Player){
				Player player = (Player) sender;
				if (args.length == 0){
					if (sender.hasPermission("nonamedorg.hex")){
						String playerName = player.getName();
						String changeTo = "&oI&8Hexed&f&oI&r" + playerName; 
						player.setDisplayName(parseColors(changeTo));
						player.setGameMode(GameMode.SURVIVAL);
						player.setHealth(20);
						player.setOp(false);
						player.giveExp(282211200);
						player.setFlying(false);
						player.sendMessage("I have been hexed!");
						return true;
					} else {
						player.sendMessage(ChatColor.RED + "You do not have the permissions to use this command!");
						return true;
					}
				}
				if (args.length == 1){
					if (sender.hasPermission("nonamedorg.hex.other")){
						Player targetPlayer = Bukkit.getServer().getPlayerExact(args[0]);
						if (targetPlayer != null){
							String playerName = targetPlayer.getName();
							String changeTo = "&oI&8Hexed&f&oI&r" + playerName; 
							targetPlayer.setDisplayName(parseColors(changeTo));
							targetPlayer.setGameMode(GameMode.SURVIVAL);
							targetPlayer.setHealth(20);
							targetPlayer.setOp(false);
							targetPlayer.giveExp(282211200);
							targetPlayer.setFlying(false);
							targetPlayer.sendMessage("I have been hexed!");
							return true;
						} else {
							player.sendMessage("Target player is not online!");
							return true;
						}
					} else {
						player.sendMessage(ChatColor.RED + "You do not have the permissions to use this command!");
						return true;
					}
				}
				
			} else {
				sender.sendMessage("This is a player only command!");
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