package com.gildedrose;

import com.gildedrose.api.dto.Item;
import com.gildedrose.service.GildedRose;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SulfurasItemTest {

    @InjectMocks
    private GildedRose app;

    @Test
    public void updateQuality_Sulfurus1() {
        String resultAfterDays = "Sulfuras, Hand of Ragnaros, 0, 49";
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 49);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app,1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_Sulfurus2() {
        String resultAfterDays = "Sulfuras, Hand of Ragnaros, 1, 51";
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 51);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app,1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_Sulfurus3() {
        String resultAfterDays = "Sulfuras, Hand of Ragnaros, -5, 51";
        Item item = new Item("Sulfuras, Hand of Ragnaros", -5, 51);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app,1, Arrays.asList(item)));
    }
}
