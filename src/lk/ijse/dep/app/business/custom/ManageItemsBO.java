package lk.ijse.dep.app.business.custom;

import lk.ijse.dep.app.business.SuperBO;
import lk.ijse.dep.app.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ManageItemsBO extends SuperBO {

    List<ItemDTO> getItems() throws SQLException;

    void createItem(ItemDTO dto) throws Exception;

    void updateItem(ItemDTO dto) throws Exception;

    void deleteItem(String code) throws SQLException;

    ItemDTO findItem(String itemCode) throws SQLException;



}
