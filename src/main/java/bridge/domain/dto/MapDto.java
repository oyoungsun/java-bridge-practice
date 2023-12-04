package bridge.domain.dto;

import bridge.domain.Bridge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapDto {
    private final List<Result> results;
    private MapDto(final int userSize, final boolean isSuccess) {
        results = new ArrayList<>();
        for(int i=0; i<userSize; i++){
            results.add(Result.SUCCESS);
        }
        if(!isSuccess){
            results.add(Result.FAIL);
        }
    }

    public static MapDto fromEntity(final int userSize, final boolean isSuccess) {
        return new MapDto(userSize, isSuccess);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(this.results);
    }
}
