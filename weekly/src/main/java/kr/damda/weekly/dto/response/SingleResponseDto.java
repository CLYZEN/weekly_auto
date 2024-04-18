package kr.damda.weekly.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SingleResponseDto {

    private Integer nowDeviceCount;

    private Integer connectDeviceCount;

    private Integer validateDeviceCount;

    private double dataVolume;
}
