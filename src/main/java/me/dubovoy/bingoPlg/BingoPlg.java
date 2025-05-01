package me.dubovoy.bingoPlg;

import me.dubovoy.bingoPlg.commands.CreateTeam;
import me.dubovoy.bingoPlg.commands.HealPlayer;
import me.dubovoy.bingoPlg.commands.JoinTeam;
import me.dubovoy.bingoPlg.commands.TeleportTeam;
import me.dubovoy.bingoPlg.database.BingoDb;
import me.dubovoy.bingoPlg.events.PlayerJoined;
import me.dubovoy.bingoPlg.logic.Difficulty;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class BingoPlg extends JavaPlugin {

    private BingoDb database;
    public boolean bLog = true;


    @Override
    public void onEnable() {
        // Plugin startup logic
        LogWMsg("Привет! BingoPlugin успешно загружен!");
        InitCommand("Heal", new HealPlayer());
        InitCommand("CreateTeam", new CreateTeam(this));
        InitCommand("JoinTeam", new JoinTeam(this));
        InitCommand("TeleportTeam", new TeleportTeam(this));

//        InitCommand("revile", new RevileCommand(this));

        LogWMsg(Difficulty.ZeroDf().toString());
        InitEvent("PlayerJoin event", new PlayerJoined(this));
        LogWMsg("Команды и События - успешно загружены!");

        try{
            if (!getDataFolder().exists())
                getDataFolder().mkdirs();
            database = new BingoDb(getDataFolder().getAbsolutePath()+"/bingoPlugin.db");
        } catch (SQLException e) {
            getLogger().severe("Error: " + e.getMessage());
            Bukkit.getPluginManager().disablePlugin(this);
        }

//        CustomRecipes.register();

//        scoreboardDelay = getServer().getScheduler().runTaskTimer(this, ScoreboardTimer.getInstance(), 0, 20);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        try {
            database.closeConnection();
        } catch (SQLException e) {
            LogErrorsMsg(e);
        }
        LogWMsg(">> Пока-пока( BingoPlugin успешно отключен!");
    }

    public static BingoPlg getInstance() {
        return getPlugin(BingoPlg.class);
    }
    public static String getScbTimerName(){
        return BingoPlg.getInstance().getName()+"_timer";
    }

    public BingoDb getDb(){
        return this.database;
    }

    public boolean RandomChance(int chance){
        int max = 100;
        int min = 0;
        int random = (int) ((Math.random()*(max-min))+min);
        return random <= chance;
    }

    public Integer RandomCoordinates(){
        int max = 3000;
        int min = -3000;
        return (int) ((Math.random()*(max-min))+min);
    }

    public void InitCommand(String command, CommandExecutor commandExec){
        Objects.requireNonNull(this.getCommand(command), "Command not found: " + command).setExecutor(commandExec);
        if (!command.isEmpty())
            LogIMsg(command + " - команда была загружена");
    }

    public void InitEvent(String event, Listener eventListener){
        Bukkit.getPluginManager().registerEvents(eventListener, this);
        if (!event.isEmpty())
            LogIMsg(event + " - событие было загружено");

    }

    public void LogWMsg(String text){
        getLogger().warning(text);
    }
    public void LogIMsg(String text){
        getLogger().info(text);
    }
    public void LogErrorsMsg(Exception e){
        getLogger().severe("Ошибка! " + e.getMessage());
        getLogger().severe(e.toString());
    }
}
