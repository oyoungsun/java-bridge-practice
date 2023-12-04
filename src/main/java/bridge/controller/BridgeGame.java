package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.Move;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Bridge bridge;

    public static BridgeGame from() {
        return new BridgeGame();
    }

    public void settingBridge(final int bridgeSize) {
        List<Integer> randomBridge = bridgeMaker.makeBridge(bridgeSize);
        List<Move> moves = randomBridge.stream().map(moveInt -> Move.findByInteger(moveInt))
                .collect(Collectors.toList());
        bridge = Bridge.from(moves);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

}
