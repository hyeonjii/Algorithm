package baekjoon0718;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main1012 {
	static int m, n, mapnum;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			m = sc.nextInt();
			n = sc.nextInt();
			int k = sc.nextInt();
			map = new int[n][m];
			visit = new boolean[n][m];
			for (int i = 0; i < k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1; 
			}
			
//			for (int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			mapnum = 0;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						mapnum++;
						solve(i, j, mapnum);	
					}					
				}
			}
			System.out.println(mapnum);
		}
	}

	public static void solve(int x, int y, int colornum) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visit[x][y] = true;
		
 		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int j = 0; j < dx.length; j++) {
				int nx = p.x + dx[j];
				int ny = p.y + dy[j];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				if(!visit[nx][ny] && map[nx][ny] == 1) {
					visit[nx][ny] = true;
					map[nx][ny] = colornum;
					q.add(new Point(nx, ny));
				}
			}
		}
		
	}
	
	public static class Point{
		int x;
		int y;
		int cnt;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
