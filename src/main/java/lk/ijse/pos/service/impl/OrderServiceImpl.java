
package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.entity.Order;
import lk.ijse.pos.repo.CustomerRepo;
import lk.ijse.pos.repo.OrderDetailsRepo;
import lk.ijse.pos.repo.OrderRepo;
import lk.ijse.pos.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 3/18/2021
 **/
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo repo;

    @Autowired
    OrderDetailsRepo detailsRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean saveOrder(OrderDTO dto) {
        System.out.println("Order Service called");
        System.out.println("Order Service called id "+dto.getOrderId());
        if (customerRepo.existsById(dto.getCustomerId())){
            boolean b = customerRepo.existsById(dto.getCustomerId());
            System.out.println(b);
            if (!repo.existsById(dto.getOrderId())) {
                System.out.println("");
                Order order = mapper.map(dto, Order.class);
                repo.save(order);
                return true;
//                if (!detailsRepo.existsById(dto.getDetails().getOrderDetailsId())){
//                    System.out.println("CAAAAAAAAALLLLLLLLLLLLLL");
//                    OrderDetails details = mapper.map(dto.getDetails(), OrderDetails.class);
//                    detailsRepo.save(details);
//                    return true;
//                } else {
//                    throw new RuntimeException("Not Added Order Details");
//                }
            } else {
                return false;
            }
        } else {
            throw new RuntimeException("Plz check added customer.....?");
        }
    }

    @Override
    public boolean updateOrder(OrderDTO dto) {
        if (repo.existsById(dto.getOrderId())) {
            Order order = mapper.map(dto, Order.class);
            repo.save(order);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public OrderDTO searchOrder(String id) {
        Optional<Order> order= repo.findById(id);
        if (order.isPresent()) {
            return mapper.map(order.get(), OrderDTO.class);
        } else {
            throw new RuntimeException("No Order for id: " + id);
        }
    }

    @Override
    public boolean deleteOrder(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        List<Order> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<OrderDTO>>() {
        }.getType());
    }
}
