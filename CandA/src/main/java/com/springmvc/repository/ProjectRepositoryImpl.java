package com.springmvc.repository;

import java.util.List;
import com.springmvc.domain.Project;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
	private List<Project> listOfProjects = new ArrayList<Project>();
	
	public ProjectRepositoryImpl() {
		Project project1 = new Project("1번 프로젝트");
		project1.setContent("11111이거는 어떻게 되고 저렇게 되고 어쩌고저쩌고 상세설명 적을 수 있는공간");
		
		Project project2 = new Project("2번 프로젝트");
		project2.setContent("222222이거는 어떻게 되고 저렇게 되고 어쩌고저쩌고 상세설명 적을 수 있는공간");

		Project project3 = new Project("3번 프로젝트");
		project3.setContent("3333이거는 어떻게 되고 저렇게 되고 어쩌고저쩌고 상세설명 적을 수 있는공간");

		Project project4 = new Project("4번 프로젝트");
		project1.setContent("4444444이거는 어떻게 되고 저렇게 되고 어쩌고저쩌고 상세설명 적을 수 있는공간");
		
		listOfProjects.add(project1);
		listOfProjects.add(project2);
		listOfProjects.add(project3);
		listOfProjects.add(project4);
	
	}

	@Override
	public List<Project> getAllProjectList() {
		// TODO Auto-generated method stub
		return listOfProjects;
	}

}
