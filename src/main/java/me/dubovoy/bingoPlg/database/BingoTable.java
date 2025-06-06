package me.dubovoy.bingoPlg.database;

import com.massivecraft.massivecore.store.Coll;
import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.logic.Difficulty;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BingoTable {

    private final BingoPlg bingoPlg;
    public BingoTable(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    public void createBingoTable(){
        try{
            int itemsCount = getGridSize() * getGridSize();
            int difficulty = getDifficulty();

            List<ItemStack> items = bingoPlg.getDb().getAllListOfItems(difficulty);
            Collections.shuffle(items);
//            List<Material> materials = bingoPlg.getDb().getAllItemsForDifficulty(quality);
//            Collections.shuffle(materials);
//            for (int i = 0; i < itemsCount; i++) {
//                items.add(materials.get(i));
//            }
            bingoPlg.getDb().setBingoTablesItems(items.subList(0, itemsCount+1));
        } catch (Exception e) {
            bingoPlg.LogWMsg("Error on Creator");
            System.out.println(e);
            bingoPlg.LogErrorsMsg(e);
        }
    }

    public void generateBingoTable(){
        try{
            int itemsCount = getGridSize() * getGridSize();
            int difficulty = getDifficulty();

            List<Integer> items = bingoPlg.getDb().getIdItemsForDifficulty(difficulty);
            Collections.shuffle(items);

            bingoPlg.getDb().setIdItemsForGame(items.subList(0, itemsCount+1));
            if (bingoPlg.bLog)
                bingoPlg.LogIMsg("Bingo Table Was Generated With Difficulty: " + difficulty + " Size: " + getGridSize());
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
    }

    public boolean isBingoTableExists(){
        try{
            return !bingoPlg.getDb().noTableInDb();
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return false;
    }


    public List<ItemStack> getBingoItems(){
        List<ItemStack> items = new ArrayList<>();
        try{
            items = bingoPlg.getDb().getBingoTableItems();
//            bingoPlg.LogWMsg(items.toString());
        } catch (Exception e) {
            bingoPlg.LogWMsg("FUNC GET BINGO ITEMS");
            bingoPlg.LogErrorsMsg(e);
        }
        return items;
    }

    public int getDifficulty(){
        int difficulty = bingoPlg.minDifficulty;
        try{
            difficulty = bingoPlg.getDb().getDifficulty();

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return difficulty;
    }

    public String setDifficulty(int difficulty){
        String message = null;
        if (difficulty < bingoPlg.minDifficulty | difficulty > bingoPlg.maxDifficulty){
            message = "Недопустимая сложность сетки!";
        } else
            try{
                bingoPlg.getDb().setDifficulty(difficulty);
                message = "Сложность Bingo теперь " + difficulty;
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Bingo Difficulty was set at " + difficulty);
            } catch (Exception e) {
                bingoPlg.LogErrorsMsg(e);
            }
        return message;
    }

    public int getGridSize(){
        int grid = 0;
        try{
            grid = bingoPlg.getDb().getGridSize();

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return grid;
    }

    public String setGridSize(int gridSize){
        String message = null;
        if (gridSize<=0 | gridSize>=7){
            message = "Недопустимый размер сетки!";
        } else
            try{
                bingoPlg.getDb().setGridSize(gridSize);
                message = "Сетка Bingo теперь " + gridSize + "x" + gridSize;
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Bingo Grid Size was set at " + gridSize);
            } catch (Exception e) {
                bingoPlg.LogErrorsMsg(e);
            }
        return message;
    }

    public String getBingoMode(){
        String mode = "CROSS";
        try{
            mode = bingoPlg.getDb().getBingoMode();

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return mode;
    }

    public String setBingoMode(String mode){
        String message = null;
        List<String> modes = new ArrayList<>();
        modes.add("CROSS");
        modes.add("TABLE");
        if (!modes.contains(mode)){
            message = "Недопустимый режим бинго!";
        } else
            try{
                bingoPlg.getDb().setBingoMode(mode);
                message = "Режим Bingo теперь " + mode;
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Bingo Mode was set at " + mode);
            } catch (Exception e) {
                bingoPlg.LogErrorsMsg(e);
            }
        return message;
    }

    public int convertIndToGui(int bingoInd) {
        int grid = getGridSize();
        int colInd = bingoInd % grid;
        int rowInd = bingoInd / grid;
        return colInd + rowInd * 9;
    }

    public int convertIndToTable(int guiInd) {
        int grid = getGridSize();
        int colInd = guiInd % 9;
        int rowInd = guiInd / 9;
        return colInd + rowInd * grid;
    }

    public int[] checkBingoInvItems(ItemStack[] pInventory, String mode){
        List<Integer> invIndexes = new ArrayList<>();

        try{
            List<ItemStack> bingoItems = getBingoItems();
//            Material[] availableMeta = {Material.POTION, Material.SPLASH_POTION, Material.LINGERING_POTION, Material.TIPPED_ARROW, Material.OMINOUS_BOTTLE};
            List<String> invItems = new ArrayList<>();

            for (ItemStack itemStack: pInventory){
                if (itemStack == null)
                    continue;
                Material material = itemStack.getType();
                ItemMeta meta = itemStack.getItemMeta();
                String keyList = material.toString() + "<meta>" + meta.getAsString();
//                System.out.println(keyList);
                if (!invItems.contains(keyList)){
                    invItems.add(keyList);
                    if (bingoItems.contains(itemStack)){
                        int ind = bingoItems.indexOf(itemStack);
                        ind = convertIndToGui(ind);
//                                System.out.println(ind);
                        invIndexes.add(ind);
                    }

                }
            }
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return invIndexes.stream().mapToInt(i->i).toArray();
    }
}
