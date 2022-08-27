package Ox03;

import org.junit.jupiter.api.*;
import java.io.IOException;
import static Ox03.방번호.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 모든 TC 테스트 및 확인(내눈으로 직접)
 */
class 방번호Test {

    @DisplayName("tc1")
    @Test
    public void test1() throws IOException {
        //given
        String s = "9999";

        //when
        doTest(s,2);
    }

    @DisplayName("tc2")
    @Test
    public void test2() throws IOException {
        //given
        String s = "122";

        //when
        doTest(s,2);
    }

    @DisplayName("tc3")
    @Test
    public void tc3() throws IOException {
        //given
        String s = "122";

        //when
        doTest(s,2);
    }

    @DisplayName("tc4")
    @Test
    public void tc4() throws IOException {
        //given
        String s = "12635";

        //when
        doTest(s,1);
    }

    @DisplayName("tc5")
    @Test
    public void tc5() throws IOException {
        //given
        String s = "888888";

        //when
        doTest(s,6);
    }

    @DisplayName("tc6")
    @Test
    public void tc6() throws IOException {
        //given
        String s = "123444";

        //when
        doTest(s,3);
    }

    @DisplayName("tc7")
    @Test
    public void tc7() throws IOException {
        //given
        String s = "0";

        //when
        doTest(s,1);
    }

    @DisplayName("tc8")
    @Test
    public void tc8() throws IOException {
        //given
        String s = "6666669";

        //when
        doTest(s,4);
    }

    @DisplayName("tc9")
    @Test
    public void tc9() throws IOException {
        //given
        String s = "199999";

        //when
        doTest(s,3);
    }

    @DisplayName("tc10")
    @Test
    public void tc10() throws IOException {
        //given
        String s = "1000000";

        //when
        doTest(s,6);
    }

    @DisplayName("tc11")
    @Test
    public void tc11() throws IOException {
        //given
        String s = "661992";

        //when
        doTest(s,2);
    }

    @DisplayName("tc12")
    @Test
    public void tc12() throws IOException {
        //given
        String s = "19";

        //when
        doTest(s,1);
    }

    @DisplayName("tc13")
    @Test
    public void tc13() throws IOException {
        //given
        String s = "69";

        //when
        doTest(s,1);
    }

    @DisplayName("tc14")
    @Test
    public void tc14() throws IOException {
        //given
        String s = "999999";

        //when
        doTest(s,3);
    }

    @DisplayName("tc15")
    @Test
    public void tc15() throws IOException {
        //given
        String s = "169";

        //when
        doTest(s,1);
    }

    @DisplayName("tc16")
    @Test
    public void tc16() throws IOException {
        //given
        String s = "66";

        //when
        doTest(s,1);
    }

    @DisplayName("tc17")
    @Test
    public void tc17() throws IOException {
        //given
        String s = "6699";

        //when
        doTest(s,2);
    }

    @DisplayName("tc18")
    @Test
    public void tc18() throws IOException {
        //given
        String s = "1199";

        //when
        doTest(s,2);
    }

    private void doTest(String s,int expected) {
        //then
        assertEquals(expected, getMinimumSetCount(s));
    }

}
