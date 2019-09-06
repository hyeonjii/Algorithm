package baekjoon0906;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 0은 평지, 1은 장애물
// 시작점과 도착점은 항상 평지
// 원숭이의 동작수의 최솟값을 출력
// 시작점에서 도착점까지 갈 수 없는 경우엔 -1


public class Main1600 {
	static int dx[] = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
	static int dy[] = {0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2}; // 말의 이동 방향
//	static int dx[] = {-1,1,0,0};
//	static int dy[] = {0,0,-1,1};	// 인접 이동 방향
	
	static int k, w, h, ans;
	static int[][] map;
	static boolean[][][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		ans = 987654321;
		map= new int[h][w];
		visit = new boolean[h][w][k+1];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		solve();
		
		if(ans == 987654321) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
	}
	
	public static void solve() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0, k));
		visit[0][0][k] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == h-1 && p.y == w-1) {
				if(ans > p.cnt) {
					ans = p.cnt;
					return;
				}
			}
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == 1) {
					continue;
				}
				
				if(i < 4 ) {
					if(!visit[nx][ny][p.k]) {
						visit[nx][ny][p.k] = true;
						q.add(new Point(nx, ny, p.cnt+1, p.k));
					}
				}else {
					if(p.k > 0 && !visit[nx][ny][p.k-1]) {
						visit[nx][ny][p.k-1] = true;
						q.add(new Point(nx, ny, p.cnt+1, p.k-1));
					}
				}
			}
		}
	}

	public static class Point {
		int x;
		int y;
		int cnt;
		int k;
		public Point(int x, int y, int cnt, int k) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
}
