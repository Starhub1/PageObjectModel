package utils;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public final class Practice {

	@Test
	public static void main(String[] args) {
		int a = 2;
		try {
			test(Arrays.asList(3, 4, 5, 61, 2, 5));
			test(Arrays.asList(3,4,5,5,1));
			System.out.println("Try block");
			a = a / 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		} finally {
			System.out.println("Finally block");
		}
	}

	public static List<Integer> test(List<Integer> al) {
		for (int i = 0; i <al.size()/2; i++) {
			int temp = al.get(i);
			al.set(i, al.get(al.size()-1-i));
			al.set(al.size()-1-i, temp);
		}
		System.out.println(al);
		return al;
	}
}
