package baekjoon0703;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1525 {
	public static class Point{
		int[][] cmap;
		int x;
		int y;
		int pre;
		int cnt;
		public Point(int[][] cmap, int x, int y, int pre, int cnt) {
			super();
			this.cmap = cmap;
			this.x = x;
			this.y = y;
			this.pre = pre;
			this.cnt = cnt;
		}
	}
	static int ans = 987654321;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] ansmap = {{1,2,3},{4,5,6},{7,8,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[3][3];
		int zx = 0;
		int zy = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) {
					zx = i;
					zy = j;
				}
			}
		}

//		int[][] cmap = new int[3][3];
//		copymap(cmap, map);
//		System.out.println(check(map));
//		swap(map,0,0, 0,1);
//		for (int i = 0; i < map.length; i++) {
//			System.out.print(Arrays.toString(map[i]));
//		}
		
		
		bfs(zx, zy, map);
		System.out.println(ans);
	}

	public static void bfs(int x, int y,int[][] map) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(map, x, y, 0, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(check(p.cmap)) {
				
				if(ans > p.cnt) {
					ans = p.cnt;
				}
				return;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= 3 || ny >= 3) {
					continue;
				}
				int[][] cmap = new int[3][3];
				copymap(cmap, map);
				
//				System.out.println(nx+" "+ny);
				if(cmap[nx][ny] != p.pre) {
					swap(cmap, p.x, p.y, nx, ny);
					q.add(new Point(cmap, nx, ny, cmap[p.x][p.y], p.cnt+1));					
				}
			}
			
		}
	}
	
	public static void copymap(int[][] cmap, int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				cmap[i][j] = map[i][j];
			}
		}
	}
	
	public static void swap(int[][] map, int x1, int y1, int x2, int y2) {
		int tmp = map[x1][y1];
		map[x1][y1] = map[x2][y2];
		map[x2][y2] = tmp;
	}
	
	public static boolean check(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] != ansmap[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
