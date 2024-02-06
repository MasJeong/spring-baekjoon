package springbasic.basic.study.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 숫자카드2 - 집합과 맵 TODO 진행중
 */
public class _10816 {

    private static int binarySearch(List<Integer> listN, int target) {
        int left = 0;
        int right = listN.size() - 1;

        while(left <= right) {
            int mid = (right + left) / 2;

            if(listN.get(mid) < target) {
                left = mid + 1;
            } else if(listN.get(mid) > target) {
                right = mid - 1;
            } else {
                listN.remove(mid);
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        List<Integer> listN = new ArrayList<>();
        List<Integer> listM = new ArrayList<>();

        // 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            listN.add(i, Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            int ele = Integer.parseInt(st.nextToken());
            listM.add(i, ele);
            map.put(ele, i);
        }

        // 정렬
        Collections.sort(listM);

        int[] result = new int[n];

        // 이진탐색
        for(int i = 0; i < listN.size(); i++) {
            result[i] = binarySearch(listM, listN.get(i));
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++) {
            sb.append(result[i])
                    .append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
