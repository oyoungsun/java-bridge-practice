package bridge.view;

import bridge.util.ExceptionHandler;

public class ProxyInputView implements Input {
    private final Input inputView;

    public ProxyInputView(Input inputView) {
        this.inputView = inputView;
    }

    @Override
    public int readBridgeSize() {
        return ExceptionHandler.input(inputView::readBridgeSize, 0);
    }

    @Override
    public String readMoving() {
        return null;
    }

    @Override
    public String readGameCommand() {
        return null;
    }
}
