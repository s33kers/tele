package com.gildedrose.service.behaviour;

import com.gildedrose.api.dto.Item;

public class Tafka extends SimpleItem {

    public Tafka(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.getQuality() < 50) {
            increaseQuality(item.getQuality() < 50);
            increaseQuality(item.getSellIn() < 11 && item.getQuality() < 50);
            increaseQuality(item.getSellIn() < 6 && item.getQuality() < 50);

        }
        item.setSellIn(item.getSellIn() - 1);

        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
    }
}
