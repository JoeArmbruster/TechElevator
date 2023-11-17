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
import com.techelevator.projects.model.Employee;

public class JdbcEmployeeDao implements EmployeeDao {

    private final String EMPLOYEE_SELECT = "SELECT e.employee_id, e.department_id, e.first_name, e.last_name, " +
            "e.birth_date, e.hire_date FROM employee e ";

    private final JdbcTemplate jdbcTemplate;

    public JdbcEmployeeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Employee getEmployeeById(int id) {
        try {
            Employee employee = null;
            String sql = EMPLOYEE_SELECT +
                    " WHERE e.employee_id=?";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                employee = mapRowToEmployee(results);
            }
            if (employee == null) {
                throw new DaoException("Employee not found for id: " + id);
            }

            return employee;
        } catch (DataAccessException ex) {
            throw new DaoException("Error retrieving employee by id", ex);
        }
    }

    @Override
    public List<Employee> getEmployees() {
        try {
            List<Employee> allEmployees = new ArrayList<>();
            String sql = EMPLOYEE_SELECT;

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Employee employeeResult = mapRowToEmployee(results);
                allEmployees.add(employeeResult);
            }

            return allEmployees;
        } catch (DataAccessException ex) {
            throw new DaoException("Error retrieving employee", ex);
        }
    }

    @Override
    public List<Employee> getEmployeesByFirstNameLastName(String firstName, String lastName) {
        try {
            List<Employee> allEmployees = new ArrayList<>();
            String sql = EMPLOYEE_SELECT +
                    " WHERE e.first_name ILIKE ? AND e.last_name ILIKE ?";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstName + "%", "%" + lastName + "%");
            while (results.next()) {
                Employee employeeResult = mapRowToEmployee(results);
                allEmployees.add(employeeResult);
            }

            return allEmployees;
        } catch (DataAccessException ex) {
            throw new DaoException("Error retrieving employees by name", ex);
        }
    }

    @Override
    public List<Employee> getEmployeesByProjectId(int projectId) {
        try {
            List<Employee> allEmployees = new ArrayList<>();
            String sql = EMPLOYEE_SELECT +
                    "JOIN project_employee pe ON e.employee_id = pe.employee_id " +
                    "WHERE pe.project_id = ?";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
            while (results.next()) {
                Employee employeeResult = mapRowToEmployee(results);
                allEmployees.add(employeeResult);
            }

            return allEmployees;
        } catch (DataAccessException ex) {
            throw new DaoException("Error retrieving employees by project id", ex);
        }
    }

    @Override
    public List<Employee> getEmployeesWithoutProjects() {
        try {
            List<Employee> allEmployees = new ArrayList<>();
            String sql = EMPLOYEE_SELECT +
                    " WHERE e.employee_id NOT IN (SELECT DISTINCT employee_id FROM project_employee)";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Employee employeeResult = mapRowToEmployee(results);
                allEmployees.add(employeeResult);
            }

            return allEmployees;
        } catch (DataAccessException ex) {
            throw new DaoException("Error retrieving employees without projects", ex);
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {
        try {
            String sql = "INSERT INTO public.employee(\n" +
                    "\tdepartment_id, first_name, last_name, birth_date, hire_date)\n" +
                    "\tVALUES (?, ?, ?, ?, ?) RETURNING employee_id;";
            int newEmployeeId = jdbcTemplate.queryForObject(sql, Integer.class,
                    employee.getDepartmentId(), employee.getFirstName(), employee.getLastName(),
                    employee.getBirthDate(), employee.getHireDate());
            employee.setId(newEmployeeId);
            return employee;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try {
            String sql = "UPDATE public.employee\n" +
                    "\tSET department_id=?, first_name=?, last_name=?, birth_date=?, hire_date=?\n" +
                    "\tWHERE employee_id = ?;";
            jdbcTemplate.update(sql, employee.getDepartmentId(), employee.getFirstName(), employee.getLastName(),
                    employee.getBirthDate(), employee.getHireDate(), employee.getId());
            return employee;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public int deleteEmployeeById(int id) {
        try {
            String sql = "DELETE FROM employee WHERE employee_id = ?;";
            return jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public int deleteEmployeesByDepartmentId(int departmentId) {
        try {
            String sql = "DELETE FROM employee WHERE department_id = ?;";
            return jdbcTemplate.update(sql, departmentId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    private Employee mapRowToEmployee(SqlRowSet result) {
        Employee employee = new Employee();
        employee.setId(result.getInt("employee_id"));
        employee.setDepartmentId(result.getInt("department_id"));
        employee.setFirstName(result.getString("first_name"));
        employee.setLastName(result.getString("last_name"));
        employee.setBirthDate(result.getDate("birth_date").toLocalDate());
        employee.setHireDate(result.getDate("hire_date").toLocalDate());
        return employee;
    }
}
