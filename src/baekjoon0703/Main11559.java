package baekjoon0703;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main11559 {
	static char[][] map;
	static boolean[][] visit;
	static List<Point> list;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int linknum = 0;
		map = new char[12][6];
		visit = new boolean[12][6];
		for (int i = 0; i < map.length; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for (int i = map.length-1; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if(map[i][j] != '.') {
					bfs(i, j);
					
				}
			}
		}
		
	}
	public static void bfs(int x, int y) {
		list = new ArrayList<>();
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.cnt >= 4) {
				
			}
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) {
					continue;
				}
				if(map[p.x][p.y] == map[nx][ny] && !visit[nx][ny]) {
					list.add(new Point(nx, ny, 0));
					
				}
			}
			
		}
	}
	
	public static class Point{
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}
