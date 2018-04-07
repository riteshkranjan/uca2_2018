package com.chitkara.learn.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudentDeserializer {
	public static void main(String[] args) {
		File f = new File("output.ser");
		ObjectInputStream oo = null;
		try {
			oo = new ObjectInputStream(new FileInputStream(f));
			Student s = (Student) oo.readObject();
			System.out.println(s.getName() + " roll " + s.getRollNo() + " cgpa " + s.getCgpa());
			Student s1 = (Student) oo.readObject();
			System.out.println(s1.getName() + " roll " + s1.getRollNo() + " cgpa " + s1.getCgpa());

		} catch (IOException | ClassNotFoundException e) {
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
