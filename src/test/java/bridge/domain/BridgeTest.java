package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    @DisplayName("주어진 다리 크기와 현재 다리 크기가 같은지를 판단한다.")
    @ParameterizedTest
    @MethodSource("generateIsFinish")
    void isFinishTest(Bridge given, Bridge given2, boolean expected) {
        // when
        boolean result = given.isSameSize(given2);
        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> generateIsFinish() {
        return Stream.of(
                Arguments.of(Bridge.from(List.of(Move.UP, Move.DOWN, Move.UP, Move.DOWN)),
                        Bridge.from(List.of(Move.UP, Move.DOWN, Move.UP, Move.DOWN)), true),
                Arguments.of(Bridge.from(List.of(Move.UP, Move.DOWN, Move.UP)),
                        Bridge.from(List.of(Move.UP, Move.DOWN, Move.UP, Move.DOWN, Move.UP)), false)
        );
    }
    @DisplayName("Move에 따라 생성된 다리와 비교한 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateMove")
    void moveTest(Bridge given, Move move, Bridge given2, boolean expected, int expectedSize) {
        // when
        boolean result = given.move(given2, move);
        // then
        assertThat(result).isEqualTo(expected);
        assertThat(given.getSize()).isEqualTo(expectedSize);
    }

    private static Stream<Arguments> generateMove(){
        return Stream.of( //user, generated, inputMove
            Arguments.of(Bridge.from(new ArrayList<>(List.of(Move.UP, Move.DOWN, Move.UP))), Move.UP,
                    Bridge.from(List.of(Move.UP, Move.DOWN, Move.UP, Move.UP)), true, 4),

            Arguments.of(Bridge.from(new ArrayList<>(List.of(Move.UP, Move.DOWN, Move.DOWN))), Move.DOWN,
                    Bridge.from(List.of(Move.UP, Move.DOWN, Move.DOWN, Move.UP)), false, 3)
        );
    }
}