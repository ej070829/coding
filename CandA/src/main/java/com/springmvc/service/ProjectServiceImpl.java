package com.springmvc.service;

import java.util.List;
import com.springmvc.domain.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.repository.ProjectRepository;


@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> getAllProjectList() {
		// TODO Auto-generated method stub
		return projectRepository.getAllProjectList();
	}

}
