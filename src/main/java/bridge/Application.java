package bridge;

import bridge.controller.GameController;
import bridge.view.Input;
import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        BridgeRandomNumberGenerator bridgeGenerator = new BridgeRandomNumberGenerator();
        Input inputView = InputView.getInstance();
        GameController controller = GameController.of(inputView, bridgeGenerator);
        controller.run();
    }
}
