package me.advantia.Guestinator;

import java.util.logging.Logger;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Fuck extends JavaPlugin {
	
	public static final Logger log = Logger.getLogger("Minecraft");
	public static Permission permission = null;
	
	@Override
	public void onEnable() {
		if (!setupPermissions()) {
			log.info(String.format("[%s] - Disabled due to not having Vault installed.", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		log.info(String.format("[%s] Enabled Version %s", getDescription().getName(), getDescription().getVersion()));
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	@Override
	public void onDisable() {
		log.info(String.format("[%s] Disabled version %s", getDescription().getName(), getDescription().getVersion()));
	}
	
	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		permission = rsp.getProvider();
		return permission != null;
	}
	
	public boolean onSomething(CommandSender sender, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			String rank = getConfig().getString("rank");
			String message = getConfig().getString("message");
			
		if(permission.has(player, "guestinator.message")) {
			/* do shit then send a fucking message or something */
		}
	if(permission.has(player, "guestinator.reload")) {
		if((cmd.getName().equalsIgnoreCase("guestinator")) && (args.length == 1)) {
			String reload = "reload";
			if(reload.equalsIgnoreCase(args[0])){
				this.reloadConfig();
				sender.sendMessage(ChatColor.GRAY + "Guestinator reloaded.");
					}
				}
			}
		}
	}
	
	

}
