package com.forezp.jdksource;

import java.lang.reflect.Field;

public class DeclaredFieldTest {

	public static void main(String[] args) {
			Integer a = 1;
		Integer b = 2;
		System.out.printf("a = %s, b = %s\n", a, b);
		swap(a, b);
		System.out.printf("a = %s, b = %s\n", a, b);
		Integer c = 1;
		Integer d = 2;
		Integer e = new Integer(8);
		System.out.printf("c = %s, d = %s\n", c, d);
		System.out.printf("e = %s\n", e);
		
	}
	//a=1 b=2
	public static void swap(Integer a, Integer b) {
		int temp = a.intValue();
		try {
			Field value = Integer.class.getDeclaredField("value");
			value.setAccessible(true);
			value.set(a, b);
			value.set(b, new Integer(temp));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
