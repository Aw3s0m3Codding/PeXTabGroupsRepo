package com.github.Aw3s0m3Codding.PeXTabGroupsRepo.Main;

import java.util.List;


import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.Aw3s0m3Codding.PeXTabGroupsRepo.Functions.PeXFunctions;
import com.githum.Aw3s0m3Codding.PeXTabGroupsRepo.Commands.PTCommand;

import net.md_5.bungee.api.ChatColor;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Main extends JavaPlugin implements Listener
{
	public FileConfiguration config = getConfig();
	
	private static Plugin plugin;
	
	
	@Override
	public void onEnable() 
	{
		plugin = this;
		String version = plugin.getDescription().getVersion();
		
		boolean pexExists = false;
		try 
		{
			PermissionsEx.isAvailable();
			pexExists = true;
		}
		
		catch(NoClassDefFoundError e)
		{
			pexExists = false;
		}
		
		if (pexExists == true) 
		{
			this.getCommand("pt").setExecutor(new PTCommand());
			getConfig().options().copyDefaults(true);
			saveConfig();
		    registerEvents(this, new PeXFunctions());
		    registerEvents(this, this);
			Bukkit.getConsoleSender().sendMessage("[" + ChatColor.BLUE + "PexTab" + ChatColor.WHITE + "]" + ChatColor.BLUE +" PexTab have been succesfuly enabled.");
			return;
		}
		else
		{
			Bukkit.getConsoleSender().sendMessage("[" + ChatColor.RED + "PexTab" + ChatColor.WHITE + "]" + ChatColor.RED + " PermissionsEx is not enabled.");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
			return;
		}
	}
	
	@Override
	public void onDisable() 
	{
		Bukkit.getConsoleSender().sendMessage("[" + ChatColor.BLUE + "PexTab" + ChatColor.WHITE + "]" + ChatColor.BLUE +" PexTab have been disabled.");
		plugin = null;
	}
	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) 
	{
	for (Listener listener : listeners) 
	{
	Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	}
	}
	
	public static Plugin getPlugin() 
	{
	return plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) 
	{
		Player p = e.getPlayer();
		World w = p.getWorld();
		String world =  w.getName();
		List<String> grupa = PeXFunctions.getGroup(p, world);
		if(config.getBoolean("Braces")) {
		Bukkit.getConsoleSender().sendMessage("braces true");
		String bcolor = config.getString("BracesColor");
		String gcolor = config.getString("Color");
		String ncolor = config.getString("NicknameColor");
		String gr = grupa.get(0);
		String grp = gr.replace("[" + "]", "");
		p.setPlayerListName("§" + bcolor+ "[" + "§" + gcolor + gr + "§" + bcolor + "]" + "§" + ncolor + " " + p.getName());
		}
		else
		{
			String gr = grupa.get(0);
			String grp = gr.replace("[" + "]", "");
			String gcolor = config.getString("Color");
			String ncolor = config.getString("NicknameColor");
			p.setPlayerListName("§" + gcolor + grp + "§" + ncolor + " " + p.getName());
		}
	}
	
	public static String PluginVersion () {
		
		return plugin.getDescription().getVersion();
		
	}

}
