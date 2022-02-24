package me.ogali.playerrevive.listeners;

import me.ogali.playerrevive.PlayerRevive;
import me.ogali.playerrevive.timers.ReviveTimer;
import me.ogali.playerrevive.utils.Chat;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DeathEvent implements Listener {

    private final PlayerRevive m;

    public DeathEvent(PlayerRevive m) {
        this.m = m;
    }

    @EventHandler
    public void onDeath(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && m.getReviveTimerHandler().waitingForRevival((Player) e.getDamager())) {
            e.setCancelled(true);
        }
        if (!(e.getEntity() instanceof Player)) return;

        Player p = (Player) e.getEntity();

        if (m.getReviveTimerHandler().waitingForRevival(p)) {
            m.getReviveTimerHandler().killPlayer(p);
            return;
        }
        if (!(p.getHealth() - e.getDamage() < 1)) return;

        e.setCancelled(true);
        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10f, 1f);
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1));

        Chat.tell(p, "&cYou have been killed!\n&7*Your allies have 1 minute to revive you!");
        ReviveTimer rt = new ReviveTimer(m, p);
        rt.start();
    }


}
