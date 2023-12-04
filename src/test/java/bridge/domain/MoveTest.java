package bridge.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class MoveTest {

    @DisplayName("Move - 'U', 'D'를 입력 받으면 Move에서 UP/DOWN 탐색이 가능하다.")
    @ParameterizedTest
    @MethodSource("generateFindBy")
    void findByMoveNameTest(String given, Move expected) {
        // when
        Move result = Move.findByMoveName(given);
        // then
        assertEquals(result, expected);
    }

    private static Stream<Arguments> generateFindBy() {
        return Stream.of(
            Arguments.of("U", Move.UP),
            Arguments.of("D", Move.DOWN)
        );
    }

    @DisplayName("Move - 0, 1를 입력 받으면 Move에서 UP/DOWN Name으로 반환된다.")
    @ParameterizedTest
    @CsvSource(value = {"0, 'D'", "1, 'U'"})
    void findStringByMoveInt(int given, String expected) {
        // when
        String result = Move.findStringByMoveInt(given);
        // then
        assertEquals(result, expected);
    }
}