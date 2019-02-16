package com.company.farmfresh.service;

import com.company.farmfresh.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> listOfItems();
    void addItem(Item item);
    void deleteItem(Item item);
    Item findItemById(int id);
    void updateItem(Item item);
}
