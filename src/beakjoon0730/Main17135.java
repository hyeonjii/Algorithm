package beakjoon0730;

import java.util.Scanner;

public class Main17135 {
	static int n, m, d, ans= 0;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		map = new int[n][m];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = i+1; j < m; j++) {
				for (int k = j+1; k < m; k++) {
					for (int k2 = 0; k2 < n; k2++) {
						solve(i, j, k);
						
						movemap();
					}
		
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void movemap() {
		for (int i = map.length-1; i > 0; i--) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = map[i-1][j];
			}
		}
		for (int i = 0; i < map.length; i++) {
			map[0][i] = 0;
		}
	}
	
	public static void solve(int c1, int c2, int c3) {
		int mind1 = d;
		int minx1 = n;
		int miny1 = m;
		int mind2 = d;
		int minx2 = n;
		int miny2 = m;
		int mind3 = d;
		int minx3 = n;
		int miny3 = m;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1) {
					int dist1 = Math.abs(i - n) + Math.abs(j - c1);
					if(mind1 >= dist1) {
						if(miny1 > j) {
							miny1 = j;
							minx1 = i;
						}
						mind1 = dist1;
					}
					int dist2 = Math.abs(i - n) + Math.abs(j - c1);
					if(mind2 >= dist2) {
						if(miny2 > j) {
							miny2 = j;
							minx2 = i;
						}
						mind2 = dist2;
					}
					int dist3 = Math.abs(i - n) + Math.abs(j - c1);
					if(mind3 >= dist3) {
						if(miny3 > j) {
							miny3 = j;
							minx3 = i;
						}
						mind3 = dist3;
					}
				}
			}
		}
		map[minx1][miny1] = 0;
		map[minx2][miny2] = 0;
		map[minx3][miny3] = 0;
		ans += 3;
		if(minx1 == miny2 && miny1 == miny2) {
			ans--;
		}
		if(minx1 == miny3 && miny1 == miny3) {
			ans--;
		}
		if(minx3 == miny2 && miny3 == miny2) {
			ans--;
		}
	}
	
	public static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
