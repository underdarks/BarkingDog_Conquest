import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {

    @Test
    public void 시간측정_테스트(){
        System.out.println("true = " + true);

        Instant start = Instant.now();

        //로직....

        Instant finish = Instant.now();
        System.out.println("소요 시간(ms) = " + Duration.between(start, finish).toMillis());
    }
}
