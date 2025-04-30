package me.dubovoy.bingoPlg;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Msg {
    public static void send(CommandSender commandSender, String message){
        commandSender.sendMessage(message);
    }

    public static void send(CommandSender commandSender, String message, String prefix){
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
    }

    public static void sendTitle(Audience target, String message){
        final Component mainTitle = Component.text("");
        final Component subtitle = Component.text(message);
        final Title title = Title.title(mainTitle, subtitle);
        target.showTitle(title);
    }

    public static void sendTitle(Audience target, String mainTitleText, String subtitleText){
        final Component mainTitle = Component.text(mainTitleText);
        final Component subtitle = Component.text(subtitleText);
        final Title title = Title.title(mainTitle, subtitle);
        target.showTitle(title);
    }
}
