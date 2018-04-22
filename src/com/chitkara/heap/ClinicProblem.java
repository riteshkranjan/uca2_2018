package com.chitkara.heap;
import java.util.*;
public class ClinicProblem{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		MaxHeap<Village> q = new MaxHeap<Village>();
		
		for(int i = 0;i<n;i++){
			q.add(new Village(i, sc.nextInt()));
		}
		
		int m = sc.nextInt();
		if(m<n) throw new RuntimeException("invalid input");
		
		m = m-n;
		while(m>0){
			Village v = q.poll();
			v.openClinic(1);
			q.add(v);
			m--;
		}
		
		Village v = q.poll();
		System.out.println("I have opened all the clinics - max load is : "+v.getDensity());
		
		sc.close();
		
		
	}
	
}