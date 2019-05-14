package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void updateQuality_expectedResultAfter0Days() {
        String resultAfterDays = "+5 Dexterity Vest, 9, 19Aged Brie, 1, 1Elixir of the Mongoose, 4, 6Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 14, 21Backstage passes to a TAFKAL80ETC concert, 9, 50Backstage passes to a TAFKAL80ETC concert, 4, 50Conjured Mana Cake, 2, 5";
        assertEquals(updateForNumberOfDays(0), resultAfterDays);
    }

    @Test
    public void updateQuality_expectedResultAfter5Days() {
        String resultAfterDays = "+5 Dexterity Vest, 5, 15Aged Brie, -3, 8Elixir of the Mongoose, 0, 2Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 10, 25Backstage passes to a TAFKAL80ETC concert, 5, 50Backstage passes to a TAFKAL80ETC concert, 0, 50Conjured Mana Cake, -2, 0";
        assertEquals(updateForNumberOfDays(5), resultAfterDays);
    }

    @Test
    public void updateQuality_expectedResultAfter8Days() {
        String resultAfterDays = "+5 Dexterity Vest, 2, 12Aged Brie, -6, 14Elixir of the Mongoose, -3, 0Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 7, 31Backstage passes to a TAFKAL80ETC concert, 2, 50Backstage passes to a TAFKAL80ETC concert, -3, 0Conjured Mana Cake, -5, 0";
        assertEquals(updateForNumberOfDays(8), resultAfterDays);
    }

    private String updateForNumberOfDays(int days) {
        GildedRose app = new GildedRose(createItems());
        app.updateQuality();

        for (int i = 0; i < days - 1; i++) {
            app.updateQuality();
        }

        StringBuilder result = new StringBuilder();
        for (Item item : app.items) {
            result.append(item);
        }
        return result.toString();
    }

    private static Item[] createItems() {
        return new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };
    }

}
