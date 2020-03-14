package io.github.zepelown.main;

import io.github.zepelown.atm.event.SignEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("플러그인 활성화");
        getServer().getPluginManager().registerEvents(new SignEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("플러그인 비활성화");
    }
}
