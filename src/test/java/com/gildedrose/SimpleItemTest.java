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
public class SimpleItemTest {

    @InjectMocks
    private GildedRose app;

    @Test
    public void updateQuality_X1() {
        String resultAfterDays = "X, -6, -5";
        Item item = new Item("X", -5, -5);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app,1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_X2() {
        String resultAfterDays = "X, 9, 9";
        Item item = new Item("X", 10, 10);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app,1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_X3() {
        String resultAfterDays = "X, 9, -5";
        Item item = new Item("X", 10, -5);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app, 1, Arrays.asList(item)));
    }

    @Test
    public void updateQuality_X4() {
        String resultAfterDays = "X, -6, 8";
        Item item = new Item("X", -5, 10);
        assertEquals(resultAfterDays, TestUtils.updateForNumberOfDays(app,1, Arrays.asList(item)));
    }
}
