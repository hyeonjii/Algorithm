package baekjoon0704;

import java.util.Scanner;

public class Main14620 {
	static int n, ans =987654321;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		solve(0, 0, 1);
		System.out.println(ans);
	}
	
	public static void solve(int idx, int sum, int x) {
		if(idx == 3) {
			if(ans > sum) {
				ans = sum;
			}
			return;
		}
		
		for (int i = x; i < n-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if(!visit[i][j]) {
					if (!check(i, j)) {
						continue;
					}
					int c = map[i][j];
					for (int k = 0; k < dx.length; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						c += map[ni][nj];
						visit[ni][nj] = true;
					}
					
					solve(idx+1, sum+ c, x );
					for (int k = 0; k < dx.length; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						visit[ni][nj] = false;
					}
				}
				
			}
		}
		
	}
	public static boolean check(int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (visit[nx][ny]) {
				return false;
			}
		}
		return true;
	}

}
