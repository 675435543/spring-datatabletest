package com.forezp.jdksource;

public class TestStringBuffer {
	
	public static void main(String[] args){
		StringBuffer sb=new StringBuffer("123");
		StringBuffer sb2=new StringBuffer("123");
		sb.append("abc");
		sb2.append("abc");
		System.out.println(sb);
		System.out.println(sb2);
		System.out.println("sb==sb2:"+(sb==sb2));
		System.out.println("sb.equals(sb2):"+(sb.equals(sb2)));
		System.out.println("sb.equals(sb2):"+((sb.toString()).equals(sb2.toString())));
	}
}
