package com.gildedrose.service.behaviour;

import com.gildedrose.api.dto.Item;

public class Sulfurus extends SimpleItem {

    public Sulfurus(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        //Do nothing
    }
}
