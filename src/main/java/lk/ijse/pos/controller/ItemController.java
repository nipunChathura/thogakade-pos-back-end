/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.controller;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 3/19/2021
 **/

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> addItem(@RequestBody ItemDTO dto){
        System.out.println("Item controller called");
        System.out.println("item controller id "+dto.getItemCode());
        try {
            System.out.println("item controller id "+dto.getItemCode());
            boolean b = itemService.saveItem(dto);
            return new ResponseEntity<>(b, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("item controller id "+dto.getItemCode());
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<Boolean> deleteItem(@RequestParam String id) {
        try{
            boolean b = itemService.deleteItem(id);
            return new ResponseEntity<>(b,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Boolean> updateItem(@RequestBody ItemDTO dto) {
        try{
            boolean b = itemService.updateItem(dto);
            return new ResponseEntity<>(b,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchItem(@PathVariable String id) {
        try{
            ItemDTO itemDTO = itemService.searchItem(id);
            return new ResponseEntity( HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        try{
            List<ItemDTO> allCustomers = itemService.getAllItem();
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
