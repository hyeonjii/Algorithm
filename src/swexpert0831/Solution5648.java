package swexpert0831;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution5648 {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {-1,1,0,0};
	static int[][] map= new int[4001][4001];
	static int n, ans = 0;
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int div = sc.nextInt();
				int k = sc.nextInt();
				q.add(new Point((x+1000)*2, (y+1000)*2, div, k));
//				System.out.println(((x+1000)*2) +" "+((y+1000)*2));
			}
			solve();
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void solve() {
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			
			if(map[p.x][p.y] > p.k) {
				ans += p.k;
				continue;
			}
			map[p.x][p.y] = 0;
			
			int nx = p.x + dx[p.div];
			int ny = p.y + dy[p.div];
			if(nx < 0|| ny < 0 || nx > 4000 || ny > 4000) {
				continue;
			}
			if(map[nx][ny] == 0) {
				map[nx][ny] += p.k;
				q.add(new Point(nx, ny, p.div, p.k));				
			}else {
				map[nx][ny] += p.k;
				ans += p.k;
			}
		}
	}

	public static class Point {
		int x;
		int y;
		int div;
		int k;
		public Point(int x, int y, int div, int k) {
			super();
			this.x = x;
			this.y = y;
			this.div = div;
			this.k = k;
		}
	}
}
