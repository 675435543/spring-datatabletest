package com.forezp.jdksource;

public class TestClassLoader {
	public static void main(String[] args) {
/*		List<String> strList = new ArrayList<String>();
		System.out.println("String.class.getComponentType()"+String.class.getComponentType());
		Object[] newType= new Object[] {"123","234"};
		String[] array1 = new String[] {"1","2","3","4","5","6","7"};
		String[] array2 = new String[] {"21","22","23","24","25","26"};
		System.out.println("array1:"+array1.length);
		System.out.println("array2:"+array2.length);
		System.arraycopy(array1, 0, array2, 0, 2);
		System.out.println("array1:"+array1.length);
		System.out.println("array2:"+array2.length);
		System.out.println("array1:"+array1.toString());
		System.out.println("array2:"+array2.toString());*/
		//System.out.println("String.class.getClassLoader():"+String.class.getClassLoader());
        
            //printing ClassLoader of this class
			System.out.println("ClassLoaderTest.getClass().getClassLoader() : "
			                     + TestClassLoader.class.getClassLoader());

			//trying to explicitly load this class again using Extension class loader
/*                Class.forName("Test.ClassLoaderTest", true
			                ,  Test.class.getClassLoader().getParent());*/
//			System.out.println("new java.lang.Object().getClass().getClassLoader()"+new java.lang.Object().getClass().getClassLoader());
       
		   String test =new String();
		    test = "测试";    
		    System.out.println(test);
		    System.out.println("testidea.getClass().getClassLoader()"+test.getClass().getClassLoader());
		    
	}
}
