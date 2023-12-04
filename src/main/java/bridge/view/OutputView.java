package bridge.view;

import bridge.domain.dto.MapDto;
import bridge.domain.dto.OutcomDto;
import bridge.domain.dto.Result;
import java.util.ArrayList;
import java.util.List;

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
        List<String> results = printMapOne(mapDto.getUpResult());
        System.out.print(String.join(Map.DELIMITER, results));
        System.out.println(Map.SUFFIX);

        System.out.print(Map.PREFIX);
        results = printMapOne(mapDto.getDownResult());
        System.out.print(String.join(Map.DELIMITER, results));
        System.out.println(Map.SUFFIX);
        printEmpty();
    }

    private static List<String> printMapOne(final List<Result> given) {
        List<String> results = new ArrayList<>();
        for (Result result : given) {
            if (result == Result.SUCCESS) {
                results.add(Map.SUCCESS);
                continue;
            }
            if (result == Result.FAIL) {
                results.add(Map.FAIL);
                continue;
            }
            results.add(Map.NOTHING);
        }
        return results;
    }


    public static void printFinalMap(final OutcomDto outcomDto) {
        System.out.println(OutMessage.FINAL.getPrint());
        printMap(outcomDto.getMap());
        if (outcomDto.isSuccess()) {
            printResult(GameResult.SUCCESS, outcomDto.getTryCount());
            printEmpty();
            return;
        }
        printResult(GameResult.FAIL, outcomDto.getTryCount());
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
        public static final String NOTHING = "   ";
        private static final String SUCCESS = " O ";
        private static final String FAIL = " X ";
        private static final String DELIMITER = "|";
        private static final String PREFIX = "[";
        private static final String SUFFIX = "]";
    }

    class GameResult {
        public static final String SUCCESS = "성공";
        public static final String FAIL = "실패";
    }
}
