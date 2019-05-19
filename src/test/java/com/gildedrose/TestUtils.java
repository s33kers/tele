package com.gildedrose;

import com.gildedrose.api.dto.Item;
import com.gildedrose.service.GildedRose;

import java.util.List;

public class TestUtils {

    public static String updateForNumberOfDays(GildedRose app, int days, List<Item> items) {

        for (int i = 0; i < days; i++) {
            items = app.updateQuality(items);
        }

        StringBuilder result = new StringBuilder();
        for (Item item : items) {
            result.append(item);
        }
        return result.toString();
    }
}
