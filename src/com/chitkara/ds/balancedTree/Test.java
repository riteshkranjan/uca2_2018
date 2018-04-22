package com.chitkara.ds.balancedTree;
public class Test{
	
	public static void main(String[] args){
		int loopCount = 8000;
		
		BST<Integer, String> bst = new BST<>();
		LLRBT<Integer, String> rbt = new LLRBT<>();
		
		for(int i = 0;i<loopCount;i++){
			bst.insert(i, null);
			rbt.insert(i,null);
		}
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i< 100 ; i++)
			bst.get(loopCount+1);
		System.out.println("bst search cost is " + (System.currentTimeMillis()-startTime));
		
		startTime = System.currentTimeMillis();
			for(int i = 0; i< 100 ; i++)
			rbt.get(loopCount+1);
			
		System.out.println("rbt search cost is " + (System.currentTimeMillis()-startTime));
		
		
		
	}
	
	
}