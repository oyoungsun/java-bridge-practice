package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<Move> bridge;

    private Bridge(final List<Move> bridge) {
        this.bridge = bridge;
    }

    public static Bridge from(final List<Move> bridge) {
        return new Bridge(bridge);
    }
}
