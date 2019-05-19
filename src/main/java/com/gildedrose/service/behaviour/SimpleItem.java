package com.gildedrose.service.behaviour;

import com.gildedrose.api.dto.Item;
import lombok.Data;

public class SimpleItem implements ItemBehaviour {

    protected Item item;

    public SimpleItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0) {
            if (item.getQuality() > 0) {
                item.setQuality(item.getQuality() - 1);
            }
        }
    }
}
