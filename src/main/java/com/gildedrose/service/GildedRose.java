package com.gildedrose.service;

import com.gildedrose.api.dto.Item;
import com.gildedrose.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GildedRose {

    private ItemRepo itemRepo;

    @Autowired
    public GildedRose(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public void updateQuality() {
        for (Item item : itemRepo.findAll()) {
            if (!item.getName().equals("Aged Brie")
                    && !item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.getQuality() > 0) {
                    if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                        item.setQuality(item.getQuality() - 1);
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.getSellIn() < 11) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }

                        if (item.getSellIn() < 6) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (!item.getName().equals("Aged Brie")) {
                    if (!item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.getQuality() > 0) {
                            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    } else {
                        item.setQuality(0);
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }

    public List<Item> getItems() {
        return ((PageImpl<Item>) itemRepo.findAll()).getContent();
    }

}