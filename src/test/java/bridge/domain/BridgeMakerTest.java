package bridge.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.BeanFactory;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    BeanFactory factory;

    @BeforeEach
    void setUp() {
        factory = new BeanFactory();
    }

    @DisplayName("BridgeMaker - 생성한 다리 size는 입력 받은 다리 길이와 같다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 20})
    void makeBridgeTest(int size) {
        //given
        BridgeMaker bridgeMaker = factory.getBridgeMaker();
        //when
        List<String> result = bridgeMaker.makeBridge(size);
        //then
        assertEquals(size, result.size());
    }
}