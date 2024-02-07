package springbasic.basic.study.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 숫자카드2 - 집합과 맵
 */
public class _10816_useBinarySearch {

    private static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while(left <= right) {
            int mid = (right + left) / 2;

            if(list.get(mid) < target) {
                left = mid + 1;
            } else if(list.get(mid) > target) {
                right = mid - 1;
            } else {
                /*
                    remove하는 경우 반례가 발생함
                    1
                    1
                    2
                    1 1
                    정답: 1 1
                    list.remove(mid);
                 */

                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        // 입력
        HashMap<Integer, Integer> mapTarget = new HashMap<>();
        HashMap<Integer, Integer> mapSearch = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            mapTarget.put(i, Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            mapSearch.put(i, Integer.parseInt(st.nextToken()));
        }

        // 정렬
        List<Integer> targetList = new ArrayList<>(mapTarget.values());
        targetList.sort(Integer::compareTo);

        int[] result = new int[m];

        // 이진탐색
        for(int i = 0; i < mapSearch.size(); i++) {
            int searchResult = 1;

            while(searchResult == 1) {
                searchResult = binarySearch(targetList, mapSearch.get(i));
                result[i]+= searchResult;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int j : result) {
            sb.append(j).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
