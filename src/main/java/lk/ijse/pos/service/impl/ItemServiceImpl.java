/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.repo.ItemRepo;
import lk.ijse.pos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 3/18/2021
 **/

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean saveItem(ItemDTO dto) {
        System.out.println("Call Item service ");
        System.out.println("Item service"+dto.getItemCode());
        if (!repo.existsById(dto.getItemCode())) {
            System.out.println("Call Item true service");
            Item item = mapper.map(dto, Item.class);
            repo.save(item);
            return true;
        } else {
            throw new RuntimeException("Item already exist..!");
        }
    }

    @Override
    public boolean updateItem(ItemDTO dto) {
        if (repo.existsById(dto.getItemCode())) {
            Item item = mapper.map(dto, Item.class);
            repo.save(item);
            return true;
        } else {
            throw new RuntimeException("No such Item for update..!");
        }
    }

    @Override
    public ItemDTO searchItem(String id) {
        Optional<Item> item = repo.findById(id);
        if (item.isPresent()) {
            return mapper.map(item.get(), ItemDTO.class);
        } else {
            throw new RuntimeException("No Item for id: " + id);
        }
    }

    @Override
    public boolean deleteItem(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("No Item for delete ID: " + id);
        }
    }

    @Override
    public List<ItemDTO> getAllItem() {
        List<Item> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<ItemDTO>>() {
        }.getType());
    }
}
