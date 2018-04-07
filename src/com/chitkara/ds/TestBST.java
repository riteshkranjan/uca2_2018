package com.chitkara.ds;

import com.chitkara.learn.serialization.Student;

public class TestBST {

	public static void main(String[] args) {
		BST<Student, String> b = new BST();
		b.insert(new Student(5, "a", 1.0f), "fiveeee");
		b.insert(new Student(3, "a", 1.0f), "the");
		b.insert(new Student(1, "a", 1.0f), "one");
		b.insert(new Student(6, "a", 1.0f), "6");
		b.inorder();
	}

}
