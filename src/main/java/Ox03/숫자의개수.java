package Ox03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class 숫자의개수 {

    /**
     * 0~9사이의 각 숫자들의 개수 구하기
     * @param value
     */
    public static void getUsedCountNumber(String value){
        ConcurrentMap<Character, Long> countMap = Stream.of(value)
//                .parallel()
                .flatMap(v -> v.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));  // key : 숫자, value : 숫자의 개수

        for(char key='0'; key<='9'; key++){
            Long count = countMap.getOrDefault(key, 0L);
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws IOException {
        int [] nums =new int[10];
        int size=3;

        long value=1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<3;i++)
            value*=(Integer.parseInt(br.readLine()));

        Instant start = Instant.now();

        String s = String.valueOf(value);

        for (char c : s.toCharArray())
            nums[c-'0']++;

        for (int num : nums)
            System.out.println(num);

        Instant finish = Instant.now();
        System.out.println("소요 시간(ms) = " + Duration.between(start, finish).toMillis());

        /**
         *  2개의 알고리즘 성능 측정
         *  반복 문에 대한 속도 비교 : for > stream
         *  스트림이 데이터량이 적으면 일반 for문 보다 느림. 그리고 데이터가 적을 때 parallel로 돌리면 더 느리다.
         */


        start = Instant.now();
        getUsedCountNumber(String.valueOf(value));

        finish = Instant.now();
        System.out.println("소요 시간(ms) = " + Duration.between(start, finish).toMillis());

        br.close();
    }
}
