package beakjoon0905;

import java.util.Arrays;
import java.util.Scanner;

public class Main17135 {
	static int n, m, d, ans = 0;

	public static void copymap(int[][] c, int[][] ma) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				c[i][j] = ma[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		int[][] map = new int[n][m];
		int[][] cmap = new int[n][m];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				for (int k = j + 1; k < m; k++) {
//					System.out.println(i + " " + j + " " + k);
					copymap(cmap, map);
					solve(i, j, k, cmap);
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void solve(int p1, int p2, int p3, int[][] map) {
		int cnt = 0;
		for (int k = 0; k < map.length; k++) {
			int md1 = 987654321, md2 = 987654321, md3 = 987654321;
			int mx1 = -1, my1 = -1, mx2 = -1, my2 = -1, mx3 = -1, my3 = -1;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 1) {
						int d1 = Math.abs(n - i) + Math.abs(p1 - j);
						int d2 = Math.abs(n - i) + Math.abs(p2 - j);
						int d3 = Math.abs(n - i) + Math.abs(p3 - j);
						if (d1 <= d) {
							if (md1 > d1) {
								md1 = d1;
								mx1 = i;
								my1 = j;
							} else if (md1 == d1) {
								if (my1 > j) {
									mx1 = i;
									my1 = j;
								}
							}
						}
						if (d2 <= d) {
							if (md2 > d2) {
								md2 = d2;
								mx2 = i;
								my2 = j;
							} else if (md2 == d2) {
								if (my2 > j) {
									mx2 = i;
									my2 = j;
								}
							}
						}
						if (d3 <= d) {
							if (md3 > d3) {
								md3 = d3;
								mx3 = i;
								my3 = j;
							} else if (md3 == d3) {
								if (my3 > j) {
									mx3 = i;
									my3 = j;
								}
							}
						}
						
						
					}
				}
			}
			if(mx1 != -1) {
				map[mx1][my1] = 0;
				cnt++;
//				System.out.println(mx1+" "+my1);
			}
			if(mx2 != -1) {
				map[mx2][my2] = 0;
				cnt++;
			}
			if(mx3 != -1) {
				map[mx3][my3] = 0;
				cnt++;
			}
			if(mx1 != -1 && mx1 == mx2 && my1 == my2) {
				cnt--;
			}
//			if(mx1 != -1 && mx1 == mx3 && my1 == my3) {
//				cnt--;
//			}
			if(mx2 != -1 && mx3 == mx2 && my3 == my2) {
				cnt--;
			}
			
			
			for (int i = map.length - 2; i >= 0; i--) {
				for (int j = 0; j < map[i].length; j++) {
					map[i + 1][j] = map[i][j];
				}
			}
			for (int i = 0; i < m; i++) {
				map[0][i] = 0;
			}
			
//			for (int l = 0; l < map.length; l++) {
//				System.out.println(Arrays.toString(map[l]));
//			}
//			System.out.println(cnt);
		}
		if(ans < cnt) {
			ans = cnt;
		}
	}

	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
