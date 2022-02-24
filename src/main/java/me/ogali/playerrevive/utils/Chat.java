package me.ogali.playerrevive.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void tell(Player receiver, String message) {
        receiver.sendMessage(colorize(message));
    }
}
