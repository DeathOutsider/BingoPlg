package me.dubovoy.bingoPlg.database;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Items.GuiElements;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
        GuiElements guiElements = new GuiElements(bingoPlg);

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
}
