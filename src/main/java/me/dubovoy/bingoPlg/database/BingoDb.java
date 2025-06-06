package me.dubovoy.bingoPlg.database;

//import org.bukkit.Bukkit;
//import org.bukkit.OfflinePlayer;
import me.dubovoy.bingoPlg.BingoPlg;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.OminousBottleMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import java.sql.*;
import java.util.*;
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
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    item TEXT,
                    material TEXT,
                    meta TEXT,
                    difficulty INTEGER DEFAULT (-1),
                    minecraft_type TEXT,
                    bingo_type TEXT);
            """);
        }
    }

    // Заполнение таблицы предметами
    public void addItemSetting(String id, String ItemName, String Material, String Meta, String Difficulty, String MinecraftType, String BingoType) throws SQLException{
        boolean noItem = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM settings WHERE item = ?")){
            preparedStatement.setString(1, ItemName);
            ResultSet resultSet = preparedStatement.executeQuery();
            noItem = !resultSet.next();
        }
        if (!noItem)
            return;
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO settings (id, item, material, meta, difficulty, minecraft_type, bingo_type) VALUES (?, ?, ?, ?, ?, ?, ?)")){
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, ItemName);
            preparedStatement.setString(3, Material);
            preparedStatement.setString(4, Meta);
            preparedStatement.setInt(5, Integer.parseInt(Difficulty));
            preparedStatement.setString(6, MinecraftType);
            preparedStatement.setString(7, BingoType);
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

    public void setBingoTablesItems(List<ItemStack> itemStacks) throws SQLException{
        StringBuilder str_items = new StringBuilder();
        List<Material> supportMetaMaterials = Arrays.asList(Material.OMINOUS_BOTTLE, Material.POTION, Material.SPLASH_POTION, Material.LINGERING_POTION, Material.TIPPED_ARROW);
        for (ItemStack item: itemStacks){
            String meta = "";
            if (supportMetaMaterials.contains(item.getType())){
                if (item.getType() == Material.OMINOUS_BOTTLE){
                    OminousBottleMeta bottleMeta = (OminousBottleMeta) item.getItemMeta();
                    meta = "AMPLIFIER:" + bottleMeta.getAmplifier();
                } else {
                    PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                    meta = potionMeta.getBasePotionType().toString();
                }
            }
            str_items.append(item.getType().toString()).append("<meta>").append(meta).append(" >, ");
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE game SET items = ? WHERE id = 0")){
            preparedStatement.setString(1, str_items.toString());
            preparedStatement.executeUpdate();
        }
    }
    public boolean noTableInDb() throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM game WHERE id = 0")){
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getString("items").isEmpty();
        }
    }

    public List<ItemStack> getBingoTableItems() throws SQLException{
        List<ItemStack> items = new ArrayList<>();
        String str_items = "";
        List<Material> supportMetaMaterials = Arrays.asList(Material.OMINOUS_BOTTLE, Material.POTION, Material.SPLASH_POTION, Material.LINGERING_POTION, Material.TIPPED_ARROW);

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT items FROM game WHERE id = 0")){
            ResultSet resultSet = preparedStatement.executeQuery();
            str_items = resultSet.getString("items");
//            System.out.println("BingoDb> " + str_items);
            for (String str_item: str_items.split(">, ")){
                String str_material = str_item.split("<meta>")[0];
                String str_meta = str_item.split("<meta>")[1];
                str_meta = str_meta.strip();
//                System.out.println(str_item);
//                System.out.println(str_material);
//                System.out.println(str_meta);
                if (!str_material.isEmpty()){
                    Material item_material = Material.getMaterial(str_material);
                    if (item_material != null){
                        ItemStack item = new ItemStack(item_material);
                        if (supportMetaMaterials.contains(item_material)){
                            ItemMeta meta = item.getItemMeta();
                            if (item_material == Material.OMINOUS_BOTTLE){
                                int amplifier = Integer.parseInt(str_meta.replace("AMPLIFIER:", ""));
                                ((OminousBottleMeta) meta).setAmplifier(amplifier);
                            } else {
                                str_meta = str_meta.strip();
//                                System.out.println(str_meta);
//                                System.out.println("AWKWARD".equals(str_meta));
                                PotionType potionType = PotionType.valueOf(str_meta);
//                                System.out.println("Potion Created");
                                ((PotionMeta) meta).setBasePotionType(potionType);


                            }

                            item.setItemMeta(meta);
                        }
                        items.add(item);
                    }
                }
            }
            return items;
        }
    }

    public List<ItemStack> getListOfItems(int difficulty) throws SQLException{
        List<ItemStack> items = new ArrayList<>();
        List<Material> supportMetaMaterials = Arrays.asList(Material.OMINOUS_BOTTLE, Material.POTION, Material.SPLASH_POTION, Material.LINGERING_POTION, Material.TIPPED_ARROW);
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM settings WHERE difficulty = ?")){
            preparedStatement.setInt(1, difficulty);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String db_material = resultSet.getString("material");
                String db_meta = resultSet.getString("meta");
                db_meta = db_meta.strip();

                if (db_material != null){
                    Material item_material = Material.getMaterial(db_material);
                    if (item_material != null) {
                        ItemStack item = new ItemStack(item_material);
                        if (supportMetaMaterials.contains(item_material)){
                            ItemMeta meta = item.getItemMeta();

                            if (item_material == Material.OMINOUS_BOTTLE){

                                db_meta = db_meta.replace("AMPLIFIER:", "");
                                int amplifier = Integer.parseInt(db_meta);
                                ((OminousBottleMeta) meta).setAmplifier(amplifier);
                                if (!((OminousBottleMeta) meta).hasAmplifier())
                                    ((OminousBottleMeta) meta).setAmplifier(0);

                            } else {
                                db_meta = db_meta.strip();
                                ((PotionMeta) meta).setBasePotionType(PotionType.valueOf(db_meta));
                            }

                            item.setItemMeta(meta);
                        }

                        items.add(item);
                    }
                }
            }
            return items;
        }
    }

    public List<ItemStack> getAllListOfItems(int difficulty) throws SQLException{
        List<ItemStack> items = new ArrayList<>();

        for (int i = BingoPlg.getInstance().minDifficulty; i < difficulty + 1; i++) {
            items.addAll(getListOfItems(i));
        }

        return items;
    }

    public String getItemDbMeta(ItemStack item) throws SQLException{
        Material material = item.getType();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM settings WHERE material = ?")){
            preparedStatement.setString(1, material.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getString("meta");
        }
    }

    public ItemStack getItemFromDb(int itemId) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM settings WHERE id = ?")) {
            preparedStatement.setInt(1, itemId);
            ResultSet resultSet = preparedStatement.executeQuery();
            String dbMaterial = resultSet.getString(3);
            String dbMeta = resultSet.getString(4);

            Material itemMaterial = Material.getMaterial(dbMaterial);

            assert itemMaterial != null;
            ItemStack itemStack = new ItemStack(itemMaterial);
            ItemMeta itemMeta = itemStack.getItemMeta();

            if (!dbMeta.isEmpty()){
                if (itemMaterial != Material.OMINOUS_BOTTLE)
                    ((PotionMeta) itemMeta).setBasePotionType(PotionType.valueOf(dbMeta));
                else
                    ((OminousBottleMeta) itemMeta).setAmplifier(Integer.parseInt(dbMeta));
                itemStack.setItemMeta(itemMeta);
            }
            return itemStack;
        }
    }

    public List<Integer> getIdItemsForDifficulty(int difficulty) throws SQLException{
        List<Integer> ids = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM settings WHERE difficulty = ?")){
            preparedStatement.setInt(1, difficulty);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ids.add(Integer.parseInt(resultSet.getString("id")));
            }

            return ids;
        }
    }

    public void setIdItemsForGame(List<Integer> ids) throws SQLException{
        String bingoItemsString = String.join(" | ", ids.toString());
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE game SET items = ? WHERE id = 0")){
            preparedStatement.setString(1, bingoItemsString);
            preparedStatement.executeUpdate();
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

        for (int i = BingoPlg.getInstance().minDifficulty; i < difficulty + 1; i++) {
            materials.addAll(getItemsForDifficulty(i));
        }

        return materials;
    }


}
