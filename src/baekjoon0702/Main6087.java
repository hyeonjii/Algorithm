package baekjoon0702;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//레이저 통신
public class Main6087 {
	static int w, h, ans = 987654321;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int[][] cloc;
	static char[][] map;
	static boolean[][][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		cloc = new int[2][2];
		int ci = 0;
		map = new char[h][w];
		visit = new boolean[h][w][4];
		for (int i = 0; i < map.length; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'C') {
					cloc[ci][0] = i;
					cloc[ci][1] = j;
					ci++;
				}
			}
		}
	
		bfs();
		System.out.println(ans);
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < 4; i++) {
			q.add(new Point(cloc[0][0], cloc[0][1], i, 0));
			visit[cloc[0][0]][cloc[0][1]][i] = true;
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			System.out.println(p.x + " " + p.y);
			System.out.println(p.cnt);
			if(p.x == cloc[1][0] && p.y == cloc[1][1]) {
				System.out.println("a");
				if(ans > p.cnt) {
					ans = p.cnt;
				}
				return;
			}
			int nx = p.x + dx[p.dir];
			int ny = p.y + dy[p.dir];
			
			if(nx < 0 || ny < 0 || nx >= h || ny >= w ) {
				continue;
			}
			
			if(map[nx][ny] == '.' && !visit[nx][ny][p.dir] ) {
				visit[nx][ny][p.dir] = true;
				if(p.dir == 0 || p.dir == 1) {
					q.add(new Point(nx, ny, 2, p.cnt+1));
					q.add(new Point(nx, ny, 3, p.cnt+1));
				}
				if(p.dir == 2 || p.dir == 3) {
					q.add(new Point(nx, ny, 0, p.cnt+1));
					q.add(new Point(nx, ny, 1, p.cnt+1));
				}
				q.add(new Point(nx, ny, p.dir, p.cnt));
			}
		}
	}

	public static class Point{
		int x;
		int y;
		int dir;
		int cnt;
		public Point(int x, int y, int dir, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
		
	}
	
}
