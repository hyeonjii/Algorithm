package swexpert0831;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution5648 {
	static int dy[] = { 1,-1,0,0 };
	static int dx[] = { 0,0,-1,1 };
	static int[][] map= new int[4001][4001];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			ans = 0;
			Queue<Point> q = new LinkedList<>();
			
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int div = sc.nextInt();
				int k = sc.nextInt();
				if(k==0) k=101;
				q.add(new Point(2*y+2000,2*x+2000, div, k));
			}
			solve(q);
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void solve(Queue<Point> q) {
		int cntz = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(map[p.y][p.x] > p.k) {
				if(p.k == 101) {
					cntz++;
				}
				ans += map[p.y][p.x];
				map[p.y][p.x] = 0;
				continue;
			}
			map[p.y][p.x] = 0;
			
			int ny = p.y + dy[p.div];
			int nx = p.x + dx[p.div];
			if(nx < 0|| ny < 0 || nx > 4000 || ny > 4000) {
				continue;
			}
			if(map[ny][nx] == 0) {
				q.add(new Point(ny, nx, p.div, p.k));				
			}else {
				if(p.k == 101) {
					cntz++;
				}
			}
			map[ny][nx] += p.k;
		}
		ans -= cntz*101;
		
	}

	public static class Point {
		int y;
		int x;
		int div;
		int k;
		public Point(int y, int x, int div, int k) {
			this.y = y;
			this.x = x;
			this.div = div;
			this.k = k;
		}
	}
}
