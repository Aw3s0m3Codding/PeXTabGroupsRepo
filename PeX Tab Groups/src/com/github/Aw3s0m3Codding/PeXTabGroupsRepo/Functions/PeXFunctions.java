package com.github.Aw3s0m3Codding.PeXTabGroupsRepo.Functions;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.mojang.authlib.yggdrasil.response.User;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PeXFunctions implements Listener 
{
	public static List<String> getGroup(Player player, String world) 
	{
		PermissionUser user = PermissionsEx.getUser(player);
		user.getParentIdentifiers(world);
		List<String> grupy = user.getParentIdentifiers(world);
		return grupy;
	}
}
	
