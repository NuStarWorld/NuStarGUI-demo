package top.nustar.nustarguidemo.entity;

import org.bukkit.configuration.ConfigurationSection;
import top.nustar.nustargui.entity.NuStarMenuButton;

public class DemoButton extends NuStarMenuButton {
    private final String type;
    public DemoButton(ConfigurationSection section) {
        super(section);
        this.type = section.getString("type");
    }

    public String getType() {
        return type;
    }
}
