package kr.damda.weekly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "iot_device_resource_history")
@Getter
@Setter
@ToString
public class IotDeviceResourceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ")
    private Long seq;

    @Column(name = "DEVICE_ID", nullable = false)
    private String deviceId;

    @Column(name = "COMMAND", nullable = false)
    private String command;

    @Column(name = "RESOURCE", columnDefinition = "longtext")
    @Lob
    private String resource;

    @Column(name = "CREATE_TIME", nullable = false)
    private Date createTime;

    @Column(name = "UPDATE_TIME", nullable = false)
    private Date updateTime;

    // Constructors, getters, and setters
}
