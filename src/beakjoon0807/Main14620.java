package beakjoon0807;

import java.util.Scanner;

public class Main14620 {
	static int n, ans= 987654321;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		solve(1, 0, 0);
		System.out.println(ans);
	}

	public static void solve(int x,  int sum, int cnt) {
		if (cnt == 3) {
			if(ans > sum) {
				ans = sum;
			}
			return;
		}

		for (int i = x; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				System.out.println(i + " " + j);
				if(!visit[i][j]) {
					if(check(i, j)) {
						int nsum = map[i][j];
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							visit[nx][ny] = true;
							nsum += map[nx][ny];
						}
						solve(x, sum+nsum, cnt+1);
						
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							visit[nx][ny] =false;
						}
					}
				}
				
			}
		}
	}
	public static boolean check(int x, int y) {
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(visit[nx][ny]) {
				return false;
			}
		}
		return true;
	}
}
