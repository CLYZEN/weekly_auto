package kr.damda.weekly.repository;

import java.time.LocalDate;
import java.util.Date;

import java.util.List;
import kr.damda.weekly.entity.IotDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IotDeviceRepository extends JpaRepository<IotDevice,Long> {
    List<IotDevice> findByDeviceIdContainingAndCreateTimeBetween(String deviceId, Date start, Date end);
}
