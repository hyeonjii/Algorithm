package baekjoon0717;

/* 2019.07.17 21:13~22:09 백준 다리만들기*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main2146 {
	static int n, mapcolor, min= 987654321;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		mapcolor = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					mapcolor++;
					color(i,j, mapcolor);	
//					System.out.println(mapcolor);
				}
			}
		}
		
//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		for (int i = 1; i <= mapcolor; i++) {
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if(map[j][k] == i) {
						findminlength(j, k, i);									
					}
				}
			}
		}
		System.out.println(min);
		
	}
	public static void findminlength(int x, int y, int color) {
		boolean[][] mvisit = new boolean[n][n];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int j = 0; j < dx.length; j++) {
				int nx = p.x + dx[j];
				int ny = p.y + dy[j];
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == color) {
					continue;
				}
				if(!mvisit[nx][ny] && map[nx][ny] == 0) {
					mvisit[nx][ny] = true;
					q.add(new Point(nx, ny, p.cnt+1));
				}
				if(map[nx][ny] != color && map[nx][ny] != 0) {
//					System.out.println(color);
					if(min > p.cnt) {
						min = p.cnt;
//						System.out.println(min);
						return;
					}
				}
			}
		}
		
	}
	
	public static void color(int x, int y, int colornum) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visit[x][y] = true;
		map[x][y] = colornum;
//		System.out.println(colornum);
 		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int j = 0; j < dx.length; j++) {
				int nx = p.x + dx[j];
				int ny = p.y + dy[j];
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
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
		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}
