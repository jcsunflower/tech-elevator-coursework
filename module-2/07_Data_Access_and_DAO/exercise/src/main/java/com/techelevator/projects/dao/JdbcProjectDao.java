package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT * " +
				"FROM project " +
				"WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		if (results.next()) {
			project = mapRowToProject(results);
		}
		return project;
	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		project.setId(rowSet.getLong("project_id"));
		project.setName(rowSet.getString("name"));
		if (rowSet.getDate("from_date") != null) {
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		}
		if (rowSet.getDate("to_date") != null) {
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT * " +
				"FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()) {
			projects.add(mapRowToProject(results));
		}
		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		Project project = null;
		final String sql = "INSERT INTO project (project_id, name, from_date, to_date) " +
				"VALUES (?, ?, ?, ?);";
		this.jdbcTemplate.update(sql, newProject.getId(), newProject.getName(), newProject.getFromDate(), newProject.getToDate());

		String returnProject = "SELECT * " +
				"FROM project " +
				"WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(returnProject, newProject.getId());

		if (results.next()) {
			project = mapRowToProject(results);
		}
		return project;
	}

	@Override
	public void deleteProject(Long projectId) {
		final String removeFromProjectEmployee = "DELETE FROM project_employee " +
				"WHERE project_id = ?";
		final String removeFromProject = "DELETE FROM project " +
				"WHERE project_id = ?;";
		this.jdbcTemplate.update(removeFromProjectEmployee, projectId);
		this.jdbcTemplate.update(removeFromProject, projectId);
	}
	

}
