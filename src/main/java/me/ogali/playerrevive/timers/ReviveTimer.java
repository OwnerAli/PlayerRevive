package me.ogali.playerrevive.timers;

import me.ogali.playerrevive.PlayerRevive;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ReviveTimer extends BukkitRunnable {

    private final PlayerRevive m;
    private final Player p;

    public ReviveTimer(PlayerRevive m, Player p) {
        this.m = m;
        this.p = p;
    }

    @Override
    public void run() {
        m.getReviveTimerHandler().killPlayer(p);
    }

    public void start() {
        this.runTaskTimer(m, 1200, 1L);
        m.getReviveTimerHandler().addReviveTimer(p, this);
    }

    public void stop() {
        this.cancel();
    }

}
