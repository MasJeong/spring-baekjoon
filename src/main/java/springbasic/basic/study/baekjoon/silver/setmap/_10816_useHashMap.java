package springbasic.basic.study.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 숫자카드2 - TODO 집합과 맵
 */
public class _10816_useHashMap {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        // 입력
        HashMap<Integer, Integer> mapTarget = new HashMap<>();
        HashMap<Integer, Integer> mapSearch = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            mapTarget.put(Integer.parseInt(st.nextToken()), null);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            mapSearch.put(i, Integer.parseInt(st.nextToken()));
        }

        int[] result = new int[m];

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int j : result) {
            sb.append(j).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
