package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
    }

    @Override
    public void update(Department obj) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                "SELECT * FROM department "
                + "WHERE Id = ?"
            );
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt(1));
                department.setName(rs.getString(2));
                return department;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}
