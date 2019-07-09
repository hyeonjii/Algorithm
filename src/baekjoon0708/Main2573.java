package baekjoon0708;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2573 {
	static int n, m;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int ans = 0;
		int[][] map = new int[n][m];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			if(zerocheck(map)) {
				System.out.println("0");
				break;
			}
			ans++;
			int[][] nmap = new int[n][m];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] != 0)
						findzero(i, j, map, nmap);
				}
			}
			copymap(map, nmap);
			
			if(!checkmap(map)) {
				System.out.println(ans);
				break;
			}
		}
		
		
	}
	
	public static boolean zerocheck(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0) {
					cnt++;
				}
			}
		}
		if(cnt == n*m) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean checkmap(int[][] map) {
		boolean[][] visit = new boolean[n][m];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] != 0 && !visit[i][j] ) {
					bfs(map,visit, i, j);
//					for (int k = 0; k < map.length; k++) {
//						System.out.println(Arrays.toString(visit[k]));
//					}
					cnt++;
//					System.out.println(i+" "+j+" "+cnt);
				}
			}
		}
		if(cnt >= 2) {
			return false;
		}
		
		return true;
	}
	
	public static void bfs(int[][] map, boolean[][] visit, int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				if(map[nx][ny] != 0 && !visit[nx][ny]) {
					q.add(new Point(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
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
	
	public static void copymap(int[][] map, int[][] nmap) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = nmap[i][j];
			}
		}
	}
	
	public static void findzero(int x, int y, int[][] map, int[][] nmap) {
		int cnt = 0;
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
				continue;
			}
			if(map[nx][ny] == 0) {
				cnt++;				
			}
		}
		if(map[x][y] - cnt < 0) {
			nmap[x][y] = 0;
		}else {
			nmap[x][y] = map[x][y] - cnt;			
		}
	}

}