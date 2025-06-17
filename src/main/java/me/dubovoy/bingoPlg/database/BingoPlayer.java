package me.dubovoy.bingoPlg.database;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Items.GuiElements;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BingoPlayer {
    private final BingoPlg bingoPlg;
    public BingoPlayer(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    public ItemStack[] getTeamInventoryItems(Player player){
        List<ItemStack> itemStacksList = new ArrayList<>();
        ItemStack[] itemStacks = new ItemStack[0];
        try{
            int teamId = bingoPlg.getDb().getTeamByPlayer(player);
            if (teamId == -1)
                return itemStacks;
            List<Player> teamPlayers = bingoPlg.getDb().listTeamPlayers(teamId);
            teamPlayers.remove(player.getPlayer());
            for (Player teammate: teamPlayers){
                itemStacksList.addAll(Arrays.stream(teammate.getInventory().getContents()).toList());
            }
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        itemStacks = new ItemStack[itemStacksList.size()];
        itemStacksList.toArray(itemStacks);

        return itemStacks;
    }

    public Inventory showGui(Player player){
        Inventory guiPlayers = Bukkit.createInventory(player, 9 * 6, "Bingo!");

        BingoTable bingoTable = new BingoTable(bingoPlg);
        GuiElements guiElements = new GuiElements();

        List<ItemStack> items = bingoTable.getBingoItems();
        int gridSize = bingoTable.getGridSize();

        ItemStack placeHolder = guiElements.invPlaceHolder();
        ItemStack spaceHolder = guiElements.invSpaceHolder();
        ItemStack playerInvItem = guiElements.playerInvMarkerPotion();
        ItemStack teamInvItem = guiElements.teamInvMarkerPotion();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                guiPlayers.setItem(i * 9 + j, placeHolder);
            }
        }
        for (int i = 6; i < 9 * 6; i+=9) {
            guiPlayers.setItem(i, spaceHolder);

        }
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                guiPlayers.setItem(i * 9 + j, items.get(i * gridSize + j));
            }
        }

        ItemStack[] teammateInvMaterials = getTeamInventoryItems(player);
        int[] indOfPlayer = bingoTable.checkBingoInvItems(player.getInventory().getContents());
        int[] indOfTeammates = bingoTable.checkBingoInvItems(teammateInvMaterials);

        Arrays.sort(indOfPlayer);
        Arrays.sort(indOfTeammates);

        for (int i:indOfTeammates){
            guiPlayers.setItem(i, teamInvItem);
        }

        for (int i:indOfPlayer){
            guiPlayers.setItem(i, playerInvItem);
        }

        return guiPlayers;
    }

    public Inventory showSettingsGui(Player player){
        Inventory settingsGui = showGui(player);
        GuiElements guiElements = new GuiElements();
        BingoTable bingoTable = new BingoTable(bingoPlg);
        int difficulty = bingoTable.getDifficulty();
        int gridSize = bingoTable.getGridSize();

        ItemStack diffBtn = guiElements.button("Difficulty: " + difficulty, Material.CARVED_PUMPKIN);
        ItemStack sizeBtn = guiElements.button("Grid Size: " + gridSize, Material.SPAWNER);
        ItemStack tableBtn = guiElements.button("Generate Table", Material.BEACON);
        ItemStack modeBtn = guiElements.button("Mode: " + bingoTable.getBingoMode(), Material.COMMAND_BLOCK);
        ItemStack allItemsBtn = guiElements.button("Items Config", Material.VAULT);
        diffBtn.setAmount(difficulty);
        sizeBtn.setAmount(gridSize);

        settingsGui.setItem(7, diffBtn);
        settingsGui.setItem(8, sizeBtn);
        settingsGui.setItem(25, modeBtn);
        settingsGui.setItem(26, tableBtn);
        settingsGui.setItem(35, allItemsBtn);

        return settingsGui;
    }

    public Inventory showItemsGui(Player player, int page){
        Inventory itemConfigGui = Bukkit.createInventory(player, 6*9, "Bingo! Items Config! Page: " + page);
        GuiElements guiElements = new GuiElements();
        BingoTable bingoTable = new BingoTable(bingoPlg);
        int lastIndex = bingoPlg.lastItemIndex + 1;
        int startIndex = (page-1)*9;
        int counter = 0;
        int lines = 0;
        ItemStack diffBtn;
        for (int itemInd = startIndex; itemInd < startIndex + 23; itemInd++) {
            ItemStack item = bingoTable.getItem(itemInd);
            int itemDifficulty = bingoTable.getItemDifficulty(itemInd);
            if (itemDifficulty <= 0) {
                diffBtn = guiElements.button("Difficulty: " + itemDifficulty, Material.RED_CONCRETE);
            } else {
                diffBtn = guiElements.button("Difficulty: " + itemDifficulty, Material.LIME_CONCRETE);
            }
            lines = counter/9;

            itemConfigGui.setItem(counter + lines * 9, item);
            itemConfigGui.setItem(counter + 9 + lines * 9, diffBtn);

            counter += 1;

        }
//        ItemStack diffBtn = guiElements.button("Difficulty: " + difficulty, Material.CARVED_PUMPKIN);
//        ItemStack sizeBtn = guiElements.button("Grid Size: " + gridSize, Material.SPAWNER);
//        ItemStack tableBtn = guiElements.button("Generate Table", Material.BEACON);
//        ItemStack modeBtn = guiElements.button("Mode: " + bingoTable.getBingoMode(), Material.COMMAND_BLOCK);
//        ItemStack allItemsBtn = guiElements.button("Items Config", Material.VAULT);
//        diffBtn.setAmount(difficulty);
//        sizeBtn.setAmount(gridSize);
//
//        settingsGui.setItem(7, diffBtn);
//        settingsGui.setItem(8, sizeBtn);
//        settingsGui.setItem(25, modeBtn);
        itemConfigGui.setItem(52, guiElements.button("Previous Page", Material.TRIAL_KEY));
        itemConfigGui.setItem(53, guiElements.button("Next Page", Material.OMINOUS_TRIAL_KEY));

        return itemConfigGui;
    }

    public boolean isPlayerWin (Player player){
        BingoTable bingoTable = new BingoTable(bingoPlg);
        GuiElements guiElements = new GuiElements();
        String bingoMode = bingoTable.getBingoMode();
        int gridSize = bingoTable.getGridSize();
        Inventory guiPlayers = player.getOpenInventory().getTopInventory();
        ItemStack playerInvItem = guiElements.playerInvMarkerPotion();

        boolean allBingoWin = false;
        boolean horizontalLine = false;
        boolean verticalLine = false;

        if (bingoMode.equals("TABLE")){
            int rowsCount = 0;
            //Horizontal Line Confirm
            for (int i = 0; i < gridSize; i++) {
                int counter = 0;
                for (int j = 0; j < gridSize; j++) {
                    int ind = i * 9 + j;
                    if (playerInvItem.getType() == guiPlayers.getItem(ind).getType()){
                        counter ++;
                        if (counter == gridSize){
                            rowsCount += 1;
                            if (bingoPlg.bLog)
                                bingoPlg.LogIMsg("Player <" + player.getName() + "> " + i + " Horizontal Line Is Completed!");
                        }
                    }
                }
            }
            if (rowsCount == gridSize){
                allBingoWin = true;
            }
        }

        if (bingoMode.equals("CROSS")){
            //Horizontal Line Confirm
            for (int i = 0; i < gridSize; i++) {
                int counter = 0;
                for (int j = 0; j < gridSize; j++) {
                    int ind = i * 9 + j;
                    if (playerInvItem.getType() == guiPlayers.getItem(ind).getType()){
                        counter ++;
                        if (counter == gridSize){
                            horizontalLine = true;
                            if (bingoPlg.bLog)
                                bingoPlg.LogIMsg("Player <" + player.getName() + "> " + i + " Horizontal Line Is Completed!");
                        }
                    }
                }
            }

            //Vertical Line Confirm
            for (int i = 0; i < gridSize; i++) {
                int counter = 0;
                for (int j = 0; j < gridSize; j++) {
                    int ind = i  + j * 9;
                    if (playerInvItem.getType() == guiPlayers.getItem(ind).getType()){
                        counter ++;
                        if (counter == gridSize){
                            verticalLine = true;
                            if (bingoPlg.bLog)
                                bingoPlg.LogIMsg("Player <" + player.getName() + "> " + i + " Vertical Line Is Completed!");
                        }
                    }
                }
            }
        }

        return allBingoWin | (horizontalLine & verticalLine);
    }

}
