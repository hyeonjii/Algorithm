package baekjoon0710;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main16957 {
	static int r, c;
	static int[][] map;
	static int[][] cnt;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		map = new int[r][c];
		cnt = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				solve(i, j);
			}
		}
		
		for (int i = 0; i < cnt.length; i++) {
			for (int j = 0; j < cnt[i].length; j++) {
				System.out.print(cnt[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void solve(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		int lx = x;
		int ly = y;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int min = map[p.x][p.y];
			int minx = -1;
			int miny = -1;
			lx = p.x;
			ly = p.y;
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
					continue;
				}
				if(min > map[nx][ny]) {
					min = map[nx][ny];
					minx = nx;
					miny = ny;
				}
			}
			if(minx != -1 && miny != -1) {
				q.add(new Point(minx, miny));				
			}
		}
		cnt[lx][ly]++;
		
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
