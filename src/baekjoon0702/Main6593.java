package baekjoon0702;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main6593 {
	static int[] dx = {0,0,1,-1,0,0};
	static int[] dy = {1,-1,0,0,0,0};
	static int[] dh = {0,0,0,0,1,-1};
	static int l, r, c, ans;
	static int sx, sy, sh;
	static int ex, ey, eh;
	static boolean issuccess;
	static char[][][] map;
	static boolean[][][] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			l = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			sx = 0; sy = 0; sh = 0;
			ex = 0; ey = 0; eh = 0;
			ans = 987654321;
			issuccess = false;
			map = new char[l][r][c];
			visit = new boolean[l][r][c];
			
			if(l == 0 && r == 0 && c ==0) {
				break;
			}
			
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String line = sc.next();
					for (int k = 0; k < line.length(); k++) {
						map[i][j][k] = line.charAt(k);
						if(map[i][j][k] == 'S') {
							sh = i;
							sx = j;
							sy = k;
						}
						if(map[i][j][k] == 'E') {
							eh = i;
							ex = j;
							ey = k;
						}
					}
				}
				sc.nextLine();
			}
			solve(); 
			
			if(issuccess) {
				System.out.println("Escaped in"+" "+ans+" "+"minute(s).");
			}else {
				System.out.println("Trapped!");
			}
		}
		
		
	}
	
	public static void solve() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sx, sy, sh, 0));
		visit[sh][sx][sy] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == ex && p.y == ey && p.h == eh) {
				if(ans > p.time) {
					ans = p.time;
					issuccess = true;
				}
				return;
			}
			
			for (int i = 0; i < dh.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nh = p.h + dh[i];
				
				if(nx < 0 || ny < 0 || nh < 0 || nx >= r || ny >= c || nh >= l) {
					continue;
				}
				
				if((map[nh][nx][ny] == '.' || map[nh][nx][ny] == 'E' )&& !visit[nh][nx][ny]) {
					visit[nh][nx][ny] = true;
					q.add(new Point(nx, ny, nh, p.time+1));
//					System.out.println(nx+" "+ny+" "+nh);
				}
			}
		}
	}
	
	public static class Point{
		int x;
		int y;
		int h;
		int time;
		public Point(int x, int y, int h, int time) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
			this.time = time;
		}
	}

}
