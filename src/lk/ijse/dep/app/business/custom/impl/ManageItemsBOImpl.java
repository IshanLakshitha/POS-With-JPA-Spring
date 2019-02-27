package lk.ijse.dep.app.business.custom.impl;

import lk.ijse.dep.app.business.Converter;
import lk.ijse.dep.app.business.custom.ManageItemsBO;
import lk.ijse.dep.app.dao.custom.ItemDAO;
import lk.ijse.dep.app.dto.ItemDTO;
import lk.ijse.dep.app.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.ControllerAdviceBean;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

@Component
@Transactional
public class ManageItemsBOImpl implements ManageItemsBO {

    private ItemDAO itemDAO;

    @Autowired
    public ManageItemsBOImpl(ItemDAO itemDAO){
       this.itemDAO = itemDAO;
    }

    public List<ItemDTO> getItems() throws SQLException{
      return itemDAO.findAll().map(Converter::<ItemDTO>getDTOList).get();
    }

    public void createItem(ItemDTO dto) throws Exception {
    itemDAO.save(Converter.getEntity(dto));
    }

    public void updateItem(ItemDTO dto) throws Exception {
    itemDAO.update(Converter.getEntity(dto));
    }

    public void deleteItem(String code) throws SQLException {
    itemDAO.delete(code);
    }

    public ItemDTO findItem(String itemCode) throws SQLException {
       return itemDAO.find(itemCode).map(Converter::<ItemDTO>getDTO).orElse(null);
    }
}
