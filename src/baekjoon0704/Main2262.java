package baekjoon0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2262 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      int n = Integer.parseInt(br.readLine());
      List<Integer> list = new ArrayList<>();
      st = new StringTokenizer(br.readLine());
      
      for(int i = 0; i < n; i++)
         list.add(Integer.parseInt(st.nextToken()));
      
      int sol = 0;
      while(list.size() != 1) {
         int idx = maxIdx(list);
         
         if(idx == 0) {
            sol += list.get(idx) - list.get(idx + 1);
            list.remove(0);
            continue;
         }
         
         if(idx == list.size() - 1) {
            sol += list.get(idx) - list.get(idx - 1);
            list.remove(list.size() - 1);
            continue;
         }
         
         if(list.get(idx - 1) > list.get(idx + 1)) {
            sol += list.get(idx) - list.get(idx - 1);
            list.remove(idx);
            continue;
         }
         else {
            sol += list.get(idx) - list.get(idx + 1);
            list.remove(idx);
            continue;
         }
      }
      
      System.out.println(sol);
   }
   
   static int maxIdx(List<Integer> list) {
      int maxNum = 0;
      int idx = 0;
      for(int i = 0; i < list.size(); i++) {
         if(list.get(i) > maxNum) {
            maxNum = list.get(i);
            idx = i;
         }
      }
      return idx;
   }
}