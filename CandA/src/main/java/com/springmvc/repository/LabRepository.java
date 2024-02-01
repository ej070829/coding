package com.springmvc.repository;

import java.util.List;
import com.springmvc.domain.Lab;

public interface LabRepository {
	List<Lab> getAllLabList();
	Lab getLabByName(String name);
	void setNewLab(Lab lab);

}
