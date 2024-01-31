package springbasic.basic.study.baekjoon.silver.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 좌표 압축 - 정렬 TODO 진행중
 * 각 Xi 보다 작은 값들에 대한 갯수를 구하는 문제
 * 1) 내림차순 정렬
 * 2) 정렬을 안하고도 해보고 해서도 해보자
 */
public class _18870 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> setX = new HashSet<Integer>();
//        int[] position = new int[n];

        // 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            setX.add(Integer.parseInt(st.nextToken()));
//            position[i] = Integer.parseInt(st.nextToken());
        }



        int[] result = new int[n];
        int[] temp = new int[setX.size()];
        Iterator iter = setX.iterator();
        int idx = 0;

        // 중복값 제거된 set int array로 데이터 옮김
        while(iter.hasNext()) {
            temp[idx++] = (int) iter.next();
        }

        for(int i = 0; i < temp.length; i++) {
            int max = temp[i];
            int cnt = 0;
            for(int j = 0; j < setX.size(); j++) {
                if(max > temp[j]) {
                    cnt++;
                }
            }

            result[i] = cnt;
        }

//            for(int i = 0; i < setX.size(); i++) {
//            int max = position[i];
//            int cnt = 0;
//            for(int j = 0; j < n; j++) {
//                // 이전에 체크한 값과 동일하면 안됨
//                if(max > position[j]) {
//                    cnt++;
//                }
//            }
//
//            result[i] = cnt;
//        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(result[i])
                    .append(" ");
        }

        System.out.println(sb);

        // 정렬
//        Arrays.sort(position, (o1, o2) -> {
//            // 두 번째 원소가 같으면 첫 번째 원소 비교
//            if(o1[1] == o2[1]) {
//                return o1[0] - o2[0];
//            } else {
//                return o1[1] - o2[1];
//            }
//        });
//
//        // 출력
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < n; i++) {
//            sb.append(position[i][0])
//                    .append(" ")
//                    .append(position[i][1])
//                    .append('\n');
//        }
//
//        System.out.println(sb);

        br.close();
    }

}
