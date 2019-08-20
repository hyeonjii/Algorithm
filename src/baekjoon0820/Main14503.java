package baekjoon0820;

import java.util.Arrays;
import java.util.Scanner;

public class Main14503 {
	static int n, m, fr, fc, fdiv, ans=0;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		Point firstcleaner = new Point(sc.nextInt(),sc.nextInt(),sc.nextInt(),1,0);
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		solve(firstcleaner);
		System.out.println(ans);
	}
	public static void solve(Point cln) {
		if(cln.cnt == 1) {
			visit[cln.r][cln.c] = true;
			ans += 1;
			int ldiv = (cln.div+1)%4;
			int nr = cln.r + dx[ldiv];
			int nc = cln.c + dy[ldiv];
			if(map[nr][nc] == 0 && !visit[nr][nc]) {
				System.out.println(nr+" "+nc);
				solve(new Point(nr, nc, ldiv, 1, 0));
			}else if(map[nr][nc] == 1 || visit[nr][nc]) {
				if(cln.cnum != 3 ) {
					System.out.println(cln.r+" "+cln.c);
					solve(new Point(cln.r, cln.c, ldiv, 2, cln.cnum+1));	
				}else {
					int bdiv = (cln.div+2)%4;
					int br = cln.r + dx[bdiv];
					int bc = cln.c + dy[bdiv];
					if(map[br][bc] == 0 && !visit[br][bc]) {
						System.out.println(br+" "+bc);
						solve(new Point(br, bc, cln.div, 2, 0));
					}else {
						return;
					}
				}
			}
			
		}
		if(cln.cnt == 2) {
			int ldiv = (cln.div+1)%4;
			int nr = cln.r + dx[ldiv];
			int nc = cln.c + dy[ldiv];
			if(map[nr][nc] == 0 && !visit[nr][nc]) {
				System.out.println(nr+" "+nc);
				solve(new Point(nr, nc, ldiv, 1, 0));
			}else if(map[nr][nc] == 1 || visit[nr][nc]) {
				if(cln.cnum != 3 ) {
					System.out.println(cln.r+" "+cln.c);
					solve(new Point(cln.r, cln.c, ldiv, 2, cln.cnum+1));	
				}else {
					int bdiv = (cln.div+2)%4;
					int br = cln.r + dx[bdiv];
					int bc = cln.c + dy[bdiv];
					if(map[br][bc] == 0 && !visit[br][bc]) {
						System.out.println(br+" "+bc);
						solve(new Point(br, bc, cln.div, 2, 0));
					}else {
						return;
					}
				}
			}
			
		}
		
		
	}
	
	
	public static class Point {
		int r;
		int c;
		int div;
		int cnt;
		int cnum;
		public Point(int r, int c, int div, int cnt, int cnum) {
			super();
			this.r = r;
			this.c = c;
			this.div = div;
			this.cnt = cnt;
			this.cnum = cnum;
		}
	}

}
