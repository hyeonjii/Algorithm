package baekjoon0717;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main10409 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			q.add(sc.nextInt());
		}
		int sum = 0;
		int cnt = 0;
		while(!q.isEmpty() ) {
			sum += q.poll();
			if(sum > t) {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
