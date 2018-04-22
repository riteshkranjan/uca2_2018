package com.chitkara.heap;
public class MaxHeap<K extends Comparable>{
	
	private K[] data = (K[])new Comparable[10];
	private int size = 0;
	
	public void add(K k){
		System.out.println("adding : " +k);
		data[size] = k;
		swim(size);
		size++;
	}
	
	public K poll(){
		K k = data[0];
		swap(0, size-1);
		size--;
		sink(0);
		return k;
	}	
	
	private void swap(int i, int j){
		System.out.println("swaping : " +i + " and " + j);
		K k = data[i];
		data[i]= data[j];
		data[j] = k;
	}
	
	private void swim(int index){
		System.out.println("swiming for : " +index);
		if(index <= 0) return;
		if(data[index].compareTo(data[index/2]) == +1){
			swap(index, index/2);
			swim(index/2);
		}
	}
	
	private void sink(int index){
		if(index >= size) return;
		int i = index;
		if(2*index < size && data[i].compareTo(data[2*index]) == +1) i = 2*index;
		if((2*index)+1 < size && data[i].compareTo(data[(2*index)+1]) == +1) i = 2*index+1;
		if(index != i){
			swap(i,index);
			sink(i);
		}
	}
	
	public static void main(String [] arg){
		MaxHeap<Integer> m = new MaxHeap();
		m.add(3);
		m.add(1);
		m.add(8);
		m.add(5);
		m.add(4);
		
		System.out.println(m.poll());
		
	}
}