package kr.damda.weekly.service;

import java.util.Date;
import java.util.List;

import kr.damda.weekly.dto.response.ResourceHistoryAvgDto;
import kr.damda.weekly.dto.response.SingleResponseDto;
import kr.damda.weekly.repository.IotDeviceRepository;
import kr.damda.weekly.repository.IotDeviceResourceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IotServiceImpl implements IotService {

    private final IotDeviceRepository iotDeviceRepository;
    private final IotDeviceResourceHistoryRepository iotDeviceResourceHistoryRepository;

    @Autowired
    public IotServiceImpl(IotDeviceRepository iotDeviceRepository,IotDeviceResourceHistoryRepository iotDeviceResourceHistoryRepository) {
        this.iotDeviceRepository = iotDeviceRepository;
        this.iotDeviceResourceHistoryRepository = iotDeviceResourceHistoryRepository;
    }

    @Override
    public SingleResponseDto getSingleDeviceInfo(String deviceId, Date start, Date end) {

        SingleResponseDto singleResponseDto = new SingleResponseDto();
        singleResponseDto.setNowDeviceCount(iotDeviceRepository.countByDeviceIdContains(deviceId));
        singleResponseDto.setConnectDeviceCount(iotDeviceRepository.countByDeviceIdContainsAndCreateTimeBetweenAndConnStatus(deviceId,start,end,1));
        singleResponseDto.setValidateDeviceCount(iotDeviceRepository.countByDeviceIdContainingAndCreateTimeBetween(deviceId,start,end));
        singleResponseDto.setDataVolume(avgResourceHistory(deviceId,start,end));

        return singleResponseDto;
    }

    @Override
    public Integer getCountByDeviceIdAndConnStatus(String deviceId,Integer connStatus, Date start, Date end) {
        return iotDeviceRepository.countByDeviceIdContainsAndCreateTimeBetweenAndConnStatus(deviceId,start,end,connStatus);
    }

    private Long avgResourceHistory(String deviceId, Date start, Date end) {
        List<ResourceHistoryAvgDto> resourceHistoryAvgDtoList = iotDeviceResourceHistoryRepository.findByDeviceIdContainsAndCreateTimeBetween(deviceId,start,end);

        long length = 0;

        for (ResourceHistoryAvgDto resourceHistoryAvgDto : resourceHistoryAvgDtoList) {
            length += resourceHistoryAvgDto.getResource().getBytes().length;
        }

        return length/1024/1024;
    }
}
