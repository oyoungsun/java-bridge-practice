package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");
    private final String command;

    private GameCommand(final String command) {
        this.command = command;
    }

    public static GameCommand findByString(final String string) {
        return Arrays.stream(GameCommand.values()).filter(command -> command.command.equals(string)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s 또는 %s로 입력해 주세요", "R", "Q")));
    }

}
