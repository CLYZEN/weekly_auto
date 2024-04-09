package kr.damda.weekly.service;

import java.util.Date;
import java.util.List;
import kr.damda.weekly.entity.IotDevice;
import kr.damda.weekly.repository.IotDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IotServiceImpl implements IotService {

    private final IotDeviceRepository iotDeviceRepository;

    @Autowired
    public IotServiceImpl(IotDeviceRepository iotDeviceRepository) {
        this.iotDeviceRepository = iotDeviceRepository;
    }

    @Override
    public List<IotDevice> getCountByDeviceId(String deviceId, Date start, Date end) {

        return iotDeviceRepository.findByDeviceIdContainingAndCreateTimeBetween(deviceId, start,
            end);
    }
}
