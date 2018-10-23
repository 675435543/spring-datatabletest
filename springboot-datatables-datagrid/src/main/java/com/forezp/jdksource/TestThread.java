package com.forezp.jdksource;

public class TestThread implements Runnable{
	private int baoZi=10;
	
	@Override
	public  synchronized void run() {
		// TODO Auto-generated method stub
		while(baoZi>0){
			System.out.println(Thread.currentThread().getName()+":吃了第"+baoZi+"个包子！");
			baoZi--;
		}
	}
	
	public static void main(String[] args) {
		TestThread demo1=new TestThread();
		new Thread(demo1, "张三").start();
		new Thread(demo1, "李四").start();
		new Thread(demo1, "王五").start();
	}
	
}
