package xyz.szymon3ek.betterhomes;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.szymon3ek.betterhomes.commands.homeCommand;
import xyz.szymon3ek.betterhomes.events.moveCommandMenu;
import xyz.szymon3ek.betterhomes.events.renameevent;

public class BetterHomes extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled!");
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("home").setExecutor(new homeCommand());
        getServer().getPluginManager().registerEvents(new moveCommandMenu(), this);
        getServer().getPluginManager().registerEvents(new renameevent(), this);
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



}



