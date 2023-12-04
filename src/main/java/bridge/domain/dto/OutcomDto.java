package bridge.domain.dto;

public class OutcomDto {
    private final MapDto mapDto;
    private final boolean isSuccess;
    private final int tryCount;

    private OutcomDto(final MapDto mapDto, final boolean isSuccess, final int tryCount) {
        this.mapDto = mapDto;
        this.isSuccess = isSuccess;
        this.tryCount = tryCount;
    }

    public static OutcomDto fromEntity(final MapDto mapDto, final boolean isSuccess, final int tryCount) {
        return new OutcomDto(mapDto, isSuccess, tryCount);
    }

    public MapDto getMap() {
        return this.mapDto;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public int getTryCount() {
        return this.tryCount;
    }
}
