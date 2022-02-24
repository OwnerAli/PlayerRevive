package me.ogali.playerrevive.items;

import me.ogali.playerrevive.utils.Chat;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ReviveItem extends ItemStack {

    public ItemStack getReviveItem(int amount) {
        ItemStack i = new ItemStack(Material.GOLDEN_APPLE, amount);
        ItemMeta meta = i.getItemMeta();

        List<String> lore = new ArrayList<>();

        lore.add(Chat.colorize("&fRight-Click a player with"));
        lore.add(Chat.colorize("&fthis item to revive them."));
        lore.add("");
        lore.add(Chat.colorize("&e&l*REVIVAL ITEM*"));

        meta.setLore(lore);
        meta.setDisplayName(Chat.colorize("&e&l[+] REVIVAL ITEM [+]"));

        i.setItemMeta(meta);
        return i;
    }

}
