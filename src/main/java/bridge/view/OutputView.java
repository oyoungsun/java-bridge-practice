package bridge.view;

import bridge.domain.dto.MapDto;
import bridge.domain.dto.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printGameStart() {
        System.out.println(OutMessage.GAME_START.getPrint());
        printEmpty();
    }

    public static void printEmpty() {
        System.out.println();
    }

    public static void printRequestBridgeSize() {
        System.out.println(OutMessage.REQUEST_BRIDGE_SIZE.getPrint());
    }

    public static void printRequestMoving() {
        System.out.println(OutMessage.REQUEST_MOVING.getPrint());
    }

    public static void printRequestGameCommand() {
        System.out.println(OutMessage.REQUEST_GAME_COMMAND.getPrint());
    }

    public static void printMap(final MapDto mapDto) {
        System.out.print(Map.PREFIX);
        List<String> results = new ArrayList<>();
        for (Result result : mapDto.getResults()) {
            if (result == Result.SUCCESS) {
                results.add(Map.SUCCESS);
                continue;
            }
            results.add(Map.FAIL);
        }
        System.out.print(String.join(Map.DELIMITER, results));
        System.out.println(Map.SUFFIX);
        printEmpty();
    }

    public static void printFinalMap() {
        System.out.println(OutMessage.FINAL.getPrint());
        /**
         * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
         * <p>
         * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
         */
        printEmpty();
    }

    public static void printResult(String result, int tryCount) {
        System.out.println(String.format(OutMessage.RESULT.getPrint(), result));
        System.out.println(String.format(OutMessage.TRY_COUNT.getPrint(), tryCount));
    }

    public static void printExceptionMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }


    enum OutMessage {
        GAME_START("다리 건너기 게임을 시작합니다."),
        REQUEST_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
        REQUEST_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        REQUEST_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
        FINAL("최종 게임 결과"),
        RESULT("게임 성공 여부: %s"),
        TRY_COUNT("총 시도한 횟수: %d");

        private String print;

        private OutMessage(final String print) {
            this.print = print;
        }

        public String getPrint() {
            return print;
        }
    }

    class Map {
        private static final String SUCCESS = " O ";
        private static final String FAIL = " X ";
        private static final String DELIMITER = "|";
        private static final String PREFIX = "[";
        private static final String SUFFIX = "]";
    }
}
