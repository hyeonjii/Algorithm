package baekjoon0702;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//벽부수고 이동하기 
public class Main2206 {
	static int n, m, ans = 987654321;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static class Point{
		int x;
		int y;
		int cur;
		int cnt;
		public Point(int x, int y, int cur, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cur = cur;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m][2];
		
		for (int i = 0; i < map.length; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j) - '0'; 	
			}
		}
		bfs();
		if(ans == 987654321) {
			System.out.println("-1");
		}else {
			System.out.println(ans+1);			
		}
		
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, 0));
		visit[0][0][1] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == n-1 && p.y == m-1) {
				if(ans > p.cnt) {
					ans = p.cnt;
				}
				return;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				if( map[nx][ny] == 1 ) {
					if(!visit[nx][ny][0] && p.cur ==1) {
						visit[nx][ny][0] = true;
						q.add(new Point(nx, ny, 0, p.cnt+1));
					}
				}else {
					if(!visit[nx][ny][p.cur]) {
						visit[nx][ny][p.cur] = true;
						q.add(new Point(nx, ny, p.cur, p.cnt+1));
					}
				}
			}
			
		}
	}
	

}

