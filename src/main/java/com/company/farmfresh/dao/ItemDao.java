package com.company.farmfresh.dao;

import com.company.farmfresh.model.Item;

import java.util.List;

public interface ItemDao {
    List<Item> listOfItems();
    void addItem(Item item);
    void deleteItem(Item item);
    Item findById(int id);
    void updateItem(Item item);
    void updateItemQuantity(List<Item> items);
}
