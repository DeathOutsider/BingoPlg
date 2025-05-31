package me.dubovoy.bingoPlg;

import me.dubovoy.bingoPlg.commands.*;
import me.dubovoy.bingoPlg.commands.teams.CreateTeam;
import me.dubovoy.bingoPlg.commands.teams.DeleteTeam;
import me.dubovoy.bingoPlg.commands.teams.JoinTeam;
import me.dubovoy.bingoPlg.commands.teams.TeleportTeam;
import me.dubovoy.bingoPlg.database.BingoDb;
import me.dubovoy.bingoPlg.database.SettingsItemsDb;
import me.dubovoy.bingoPlg.events.ClockClicking;
import me.dubovoy.bingoPlg.events.CompassClicking;
import me.dubovoy.bingoPlg.events.PlayerJoined;
import me.dubovoy.bingoPlg.plgRecipes.CompassRecipe;
import me.dubovoy.bingoPlg.plgRecipes.MusicDisksRecipes;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.Objects;

public final class BingoPlg extends JavaPlugin {

    private BingoDb database;
    public boolean bLog = true;
    public int maxGridSize = 6;
    public int minGridSize = 1;
    public int maxDifficulty = 5;
    public int minDifficulty = 0;
    public int deltaCoordinates = 1000;

    @Override
    public void onEnable() {
        // Plugin startup logic
        LogWMsg("Привет! BingoPlugin v. 1.2.0 успешно загружен!");
        CompassRecipe.register();
        MusicDisksRecipes.register();
        InitCommand("Heal", new HealPlayer());
        InitCommand("CreateTeam", new CreateTeam(this));
        InitCommand("DeleteTeam", new DeleteTeam(this));
        InitCommand("JoinTeam", new JoinTeam(this));
        InitCommand("TeleportTeam", new TeleportTeam(this));
        InitCommand("Table", new CreateTableEx(this));
        InitCommand("StartBingo", new StartBingo(this));
        InitCommand("CreateTable", new GenerateTable(this));
        InitCommand("SettingsClock", new SettingsClock());

        InitEvent("PlayerJoin event", new PlayerJoined(this));
        InitEvent("PlayerInteractCompass event", new CompassClicking(this));
        InitEvent("PlayerInteractCompass event", new ClockClicking(this));

        LogWMsg("Команды и События - успешно загружены!");

        try{
            if (!getDataFolder().exists())
                getDataFolder().mkdirs();
            database = new BingoDb(getDataFolder().getAbsolutePath()+"/bingoPlugin.db");

        } catch (SQLException e) {
            getLogger().severe("Error: " + e.getMessage());
            Bukkit.getPluginManager().disablePlugin(this);
        }
        SettingsItemsDb settings = new SettingsItemsDb(this);
        settings.fillSettings();

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
        int max = deltaCoordinates;
        int min = -1 * max;
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
