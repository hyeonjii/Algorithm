package baekjoon0709;

import java.util.Scanner;

public class Main17136 {
	static int n = 10;
	static int[][] map;
	static int[] cnt;
	static int total = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new int[10][10];
		cnt = new int[6];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					total++;
				}
			}
		}
		
		solve(0, 0, 0, 0, new int[n][n], cnt);
		
	}
	public static void solve(int x, int y, int tot ,int ans, int[][] cmap, int[] cnt) {
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] >= 5) {
				return;
			}
		}
		
		if(total == tot ) {
			return;
		}
		
		for (int i = x; i < n; i++) {
			for (int j = y; j < n; j++) {
				int m = 1;
				if(map[i][j] == 1) {
					for (int k = 5; k > 0; k--) {
						if(maxlen(i, j, k)) {
							m = k;
						}
					}
				}
				
			}
		}
	}
	

	public static boolean maxlen(int x, int y, int m) {
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(map[x+i][y+i] != 1) {
					return false;
				}
			}
		}
		
		return true;
	}
}
