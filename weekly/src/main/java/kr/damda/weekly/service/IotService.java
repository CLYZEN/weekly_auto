package kr.damda.weekly.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import kr.damda.weekly.entity.IotDevice;

public interface IotService {

    List<IotDevice> getCountByDeviceId(String deviceId, Date start, Date end);

}
