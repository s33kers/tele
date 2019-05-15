package com.gildedrose;

import com.gildedrose.api.dto.Item;
import com.gildedrose.repo.ItemRepo;
import com.gildedrose.service.GildedRose;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseTest {

    @InjectMocks
    private GildedRose app;
    @Mock
    private ItemRepo itemRepo;

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
        Mockito.when(itemRepo.findAll()).thenReturn(new PageImpl<>(createItems()));

        String resultAfterDays = "+5 Dexterity Vest, 9, 19Aged Brie, 1, 1Elixir of the Mongoose, 4, 6Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 14, 21Backstage passes to a TAFKAL80ETC concert, 9, 50Backstage passes to a TAFKAL80ETC concert, 4, 50Conjured Mana Cake, 2, 5";
        assertEquals(updateForNumberOfDays(0), resultAfterDays);
    }

    @Test
    public void updateQuality_expectedResultAfter5Days() {
        Mockito.when(itemRepo.findAll()).thenReturn(new PageImpl<>(createItems()));

        String resultAfterDays = "+5 Dexterity Vest, 5, 15Aged Brie, -3, 8Elixir of the Mongoose, 0, 2Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 10, 25Backstage passes to a TAFKAL80ETC concert, 5, 50Backstage passes to a TAFKAL80ETC concert, 0, 50Conjured Mana Cake, -2, 0";
        assertEquals(updateForNumberOfDays(5), resultAfterDays);
    }

    @Test
    public void updateQuality_expectedResultAfter8Days() {
        Mockito.when(itemRepo.findAll()).thenReturn(new PageImpl<>(createItems()));

        String resultAfterDays = "+5 Dexterity Vest, 2, 12Aged Brie, -6, 14Elixir of the Mongoose, -3, 0Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 7, 31Backstage passes to a TAFKAL80ETC concert, 2, 50Backstage passes to a TAFKAL80ETC concert, -3, 0Conjured Mana Cake, -5, 0";
        assertEquals(updateForNumberOfDays(8), resultAfterDays);
    }

    private String updateForNumberOfDays(int days) {
        app.updateQuality();

        for (int i = 0; i < days - 1; i++) {
            app.updateQuality();
        }

        StringBuilder result = new StringBuilder();
        for (Item item : app.getItems()) {
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
