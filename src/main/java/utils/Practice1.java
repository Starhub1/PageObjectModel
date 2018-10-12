package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice1 {
	
	public void test1() {
		Object a ="s";
		Integer b =(Integer) a;
		Object c =b;
	}
	
	public static void test2() {
		Object a = 1;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public static void main(String[] args) {
		System.out.println("This is the main method");
		test();
		
	}
	
	public static void test() {
		//Remove Duplicate elements from the array
		int[] b = {1,23,23,1,3,4,5,4};
		
		//Method one
		List<Integer> al =Arrays.stream(b).boxed().distinct().collect(Collectors.toList());
		//al.forEach(System.out::println);
		for(int a :al) {
			System.out.println(a);
		}
		//Method 2
		System.out.println("Method 2");
		int[] c = {1,23,23,1,3,4,5,4};
		Set<Integer> cc = Arrays.stream(c).boxed().collect(Collectors.toSet());
		
		for(int t :cc) {
			System.out.println(t);
		}
		
		//Method 3
		System.out.println("Method 3");
		int[] d = {1,23,23,1,3,4,5,4};
		Set<Integer> dd = new HashSet<>();
		for(int i=0;i<d.length;i++) {
			dd.add(d[i]);
		}
		System.out.println(dd);
		
	}

}
