package me.ogali.playerrevive.holograms;

import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;

public class ReviveHologram {

    public ArmorStand getReviveHologram(Player deadPlayer) {

        ArmorStand hologram = (ArmorStand) deadPlayer.getWorld().spawnEntity(deadPlayer.getLocation().add(0, 0.5, 0), EntityType.ARMOR_STAND);

        hologram.setVisible(false);
        hologram.setGravity(false);
        hologram.setBasePlate(false);
        hologram.setArms(false);
        hologram.setCustomNameVisible(true);

        hologram.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.ADDING_OR_CHANGING);
        hologram.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.ADDING_OR_CHANGING);
        hologram.addEquipmentLock(EquipmentSlot.OFF_HAND, ArmorStand.LockType.ADDING_OR_CHANGING);
        hologram.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.ADDING_OR_CHANGING);
        hologram.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.ADDING_OR_CHANGING);
        hologram.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.ADDING_OR_CHANGING);

        hologram.setCustomName(ChatColor.translateAlternateColorCodes('&', "&cWaiting to be revived..."));

        return hologram;
    }

}
