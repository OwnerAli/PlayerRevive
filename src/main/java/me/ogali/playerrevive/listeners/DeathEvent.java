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

    private final PlayerRevive main;

    public DeathEvent(PlayerRevive m) {
        this.main = m;
    }

    @EventHandler
    public void onDeath(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && main.getReviveTimerHandler().waitingForRevival((Player) e.getDamager())) {
            e.setCancelled(true);
        }
        if (!(e.getEntity() instanceof Player)) return;

        Player player = (Player) e.getEntity();

        if (main.getReviveTimerHandler().waitingForRevival(player)) {
            main.getReviveTimerHandler().killPlayer(player);
            return;
        }
        if (!(player.getHealth() - e.getDamage() < 1)) return;

        e.setCancelled(true);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10f, 1f);
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1));

        Chat.tell(player, "&cYou have been killed!\n&7*Your allies have 1 minute to revive you!");
        ReviveTimer rt = new ReviveTimer(main, player);
        rt.start();
    }


}
