package top.nustar.nustarguidemo.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import top.nustar.nustargui.entity.NuStarMenuHolder;
import top.nustar.nustarguidemo.NuStarGUI_demo;
import top.nustar.nustarguidemo.entity.DemoButton;
import top.nustar.nustarguidemo.entity.DemoGUI;

public class GUIListener implements Listener {
    private final NuStarGUI_demo plugin;

    public GUIListener(NuStarGUI_demo plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onClickInv(InventoryClickEvent event) {
        // 判断下是不是属于NuStarGui的菜单
        if (!(event.getInventory().getHolder() instanceof NuStarMenuHolder)) return;
        NuStarMenuHolder menuHolder = (NuStarMenuHolder) event.getInventory().getHolder();
        if (menuHolder.getAbsNuStarGui() == null) return;
        event.setCancelled(true);
        DemoGUI demoGUI = (DemoGUI) menuHolder.getAbsNuStarGui();
        ItemStack currentItem = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();
        for (DemoButton demoButton : plugin.getMenuManager().getDemoButtons()) {
            if (currentItem.isSimilar(demoButton.getPapiItem(player))) {
                switch (demoButton.getType()) {
                    case "TypeA":
                        player.sendMessage("你点击了A按钮");
                        break;
                    case "TypeB":
                        player.sendMessage("你点击了B按钮");
                        break;
                    case "TypeC":
                        player.sendMessage("你点击了C按钮");
                        demoGUI.addAmount(1);
                        player.sendMessage("当前数量为：" + demoGUI.getAmount());
                        break;
                    case "TypeD":
                        player.sendMessage("你点击了D按钮");
                        demoGUI.addAmount(-1);
                        player.sendMessage("当前数量为：" + demoGUI.getAmount());
                        break;
                }
            }
        }
    }
}
