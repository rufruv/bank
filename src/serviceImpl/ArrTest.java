package serviceImpl;

import java.util.*;

public class ArrTest {
	public static void main(String[] args) {
		String[] arr = {"a","b","c","d"};
		Set<String> set = new HashSet<String>();
		for(String str:arr){
			set.add(str);
		}
		System.out.println(set.toString());
	}
}
