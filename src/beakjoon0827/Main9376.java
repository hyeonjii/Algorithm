package beakjoon0827;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main9376 {
	static int h, w, ans = 987654321;
	static int[][] out;
	static char[][] map;
	static int[][] cnt;
	static boolean[][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			h = sc.nextInt();
			w = sc.nextInt();
			out = new int[2][2];
			int num = 0;
			map = new char[h][w];
			cnt = new int[h][w];
			for (int i = 0; i < map.length; i++) {
				String line = sc.next();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == '$') {
						out[num][0] = i;
						out[num][1] = j;
						num++;
					}
				}
			}
			
			for (int i = 0; i < 2; i++) {
				visit = new boolean[h][w];
				solve(i);
//				for (int j = 0; j < cnt.length; j++) {
//					System.out.println(Arrays.toString(cnt[j]));
//				}
				System.out.println(ans);
			}
			System.out.println();
		}
	}
	
	public static void solve(int n) {
		int scnt = 0;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(out[n][0], out[n][1]));
		visit[out[n][0]][out[n][1]] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
					if(ans > scnt) {
						ans = scnt;
					}
					continue;
				}
				if(map[nx][ny] != '*' && !visit[nx][ny]) {
					if(map[nx][ny] == '#') {
						if(cnt[nx][ny] == 0) {
							scnt++;
							cnt[nx][ny]++;
						}
					}
					q.add(new Point(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
	}
	
	public static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
