/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.repo;

import lk.ijse.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 3/18/2021
 **/
public interface CustomerRepo extends JpaRepository<Customer, String> {

}
