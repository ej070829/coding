package com.springmvc.controller;

import java.nio.file.Files;
import java.nio.file.Path;

public class Version {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectDirectory = System.getProperty("user.dir");
		 String imagesDirectory = projectDirectory + "\\src\\main\\webapp\\resources\\image"; // 예시 경로
		 System.out.println(projectDirectory);
		 System.out.println(imagesDirectory);
        Path targetDirectory = Path.of(imagesDirectory);
        System.out.println(targetDirectory);
        System.out.println(Files.exists(targetDirectory));
        

	}

}
