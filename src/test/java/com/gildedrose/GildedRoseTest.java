package com.gildedrose;

import com.gildedrose.api.dto.Item;
import com.gildedrose.service.GildedRose;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseTest {

    @InjectMocks
    private GildedRose app;

    @Test
    public void foo() {
        //FIXME
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("foo", app.getItems()[0].getName());
    }

    @Test
    public void updateQuality_expectedResultAfter0Days() {
        String resultAfterDays = "+5 Dexterity Vest, 10, 20Aged Brie, 2, 0Elixir of the Mongoose, 5, 7Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 15, 20Backstage passes to a TAFKAL80ETC concert, 10, 49Backstage passes to a TAFKAL80ETC concert, 5, 49Conjured Mana Cake, 3, 6";
        assertEquals(updateForNumberOfDays(0, createItems()), resultAfterDays);
    }

    @Test
    public void updateQuality_expectedResultAfter5Days() {
        String resultAfterDays = "+5 Dexterity Vest, 5, 15Aged Brie, -3, 8Elixir of the Mongoose, 0, 2Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 10, 25Backstage passes to a TAFKAL80ETC concert, 5, 50Backstage passes to a TAFKAL80ETC concert, 0, 50Conjured Mana Cake, -2, 0";
        assertEquals(updateForNumberOfDays(5, createItems()), resultAfterDays);
    }

    @Test
    public void updateQuality_expectedResultAfter8Days() {
        String resultAfterDays = "+5 Dexterity Vest, 2, 12Aged Brie, -6, 14Elixir of the Mongoose, -3, 0Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 7, 31Backstage passes to a TAFKAL80ETC concert, 2, 50Backstage passes to a TAFKAL80ETC concert, -3, 0Conjured Mana Cake, -5, 0";
        assertEquals(updateForNumberOfDays(8, createItems()), resultAfterDays);
    }

    private String updateForNumberOfDays(int days, List<Item> items) {

        for (int i = 0; i < days; i++) {
            app.updateQuality(items);
        }

        StringBuilder result = new StringBuilder();
        for (Item item : items) {
            result.append(item);
        }
        return result.toString();
    }

    private static List<Item> createItems() {
        return Arrays.asList(new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) });
    }

}
