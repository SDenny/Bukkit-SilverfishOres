package com.minecraftport.silverfishOres;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    public static main plugin;
    public final BlockListener bl = new BlockListener(this);

    public void onDisable(){
        PluginManager pm = getServer().getPluginManager();
        PluginDescriptionFile config = getDescription();
        String tag = "[SilverFishOres]";
        System.out.println(tag + " v" + config.getVersion() + " has been enabled!");
    }

    public void onEnable(){
        PluginManager pm = getServer().getPluginManager();
        PluginDescriptionFile config = getDescription();
        String tag = "[SilverFishOres]";
        pm.registerEvents(bl, this);
        System.out.println(tag + " v" + config.getVersion() + " has been enabled!");
    }
}
