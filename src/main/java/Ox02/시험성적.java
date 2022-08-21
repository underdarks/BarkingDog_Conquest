package Ox02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 시험성적 {

    /**
     * Map의 순서보장을 위해 LinkedHashMap 사용
     * 구간별 점수에 대한 성적 결과값을 저장하는 자료
     */
    public static LinkedHashMap<Integer, String> getMapScore() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(90,"A");
        linkedHashMap.put(80,"B");
        linkedHashMap.put(70,"C");
        linkedHashMap.put(60,"D");

        return linkedHashMap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        st = new StringTokenizer(s);

        int score = Integer.parseInt(st.nextToken());

        String testScore = getMapScore().entrySet()
                .stream()
                .filter(entry -> score >= entry.getKey())
                .map(e -> e.getValue())
                .findFirst()
                .orElse("F");

        System.out.println(testScore);
    }
}
