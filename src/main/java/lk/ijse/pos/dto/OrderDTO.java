/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.dto;

import lk.ijse.pos.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 3/18/2021
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String orderId;
    private String customerId;
    private String orderDate;
    private OrderDetails details;
}
