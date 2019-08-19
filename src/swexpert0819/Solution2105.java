package swexpert0819;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2105 {
	static int n, ans = -1;
	static int[][] map;
	static boolean[] visit;
	static int[] dx = {-1,1,1,-1};
	static int[] dy = {1,1,-1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 1; i < n-1; i++) {
				for (int j = 0; j < n-1; j++) {
					visit = new boolean[101];
					solve(i, j);
					
				}
			}
			
			
			System.out.println("#"+t+" "+ ans);
			
		}
	}
	
	public static void solve(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, 0, 0));
		visit[map[r][c]] = true;
		System.out.println(map[r][c]+"S");
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.div == 3 && p.x == r && p.y == c) {
				if(ans < p.sum) {
					ans = p.sum;
				}
			}
			if(p.div != 3) {
				for (int k = p.div; k < p.div+2; k++) {
					int nx = p.x + dx[k];
					int ny = p.y + dy[k];
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
						continue;
					}
					if(!visit[map[nx][ny]] ) {
						visit[map[nx][ny]] = true;
						System.out.println(map[nx][ny]);
						q.add(new Point(nx, ny, k, p.sum+1));
					}
				}
			}else if(p.div == 3) {
				int nx = p.x + dx[p.div];
				int ny = p.y + dy[p.div];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				if(!visit[map[nx][ny]] ) {
					visit[map[nx][ny]] = true;
					System.out.println(map[nx][ny]);
					q.add(new Point(nx, ny, p.div, p.sum+1));
				}
			}
			
		}
	}
	
	public static class Point {
		int x;
		int y;
		int div;
		int sum;
		public Point(int x, int y, int div, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.div = div;
			this.sum = sum;
		}
		
	}

}
