package kr.damda.weekly.repository;

import kr.damda.weekly.dto.response.ResourceHistoryAvgDto;
import kr.damda.weekly.entity.IotDeviceResourceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IotDeviceResourceHistoryRepository extends JpaRepository<IotDeviceResourceHistory,Long> {

    List<ResourceHistoryAvgDto> findTop100ByDeviceIdStartingWithAndCreateTimeBetween(String deviceId, Date start, Date end);


    @Query("SELECT count(*) FROM IotDeviceResourceHistory WHERE deviceId LIKE :deviceId% AND createTime BETWEEN :start AND :end")
    Integer countByDeviceIdStartingWithAndCreateTimeBetween(@Param("deviceId") String deviceId, @Param("start") Date start, @Param("end") Date end);
}
