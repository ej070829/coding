package com.springmvc.repository;

import java.util.List;
import com.springmvc.domain.Lab;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class LabRepositoryImpl implements LabRepository {
	private List<Lab> listOfLabs = new ArrayList<Lab>();
	
	public LabRepositoryImpl() {
		Lab lab1 = new Lab("1번 프로젝트");
		lab1.setContent("11111이거는 어떻게 되고 저렇게 되고 어쩌고저쩌고 상세설명 적을 수 있는공간");
		
		Lab lab2 = new Lab("2번 프로젝트");
		lab2.setContent("222222이거는 어떻게 되고 저렇게 되고 어쩌고저쩌고 상세설명 적을 수 있는공간");

		Lab lab3 = new Lab("3번 프로젝트");
		lab3.setContent("3333이거는 어떻게 되고 저렇게 되고 어쩌고저쩌고 상세설명 적을 수 있는공간");

		Lab lab4 = new Lab("4번 프로젝트");
		lab1.setContent("4444444이거는 어떻게 되고 저렇게 되고 어쩌고저쩌고 상세설명 적을 수 있는공간");
		
		listOfLabs.add(lab1);
		listOfLabs.add(lab2);
		listOfLabs.add(lab3);
		listOfLabs.add(lab4);
	
	}

	@Override
	public List<Lab> getAllLabList() {
		// TODO Auto-generated method stub
		return listOfLabs;
	}

	@Override
	public Lab getLabByName(String name) {
		Lab labInfo=null;
		for(int i=0;i<listOfLabs.size();i++) {
			Lab lab = listOfLabs.get(i);
			if(lab!=null && lab.getName()!=null&&lab.getName().equals(name)) {
				labInfo=lab;
				break;
			}
		}
		if(labInfo==null) {
			throw new IllegalArgumentException("해당 프로젝트를 찾을 수 없습니다.");
		}
		return labInfo;
	}

	@Override
	public void setNewLab(Lab lab) {
		listOfLabs.add(lab);
		
	}

}
