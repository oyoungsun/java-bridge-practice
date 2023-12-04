package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.util.ExceptionHandler;
import bridge.view.Input;
import bridge.view.OutputView;

public class GameController {
    private final BridgeRandomNumberGenerator bridgeGenerator;
    private final Input inputView;
    private BridgeGame bridgeGame;

    public GameController(final BridgeRandomNumberGenerator bridgeGenerator, final Input inputView) {
        this.bridgeGenerator = bridgeGenerator;
        this.inputView = inputView;
    }

    public static GameController of(Input inputView, BridgeRandomNumberGenerator bridgeGenerator) {
        return new GameController(bridgeGenerator, inputView);
    }

    public void run() {
        OutputView.printGameStart();
        settingBridge();
    }

    private void settingBridge() {
        OutputView.printRequestBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = BridgeGame.from();
    }
}
