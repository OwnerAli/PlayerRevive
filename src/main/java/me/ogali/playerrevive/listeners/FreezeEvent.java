package me.ogali.playerrevive.listeners;

import me.ogali.playerrevive.PlayerRevive;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeEvent implements Listener {

    private final PlayerRevive main;

    public FreezeEvent(PlayerRevive m) {
        this.main = m;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (!main.getPlayerReviveHandler().waitingForRevival(e.getPlayer())) return;
        e.setCancelled(true);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (!main.getPlayerReviveHandler().waitingForRevival(e.getPlayer())) return;
        e.setCancelled(true);
    }


}
