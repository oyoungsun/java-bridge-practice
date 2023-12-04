package bridge.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView implements Input {
    private static final InputView inputView = new InputView();
    private static final Pattern NUMBER = Pattern.compile("^[0-9]*$");
    private static final Pattern GAME_COMMAND = Pattern.compile("[RQ]");
    private static final Pattern MOVING_COMMAND = Pattern.compile("[UD]");
    private static final String ONLY_NUMBER = "숫자만 입력해주세요";
    private static final String NULL_INPUT = "입력이 비어있습니다.";
    private static final String INTEGER_BOUNDARY = "정수의 범위를 벗어났습니다. ";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String BRIDGE_BOUNDARY = String.format("다리 길이는 %d부터 %d까지 가능합니다.", MIN_BRIDGE_SIZE,
            MAX_BRIDGE_SIZE);
    private static final String NOT_MOVE_PATTERN = String.format("%s 또는 %s로 입력해 주세요", "U", "D");
    private static final String NOT_GAME_PATTERN = String.format("%s 또는 %s로 입력해 주세요", "R", "Q");

    public static Input getInstance() {
        return new ProxyInputView(inputView);
    }

    @Override
    public int readBridgeSize() {
        int input = readInt();
        if (MIN_BRIDGE_SIZE <= input && input <= MAX_BRIDGE_SIZE) {
            return input;
        }
        throw new IllegalArgumentException(BRIDGE_BOUNDARY);
    }

    @Override
    public String readMoving() {
        String input = readCharactor();
        if (MOVING_COMMAND.matcher(input).matches()) {
            return input;
        }
        throw new IllegalArgumentException(NOT_MOVE_PATTERN);
    }

    @Override
    public String readGameCommand() {
        String input = readCharactor();
        if (GAME_COMMAND.matcher(input).matches()) {
            return input;
        }
        throw new IllegalArgumentException(NOT_GAME_PATTERN);
    }

    private String readCharactor() {
        String input = Console.readLine();
        if (input.isEmpty() || input.trim().length() == 0) {
            throw new IllegalArgumentException(NULL_INPUT);
        }
        if (input.length() != 1) {
            throw new IllegalArgumentException("한 글자만 입력해주세요.");
        }
        return input;
    }
    private String readString() {
        String input = Console.readLine();
        if (input.isEmpty() || input.trim().length() == 0) {
            throw new IllegalArgumentException(NULL_INPUT);
        }
        return input;
    }

    private int readInt() {
        String input = readString();
        Matcher matcher = NUMBER.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_BOUNDARY);
        }
        return Integer.parseInt(input);
    }

}
