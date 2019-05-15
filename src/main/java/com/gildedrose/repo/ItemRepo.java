package com.gildedrose.repo;

import com.gildedrose.api.dto.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends ElasticsearchCrudRepository<Item, String> {
}
