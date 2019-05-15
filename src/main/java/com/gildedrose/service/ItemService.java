package com.gildedrose.service;

import com.gildedrose.api.dto.Item;
import com.gildedrose.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private GildedRose gildedRose;
    private ItemRepo itemRepo;

    @Autowired
    public ItemService(GildedRose gildedRose, ItemRepo itemRepo) {
        this.gildedRose = gildedRose;
        this.itemRepo = itemRepo;
    }

    @Scheduled(cron = "${tele.item-update.cron}")
    public void updateCron() {
        //TODO batch
        gildedRose.updateQuality(getItems());
        //TODO save
    }

    //TODO paging
    public List<Item> getItems() {
        return ((PageImpl<Item>) itemRepo.findAll()).getContent();
    }
}
