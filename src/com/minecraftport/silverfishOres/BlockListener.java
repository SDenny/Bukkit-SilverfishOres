package com.minecraftport.silverfishOres;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BlockListener implements Listener {

    public BlockListener(main instance) {
        main.plugin = instance;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Block b = event.getBlock();
        Player p = event.getPlayer();
        List<Material> picks = new ArrayList<Material>();
        List<Material> blocks = new ArrayList<Material>();
        picks.add(Material.DIAMOND_PICKAXE);
        picks.add(Material.GOLD_PICKAXE);
        picks.add(Material.IRON_PICKAXE);
        picks.add(Material.STONE_PICKAXE);
        picks.add(Material.WOOD_PICKAXE);
        blocks.add(Material.DIAMOND_ORE);
        blocks.add(Material.EMERALD_ORE);

        if(blocks.contains(b.getType()) && picks.contains(p.getItemInHand().getType()) && p.getGameMode() == GameMode.SURVIVAL){
            double randNum = Math.random()*10;
            if(randNum >= 9) {
                Location loc = b.getLocation();
                World w = loc.getWorld();
                w.spawnEntity(loc, EntityType.SILVERFISH);
                String blockName;
                if(b.getType() == Material.DIAMOND_ORE){
                    blockName = "diamond ore";
                }else{
                    blockName = "emerald ore";
                }
                p.sendMessage(ChatColor.DARK_RED + "A silverfish spawned out of that " + blockName + "!");
            }
        }
        if(b.getType() == Material.MOB_SPAWNER){
            Location loc = b.getLocation();
            World world = b.getWorld();
            ItemStack is = new ItemStack(Material.EXP_BOTTLE, 35);
            world.dropItemNaturally(loc, is);
        }
    }
}
