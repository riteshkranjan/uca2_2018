package com.chitkara.ds;

import java.util.Iterator;

import com.chitkara.learn.serialization.Student;

public class Test {

	public static void main(String... s) throws MyException {
		
		MyQueue<Student> q = new StaticArrayQueue<Student>();
		Student s1 = new Student();
		s1.setCgpa(1.5f);
		s1.setName("Tom");
		s1.setRollNo(1111);

		Student s2 = new Student();
		s2.setCgpa(2.5f);
		s2.setName("Jerry");
		s2.setRollNo(2222);
		

		q.push(s1);
		q.push(s2);
		Iterator<Student> ite = q.iterator();
		System.out.println("printing all elements of q");
		while(ite.hasNext()) {
			System.out.println(ite.next().getName());
		}
		System.out.println(q.pop().getName());
		System.exit(0);
		/*
		 * Iterator<Integer> ite = q1.iterator(); while(ite.hasNext()) {
		 * System.out.println(ite.next()); }
		 */

		/*
		 * MyQueue q2 = new LinkedListQueue(); try { testQueue(q2); } catch (MyException
		 * e) { e.getMessage(); }
		 */

	}

	private static void testQueue(MyQueue q) throws MyException {
		q.push(1);
		q.push(2);
		if (q.pop().equals(1))
			System.out.println("your implementation is wrong");
		else
			System.out.println("good job");
	}

}
