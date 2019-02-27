package lk.ijse.dep.app.dao;

import lk.ijse.dep.app.entity.SuperEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity, ID> extends SuperDAO {

    Optional<T> find(ID key) throws SQLException;

    Optional<List<T>> findAll() throws SQLException;

    void save(T entity) throws SQLException, Exception;

    void update(T entity) throws SQLException, Exception;

    void delete(ID key) throws SQLException;

}
