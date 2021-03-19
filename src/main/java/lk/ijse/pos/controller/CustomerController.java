/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.controller;


import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 3/18/2021
 **/

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> addCustomer(@RequestBody CustomerDTO dto){
        System.out.println("Controller Called");
       try {
           System.out.println("Controller save Called");
           System.out.println("Customer ID "+dto.getCustomerId());
           boolean b = customerService.saveCustomer(dto);
           return new ResponseEntity<>(b, HttpStatus.OK);
       }catch (Exception e){
           System.out.println("Controller false Called");
           return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<Boolean> deleteCustomer(@RequestParam String id) {
        try{
            boolean b = customerService.deleteCustomer(id);
            return new ResponseEntity<>(b,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Boolean> updateCustomer(@RequestBody CustomerDTO dto) {
        try{
            boolean b = customerService.updateCustomer(dto);
            return new ResponseEntity<>(b,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id) {
        try{
            CustomerDTO customerDTO = customerService.searchCustomer(id);
            return new ResponseEntity( HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        try{
            List<CustomerDTO> allCustomers = customerService.getAllCustomers();
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
