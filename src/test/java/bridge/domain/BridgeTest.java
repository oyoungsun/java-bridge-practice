package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.service.BridgeGame;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    @DisplayName("주어진 다리 크기와 현재 다리 크기가 같은지를 판단한다.")
    @ParameterizedTest
    @MethodSource("generateIsFinish")
    void isFinishTest(Bridge given, Bridge given2, boolean expected){
        // when
        boolean result = given.isSameSize(given2);
        // then
        assertThat(result).isEqualTo(expected);
    }
    static Stream<Arguments> generateIsFinish(){
        return Stream.of(
                Arguments.of(Bridge.from(List.of(Move.UP, Move.DOWN, Move.UP, Move.DOWN)), Bridge.from(List.of(Move.UP, Move.DOWN, Move.UP, Move.DOWN)), true),
                Arguments.of(Bridge.from(List.of(Move.UP, Move.DOWN, Move.UP)), Bridge.from(List.of(Move.UP, Move.DOWN, Move.UP, Move.DOWN, Move.UP)), false)
        );
    }
}