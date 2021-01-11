package de.timeox2k.mrbeast.listener;

import de.timeox2k.mrbeast.MrBeastRandomChallenge;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Random;

public class BlockBreakListener implements Listener {

    private final HashMap<String, Material> bindings = new HashMap<>();

    @EventHandler
    public void on(BlockBreakEvent event) {

        if(!bindings.containsKey(event.getBlock().getType().data.getName())) {
            Material randomMaterial = MrBeastRandomChallenge.getMaterials().get(new Random().nextInt(MrBeastRandomChallenge.getMaterials().size()));

            if (randomMaterial == Material.AIR) return;

            bindings.put(event.getBlock().getType().data.getName(), randomMaterial);
            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(randomMaterial));


        } else {
            Material material = bindings.get(event.getBlock().getType().data.getName().toString());
            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(material));
        }

    }

}
