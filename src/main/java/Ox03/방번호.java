package Ox03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 방번호 {

    /**
     * 각 숫자들의 개수 구한 후 최대값 반환
     * (6,9는 예외)
     */
    public static int getMinimumSetCount(String s) {
        int[] numsCount = new int[10];
        boolean flag=false;

        for (Character c : s.toCharArray()) {
            numsCount[c - '0']++;
        }

        //가장 많은 숫자가 나온 최대값
        int max = Arrays.stream(numsCount)
                .max()
                .orElse(0);

        for (int i = 0; i < numsCount.length; i++) {
            if(i == 6 || i == 9)
                continue;

            else{
                if(numsCount[i] == max) {
                    flag = true;
                    break;
                }
            }
        }

        //6,9를 제외한 나머지 숫자들 중 갯수가 같은 경우(ex.111999)
        if(flag) {
            return max;
        }

        //6,9가 포함된 개수가 젤 많으면 6의 갯수+9의 갯수로 세트수 구함
        else {
            int countSix = numsCount[6];
            int countNine = numsCount[9];
            if (countSix == max || countNine == max) {
                int result = (countSix + countNine) / 2;
                return (countSix + countNine) % 2 == 0 ? result : result + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();

        int count = getMinimumSetCount(s);
        System.out.println(count);

        br.close();
    }
}
