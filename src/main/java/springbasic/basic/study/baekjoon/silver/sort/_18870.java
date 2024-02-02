package springbasic.basic.study.baekjoon.silver.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 좌표 압축 - 정렬
 * 각 Xi 보다 작은 값들에 대한 갯수를 구하는 문제
 * 1) 내림차순 정렬
 * 2) 정렬을 안하고도 해보고 해서도 해보자
 */
public class _18870 {

    /**
     * 이진탐색 구현 - Arrays.binarySearch()
     */
//    private static void binarySearch(int[] temp) {
//        int left = 0;
//        int right = temp.length - 1;
//        while(left <= right) {
//
//        }
//    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] position = new int[n];
        int[] tempArr = new int[n];
        int count = 0;

        // 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            position[i] = Integer.parseInt(st.nextToken());
        }

        tempArr = position.clone();

        // 정렬
        Arrays.sort(tempArr);

        // TODO 마저 진행하자. 2중 for문으로 값을 찾는 것 말고 다른 방법을 찾아보자 없으면 HashMap 사용 (검색에 빠름...)
        /*
            HashMap 검색속도 O(1)
            List 검색속도 O(n) - 정렬된 경우 이진탐색을 사용하여 O(log n)
         */
        for(int i = 0; i < position.length; i++) {
//            if(position[i] == tempArr) {
//
//            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(position[i])
                    .append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
