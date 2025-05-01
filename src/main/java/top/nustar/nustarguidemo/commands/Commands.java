package top.nustar.nustarguidemo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.nustar.nustarguidemo.NuStarGUI_demo;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        if (strings[0].equals("open")) {
            NuStarGUI_demo.INSTANCE.getMenuManager().openGui((Player) commandSender);
        }
        return true;
    }
}
