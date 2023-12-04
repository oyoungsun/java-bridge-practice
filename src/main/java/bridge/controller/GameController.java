package bridge.controller;

import bridge.service.BridgeGame;
import bridge.util.ExceptionHandler;
import bridge.view.Input;
import bridge.view.OutputView;

public class GameController {
    private final Input inputView;
    private final BridgeGame bridgeGame;

    public GameController(final Input inputView, final BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.bridgeGame = bridgeGame;
    }

    public static GameController of(Input inputView, BridgeGame bridgeGame) {
        return new GameController(inputView, bridgeGame);
    }

    public void run() {
        OutputView.printGameStart();
        settingBridge();
        do {
            ExceptionHandler.process(() -> processMove());
            if (bridgeGame.isFinish()) {
                break;
            }
        } while (ExceptionHandler.setting(() -> processRetry()));
        processResult();
    }

    private void processResult() {
        OutputView.printFinalMap(bridgeGame.getFinalScore());
    }

    private boolean processRetry() {
        OutputView.printRequestGameCommand();
        String command = inputView.readGameCommand();
        boolean isRetry = bridgeGame.retry(command);
        return isRetry;
    }

    private void processMove() {
        OutputView.printRequestMoving();
        String moving = inputView.readMoving();
        boolean isSuccess = bridgeGame.move(moving);
        OutputView.printMap(bridgeGame.getResult(isSuccess));
        if (bridgeGame.isFinish()) {
            return;
        }
        if (isSuccess) {
            processMove();
        }
    }

    private void settingBridge() {
        OutputView.printRequestBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.settingBridge(bridgeSize);
        OutputView.printEmpty();
    }
}
