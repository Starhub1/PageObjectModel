package utils;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;

public class Practice {
	public String s = "test".toLowerCase();
	public HomePage h = new HomePage().clickLogin();
	public static int ss = Math.max(2, 3);

	@Test
	public static void main(String[] args) {
		test(Arrays.asList(3, 4, 5, 61, 2, 5));
		test(Arrays.asList(3, 4, 5, 5, 1));
		try {
			throwException();
		} catch (Exception a) {
			try {
				
			}catch(ExceptionInInitializerError e) {
				
			}finally {
				
			}
			System.out.println("main method");
			a.printStackTrace();
		}
	}

	public static List<Integer> test(List<Integer> al) {
		for (int i = 0; i < al.size() / 2; i++) {
			int temp = al.get(i);
			al.set(i, al.get(al.size() - 1 - i));
			al.set(al.size() - 1 - i, temp);
		}
		System.out.println(al);
		String i = Integer.toHexString(System.identityHashCode(al));
		System.out.println(i);
		
		return al;
	}

	public static void throwException() {
		try {
			String s = null;
			s.toLowerCase();
		} catch (Exception e) {
			System.out.println("throwException Method");
			e.printStackTrace();
			String s = null;
			s.toLowerCase();
		} finally {
			System.out.println("FInally block throException");
		}
	}
}
