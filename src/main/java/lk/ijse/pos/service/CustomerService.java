/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.service;

import lk.ijse.pos.dto.CustomerDTO;

import java.util.List;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 3/18/2021
 **/

public interface CustomerService {
    boolean saveCustomer(CustomerDTO dto);
    boolean updateCustomer(CustomerDTO dto);
    CustomerDTO searchCustomer(String id);
    boolean deleteCustomer(String id);
    List<CustomerDTO> getAllCustomers();
}
