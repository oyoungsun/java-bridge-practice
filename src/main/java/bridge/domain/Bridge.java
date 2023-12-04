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


    public boolean move(final Bridge bridge, final Move move) {
        if(isMoveable(bridge, move)){
            this.bridge.add(move);
            return true;
        }
        return false;
    }

    private boolean isMoveable(final Bridge bridge, final Move move) {
        int depth = this.bridge.size();
        if(bridge.isSame(depth, move)){
            return true;
        }
        return false;
    }

    private boolean isSame(final int depth, final Move move) {
        return bridge.get(depth).equals(move);
    }

    public boolean isSameSize(final Bridge bridge) {
        return this.bridge.size() == bridge.bridge.size();
    }

    public int getSize() {
        return bridge.size();
    }

    public boolean isUp(final int i) {
        return bridge.get(i).isUp();
    }
}
