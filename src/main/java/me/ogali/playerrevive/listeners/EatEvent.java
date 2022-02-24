package me.ogali.playerrevive.listeners;

import me.ogali.playerrevive.PlayerRevive;
import me.ogali.playerrevive.utils.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class EatEvent implements Listener {

    private final PlayerRevive m;

    public EatEvent(PlayerRevive m) {
        this.m = m;
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        if (e.getItem().getItemMeta() == null) return;
        if (!(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Chat.colorize("&e&l[+] REVIVAL ITEM [+]")))) return;
        if (!(e.getItem().getItemMeta().getLore() != null && e.getItem().getItemMeta().getLore().contains(Chat.colorize("&e&l*REVIVAL ITEM*")))) return;

        e.setCancelled(true);
    }

}
