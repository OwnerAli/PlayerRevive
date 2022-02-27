package me.ogali.playerrevive;

import me.ogali.playerrevive.commands.MainCommand;
import me.ogali.playerrevive.handlers.HologramHandler;
import me.ogali.playerrevive.handlers.PlayerReviveHandler;
import me.ogali.playerrevive.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PlayerRevive extends JavaPlugin {

    private static PlayerRevive instance;
    private PlayerReviveHandler playerReviveHandler;
    private HologramHandler hologramHandler;

    @Override
    public void onEnable() {
        instance = this;
        registerEvents();
        registerCommands();
        registerHandlers();
    }

    public void registerCommands() {
        Objects.requireNonNull(getCommand("playerrevive")).setExecutor(new MainCommand());
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
        getServer().getPluginManager().registerEvents(new FreezeEvent(this), this);
        getServer().getPluginManager().registerEvents(new ReviveEvent(this), this);
        getServer().getPluginManager().registerEvents(new EatEvent(this), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(this), this);
    }

    public void registerHandlers() {
        playerReviveHandler = new PlayerReviveHandler();
        hologramHandler = new HologramHandler();
    }

    public static PlayerRevive getInstance() {
        return instance;
    }

    public PlayerReviveHandler getPlayerReviveHandler() {
        return playerReviveHandler;
    }

    public HologramHandler getHologramHandler() {
        return hologramHandler;
    }
}
