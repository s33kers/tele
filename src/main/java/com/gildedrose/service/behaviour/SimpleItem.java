package com.gildedrose.service.behaviour;

import com.gildedrose.api.dto.Item;
import lombok.Getter;

@Getter
public class SimpleItem implements ItemBehaviour {

    protected Item item;

    public SimpleItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        decreaseQuality(item.getQuality() > 0);
        item.setSellIn(item.getSellIn() - 1);
        decreaseQuality(item.getSellIn() < 0 && item.getQuality()  > 0);
    }

    void increaseQuality(boolean condition) {
        if (condition) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    void decreaseQuality(boolean condition) {
        if (condition) {
            item.setQuality(item.getQuality() - 1);
        }
    }
}
