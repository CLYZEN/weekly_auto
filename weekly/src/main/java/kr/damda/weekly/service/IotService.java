package kr.damda.weekly.service;

import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public interface IotService {

    Integer getCountByDeviceId(String deviceId, Date start, Date end);

}
