package com.chitkara.learn.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StudentSerializer {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setCgpa(1.5f);
		s1.setName("Tom");
		s1.setRollNo(1111);

		Student s2 = new Student();
		s2.setCgpa(2.5f);
		s2.setName("Jerry");
		s2.setRollNo(2222);
		
		File f = new File("output.ser");
		ObjectOutputStream oo = null;
		try {
			oo = new ObjectOutputStream(new FileOutputStream(f));
			oo.writeObject(s1);
			oo.writeObject(s2);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				oo.close();
			} catch (IOException e) {
				System.out.println("issue in closing this stream" + e.getMessage());
			}
		}

	}
}
