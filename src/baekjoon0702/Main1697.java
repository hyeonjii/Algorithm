package baekjoon0702;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 숨바꼭질 */

public class Main1697 {
	public static class Time{
		int location;
		int time;
		public Time(int location, int time) {
			super();
			this.location = location;
			this.time = time;
		}
	}
	
	static int n, k;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		visit = new boolean[100001];
		
		solve();
	}
	
	public static void solve() {
		Queue<Time> q = new LinkedList<Time>();
		q.add(new Time(n, 0));
//		visit[n] = true;
		
		while(!q.isEmpty()) {
			Time p = q.poll();
			
			if(p.location == k) {
				System.out.println(p.time);
				return;
			}
			if(p.location < 0 || p.location > 100000) {
				continue;
			}
			
			if(!visit[p.location]) {
				visit[p.location] = true;
				q.add(new Time(p.location-1, p.time+1));
				q.add(new Time(p.location+1, p.time+1));
				q.add(new Time(p.location*2, p.time+1));				
			}
			
		}
	}

}
