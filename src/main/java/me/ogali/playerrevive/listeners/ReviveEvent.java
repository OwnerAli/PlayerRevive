package me.ogali.playerrevive.listeners;

import me.ogali.playerrevive.PlayerRevive;
import me.ogali.playerrevive.utils.Chat;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ReviveEvent implements Listener {

    private final PlayerRevive main;

    public ReviveEvent(PlayerRevive m) {
        this.main = m;
    }

    @EventHandler
    public void onClick(PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) return;
        if (!main.getPlayerReviveHandler().waitingForRevival((Player) e.getRightClicked())) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getType() != Material.GOLDEN_APPLE) return;

        ItemStack i = e.getPlayer().getInventory().getItemInMainHand();
        Player deadPlayer = (Player) e.getRightClicked();

        if (i.getItemMeta() == null) return;
        if (!(i.getItemMeta().getDisplayName().equalsIgnoreCase(Chat.colorize("&e&l[+] REVIVAL ITEM [+]")))) return;
        if (!(i.getItemMeta().getLore() != null && i.getItemMeta().getLore().contains(Chat.colorize("&e&l*REVIVAL ITEM*")))) return;

        int amount = e.getPlayer().getInventory().getItemInMainHand().getAmount();
        e.getPlayer().getInventory().getItemInMainHand().setAmount(amount - 1);
        Chat.tell(e.getPlayer(), "&aYou have successfully revived: &f" + deadPlayer.getName());

        main.getPlayerReviveHandler().revivePlayer(deadPlayer, e.getPlayer().getName());
    }


}
