package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.GameCommand;
import bridge.domain.Move;
import bridge.domain.dto.MapDto;
import bridge.domain.dto.OutcomDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final int INITIAL_TRY_COUNT = 1;
    private int tryCount = INITIAL_TRY_COUNT;
    private Bridge bridge;
    private Bridge user;
    private Move userLastMove;

    public static BridgeGame from() {
        return new BridgeGame();
    }

    public void settingBridge(final int bridgeSize) {
        List<String> randomBridge = bridgeMaker.makeBridge(bridgeSize);
        List<Move> moves = randomBridge.stream().map(moveName -> Move.findByMoveName(moveName))
                .collect(Collectors.toList());
        bridge = Bridge.from(moves);
        user = Bridge.from(new ArrayList<>());
        System.out.println(moves);
    }

    public boolean move(final String given) {
        userLastMove = Move.findByMoveName(given);
        boolean isMovable = user.move(bridge, userLastMove);
        return isMovable;
    }
    
    public boolean retry(final String given) {
        GameCommand command = GameCommand.findByString(given);
        if(command == GameCommand.RETRY){
            tryCount++;
            user = Bridge.from(new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean isFinish() {
        return user.isSameSize(bridge);
    }

    public MapDto getResult(final boolean isSuccess) {
        //현재까지의 성공한 결과에 가장 최근 결과를 반영해 반환한다.
        if(isSuccess){
            MapDto.fromEntity(user, userLastMove, isSuccess);
        }
        return MapDto.fromEntity(user, userLastMove, isSuccess);
    }

    public OutcomDto getFinalScore() {
        boolean isSuccess = user.isSameSize(bridge);
        return OutcomDto.fromEntity(getResult(isSuccess), isSuccess, tryCount);
    }
}
