package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.view.Input;
import bridge.view.OutputView;

public class GameController {
    private final BridgeRandomNumberGenerator bridgeGenerator;
    private final Input inputView;
    private final BridgeGame bridgeGame;

    public GameController(final BridgeRandomNumberGenerator bridgeGenerator, final Input inputView,
                          final BridgeGame bridgeGame) {
        this.bridgeGenerator = bridgeGenerator;
        this.inputView = inputView;
        this.bridgeGame = bridgeGame;
    }

    public static GameController of(Input inputView,
                                    BridgeRandomNumberGenerator bridgeGenerator,
                                    BridgeGame bridgeGame) {
        return new GameController(bridgeGenerator, inputView, bridgeGame);
    }

    public void run() {
        OutputView.printGameStart();
        settingBridge();
    }

    private void settingBridge() {
        OutputView.printRequestBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.settingBridge(bridgeSize);
    }
}
