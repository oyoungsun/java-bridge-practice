package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {
    @DisplayName("GameCommand - 'R', 'Q'를 입력 받으면 GameCommand에서 RETRY/QUIT 탐색이 가능하다.")
    @ParameterizedTest
    @MethodSource("generateFindBy")
    void findByStringTest(String given, GameCommand expected) {
        // when
        GameCommand result = GameCommand.findByString(given);
        // then
        assertEquals(result, expected);
    }

    private static Stream<Arguments> generateFindBy() {
        return Stream.of(
                Arguments.of("R", GameCommand.RETRY),
                Arguments.of("Q", GameCommand.QUIT)
        );
    }

    @DisplayName("GameCommand - 정해진 값 이외 문자를 입력 받으면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "T", "TEST", "pho"})
    void findByMoveNameTestException(String given) {
        assertThatThrownBy(() -> Move.findByMoveName(given))
                .isInstanceOf(IllegalStateException.class);
    }
}