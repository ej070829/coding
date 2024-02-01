package com.springmvc.service;

import java.util.List;
import com.springmvc.domain.Lab;

public interface LabService {
	List<Lab> getAllLabList();
	
	Lab getLabByName(String name);
	void setNewLab(Lab lab);
	
}
