package com.company.farmfresh.service;

import com.company.farmfresh.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> listOfItems();
    void addItems(Item item);
}
