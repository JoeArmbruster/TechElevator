package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

    private final String DEPARTMENT_SELECT = "SELECT d.department_id, d.name FROM department d ";

    private final JdbcTemplate jdbcTemplate;

    public JdbcDepartmentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Department getDepartmentById(int id) {
        try {
            Department department = null;
            String sql = DEPARTMENT_SELECT +
                    " WHERE d.department_id=?";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                department = mapRowToDepartment(results);
            }

            if (department == null) {
                throw new DaoException("Department not found for id: " + id);
            }

            return department;
        } catch (DataAccessException ex) {
            throw new DaoException("Error retrieving deparmtent", ex);
        }
    }

    @Override
    public List<Department> getDepartments() {
        try {
            List<Department> departments = new ArrayList<>();
            String sql = DEPARTMENT_SELECT;

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                departments.add(mapRowToDepartment(results));
            }

            return departments;
        } catch (DataAccessException ex) {
            throw new DaoException("Error retrieving departments", ex);
        }
    }

    @Override
    public Department createDepartment(Department department) {
        Department newDepartment = null;

        String sql = "INSERT INTO department (name) VALUES (?) RETURNING department_id;";
        try {
            int newDepartmentId = jdbcTemplate.queryForObject(sql, Integer.class, department.getName());

            newDepartment = getDepartmentById(newDepartmentId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newDepartment;
    }

    @Override
    public Department updateDepartment(Department department) {
        try {
            String sql = "UPDATE department SET name = ? WHERE department_id = ?;";
            jdbcTemplate.update(sql, department.getName(), department.getId());
            return department;
        } catch (DataAccessException ex) {
            throw new DaoException("Error updating department", ex);
        }
    }

    @Override
    public int deleteDepartmentById(int id) {
        String deleteEmployeeSql = "DELETE FROM employee WHERE department_id = ?;";
        String deleteDepartmentSql = "DELETE FROM department WHERE department_id = ?;";


        try {
            jdbcTemplate.update(deleteEmployeeSql, id);
            return jdbcTemplate.update(deleteDepartmentSql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    private Department mapRowToDepartment(SqlRowSet results) {
        Department department = new Department();
        department.setId(results.getInt("department_id"));
        department.setName(results.getString("name"));
        return department;
    }

}
