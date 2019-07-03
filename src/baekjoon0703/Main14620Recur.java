package baekjoon0703;

import java.util.Scanner;

public class Main14620Recur {
	static int n, ans = 987654321;
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

		solve(0, 0, 1);
		System.out.println(ans);
	}

	public static void solve(int cnt, int sum, int ni) {
		if (cnt == 3) {
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = ni; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (visit[i][j]) {
					continue;
				}
				if (!check(i, j)) {
					continue;
				}
				int c = map[i][j];
				for (int k = 0; k < dx.length; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					visit[nx][ny] = true;
					c += map[nx][ny];
				}
				solve(cnt + 1, sum + c, ni);

				for (int k = 0; k < dx.length; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					visit[nx][ny] = false;
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
