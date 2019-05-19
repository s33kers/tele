package com.gildedrose.service;

import com.gildedrose.api.dto.Item;
import com.gildedrose.service.behaviour.ItemBehaviour;
import com.gildedrose.service.behaviour.ItemBehaviourFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GildedRose {

    public void updateQuality(List<Item> items) {
        for (Item item : items) {
            ItemBehaviour itemBehaviour = new ItemBehaviourFactory(item).createItem(item);
            itemBehaviour.updateQuality();
        }
    }

}