package com.gildedrose.api;

import com.gildedrose.api.dto.Item;
import com.gildedrose.service.GildedRose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ItemController {

    private GildedRose gildedRose;

    @Autowired
    public ItemController(GildedRose gildedRose) {
        this.gildedRose = gildedRose;
    }

    //TODO add paging
    @GetMapping("/items")
    public List<Item> getItems() {
        return gildedRose.getItems();
    }
}
