package kr.damda.weekly.service;

import java.util.Date;
import kr.damda.weekly.repository.IotDeviceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IotServiceImpl implements IotService {

    private final IotDeviceRepository iotDeviceRepository;

    @Override
    public Integer getCountByDeviceId(String deviceId, Date start, Date end) {

        return iotDeviceRepository.countByDeviceIdContainingAndCreateTimeBetween(deviceId, start,
            end);
    }
}
