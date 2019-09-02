package beakjoon0902;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main15653 {
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static char[][] map;
	static boolean[][][] rvisit;
	static boolean[][][] bvisit;
	static int n,m,Rx,Ry,Bx,By,Ox,Oy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		rvisit = new boolean[4][n][m];
		bvisit = new boolean[4][n][m];
		Rx = -1;
		Ry = -1;
		Bx = -1;
		By = -1;
		Ox = -1;
		Oy = -1;
		for (int i = 0; i < map.length; i++) {
			String line = sc.next();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'R' ) {
					Rx = i;
					Ry = j;
				}
				if(map[i][j] == 'B') {
					Bx = i;
					By = j;					
				}
				if(map[i][j] == 'O') {
					Ox = i;
					Oy = j;					
				}
			}
		}
		
		solve();
		
	}
	
	public static void solve() {
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < dx.length; i++) {
			q.add(new Point(Rx, Ry, i, 0));
			rvisit[i][Rx][Ry] = true;
			q.add(new Point(Bx, By, i, 0));			
			bvisit[i][Bx][By] = true;
		}
		
		while(!q.isEmpty()) {
			int cr = 0, cb = 0;
			
			Point pr = q.poll();
			Point pb = q.poll();
			
			int rx = pr.x + dx[pr.div];
			int ry = pr.y + dy[pr.div];
			while(true) {
				if(map[rx][ry] == '#') {
					rx = pr.x + dx[(pr.div+2)%4];
					ry = pr.y + dy[(pr.div+2)%4];
					break;
				}else {
					rx += dx[pr.div];
					ry += dy[pr.div];
					cr++;
				}				
			}
			
			int bx = pb.x + dx[pb.div];
			int by = pb.y + dy[pb.div];
			while(true) {
				if(map[bx][by] == '#') {
					bx = pb.x + dx[(pb.div+2)%4];
					by = pb.y + dy[(pb.div+2)%4];
					break;
				}else {
					bx += dx[pb.div];
					by += dy[pb.div];
					cb++;
				}				
			}
			
			if(rx == bx && ry == by) {
				if(cr > cb) {
					rx = pr.x + dx[(pr.div+2)%4];
					ry = pr.y + dy[(pr.div+2)%4];
				}else {
					bx = pb.x + dx[(pb.div+2)%4];
					by = pb.y + dy[(pb.div+2)%4];
				}
			}
			
			
			q.add(new Point(rx, ry, pr.div, pr.cnt+1));
			q.add(new Point(bx, by, pb.div, pb.cnt+1));
			
		}
	}

	public static class Point {
		int x;
		int y;
		int div;
		int cnt;
		public Point(int x, int y, int div, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.div = div;
			this.cnt = cnt;
		}
	}
}
