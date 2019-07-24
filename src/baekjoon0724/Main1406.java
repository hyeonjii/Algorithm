package baekjoon0724;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1406 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Character> list = new LinkedList<>();
		String line = sc.next();
		int cursor = line.length();
		for (int i = 0; i < line.length(); i++) {
			list.add(line.charAt(i));
		}
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			char ch = sc.next().charAt(0);
			if(ch == 'P') {
				char addch = sc.next().charAt(0);
					list.add(cursor, addch);
				cursor += 1;
				
			}else {
				if(ch == 'L') {
					if(cursor != 0) {
						cursor -= 1;
					}
				}
				if(ch == 'D') {
					if(cursor != list.size()) {
						cursor += 1;
					}
				}
				if(ch == 'B') {
					if(cursor != 0) {
						cursor -= 1;
						list.remove(cursor);
					}
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}

}
