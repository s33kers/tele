package com.gildedrose.service.behaviour;

import com.gildedrose.api.dto.Item;

public class Aged extends SimpleItem {

    public Aged(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality(item.getQuality() < 50);
        item.setSellIn(item.getSellIn() - 1);
        increaseQuality(item.getSellIn() < 0 && item.getQuality() < 50);

    }
}
