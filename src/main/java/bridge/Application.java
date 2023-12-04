package bridge;

import bridge.domain.BridgeMaker;
import bridge.service.BridgeGame;
import bridge.controller.GameController;
import bridge.view.Input;
import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        BeanFactory factory = new BeanFactory();
        GameController controller = factory.getController();
        controller.run();
    }
}
