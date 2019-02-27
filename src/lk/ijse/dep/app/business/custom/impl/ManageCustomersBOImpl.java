package lk.ijse.dep.app.business.custom.impl;

import lk.ijse.dep.app.business.Converter;
import lk.ijse.dep.app.business.custom.ManageCustomersBO;
import lk.ijse.dep.app.dao.custom.CustomerDAO;
import lk.ijse.dep.app.dto.CustomerDTO;
import lk.ijse.dep.app.util.JPAUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

@Component
@Transactional
public class ManageCustomersBOImpl implements ManageCustomersBO {

    private CustomerDAO customerDAO;

    public ManageCustomersBOImpl(CustomerDAO customerDAO){
       this.customerDAO = customerDAO;
    }

    public List<CustomerDTO> getCustomers() throws SQLException {
      return customerDAO.findAll().map(Converter::<CustomerDTO>getDTOList).get();
    }

    public void createCustomer(CustomerDTO dto) throws Exception {
      customerDAO.save(Converter.getEntity(dto));
    }

    public void updateCustomer(CustomerDTO dto) throws Exception {
     customerDAO.update(Converter.getEntity(dto));
    }

    public void deleteCustomer(String customerID) throws SQLException {
      customerDAO.delete(customerID);
    }

    public CustomerDTO findCustomer(String id) throws SQLException {
    return customerDAO.find(id).map(Converter::<CustomerDTO>getDTO).orElse(null);
    }

}
