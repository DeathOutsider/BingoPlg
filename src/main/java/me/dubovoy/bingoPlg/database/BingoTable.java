package me.dubovoy.bingoPlg.database;

import com.massivecraft.massivecore.store.Coll;
import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.logic.Difficulty;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BingoTable {
    private final BingoPlg bingoPlg;
    public BingoTable(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    public void CreateBingoTable(){
        try{
            int itemsCount = bingoPlg.getDb().getGridSize() * bingoPlg.getDb().getGridSize();
            int quality = bingoPlg.getDb().getDifficulty();

            List<Material> items = new ArrayList<>();
            List<Material> materials = Difficulty.readBingoFiles(bingoPlg.getDataFolder().getAbsolutePath(), quality);

            Collections.shuffle(materials);
            for (int i = 0; i < itemsCount; i++) {
                items.add(materials.get(i));
            }
            bingoPlg.getDb().setItems(items);
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
    }

    public List<Material> getBingoItems(){
        List<Material> items = new ArrayList<>();
        try{
            items = bingoPlg.getDb().getItems();

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return items;
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

    public String getBingoItemsStringTable(){
        StringBuilder table = new StringBuilder();

        try{
            List<Material> items = bingoPlg.getDb().getItems();
            int rowItems = bingoPlg.getDb().getGridSize();
            for (int i = 0; i < rowItems; i++) {
                for (int j = 0; j < rowItems; j++) {
                    table.append(items.get(i * rowItems + j).toString()).append(" ");
                }
                table.append("\n");
            }
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return table.toString();
    }

    public int[] checkBingoInvItems(ItemStack[] pInventory, String mode){
        List<Integer> invIndexes = new ArrayList<>();

        try{
            List<Material> bingoItems = getBingoItems();
            List<Material> invItems = new ArrayList<>();
            for (ItemStack itemStack: pInventory){
                Material material = itemStack.getType();
                if (!invItems.contains(material)){
                    invItems.add(material);
                    if (bingoItems.contains(material))
                        invIndexes.add(bingoItems.indexOf(material));
                }
            }
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return invIndexes.stream().mapToInt(i->i).toArray();
    }
}
