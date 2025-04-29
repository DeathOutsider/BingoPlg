package me.dubovoy.bingoPlg.database;

import org.bukkit.entity.Player;

import java.sql.*;

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
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO players (uuid) VALUES (?)")){
            preparedStatement.setString(1, player.getUniqueId().toString());
            preparedStatement.executeUpdate();
        }
    }
}
