package bridge;

import bridge.controller.GameController;
import bridge.domain.BridgeMaker;
import bridge.service.BridgeGame;
import bridge.view.Input;
import bridge.view.InputView;

public class BeanFactory {
    private final BridgeRandomNumberGenerator bridgeGenerator;
    private final Input inputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BeanFactory(){
        bridgeGenerator = new BridgeRandomNumberGenerator();
        inputView = InputView.getInstance();
        bridgeMaker = new BridgeMaker(bridgeGenerator);
        bridgeGame = BridgeGame.from(bridgeMaker);
    }
    public GameController getController() {
        return GameController.of(inputView, bridgeGame);
    }

    public BridgeGame getBridgeGame() {
        return bridgeGame;
    }

    public BridgeMaker getBridgeMaker() {
        return bridgeMaker;
    }
}
