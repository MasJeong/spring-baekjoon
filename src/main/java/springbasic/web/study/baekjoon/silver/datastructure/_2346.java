package springbasic.web.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 풍선 터뜨리기 - 덱
 */
public class _2346 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        final ArrayDeque<Integer> deque = new ArrayDeque<>();
        final ArrayDeque<Integer> subDeque = new ArrayDeque<>();

        final HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            deque.offer(input);
            map.put(input, i);
        }

        int num = deque.pollFirst();
        sb.append(map.get(num)).append(" ");

        while (!deque.isEmpty()) {
            if (num > 0) {

            } else {

            }
        }

        System.out.println(sb);
        br.close();
    }
}
