package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SubStrings {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int k = in.nextInt();
		
		ArrayList<String> lines = new ArrayList<>();
		
		for(int i = 0; i <= s.length() - k; i++) {
			String temp = s.substring(i, i + k);
			lines.add(temp);
		}
		
		Collections.sort(lines, new OrderLexigraph());
		System.out.println(lines.get(0) + "\n" + lines.get(lines.size()-1));
		
	}
	
	public static class OrderLexigraph implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if(o1.charAt(0) > o2.charAt(0))
				return 1;
			else if (o1.charAt(0) < o2.charAt(0))
				return -1;
			else {
				if(o1.length() > 1 || o2.length() > 1)
					return ifFirstSame(o1, o2);
				else
					return 0;
			}
		}
		
		private static int ifFirstSame(String a, String b) {
			for(int i = 1; i <= a.length() && i <= b.length(); i++) {
				if(a.charAt(i) != b.charAt(i)) {
					if(a.charAt(i) > b.charAt(i))
						return 1;
					else if (a.charAt(i) < b.charAt(i))
						return -1;
				}
			}
			
			return 0;
		}
		
	}

}
