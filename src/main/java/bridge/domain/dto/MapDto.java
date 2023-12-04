package bridge.domain.dto;

import bridge.domain.Bridge;
import bridge.domain.Move;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapDto {
    private final List<Result> up;
    private final List<Result> down;

    private MapDto(final Bridge user, final Move last, final boolean isSuccess) {
        up = new ArrayList<>();
        down = new ArrayList<>();
        for (int i = 0; i < user.getSize(); i++) {
            if (user.isUp(i)) {
                addSuccess(up, down);
                continue;
            }
            addSuccess(down, up);
        }
        if (!isSuccess) {
            addFail(last);
        }
    }

    public static MapDto fromEntity(final Bridge user, final Move last, final boolean isSuccess) {
        return new MapDto(user, last, isSuccess);
    }

    private void addFail(final Move last) {
        if (last.isUp()) {
            up.add(Result.FAIL);
            down.add(Result.NOTHING);
            return;
        }
        up.add(Result.NOTHING);
        down.add(Result.FAIL);
    }

    private void addSuccess(final List<Result> first, final List<Result> second) {
        first.add(Result.SUCCESS);
        second.add(Result.NOTHING);
    }

    public List<Result> getUpResult() {
        return Collections.unmodifiableList(this.up);
    }

    public List<Result> getDownResult() {
        return Collections.unmodifiableList(this.down);
    }
}
