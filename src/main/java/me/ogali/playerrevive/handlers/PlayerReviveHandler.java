package me.ogali.playerrevive.handlers;

import me.ogali.playerrevive.PlayerRevive;
import me.ogali.playerrevive.timers.ReviveTimer;
import me.ogali.playerrevive.utils.Chat;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class PlayerReviveHandler {

    private final Map<Player, ReviveTimer> timerMap = new HashMap<>();

    public void addReviveTimer(Player p, ReviveTimer timer) {
        timerMap.put(p, timer);
    }

    public void removeReviveTimer(Player p) {
        timerMap.get(p).stop();
        timerMap.remove(p);
    }

    public boolean waitingForRevival(Player p) {
        return timerMap.get(p) != null;
    }

    public void killPlayer(Player p) {
        p.setHealth(0.0D);
        removeReviveTimer(p);
        PlayerRevive.getInstance().getHologramHandler().removeHologram(p);
    }

    public void revivePlayer(Player p, String reviver) {
        removeReviveTimer(p);
        PlayerRevive.getInstance().getHologramHandler().removeHologram(p);
        Chat.tell(p, "&aYou have been revived by: &f" + reviver);
        p.removePotionEffect(PotionEffectType.BLINDNESS);
        p.setHealth(20.0D);
    }

}
