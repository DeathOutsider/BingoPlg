package me.dubovoy.bingoPlg.plgRecipes;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Items.BingoItems;
import me.dubovoy.bingoPlg.Keys;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.ArrayList;
import java.util.List;

public class MusicDisksRecipes {

    public static void register(){
        List<ItemStack> musics = new ArrayList<>();
        musics.add(new ItemStack(Material.MUSIC_DISC_13));
        musics.add(new ItemStack(Material.MUSIC_DISC_CAT));
        musics.add(new ItemStack(Material.MUSIC_DISC_5));
        musics.add(new ItemStack(Material.MUSIC_DISC_PIGSTEP));
        musics.add(new ItemStack(Material.MUSIC_DISC_11));
        musics.add(new ItemStack(Material.MUSIC_DISC_BLOCKS));
        musics.add(new ItemStack(Material.MUSIC_DISC_CHIRP));
        musics.add(new ItemStack(Material.MUSIC_DISC_CREATOR));
        musics.add(new ItemStack(Material.MUSIC_DISC_CREATOR_MUSIC_BOX));
        musics.add(new ItemStack(Material.MUSIC_DISC_FAR));
        musics.add(new ItemStack(Material.MUSIC_DISC_MALL));
        musics.add(new ItemStack(Material.MUSIC_DISC_MELLOHI));
        musics.add(new ItemStack(Material.MUSIC_DISC_OTHERSIDE));
        musics.add(new ItemStack(Material.MUSIC_DISC_PRECIPICE));
        musics.add(new ItemStack(Material.MUSIC_DISC_RELIC));
        musics.add(new ItemStack(Material.MUSIC_DISC_STAL));
        musics.add(new ItemStack(Material.MUSIC_DISC_STRAD));
        musics.add(new ItemStack(Material.MUSIC_DISC_WAIT));
        musics.add(new ItemStack(Material.MUSIC_DISC_WARD));
        musics.add(new ItemStack(Material.MUSIC_DISC_LAVA_CHICKEN));
        musics.add(new ItemStack(Material.MUSIC_DISC_TEARS));

        Material[] disk13M = {Material.YELLOW_DYE, Material.WHITE_DYE};
        Material[] diskCatM = {Material.LIME_DYE};
        Material[] disk11M = {Material.GRAY_DYE};
        Material[] diskBlocksM = {Material.ORANGE_DYE};
        Material[] diskChirpM = {Material.RED_DYE};
        Material[] diskFarM = {Material.YELLOW_DYE, Material.LIME_DYE};
        Material[] diskMallM = {Material.PURPLE_DYE};
        Material[] diskMellohiM = {Material.MAGENTA_DYE, Material.WHITE_DYE};
        Material[] diskOthersideM = {Material.GREEN_DYE, Material.CYAN_DYE};
        Material[] diskStalM = {Material.BLACK_DYE};
        Material[] diskStradM = {Material.WHITE_DYE};
        Material[] diskWaitM = {Material.LIGHT_BLUE_DYE};
        Material[] diskWardM = {Material.GREEN_DYE, Material.LIME_DYE};

        regRec(Material.MUSIC_DISC_13, "Disk-13", disk13M, musics);
        regRec(Material.MUSIC_DISC_CAT, "Disk-Cat", diskCatM, musics);
        regRec(Material.MUSIC_DISC_11, "Disk-11", disk11M, musics);
        regRec(Material.MUSIC_DISC_BLOCKS, "Disk-Blocks", diskBlocksM, musics);
        regRec(Material.MUSIC_DISC_CHIRP, "Disk-Chirp", diskChirpM, musics);
        regRec(Material.MUSIC_DISC_FAR, "Disk-Far", diskFarM, musics);
        regRec(Material.MUSIC_DISC_MALL, "Disk-Mall", diskMallM, musics);
        regRec(Material.MUSIC_DISC_MELLOHI, "Disk-Mellohi", diskMellohiM, musics);
        regRec(Material.MUSIC_DISC_OTHERSIDE, "Disk-Otherside", diskOthersideM, musics);
        regRec(Material.MUSIC_DISC_STAL, "Disk-Stal", diskStalM, musics);
        regRec(Material.MUSIC_DISC_STRAD, "Disk-Strad", diskStradM, musics);
        regRec(Material.MUSIC_DISC_WAIT, "Disk-Wait", diskWaitM, musics);
        regRec(Material.MUSIC_DISC_WARD, "Disk-Ward", diskWardM, musics);

        musics = new ArrayList<>();
        musics.add(new ItemStack(Material.MUSIC_DISC_CREATOR));
        musics.add(new ItemStack(Material.MUSIC_DISC_CREATOR_MUSIC_BOX));
        musics.add(new ItemStack(Material.MUSIC_DISC_PRECIPICE));

        Material[] diskCreatorM = {Material.OXIDIZED_COPPER};
        Material[] diskCreatorBoxM = {Material.COPPER_BLOCK};
        Material[] diskPrecipiceM = {Material.EXPOSED_COPPER};

        regRec(Material.MUSIC_DISC_CREATOR, "Disk-Creator", diskCreatorM, musics);
        regRec(Material.MUSIC_DISC_CREATOR_MUSIC_BOX, "Disk-CreatorBox", diskCreatorBoxM, musics);
        regRec(Material.MUSIC_DISC_PRECIPICE, "Disk-Precipice", diskPrecipiceM, musics);
    }

    public static void regRec(Material diskMaterial, String diskName, Material[] recipeMaterials, List<ItemStack> allDisks){
        int counter = 0;
        ItemStack craftableDisk = new ItemStack(diskMaterial);
        for (ItemStack disk: allDisks){
            if (disk.getType() != craftableDisk.getType()){
                ShapelessRecipe r = new ShapelessRecipe(new NamespacedKey(BingoPlg.getInstance(), diskName + "_" + counter), craftableDisk);
                for (Material recipeMaterial: recipeMaterials)
                    r.addIngredient(new ItemStack(recipeMaterial));
                r.addIngredient(disk);
                Bukkit.addRecipe(r);
            }
            counter ++;
        }
    }

}
