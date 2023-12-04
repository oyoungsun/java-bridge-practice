package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("Move - 정해진 값 이외 문자를 입력 받으면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "T", "TEST", "pho"})
    void findByMoveNameTestException(String given) {
        assertThatThrownBy(() -> Move.findByMoveName(given))
                .isInstanceOf(IllegalStateException.class);
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

    @DisplayName("Move - 정해진 값 이외 숫자를 입력 받으면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3, 4, 5, 6, 7, 8})
    void findStringByMoveIntException(int given) {
        assertThatThrownBy(() -> Move.findStringByMoveInt(given))
            .isInstanceOf(IllegalStateException.class);
    }
}