package com.githum.Aw3s0m3Codding.PeXTabGroupsRepo.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import com.github.Aw3s0m3Codding.PeXTabGroupsRepo.Main.Main;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PTCommand implements CommandExecutor 
{
	@Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) 
    {
    Player player = (Player) sender;
    if (alias.equalsIgnoreCase("pt")) 
    {
    if (args.length == 0) 
    {
    if (player.hasPermission("pt.admin")) 
    {
    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "PexTab" + ChatColor.DARK_GRAY +"]" + ChatColor.RED + " Your server is running PexTab version " +  Main.PluginVersion() + ".");
    player.sendMessage(ChatColor.RED + "Your server is running PermissionsEx version " + PermissionsEx.getPlugin().getDescription().getVersion() + ".");
    player.sendMessage(ChatColor.RED + "Available commands: /pt reload.");
    }
    else 
    {
    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "PexTab" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Insufficient permissions!");	
    return false;
    }
    } 
    else 
    {
    if (args.length == 1) 
    {
    	if (player.hasPermission("pt.admin")) 
    	{
    		if (args[0].equalsIgnoreCase("reload")) 
    		{
    			Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("PexTab");
    			plugin.getServer().getPluginManager().disablePlugin(plugin);
                plugin.getServer().getPluginManager().enablePlugin(plugin);
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "PexTab" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " PexTab have been succesfully reloaded!");
                return false;
                
    		}
    		else 
    		{
    			player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "PexTab" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Incorrect argument."	);
    	    	return false;
    		}
    	}
    	else 
    	{
    	player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "PexTab" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Insufficient permissions!");	
    	return false;
    	}
    }
    else
    {
    	player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "PexTab" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Too many arguments."	);
    	return false;
    }
    }
    }
	return false;
    }
}
