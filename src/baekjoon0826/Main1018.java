package baekjoon0826;

import java.util.Arrays;
import java.util.Scanner;

public class Main1018 {
	static boolean[][] map;
	static int ans = 987654321;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new boolean[n][m];
		for (int i = 0; i < map.length; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				if(line.charAt(j) == 'W') {
					map[i][j] = true;
				}else {
					map[i][j] = false;					
				}
			}
		}
//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println(map.length);
		for (int i = 0; i <= map.length-8; i++) {
			for (int j = 0; j <= map[i].length-8; j++) {
				bsolve(i, j);
				wsolve(i, j);
			}
		}
		System.out.println(ans);
	}
	
	public static void bsolve(int sr, int sc) {
		boolean ch = false;
		int cnt = 0;
		for (int i = sr; i < sr+8; i++) {
			for (int j = sc; j < sc+8; j++) {
				if(map[i][j] != ch) {
					cnt++;
				}
				if(j != sc+7) {
					ch = !ch;
				}
			}
		}
		if(ans > cnt) {
			ans = cnt;
		}
	}
	public static void wsolve(int sr, int sc) {
		boolean ch = true;
		int cnt = 0;
		for (int i = sr; i < sr+8; i++) {
			for (int j = sc; j < sc+8; j++) {
				if(map[i][j] != ch) {
					cnt++;
				}
				if(j != sc+7) {
					ch = !ch;	
				}
			}
		}
		if(ans > cnt) {
			ans = cnt;
		}
	}

}
