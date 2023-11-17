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
import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

    private final String PROJECT_SELECT = "SELECT p.project_id, p.name, p.from_date, p.to_date FROM project p";

    private final JdbcTemplate jdbcTemplate;

    public JdbcProjectDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Project getProjectById(int id) {
        try {
            Project project = null;
            String sql = PROJECT_SELECT +
                    " WHERE p.project_id=?";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                project = mapRowToProject(results);
            }
            if (project == null) {
                throw new DaoException("Project not found for id: " + id);
            }

            return project;
        } catch (DataAccessException ex) {
            throw new DaoException("Error retrieving project by id", ex);
        }
    }

    @Override
    public List<Project> getProjects() {
        try {
            List<Project> allProjects = new ArrayList<>();
            String sql = PROJECT_SELECT;

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Project projectResult = mapRowToProject(results);
                allProjects.add(projectResult);
            }

            return allProjects;
        } catch (DataAccessException ex) {
            throw new DaoException("Error retrieving projects", ex);
        }
    }

    @Override
    public Project createProject(Project project) {
        try {
            String sql = "INSERT INTO project (name, from_date, to_date) VALUES (?, ?, ?) RETURNING project_id;";
            int newProjectId = jdbcTemplate.queryForObject(sql, Integer.class, project.getFromDate(), project.getToDate());
            project.setId(newProjectId);
            return project;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public void linkProjectEmployee(int id, int employeeId) {
        try {
            String sql = "INSERT INTO project_employee (project_ic, employee_id) VALUES (?, ?);";
            jdbcTemplate.update(sql, id, employeeId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public void unlinkProjectEmployee(int id, int employeeId) {
        try {
            String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?;";
            jdbcTemplate.update(sql, id, employeeId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public Project updateProject(Project project) {
        try {
            String sql = "UPDATE project SET name = ?, from_date = ?, to_date = ?, WHERE project_id = ?;";
            jdbcTemplate.update(sql, project.getName(), project.getFromDate(), project.getToDate(), project.getId());
            return project;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public int deleteProjectById(int id) {
        try {
            String sql = "DELETE FROM project WHERE project_id = ?;";
            return jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    private Project mapRowToProject(SqlRowSet results) {
        Project project = new Project();
        project.setId(results.getInt("project_id"));
        project.setName(results.getString("name"));
        if (results.getDate("from_date") != null) {
            project.setFromDate(results.getDate("from_date").toLocalDate());
        }
        if (results.getDate("to_date") != null) {
            project.setToDate(results.getDate("to_date").toLocalDate());
        }
        return project;
    }

}
