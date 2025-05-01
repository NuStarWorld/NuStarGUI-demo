package top.nustar.nustarguidemo;

import org.bukkit.plugin.java.JavaPlugin;
import top.nustar.nustarguidemo.commands.Commands;
import top.nustar.nustarguidemo.listener.GUIListener;
import top.nustar.nustarguidemo.managers.MenuManager;

public final class NuStarGUI_demo extends JavaPlugin {
    private MenuManager menuManager;
    public static NuStarGUI_demo INSTANCE;
    @Override
    public void onEnable() {
        // Plugin startup logic
        menuManager = new MenuManager(this);
        INSTANCE = this;
        getCommand("nustarguidemo").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new GUIListener(this), this);
    }

    public MenuManager getMenuManager() {
        return menuManager;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
