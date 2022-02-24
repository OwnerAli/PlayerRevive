package me.ogali.playerrevive.listeners;

import me.ogali.playerrevive.PlayerRevive;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    private final PlayerRevive m;

    public LeaveEvent(PlayerRevive m) {
        this.m = m;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if (!m.getReviveTimerHandler().waitingForRevival(e.getPlayer())) return;
        m.getReviveTimerHandler().killPlayer(e.getPlayer());
    }

}
