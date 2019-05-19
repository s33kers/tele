package com.gildedrose.service.behaviour;

import com.gildedrose.api.dto.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemBehaviourFactory {

    private static final Map<String, ItemBehaviour> ITEMS = new HashMap<>();

    public ItemBehaviourFactory(Item item) {
        ITEMS.put("Sulfuras, Hand of Ragnaros", new Sulfurus(item));
        ITEMS.put("Backstage passes to a TAFKAL80ETC concert", new Tafka(item));
        ITEMS.put("Aged Brie", new Aged(item));
    }

    public ItemBehaviour createItem(Item item) {
        ItemBehaviour itemBehaviour = ITEMS.get(item.getName());
        if (itemBehaviour == null) {
            itemBehaviour = new SimpleItem(item);
        }
        return itemBehaviour;
    }
}
