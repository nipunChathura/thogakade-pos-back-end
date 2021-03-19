/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.repo.CustomerRepo;
import lk.ijse.pos.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean saveCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getCustomerId())) {
            System.out.println("Customer service called");
            Customer customer = mapper.map(dto, Customer.class);
            repo.save(customer);
            return true;
        } else {
            System.out.println("Customer service false called");
            return false;
        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getCustomerId())) {
            Customer customer = mapper.map(dto, Customer.class);
            repo.save(customer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customer = repo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("No customer for id: " + id);
        }
    }

    @Override
    public boolean deleteCustomer(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }
}
