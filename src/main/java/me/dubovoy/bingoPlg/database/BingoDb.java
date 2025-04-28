package me.dubovoy.bingoPlg.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BingoDb {
    private final Connection connection;

    public BingoDb(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path);

//        selectedTable(connection);
//        playerInfoTable(connection);
    }

    // Автоматическое закрытие подключения
    public void closeConnection() throws SQLException{
        if (connection != null && !connection.isClosed())
            connection.close();
    }
}
