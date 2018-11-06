package com.forezp.jdksource;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

class Student{
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Student() {
	
	}
}
public class TestHashMap {
	public static void main(String[] args) {
		Map<String,String> hashMap= new HashMap<String,String>();
		Hashtable<String, Student> hashtable=new Hashtable<String,Student>();
		hashtable.put("1号", new Student("1号",13));
		hashtable.put("2号", new Student("2号",14));
		hashtable.put("5号", new Student("5号",15));
		hashtable.put("4号", new Student("4号",10));
		hashtable.put("3号", new Student("3号",11));
		hashtable.put("3号", new Student("3号",11));
		Student a=hashtable.get("4号");
		System.out.println(a.getName()+a.getAge()+"岁");
		System.out.println("******************");
		Iterator<String> s=hashtable.keySet().iterator();
		while(s.hasNext()){
			String m=s.next();
			System.out.println(hashtable.get(m).getName()+hashtable.get(m).getAge()+"岁");
		}
	}
}
