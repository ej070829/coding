package com.springmvc.repository;

import java.util.List;
import com.springmvc.domain.Lab;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class LabRepositoryImpl implements LabRepository {
	private List<Lab> listOfLabs = new ArrayList<Lab>();
	
	public LabRepositoryImpl() {
		Lab lab1 = new Lab("1�� ������Ʈ");
		lab1.setContent("11111�̰Ŵ� ��� �ǰ� ������ �ǰ� ��¼����¼�� �󼼼��� ���� �� �ִ°���");
		
		Lab lab2 = new Lab("2�� ������Ʈ");
		lab2.setContent("222222�̰Ŵ� ��� �ǰ� ������ �ǰ� ��¼����¼�� �󼼼��� ���� �� �ִ°���");

		Lab lab3 = new Lab("3�� ������Ʈ");
		lab3.setContent("3333�̰Ŵ� ��� �ǰ� ������ �ǰ� ��¼����¼�� �󼼼��� ���� �� �ִ°���");

		Lab lab4 = new Lab("4�� ������Ʈ");
		lab1.setContent("4444444�̰Ŵ� ��� �ǰ� ������ �ǰ� ��¼����¼�� �󼼼��� ���� �� �ִ°���");
		
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
			throw new IllegalArgumentException("�ش� ������Ʈ�� ã�� �� �����ϴ�.");
		}
		return labInfo;
	}

	@Override
	public void setNewLab(Lab lab) {
		listOfLabs.add(lab);
		
	}

}
