package top.nustar.nustarguidemo.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import top.nustar.nustargui.MenuUtil;
import top.nustar.nustargui.entity.MenuTemplate;
import top.nustar.nustarguidemo.NuStarGUI_demo;
import top.nustar.nustarguidemo.entity.DemoButton;
import top.nustar.nustarguidemo.entity.DemoGUI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private final MenuTemplate menuTemplate;
    // 自定义按钮列表
    private final List<DemoButton> demoButtons = new ArrayList<>();

    public MenuManager(NuStarGUI_demo plugin) {
        File exampleMenu = new File(plugin.getDataFolder(), "example-gui.yml");
        if (!exampleMenu.exists()) {
            plugin.saveResource("example-gui.yml", false);
        }
        // 构建菜单模板
        this.menuTemplate = MenuUtil.buildMenu(exampleMenu);
        // 获取菜单自定义按钮
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(exampleMenu);
        for (String key : yml.getConfigurationSection("Buttons").getKeys(false)) {
            demoButtons.add(new DemoButton(yml.getConfigurationSection("Buttons." + key)));
        }
    }

    public void openGui(Player player) {
        new DemoGUI(menuTemplate.getMenuTitle(), menuTemplate.getMenuName(), menuTemplate.cloneInventory()).open(player);
    }

    public List<DemoButton> getDemoButtons() {
        return demoButtons;
    }
}
