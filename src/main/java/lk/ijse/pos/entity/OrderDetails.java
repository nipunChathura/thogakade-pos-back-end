/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 3/18/2021
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetails {
    @Id
    private String OrderDetailsId;
    private int qty;
    private double unitePrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order orders;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemCode", referencedColumnName = "itemCode")
    private Item item;
}
