package com.chitkara.heap;

public class Village implements Comparable<Village>{
	private int id;
	private int population;
	private int clinics;
	private double density;
	
	public Village(int id, int population){
		this.id = id;
		this.population = population;
		this.clinics = 1;
		this.density = this.population/this.clinics;
	}
	
	public double getDensity(){
		return this.density;
	}
	
	public void openClinic(int clinics){
		this.clinics = this.clinics + clinics;
		this.density = this.population/this.clinics;
	}
	
	@Override
	public int compareTo(Village other){
		if(this.density == other.density) return 0;
		if(this.density > other.density) return +1;
		return -1;
	}
	
}