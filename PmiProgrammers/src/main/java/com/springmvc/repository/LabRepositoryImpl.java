package com.springmvc.repository;

import java.util.List;


import com.springmvc.domain.Lab;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;



@Repository
public class LabRepositoryImpl implements LabRepository {
	private JdbcTemplate template; 
	 
	 @Autowired  
	 public void setJdbctemplate(DataSource dataSource) {
	    this.template = new JdbcTemplate(dataSource);
	 }
	private List<Lab> listOfLabs = new ArrayList<Lab>();
	
	public LabRepositoryImpl() {
		Lab lab1 = new Lab("1踰� �봽濡쒖젥�듃");
		lab1.setContent("11111�씠嫄곕뒗 �뼱�뼸寃� �릺怨� ���젃寃� �릺怨� �뼱姨뚭퀬��姨뚭퀬 �긽�꽭�꽕紐� �쟻�쓣 �닔 �엳�뒗怨듦컙");
		
		Lab lab2 = new Lab("2踰� �봽濡쒖젥�듃");
		lab2.setContent("222222�씠嫄곕뒗 �뼱�뼸寃� �릺怨� ���젃寃� �릺怨� �뼱姨뚭퀬��姨뚭퀬 �긽�꽭�꽕紐� �쟻�쓣 �닔 �엳�뒗怨듦컙");

		Lab lab3 = new Lab("3踰� �봽濡쒖젥�듃");
		lab3.setContent("3333�씠嫄곕뒗 �뼱�뼸寃� �릺怨� ���젃寃� �릺怨� �뼱姨뚭퀬��姨뚭퀬 �긽�꽭�꽕紐� �쟻�쓣 �닔 �엳�뒗怨듦컙");

		Lab lab4 = new Lab("4踰� �봽濡쒖젥�듃");
		lab4.setContent("4444444�씠嫄곕뒗 �뼱�뼸寃� �릺怨� ���젃寃� �릺怨� �뼱姨뚭퀬��姨뚭퀬 �긽�꽭�꽕紐� �쟻�쓣 �닔 �엳�뒗怨듦컙");
		
		listOfLabs.add(lab1);
		listOfLabs.add(lab2);
		listOfLabs.add(lab3);
		listOfLabs.add(lab4);
	
	}

	@Override
	public List<Lab> getAllLabList() {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM lab";  
        List<Lab> listOfLabs = template.query(SQL, new LabRowMapper());  
		// TODO Auto-generated method stub
		return listOfLabs;
	}
	
	public Lab getBookById(String labId) {
		Lab labInfo = null;
		String SQL = "SELECT count(*) FROM lab where lab_id=?";  
        int rowCount = template.queryForObject(SQL, Integer.class, labId);  
        if (rowCount != 0) {
            SQL = "SELECT * FROM lab where lab_id=?";  
            labInfo = template.queryForObject(SQL, new Object[] { labId }, new LabRowMapper());  
        }
		if(labInfo == null) {
			throw new IllegalArgumentException("�봽濡쒖젥�듃 ID媛� "+labId+"�씤 �빐�떦 �옄猷뚮�� 李얠쓣 �닔 �뾾�뒿�땲�떎.");
		}
		return labInfo;
	}

}
