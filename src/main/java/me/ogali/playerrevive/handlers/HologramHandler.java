package me.ogali.playerrevive.handlers;

import me.ogali.playerrevive.holograms.ReviveHologram;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class HologramHandler {

    private final Map<Player, ArmorStand> hologramsMap = new HashMap<>();

    public void createReviveHologram(Player deadPlayer) {
        hologramsMap.put(deadPlayer, new ReviveHologram().getReviveHologram(deadPlayer));
    }

    public void removeHologram(Player deadPlayer) {
        hologramsMap.get(deadPlayer).remove();
        hologramsMap.remove(deadPlayer);
    }

}
