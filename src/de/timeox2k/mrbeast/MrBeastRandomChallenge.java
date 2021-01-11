package de.timeox2k.mrbeast;

import de.timeox2k.mrbeast.listener.BlockBreakListener;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class MrBeastRandomChallenge extends JavaPlugin {

    private static ArrayList<Material> materials;

    @Override
    public void onEnable() {
        materials = new ArrayList<>();

        for (Material material : Material.values()) {
            materials.add(material);
        }
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    public static ArrayList<Material> getMaterials() {
        return materials;
    }
}
