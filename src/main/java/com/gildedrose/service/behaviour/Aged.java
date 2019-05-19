package com.gildedrose.service.behaviour;

import com.gildedrose.api.dto.Item;

public class Aged extends SimpleItem {

    public Aged(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
        item.setSellIn(item.getSellIn() - 1);

        if (item.getSellIn() < 0) {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }
        }

    }
}
