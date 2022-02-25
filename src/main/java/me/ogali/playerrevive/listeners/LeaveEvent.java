package me.ogali.playerrevive.listeners;

import me.ogali.playerrevive.PlayerRevive;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    private final PlayerRevive main;

    public LeaveEvent(PlayerRevive m) {
        this.main = m;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if (!main.getReviveTimerHandler().waitingForRevival(e.getPlayer())) return;
        main.getReviveTimerHandler().killPlayer(e.getPlayer());
    }

}
