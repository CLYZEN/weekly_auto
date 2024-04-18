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
        singleResponseDto.setConnectDeviceCount(iotDeviceRepository.countByDeviceIdContainsAndConnStatus(deviceId,1));
        singleResponseDto.setValidateDeviceCount(iotDeviceRepository.countByDeviceIdContainingAndCreateTimeBetween(deviceId,start,end));
        singleResponseDto.setDataVolume(avgResourceHistory(deviceId,start,end));

        return singleResponseDto;
    }

    @Override
    public Integer getCountByDeviceIdAndConnStatus(String deviceId,Integer connStatus, Date start, Date end) {
        return iotDeviceRepository.countByDeviceIdContainsAndCreateTimeBetweenAndConnStatus(deviceId,start,end,connStatus);
    }

    private double avgResourceHistory(String deviceId, Date start, Date end) {
        List<ResourceHistoryAvgDto> resourceHistoryAvgDtoList = iotDeviceResourceHistoryRepository.findTop100ByDeviceIdStartingWithAndCreateTimeBetween(deviceId,start,end);
        Integer count = iotDeviceResourceHistoryRepository.countByDeviceIdStartingWithAndCreateTimeBetween(deviceId,start,end);

        double length = 0;

        for (ResourceHistoryAvgDto resourceHistoryAvgDto : resourceHistoryAvgDtoList) {
            length += resourceHistoryAvgDto.getResource().getBytes().length;
        }
        return ((double)length/100)*((double)count/1024)/1024;
    }
}
