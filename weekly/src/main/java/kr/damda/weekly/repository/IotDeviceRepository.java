package kr.damda.weekly.repository;

import java.util.Date;
import kr.damda.weekly.entity.IotDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IotDeviceRepository extends JpaRepository<IotDevice,Long> {
    Integer countByDeviceIdContainingAndCreateTimeBetween(String deviceId, Date start, Date end);
}