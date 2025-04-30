package me.dubovoy.bingoPlg.database;

//import org.bukkit.Bukkit;
//import org.bukkit.OfflinePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.UUID;

public class BingoDb {
    private final Connection connection;

    public BingoDb(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path);

        teamsTable(connection);
        playersTable(connection);
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

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT nickname FROM players WHERE team_id = ?")){
            preparedStatement.setInt(1, teamId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                listAllTeamPlayers.add(Bukkit.getPlayer(resultSet.getString("nickname")));
            }
            return listAllTeamPlayers;
        }
    }

}
