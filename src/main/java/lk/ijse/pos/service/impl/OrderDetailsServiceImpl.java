/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.OrderDetailDTO;
import lk.ijse.pos.entity.OrderDetails;
import lk.ijse.pos.repo.OrderDetailsRepo;
import lk.ijse.pos.repo.OrderRepo;
import lk.ijse.pos.service.OrderDetailsService;
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
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsRepo repo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ModelMapper mapper;

    @Transactional
    @Override
    public boolean saveOrderDetails(OrderDetailDTO dto) {

        if (orderRepo.existsById(dto.getOrderId())){
            if (!repo.existsById(dto.getOrderDetailsId())) {
                OrderDetails details = mapper.map(dto, OrderDetails.class);
                repo.save(details);
                return true;
            } else {
                throw new RuntimeException("Order Details already exist..!");
            }
        }else {
            throw new  RuntimeException("Plz check your order added....? ");
        }
    }

    @Override
    public boolean updateOrderDetails(OrderDetailDTO dto) {
        if (repo.existsById(dto.getOrderDetailsId())) {
            OrderDetails order = mapper.map(dto, OrderDetails.class);
            repo.save(order);
            return true;
        } else {
            throw new RuntimeException("No such Order for update..!");
        }
    }

    @Override
    public OrderDetailDTO searchOrderDetails(String id) {
        Optional<OrderDetails> details = repo.findById(id);
        if (details.isPresent()) {
            return mapper.map(details.get(), OrderDetailDTO.class);
        } else {
            throw new RuntimeException("No Order Details for id: " + id);
        }
    }

    @Override
    public boolean deleteOrderDetails(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("No Order Details for delete ID: " + id);
        }
    }

    @Override
    public List<OrderDetailDTO> getAllOrderDetails() {
        List<OrderDetails> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<OrderDetailDTO>>() {
        }.getType());
    }
}
