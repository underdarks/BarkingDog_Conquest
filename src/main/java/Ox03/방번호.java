package Ox03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제 요구사항
 * -필요한 세트의 개수의 최소값을 구하여라
 * <p>
 * 변경/확장이 발생할 가능성이 있는 요소
 * -0번~9번까지의 숫자카드 -> 만약 0~100까지 숫자라면?
 * -6과9처럼 뒤집어서 이용할 수 있는 카드의 확장성 -> 만약 (2,5) (9,3)등의 추가 쌍이 생긴다면?
 * <p>
 * 그렇다면 어떻게 설계하고 구현할 것인가?(해결)
 * -일단 숫자카드의 확장성을 고려한 자료구조 선택
 * -숫자 순서쌍의 확정성을 고려한 로직 구현
 */
public class 방번호 {


    /**
     * (6,9)쌍처럼 추가 확장성을 고려한 자료구조 선택
     **/
    public static Map<Integer, Integer> getReversePairNumber() {
        Map<Integer, Integer> pairNum = new HashMap<>();    //순서 쌍
        pairNum.put(6, 9);

        return pairNum;
    }

    /**
     * 각 숫자들의 개수 구한 후 최대값 반환(예외 사항 반영)
     */
    public static int getMinimumSetCount(String s) {
        Map<Integer, Integer> countMap = new HashMap<>();             //key : 숫자, value: 해당 숫자의 개수
        Map<Integer, Integer> pairNumber = getReversePairNumber();    //순서쌍(key,value)
        List<Object> maxCountNumbers = new ArrayList<>();
        int max = 0;     //숫자들중 최대갯수

        for (Character c : s.toCharArray()) {
            int key = c - '0';
            int value = (Integer) countMap.getOrDefault(key, 0) + 1;
            max = Math.max(max, value);
            countMap.put(key, value);
        }

        //최대값을 가진 숫자들을 찾기
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            //순서쌍이 아닌 최대값을 가진 숫자들을 저장
            for (Map.Entry<Integer, Integer> pairEntry : pairNumber.entrySet()) {
                if (entry.getValue().equals(max) && !entry.getKey().equals(pairEntry.getKey()) && !entry.getKey().equals(pairEntry.getValue())) {
                    maxCountNumbers.add(entry.getKey());
                }
            }
        }

        //순서쌍의 순자들의 개수가 가장 많은 경우
        if (maxCountNumbers.size() < 1) {
            int maxPairCount = 0;

            for (Map.Entry<Integer, Integer> entry : pairNumber.entrySet()) {
                int key = countMap.getOrDefault(entry.getKey(), 0);
                int pair = countMap.getOrDefault(entry.getValue(), 0);

                if (key == max || pair == max) {
                    int result = (key + pair) % 2 == 0 ? (key + pair) / 2 : (key + pair) / 2 + 1;
                    maxPairCount=Math.max(maxPairCount,result);
                }
            }

            return maxPairCount;
        }

        //순서쌍을 이루는 숫자들을 제외한 숫자중 최대값
        return max;
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
