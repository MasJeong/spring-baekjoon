package springbasic.basic.study.baekjoon.bronze;

import java.io.*;

public class _5073 {

    private static int LENGTH = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strArr = new String[LENGTH];
        int nMax = -1;

        for(int i = 0; i < strArr.length; i++) {
            // TODO scanner 사용할 떄와 string[] to int 시 성능 확인
            String[] arrNum = br.readLine().split(" ");
            int num1 = Integer.parseInt(arrNum[0]);
            int num2 = Integer.parseInt(arrNum[1]);
            int num3 = Integer.parseInt(arrNum[2]);

            if(num1 == 0 && num2 == 0 && num3 == 0)
                break;

            // set max value
            for(int j = 0; j < arrNum.length; j++) {
                int num = Integer.parseInt(arrNum[j]);
                if(nMax < num) {
                    nMax = num;
                }
            }

            if(nMax >= num1 + num2 || nMax >= num2 + num3 || nMax >= num1 + num3)
                strArr[i] = "Invalid";
            else if(num1 == num2 && num2 == num3)
                strArr[i] = "Equilateral";
            else if(num1 == num2 || num1 == num3 || num2 == num3)
                strArr[i] = "Isosceles";
            else
                strArr[i] = "Scalene";
        }

        for(int i = 0; i < strArr.length - 2; i++)
            bw.write(strArr[i] + "\n");

        bw.write(strArr[strArr.length - 2]);

        bw.flush();
        bw.close();
        br.close();
    }

}
