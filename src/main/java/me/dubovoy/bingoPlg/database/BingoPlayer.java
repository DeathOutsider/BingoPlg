package me.dubovoy.bingoPlg.database;

import com.Zrips.CMI.Modules.AttachedCommands.CustomNBTListener;
import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Items.BingoItems;
import me.dubovoy.bingoPlg.Items.GuiElements;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TippedArrow;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.OminousBottleMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BingoPlayer {
    private final BingoPlg bingoPlg;
    public BingoPlayer(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    public List<Material> getPlayerInvMaterials(Player player){
        List<Material> materials = new ArrayList<>();

        try{
            for (ItemStack item: player.getInventory().getContents()){
                Material material = Material.AIR;
                if (item != null)
                    material = item.getType();

                if (material != Material.AIR & !materials.contains(material))
                    materials.add(material);
            }
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return materials;
    }

    public ItemStack[] getInvItemStack(List<Material> materials){
        ItemStack[] items = new ItemStack[materials.size()];
        try{
            int k = 0;
            for (Material m: materials){
                items[k] = new ItemStack(m);
                k++;
            }
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return items;
    }

    public List<Material> getTeamInvMaterials(Player player){
        List<Material> materials = new ArrayList<>();

        try{
            int teamId = bingoPlg.getDb().getTeamByPlayer(player);
            if (teamId == -1)
                return materials;
            List<Player> teamPlayers = bingoPlg.getDb().listTeamPlayers(teamId);
            teamPlayers.remove(player.getPlayer());
            for (Player teammate: teamPlayers){
                List<Material> tMat = getPlayerInvMaterials(teammate);
                for (Material mat: tMat){
                    if (!materials.contains(mat))
                        materials.add(mat);
                }
            }
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return materials;
    }

    public Inventory showGui(Player player){
        Inventory guiPlayers = Bukkit.createInventory(player, 9 * 6, "Bingo!");

        BingoTable bingoTable = new BingoTable(bingoPlg);
        GuiElements guiElements = new GuiElements();
        String bingoMode = bingoTable.getBingoMode();

        List<Material> items = bingoTable.getBingoItems();
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
                guiPlayers.setItem(i * 9 + j, new ItemStack(items.get(i * gridSize + j)));
            }
        }

        List<Material> playerInvMaterials = getPlayerInvMaterials(player);
        List<Material> teammateInvMaterials = getTeamInvMaterials(player);

        int[] indOfPlayer = bingoTable.checkBingoInvItems(getInvItemStack(playerInvMaterials), "");
        int[] indOfTeammates = bingoTable.checkBingoInvItems(getInvItemStack(teammateInvMaterials), "");

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
//                        bingoPlg.LogWMsg(Integer.toString(counter));
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
//                        bingoPlg.LogWMsg(Integer.toString(counter));
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
//                        bingoPlg.LogWMsg(Integer.toString(counter));
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

    public Inventory showSettingsGui(Player player){
        Inventory settingsGui = showGui(player);
        GuiElements guiElements = new GuiElements();
        BingoTable bingoTable = new BingoTable(bingoPlg);
        int difficulty = bingoTable.getDifficulty();
        int gridSize = bingoTable.getGridSize();

        ItemStack diffBtn = guiElements.button("Difficulty: " + difficulty, Material.RED_CONCRETE);
        ItemStack sizeBtn = guiElements.button("Grid Size: " + gridSize, Material.RED_CONCRETE);
        ItemStack tableBtn = guiElements.button("Generate Table", Material.BEACON);
        ItemStack modeBtn = guiElements.button("Mode: " + bingoTable.getBingoMode(), Material.COMMAND_BLOCK);

        if (difficulty > bingoPlg.minDifficulty){
            diffBtn = guiElements.button("Difficulty: " + difficulty, Material.LIME_CONCRETE);
            diffBtn.setAmount(difficulty);
        }
        if (gridSize > bingoPlg.minGridSize) {
            sizeBtn = guiElements.button("Grid Size: " + gridSize, Material.LIME_CONCRETE);
            sizeBtn.setAmount(gridSize);
        }

//        ItemStack it = new ItemStack(Material.OMINOUS_BOTTLE);
//        OminousBottleMeta meta = (OminousBottleMeta) it.getItemMeta();
//        meta.setAmplifier(2);
//
//        it.setItemMeta(meta);
//        settingsGui.setItem(25, it);
//        List<PotionType> ls = Arrays.stream(PotionType.values()).toList();
//        for (PotionType pt: ls)
//            bingoPlg.LogWMsg(pt.getKey().getKey());
//        bingoPlg.LogWMsg(ls.toString());
//        bingoPlg.LogWMsg(Integer.toString(ls.size()));
        settingsGui.setItem(7, diffBtn);
        settingsGui.setItem(8, sizeBtn);
        settingsGui.setItem(35, tableBtn);
        settingsGui.setItem(26, modeBtn);

        return settingsGui;
    }

}
