package me.ogali.playerrevive.timers;

import me.ogali.playerrevive.PlayerRevive;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ReviveTimer extends BukkitRunnable {

    private final PlayerRevive main;
    private final Player player;

    public ReviveTimer(PlayerRevive m, Player p) {
        this.main = m;
        this.player = p;
    }

    @Override
    public void run() {
        main.getPlayerReviveHandler().killPlayer(player);
    }

    public void start() {
        this.runTaskTimer(main, 1200, 1L);
        main.getPlayerReviveHandler().addReviveTimer(player, this);
        main.getHologramHandler().createReviveHologram(player);
    }

    public void stop() {
        this.cancel();
    }

}
