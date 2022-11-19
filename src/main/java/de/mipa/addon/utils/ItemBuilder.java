package de.mipa.addon.utils;


import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemBuilder {

        private final ItemMeta itemMeta;
        private final ItemStack itemStack;

        public ItemBuilder(Material mat) {
            itemStack = new ItemStack(mat);
            itemMeta = itemStack.getItemMeta();
        }

        public ItemBuilder setAmount(int amount){
            itemStack.setAmount(amount);
            return this;
        }

        public ItemBuilder setDisplayname(String s) {
            itemMeta.setDisplayName(s);
            return this;
        }

        public ItemBuilder setLocalizedName(String s) {
            itemMeta.setLocalizedName(s);
            return this;
        }

        public ItemBuilder setLore(String... s) {
            itemMeta.setLore(Arrays.asList(s));
            return this;
        }

        public ItemBuilder setUnbreakable(boolean s) {
            itemMeta.setUnbreakable(s);
            return this;
        }

        public ItemBuilder addItemFlags(ItemFlag... s) {
            itemMeta.addItemFlags(s);
            return this;
        }

        public ItemBuilder addEnchantment(Enchantment e, int level){
            itemMeta.addEnchant(e,level,true);
            return this;
        }

        public ItemBuilder add(Attribute a, AttributeModifier am){
            itemMeta.addAttributeModifier(a,am);
            return this;
        }


        public ItemStack build() {
            itemStack.setItemMeta(itemMeta);
            return itemStack;
        }

}
