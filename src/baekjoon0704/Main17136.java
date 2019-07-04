package baekjoon0704;

import java.util.Scanner;

public class Main17136 {
    static class Box {
        int r, c;
 
        Box(int r, int c) {
            this.r = r;
            this.c = c;
        }
 
        @Override
        public String toString() {
            return "Box [r=" + r + ", c=" + c + "]";
        }
 
    }
 
    static int[] block;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        block = new int[] { 0, 5, 5, 5, 5, 5 };
        int[][] map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                map[i][j] = sc.nextInt();
        }
        dfs(map, 0);
        System.out.println(ans==987654321?-1:ans);
    }
    static int ans = 987654321;
    static void dfs(int[][] map, int cnt) {
        //네모가 시작될 수 있는 지점을 찾자.
        Box b = findStart(map);
        //네모가 시작될 수 있는 지점이 없다는건 1이 더이상 존재하지 않음(다 가린거)
        if( b == null) {
            ans = Math.min(cnt, ans);
            return;
        }
        //이미 알고 있는 색종이 수 보다 오버되면 프루닝
        if(cnt >= ans)
            return;
        //해당 시작점으로부터 붙일 수 있는 가장 큰 색종이 크기를 얻어옴
        int size = getMax(map, b);
        //큰 색종이부터 줄여가며 색종이를 붙여봄
        for(int i = size; i > 0; i--) {
            //현재 붙이려는 색종이가 아직 남아있다면
            if(block[i] > 0) {
                //색종이 하나 낭비시키고
                block[i]--;
                //새로운 지도를 그려서
//              int[][] tmp = new int[10][10];
//              deepcopy(map, tmp);
                //색종이를 붙여보고
                for(int k = 0; k < i; k++) {
                    for(int j = 0; j < i; j++)
                        map[b.r+k][b.c+j] = 0;
                }
                //재귀호출ㄱ
                dfs(map, cnt+1);
                for(int k = 0; k < i; k++) {
                    for(int j = 0; j < i; j++)
                        map[b.r+k][b.c+j] = 1;
                }
                //사용했던 색종이 백트래킹( 백트래킹 귀찮아서 딥카피 했는데 메모리 제한이 256M이고 프루닝 안한다면 위험함 )
                block[i]++;
            }
        }
    }
    static void deepcopy(int[][] map, int[][] tmp) {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++)
                tmp[i][j] = map[i][j];
        }
    }
    static int getMax(int[][] map, Box b) {
        int cnt = 5;
        while (cnt > 0) {
            boolean isok = true;
            out: for (int i = 0; i < cnt; i++) {
                for (int j = 0; j < cnt; j++) {
                    if (b.r + i >=10 || b.c + j >= 10 || map[b.r + i][b.c + j] == 0) {
                        isok = false;
                        break out;
                    }
                }
            }
            if(isok)
                return cnt;
            cnt--;
        }
        return cnt;
    }
 
    static Box findStart(int[][] map) {
        Box b = null;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    if (i == 0 && j == 0)
                        return new Box(i, j);
                    if (i == 0 && j > 0 && map[i][j - 1] == 0)
                        return new Box(i, j);
                    if (j == 0 && i > 0 && map[i - 1][j] == 0)
                        return new Box(i, j);
                    if (i > 0 && j > 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0)
                        return new Box(i, j);
                }
            }
        }
 
        return b;
    }
 
}