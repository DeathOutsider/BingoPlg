package me.dubovoy.bingoPlg.database;

//import org.bukkit.Bukkit;
//import org.bukkit.OfflinePlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//import java.util.UUID;

public class BingoDb {
    private final Connection connection;

    public BingoDb(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path);

        teamsTable(connection);
        playersTable(connection);
        gameTable(connection);
        settingsTable(connection);
        insertGame();
    }

    private void teamsTable(Connection connection) throws SQLException{
        try (Statement statement = connection.createStatement()){
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS teams(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT UNIQUE);
            """);
        }
    }

    private void playersTable(Connection connection) throws SQLException{
        try (Statement statement = connection.createStatement()){
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS players(
                    uuid TEXT PRIMARY KEY,
                    nickname TEXT,
                    team_id INTEGER DEFAULT (-1));
            """);
        }
    }

    private void gameTable(Connection connection) throws SQLException{
        try (Statement statement = connection.createStatement()){
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS game(
                    id INTEGER PRIMARY KEY,
                    title TEXT,
                    gameMode TEXT,
                    difficulty INTEGER DEFAULT (3),
                    gridSize INTEGER DEFAULT (5),
                    items TEXT);
            """);
        }
    }

    private void settingsTable(Connection connection) throws SQLException{
        try (Statement statement = connection.createStatement()){
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS settings(
                    id INTEGER PRIMARY KEY,
                    item TEXT UNIQUE,
                    material TEXT UNIQUE,
                    difficulty INTEGER DEFAULT (-1),
                    minecraft_type TEXT,
                    bingo_type TEXT);
            """);
        }
    }

    public void addItemSetting(String item, String material, int difficulty) throws SQLException{
        boolean noItem = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM settings WHERE item = ?")){
            preparedStatement.setString(1, item);
            ResultSet resultSet = preparedStatement.executeQuery();
            noItem = !resultSet.next();
        }
        if (!noItem)
            return;
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO settings (item, material, difficulty) VALUES (?, ?, ?)")){
            preparedStatement.setString(1, item);
            preparedStatement.setString(2, material);
            preparedStatement.setInt(3, difficulty);
            preparedStatement.executeUpdate();

        }
    }

    // Автоматическое закрытие подключения
    public void closeConnection() throws SQLException{
        if (connection != null && !connection.isClosed())
            connection.close();
    }

    public boolean noPlayerInDb(Player player) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid = ?")){
            preparedStatement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            return !resultSet.next();
        }
    }

    public void addPlayer(Player player) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO players (uuid, nickname) VALUES (?, ?)")){
            preparedStatement.setString(1, player.getUniqueId().toString());
            preparedStatement.setString(2, player.getName());
            preparedStatement.executeUpdate();

        }
    }

    public boolean noTeamInDb(String teamName) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teams WHERE name = ?")){
            preparedStatement.setString(1, teamName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return !resultSet.next();
        }
    }

    public void addTeam(String teamName) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO teams (name) VALUES (?)")){
            preparedStatement.setString(1, teamName);
            preparedStatement.executeUpdate();
        }
    }

    public void removeTeam(String teamName) throws SQLException{
        int teamId = getTeamByName(teamName);

        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET team_id = ? WHERE team_id = ?")){
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, teamId);
            preparedStatement.executeUpdate();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM teams WHERE id = ?")){
            preparedStatement.setInt(1, teamId);
            preparedStatement.executeUpdate();
        }
    }

    public int getTeamByName(String teamName) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM teams WHERE name = ?")){
            preparedStatement.setString(1, teamName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getInt("id");
        }
    }

    public String getTeamById(int teamId) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM teams WHERE id = ?")){
            preparedStatement.setInt(1, teamId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getString("name");
        }
    }

    public int getTeamByPlayer(Player player) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT team_id FROM players WHERE uuid = ?")){
            preparedStatement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getInt("team_id");
        }
    }

    public void updatePlayerTeam(Player player, int teamId) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET team_id = ? WHERE uuid = ?")){
            preparedStatement.setInt(1, teamId);
            preparedStatement.setString(2, player.getUniqueId().toString());
            preparedStatement.executeUpdate();
        }
    }

    public List<String> listTeams() throws SQLException{
        List<String> listAllTeams = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM teams")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                listAllTeams.add(resultSet.getString("name"));
            }
            return listAllTeams;
        }
    }
    public List<Player> listTeamPlayers(int teamId) throws SQLException{
        List<Player> listAllTeamPlayers = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT uuid FROM players WHERE team_id = ?")){
            preparedStatement.setInt(1, teamId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Player player = Bukkit.getPlayer(UUID.fromString(resultSet.getString("uuid")));
                if (player != null && player.isOnline())
                        listAllTeamPlayers.add(player);
            }
            return listAllTeamPlayers;
        }
    }

    public void insertGame() throws SQLException{
        boolean gameInDb = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM game")){
            ResultSet resultSet = preparedStatement.executeQuery();
            gameInDb = resultSet.next();
        }

        if (gameInDb)
            return;

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO game (id, title, gameMode) VALUES (?, ?, ?)")){
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, "BINGO!");
            preparedStatement.setString(3, "CROSS");
            preparedStatement.executeUpdate();
        }
    }

    public void setDifficulty(int difficulty) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE game SET difficulty = ? WHERE id = 0")){
            preparedStatement.setInt(1, difficulty);
            preparedStatement.executeUpdate();
        }
    }

    public int getDifficulty() throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT difficulty FROM game WHERE id = 0")){
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getInt("difficulty");
        }
    }

    public void setGridSize(int gridSize) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE game SET gridSize = ? WHERE id = 0")){
            preparedStatement.setInt(1, gridSize);
            preparedStatement.executeUpdate();
        }
    }

    public int getGridSize() throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT gridSize FROM game WHERE id = 0")){
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getInt("gridSize");
        }
    }

    public String getBingoMode() throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT gameMode FROM game WHERE id = 0")){
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getString("gameMode");
        }
    }

    public void setBingoMode(String mode) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE game SET gameMode = ? WHERE id = 0")){
            preparedStatement.setString(1, mode);
            preparedStatement.executeUpdate();
        }
    }


    public void setBingoTablesItems(List<Material> materials) throws SQLException{
        String items = materials.toString();
        items = items.replace("[", "");
        items = items.replace("]", "");
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE game SET items = ? WHERE id = 0")){
            preparedStatement.setString(1, items);
            preparedStatement.executeUpdate();
        }
    }

    public List<Material> getBingoTableItems() throws SQLException{
        List<Material> materials = new ArrayList<>();
        String items = "";
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT items FROM game WHERE id = 0")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                items = resultSet.getString("items");
            }
            for (String i: items.split(", ")){
                materials.add(Material.getMaterial(i));
            }
            return materials;
        }
    }

    public List<Material> getItemsForDifficulty(int difficulty) throws SQLException{
        List<Material> materials = new ArrayList<>();
        String items = "";
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM settings WHERE difficulty = ?")){
            preparedStatement.setInt(1, difficulty);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                items += resultSet.getString("material") + ", ";
            }
            for (String i: items.split(", ")){
                materials.add(Material.getMaterial(i));
            }
            return materials;
        }
    }

    public List<Material> getAllItemsForDifficulty(int difficulty) throws SQLException{
        List<Material> materials = new ArrayList<>();

        for (int i = 0; i < difficulty + 1; i++) {
            materials.addAll(getItemsForDifficulty(i));
        }

        return materials;
    }


}
