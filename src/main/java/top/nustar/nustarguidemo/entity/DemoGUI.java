package top.nustar.nustarguidemo.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import top.nustar.nustargui.entity.AbsNuStarGui;
import top.nustar.nustargui.entity.NuStarMenuHolder;

public class DemoGUI extends AbsNuStarGui {
    // 自定义菜单继承抽象菜单的目的是可以让自定义菜单携带自定义对象
    private final String customObj = "菜单携带的文本";
    private int amount;

    private Inventory demoInventory;
    public DemoGUI(String title, String menuName, Inventory templateInventory) {
        super(title, menuName, templateInventory);
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getCustomObj() {
        return customObj;
    }

    @Override
    public void open(Player player) {
        player.openInventory(refresh(player));
    }

    @Override
    public Inventory refresh(Player player) {
        // 克隆菜单对象
        // 注意这里的MenuHolder携带了当前对象
        demoInventory = Bukkit.createInventory(
                new NuStarMenuHolder((NuStarMenuHolder) templateInventory.getHolder(),this),
                templateInventory.getSize(),
                title
        );
        demoInventory.setContents(templateInventory.getContents());
        // ...下面可以自己写一些更新菜单内容的逻辑
        // .......
        return demoInventory;
    }
}
