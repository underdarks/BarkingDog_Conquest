package Ox03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제 요구사항
 * - 자연수 X가 주어졌을 때 a1+a2 = X을 만족하는 순서쌍의 개수를 구하여라
 *
 */
public class 두수의합 {

    /**
     * a+b = x를 만족하는 순서쌍 개수 리턴
     */
    public static int getNumOfPairs(List<Integer> list, int x) {
        int count = 0;

        //1. two pointer 검색을 위한 정렬
        Collections.sort(list);

        int j=list.size()-1;
        for (int i = 0; i < j; i++) {
            for (; i < j; j--) {
                Integer a = list.get(i);
                Integer b = list.get(j);

                if (a+b == x) {
                    count++;
                    j--;
                    break;
                }

                else if(a+b <x)
                    break;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        List<Integer> list = new ArrayList<>();

        int size = Integer.parseInt(br.readLine());
        String s = br.readLine();
        st = new StringTokenizer(s);

        for (int i = 0; i < size; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        int x = Integer.parseInt(br.readLine());
        int numOfPairs = getNumOfPairs(list, x);

        System.out.println(numOfPairs);


        br.close();
    }
}
