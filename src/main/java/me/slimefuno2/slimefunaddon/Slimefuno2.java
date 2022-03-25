package me.slimefuno2.slimefunaddon;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class Slimefuno2 extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        /*
         * 1. Creating a new Category
         * This Category will use the following ItemStack
         */
        ItemStack itemGroupItem = new CustomItemStack(Material.SLIME_BALL, "&aSlimefuno", "", "&a> Click to open");
        //A category inside the slimefuno category


        // Give your Category a unique id.
        NamespacedKey itemGroupId = new NamespacedKey(this, "addon_category");
        ItemGroup itemGroup = new ItemGroup(itemGroupId, itemGroupItem);

        /*
         * 2. Create a new SlimefunItemStack
         * This class has many constructors, it is very important
         * that you give each item a unique id.
         */
        SlimefunItemStack clearslime = new SlimefunItemStack("CLEAR_SLIME", Material.SLIME_BALL, "&aClear Slime", "&aI can see right through it");
        //Condensed Slime
        SlimefunItemStack condensedslime = new SlimefunItemStack("CONDENSED_SLIME", Material.SLIME_BLOCK, "&aCondensed Slime", "&aIt's so condensed that", "&aI can't see through it");
        //Slimy Hair
        SlimefunItemStack slimyhair = new SlimefunItemStack("SLIMY_HAIR", Material.SLIME_BALL, "&aSlimy Hair", "&aIt's so slimy and fluffy", "&aThat I can run my", "&afingers through it");
        

        /*
         * 3. Creating a Recipe
         * The Recipe is an ItemStack Array with a length of 9.
         * It represents a Shaped Recipe in a 3x3 crafting grid.
         * The machine in which this recipe is crafted in is specified
         * further down as the RecipeType.
         */
        ItemStack[] clearslimerecipe = { new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.GLASS), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL) };
        ItemStack[] condensedslimerecipe = { new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK) };
        ItemStack[] slimyhairrecipe = { new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.STRING), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL) };

        /*
         * 4. Registering the Item
         * Now you just have to register the item.
         * RecipeType.ENHANCED_CRAFTING_TABLE refers to the machine in
         * which this item is crafted in.
         * Recipe Types from Slimefun itself will automatically add the recipe to that machine.
         */
        SlimefunItem clearslimeitem = new SlimefunItem(itemGroup, clearslime, RecipeType.ENHANCED_CRAFTING_TABLE, clearslimerecipe);
        SlimefunItem condensedslimeitem = new SlimefunItem(itemGroup, condensedslime, RecipeType.ENHANCED_CRAFTING_TABLE, condensedslimerecipe);
        SlimefunItem slimyhairitem = new SlimefunItem(itemGroup, slimyhair, RecipeType.ENHANCED_CRAFTING_TABLE, slimyhairrecipe);
        clearslimeitem.register(this);
        condensedslimeitem.register(this);
        slimyhairitem.register(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
