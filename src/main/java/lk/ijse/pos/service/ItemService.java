/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) IJSE Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.pos.service;

import lk.ijse.pos.dto.ItemDTO;

import java.util.List;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 3/18/2021
 **/

public interface ItemService {
    boolean saveItem(ItemDTO dto);
    boolean updateItem(ItemDTO dto);
    ItemDTO searchItem(String id);
    boolean deleteItem(String id);
    List<ItemDTO> getAllItem();
}
