package com.company.farmfresh.service;

import com.company.farmfresh.dao.ItemDao;
import com.company.farmfresh.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> listOfItems() {
        return itemDao.listOfItems();
    }
}
