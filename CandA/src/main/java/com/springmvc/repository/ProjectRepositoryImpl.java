package com.springmvc.repository;

import java.util.List;
import com.springmvc.domain.Project;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
	private List<Project> listOfProjects = new ArrayList<Project>();
	
	public ProjectRepositoryImpl() {
		Project project1 = new Project("1�� ������Ʈ");
		project1.setContent("11111�̰Ŵ� ��� �ǰ� ������ �ǰ� ��¼����¼�� �󼼼��� ���� �� �ִ°���");
		
		Project project2 = new Project("2�� ������Ʈ");
		project2.setContent("222222�̰Ŵ� ��� �ǰ� ������ �ǰ� ��¼����¼�� �󼼼��� ���� �� �ִ°���");

		Project project3 = new Project("3�� ������Ʈ");
		project3.setContent("3333�̰Ŵ� ��� �ǰ� ������ �ǰ� ��¼����¼�� �󼼼��� ���� �� �ִ°���");

		Project project4 = new Project("4�� ������Ʈ");
		project1.setContent("4444444�̰Ŵ� ��� �ǰ� ������ �ǰ� ��¼����¼�� �󼼼��� ���� �� �ִ°���");
		
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
