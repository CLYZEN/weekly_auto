package kr.damda.weekly.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SingleRequestDto {

    private String deviceId;

    private String startDate;

    private String endDate;

    private Integer connStatus;
}
