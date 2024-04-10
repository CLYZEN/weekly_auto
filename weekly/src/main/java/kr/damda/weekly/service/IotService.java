package kr.damda.weekly.service;

import kr.damda.weekly.dto.response.SingleResponseDto;

import java.util.Date;

public interface IotService {

    SingleResponseDto getSingleDeviceInfo(String deviceId, Date start, Date end);

    Integer getCountByDeviceIdAndConnStatus(String deviceId,Integer connStatus, Date start, Date end);
}
