/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.service;

import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailDTO;

import java.util.List;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 3/18/2021
 **/
public interface OrderService {
    boolean saveOrder(OrderDTO dto);
    boolean updateOrder(OrderDTO dto);
    OrderDTO searchOrder(String id);
    boolean deleteOrder(String id);
    List<OrderDTO> getAllOrder();
}
