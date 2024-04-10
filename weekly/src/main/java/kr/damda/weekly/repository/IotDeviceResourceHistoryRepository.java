package kr.damda.weekly.repository;

import kr.damda.weekly.dto.response.ResourceHistoryAvgDto;
import kr.damda.weekly.entity.IotDeviceResourceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IotDeviceResourceHistoryRepository extends JpaRepository<IotDeviceResourceHistory,Long> {

    List<ResourceHistoryAvgDto> findByDeviceIdContainsAndCreateTimeBetween(String deviceId, Date start, Date end);
}
