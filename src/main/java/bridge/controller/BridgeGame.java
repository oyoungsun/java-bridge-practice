package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.Move;
import bridge.domain.dto.MapDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Bridge bridge;
    private Bridge user;

    public static BridgeGame from() {
        return new BridgeGame();
    }

    public void settingBridge(final int bridgeSize) {
        List<String> randomBridge = bridgeMaker.makeBridge(bridgeSize);
        List<Move> moves = randomBridge.stream().map(moveInt -> Move.findByMoveInt(moveInt))
                .collect(Collectors.toList());
        bridge = Bridge.from(moves);
        user = Bridge.from(new ArrayList<>());
        System.out.println(moves);
    }

    public boolean move(final String given) {
        Move move = Move.findByMoveName(given);
        boolean isMovable = user.move(bridge, move);
        return isMovable;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public boolean retry(final String command) {
        //user 초기화
        return false;
    }

    public boolean isFinish() {
        return user.isSameSize(bridge);
    }

    public MapDto getResult(final boolean isSuccess) {
        //현재까지의 성공한 결과에 가장 최근 결과를 반영해 반환한다.
        if(isSuccess){
            MapDto.fromEntity(user.getSize(), isSuccess);
        }
        return MapDto.fromEntity(user.getSize(), isSuccess);
    }
}
