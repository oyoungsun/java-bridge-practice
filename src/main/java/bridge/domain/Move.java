package bridge.domain;

import java.util.Arrays;

public enum Move {
    UP("U", 1),
    DOWN("D", 0);
    private final String moveName;
    private final int moveInt;

    private Move(final String moveName, final int moveInt) {
        this.moveName = moveName;
        this.moveInt = moveInt;
    }

    public static Move findByMoveName(final String string) {
        return Arrays.stream(Move.values()).filter(move -> move.moveName.equals(string)).findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("%s 또는 %s로 입력해 주세요", "U", "D")));
    }

    public static String findStringByMoveInt(final int moveInt) {
        return Arrays.stream(Move.values()).filter(move -> move.moveInt == moveInt).findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("%d 또는 %d로 생성 가능합니다", 0, 1)))
                .moveName;
    }

    public boolean isUp() {
        return this.equals(UP);
    }
}
