package beakjoon0805;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main6087 {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int w, h, ans= 987654321;
	static char[][] map;
	static int[][] cmap;
	static boolean[][][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		cmap = new int[2][2];
		int c = 0;
		map= new char[h][w];
		visit = new boolean[4][h][w];
		for (int i = 0; i < map.length; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'C') {
					cmap[c][0] = i;
					cmap[c][1] = j;
					c++;
				}
			}
		}

		solve();
//		System.out.println(ans);
	}

	public static void solve() {
//		Queue<Point> q = new LinkedList<>();
		PriorityQueue<Point> q = new PriorityQueue<>();
		
		for (int i = 0; i < 4; i++) {
			q.add(new Point(cmap[0][0], cmap[0][1], i, 0));
			visit[i][cmap[0][0]][cmap[0][1]] = true;
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == cmap[1][0] && p.y == cmap[1][1]) {
//				if(ans > p.cnt) {
//					ans = p.cnt;
//				}
				System.out.println(p.cnt);
				return;
			}
			
			int nx = p.x + dx[p.div];
			int ny = p.y + dy[p.div];
			if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
				continue;
			}
			if(map[nx][ny] != '*' && !visit[p.div][nx][ny]) {
				visit[p.div][nx][ny] = true;
				if(p.div == 0) {
					q.add(new Point(nx, ny, 0, p.cnt));
					q.add(new Point(nx, ny, 2, p.cnt+1));
					q.add(new Point(nx, ny, 3, p.cnt+1));
				}
				if(p.div == 1) {
					q.add(new Point(nx, ny, 1, p.cnt));
					q.add(new Point(nx, ny, 2, p.cnt+1));
					q.add(new Point(nx, ny, 3, p.cnt+1));
				}
				if(p.div == 2) {
					q.add(new Point(nx, ny, 2, p.cnt));
					q.add(new Point(nx, ny, 0, p.cnt+1));
					q.add(new Point(nx, ny, 1, p.cnt+1));
				}
				if(p.div == 3) {
					q.add(new Point(nx, ny, 3, p.cnt));
					q.add(new Point(nx, ny, 0, p.cnt+1));
					q.add(new Point(nx, ny, 1, p.cnt+1));
				}
			}
		}
	}
	
	public static class Point implements Comparable<Point>{
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
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.cnt - o.cnt;
		}
	}
}
