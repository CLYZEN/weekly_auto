package kr.damda.weekly.repository;


import kr.damda.weekly.entity.IotDeviceResourceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IotDeviceResourceHistoryRepository extends JpaRepository<IotDeviceResourceHistory,Long> {

}
