package beakjoon0904;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main9376 {
	static int h, w, ans;
	static char[][] map;
	static int[][] s;
	static boolean[][] visit1;
	static boolean[][] visit2;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			ans = 0;
			h = sc.nextInt();
			w = sc.nextInt();
			s = new int[2][2];
			int si = 0;
			map = new char[h][w];
			visit1 = new boolean[h][w];
			visit2 = new boolean[h][w];
			for (int i = 0; i < map.length; i++) {
				String line = sc.next();
				for (int j = 0; j < map.length; j++) {
					map[i][j] = line.charAt(j); 
					if(map[i][j] == '$') {
						s[si][0] = i; 
						s[si][1] = j;
						si++;
					}
				}
			}
			solve();
			System.out.println(ans);
			System.out.println();
		}
		
	}
	public static void solve() {
		int s1 = 0, s2 =0;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, s[0][0], s[0][1], 0));
		q.add(new Point(1, s[1][0], s[1][1], 0));
		visit1[s[0][0]][s[0][1]] = true;
		visit2[s[1][0]][s[1][1]] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
//			System.out.println(p.cnt);
			
			for (int i = 0; i < dx.length; i++) {
				int sx = p.s1x + dx[i];
				int sy = p.s1y + dy[i];
//				System.out.println(sx +" "+sy);
				
				if(sx < 0 | sy < 0 | sx >= h | sy >= w) {
					if(p.idx == 0 && s1== 0) {
						ans += p.cnt;
						System.out.println(ans);
						s1 = 1;
					}
					if(p.idx == 1 && s2== 0) {
						ans += p.cnt;
						System.out.println(ans);
						s2 = 1;
					}
					if(s1 == 1 && s2 == 1) {
						return;
					}
					if(s1 == 1 || s2 == 1) {
						continue;
					}
				}
				
				if(p.idx == 0) {
					if(!visit1[sx][sy] && map[sx][sy] != '*') {
						if(map[sx][sy] == '#') {
							map[sx][sy] = '.';
							q.add(new Point(p.idx, sx, sy, p.cnt+1));
						}else {							
							q.add(new Point(p.idx, sx, sy, p.cnt));
						}
						visit1[sx][sy] = true;
					}
				}
				
				if(p.idx == 1) {
					if(!visit2[sx][sy] && map[sx][sy] != '*') {
						if(map[sx][sy] == '#') {
							map[sx][sy] = '.';
							q.add(new Point(p.idx, sx, sy, p.cnt+1));
						}else {							
							q.add(new Point(p.idx, sx, sy, p.cnt));
						}
						visit2[sx][sy] = true;
					}
				}
				
			}
		}
	}
	
	public static class Point {
		int idx;
		int s1x;
		int s1y;
		int cnt;
		public Point(int idx, int s1x, int s1y, int cnt) {
			super();
			this.idx = idx;
			this.s1x = s1x;
			this.s1y = s1y;
			this.cnt = cnt;
		}
		
	}

}
