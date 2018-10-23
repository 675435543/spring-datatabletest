package com.forezp.jdksource.fanxing;

public class Demo<T extends Animal>{
	private T ob;

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}

	public Demo(T ob) {
		super();
		// TODO Auto-generated constructor stub
		this.ob=ob;
	}
	
	public void print(){
		System.out.println("T的类型是"+ob.getClass().getName());
	}
}
