package springbasic.basic.study.baekjoon.bronze.bruteforce;

import java.io.*;

/**
 * TODO 분해합
 * 자연수 245(n)의 분해합은 256(2+4+5)(m)
 */
public class _2231_separateSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        1,000,000 * 20까지
        반복문은 200번까지만 돌아야한다.
         */
        long n = Integer.parseInt(br.readLine());
        long m = 0;
        char[] ch = new char[7];

        for(int i = 1; i <= n; i++) {
            String str = Integer.toString(i);
            for(int j = 0; j < str.length(); j++) {
                ch[j] = str.charAt(j);
            }

            m = Integer.parseInt(str);
            for(int j = 0; j < ch.length; j++) {
                if(ch[j] == '\u0000') break;

                m += ch[j] - '0';
            }
        }

        if(n == m) {
            bw.write(Integer.toString(0));
        }

        br.close();
        bw.write(Long.toString(m));
        bw.flush();
        bw.close();
    }
}
