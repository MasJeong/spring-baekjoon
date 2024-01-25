package springbasic.basic.study.baekjoon.silver.greedy;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 잃어버린 괄호 - 실버2
 * 그리디 알고리즘이란
 * - 선택의 순간마다 당장 눈 앞에 보이는 최적의 상황을 쫓아 최적해를 구하는 알고리즘
 * - 순간마다 최선을 선택했다고 하나 최종적인 해답에서 최적이라고 보장은 없다.
 * 그리디 알고리즘 적용 조건
 * 1) 앞의 선택이 이후의 선택에 영향을 주면 안된다.
 * 2) 문제에 대한 최종 해결 방법은 부분 문제에 대한 최적 문제 해결 방법으로 구성된다.
 */
public class _1541__lostParenthesis {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        String[] arr = new String[25];
        int idx = 0;
        int result = 0 ;

        int[] arrTemp = new int[25];

        while(st.hasMoreTokens()) {
            arr[idx++] = st.nextToken();
        }

        for(int i = 0; i < arr.length; i++) {
            if(StringUtils.hasText(arr[i])) {
                if(arr[i].contains("+")) {
                    st = new StringTokenizer(arr[i], "+");

                    int idx2 = 0;
                    while(st.hasMoreTokens()) {
                        arrTemp[idx2++] = Integer.parseInt(st.nextToken());
                    }

                    int temp = 0;
                    for(int j = 0; j < arrTemp.length; j++) {
                        temp += arrTemp[j];
                    }

                    // TODO 모두 +인 경우 여기서 음수 처리된다. 수정필요
                    result -= temp;
                } else {
                    result += Integer.parseInt(arr[i]);
                }
            }
        }

        // 00009와 같은 숫자에 대한 처리가 필요하다.

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
