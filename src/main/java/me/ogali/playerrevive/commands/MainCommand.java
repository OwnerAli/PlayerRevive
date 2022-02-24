package me.ogali.playerrevive.commands;

import me.ogali.playerrevive.PlayerRevive;
import me.ogali.playerrevive.items.ReviveItem;
import me.ogali.playerrevive.timers.ReviveTimer;
import me.ogali.playerrevive.utils.Chat;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(label.equalsIgnoreCase("playerrevive") || label.equalsIgnoreCase("pr"))) return false;
        if (!(sender instanceof Player)) return false;

        Player p = (Player) sender;

        if (args.length >= 3) {
            if (!args[0].equalsIgnoreCase("give")) return false;
            if (Bukkit.getPlayer(args[1]) == null) {
                Chat.tell(p, "&cInvalid or offline player.");
                return false;
            }

            Player receiver = Bukkit.getPlayer(args[1]);

            if (NumberUtils.isNumber(args[2])) {
                ItemStack reviveItem = new ReviveItem().getReviveItem(Integer.parseInt(args[2]));

                if (receiver.getInventory().firstEmpty() == -1) {
                    Chat.tell(receiver, "&cYour inventory was full so the item was dropped at your feet.");
                    receiver.getWorld().dropItemNaturally(receiver.getLocation(), reviveItem);
                    return false;
                }
                receiver.getInventory().addItem(reviveItem);
                return false;
            } else {
                Chat.tell(p, "&cUsage: /pr give (player) (amount)");
            }
        } else {
            Chat.tell(p, "&cUsage: /pr give (player) (amount)");
        }

        return false;
    }
}
