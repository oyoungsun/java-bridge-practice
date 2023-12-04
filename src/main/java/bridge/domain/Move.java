package bridge.domain;

import java.util.Arrays;

public enum Move {
    UP("U", 1),
    DOWN("D", 0);
    private final String move;
    private final int moveInt;

    private Move(final String move, final int moveInt) {
        this.move = move;
        this.moveInt = moveInt;
    }

    public static Move findByString(final String string) {
        return Arrays.stream(Move.values()).filter(move -> move.move.equals(string)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s 또는 %s로 입력해 주세요", "U", "D")));
    }

    public static Move findByInteger(final Integer moveInt) {
        return Arrays.stream(Move.values()).filter(move -> move.moveInt == moveInt).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%d 또는 %d로 생성 가능합니다", 0, 1)));
    }
}
