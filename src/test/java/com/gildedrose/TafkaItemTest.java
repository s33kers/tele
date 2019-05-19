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
public class TafkaItemTest {

    @InjectMocks
    private GildedRose app;

    @Test
    public void updateQuality_backstage() {
        String resultAfterDays = "Backstage passes to a TAFKAL80ETC concert, 4, 50";
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app, 1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_backstage2() {
        String resultAfterDays = "Backstage passes to a TAFKAL80ETC concert, 4, 50";
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app, 1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_backstage3() {
        String resultAfterDays = "Backstage passes to a TAFKAL80ETC concert, 13, 41";
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 14, 40);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app, 1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_backstage4() {
        String resultAfterDays = "Backstage passes to a TAFKAL80ETC concert, 7, 42";
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 40);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app, 1, Arrays.asList(item)));
    }
}
