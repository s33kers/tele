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
public class AgedItemTest {

    @InjectMocks
    private GildedRose app;

    @Test
    public void updateQuality_Aged1() {
        String resultAfterDays = "Aged Brie, 9, 50";
        Item item = new Item("Aged Brie", 10, 49);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app, 1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_Aged2() {
        String resultAfterDays = "Aged Brie, 9, 51";
        Item item = new Item("Aged Brie", 10, 51);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app, 1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_Aged3() {
        String resultAfterDays = "Aged Brie, -6, 50";
        Item item = new Item("Aged Brie", -5, 48);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app, 1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_Aged4() {
        String resultAfterDays = "Aged Brie, -6, 51";
        Item item = new Item("Aged Brie", -5, 51);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app, 1, Arrays.asList(item)));
    }
}
