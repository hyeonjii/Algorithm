package baekjoon0718;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main2583 {
	static int m,n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		int k = sc.nextInt();
		map = new int[m][n];
		visit = new boolean[m][n];
		
		for (int i = 0; i < k; i++) {
			int ys = sc.nextInt();
			int xs = sc.nextInt();
			int yf = sc.nextInt();
			int xf = sc.nextInt();
			for (int j = xs; j < xf; j++) {
				for (int r = ys; r < yf; r++) {
					map[j][r] = 1;
				}
			}
			
		}
		int num = 0;
	
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(!visit[i][j] && map[i][j] == 0) {
					num++;
					bfs(i, j);					
				}
			}
		}
		list.sort(null);
		System.out.println(num);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
			
		}
	}
	public static void bfs(int x, int y) {
		int cnt = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x +dx[i];
				int ny = p.y +dy[i];
				if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
					continue;
				}
				if(!visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
					cnt++;
				}
			
			}
		}
		list.add(cnt);
//		System.out.println(cnt);
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
