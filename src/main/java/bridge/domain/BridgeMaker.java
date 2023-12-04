package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final String BRIDGE_STATE_EXCEPTION = "다리의 길이가 맞지 않습니다.";

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for(int i=0; i<size; i++){
            bridge.add(Move.findStringByMoveInt(bridgeNumberGenerator.generate()));
        }
        if(bridge.size()!=size){
            throw new IllegalStateException(BRIDGE_STATE_EXCEPTION);
        }
        return bridge;
    }
}
