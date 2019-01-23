package com.company.farmfresh.service;

import com.company.farmfresh.dao.ItemDao;
import com.company.farmfresh.dao.ItemDaoImpl;
import com.company.farmfresh.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> listOfItems() {
        return itemDao.listOfItems();
    }

    @Override
    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    @Override
    public void deleteItem(Item item) {
        itemDao.deleteItem(item);
    }

    @Override
    public Item findIteamById(int id) {
        Item item=itemDao.findIteamById(id);
        return item;
    }

    @Override
    public void updateItem(Item item) {
        itemDao.updateItem(item);
    }
}
