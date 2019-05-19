package com.gildedrose.service;

import com.gildedrose.api.dto.Item;
import com.gildedrose.service.behaviour.ItemBehaviour;
import com.gildedrose.service.behaviour.ItemBehaviourFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GildedRose {

    public List<Item> updateQuality(List<Item> items) {
        //TODO should use .parallelStream() with synchronizedList because arrayList is not thread-safe; need to investigate
        return items.stream().map(i -> {
            ItemBehaviour itemBehaviour = new ItemBehaviourFactory(i).createItem(i);
            itemBehaviour.updateQuality();
            return itemBehaviour.getItem();
        }).collect(Collectors.toList()); }
}