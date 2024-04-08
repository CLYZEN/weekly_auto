package kr.damda.weekly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "iot_device")
@Getter
@Setter
@ToString
public class IotDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DEVICE_ID", nullable = false)
    private String deviceId;

    @Column(name = "SUBS_NO", nullable = false)
    private String subsNo;

    @Column(name = "PARENT_ID")
    private String parentId;

    @Column(name = "CONN_STATUS", nullable = false)
    private Integer connStatus;

    @Column(name = "DEVICE_MODEL_ID", nullable = false)
    private Long deviceModelId;

    @Column(name = "MANUFACTURER", nullable = false)
    private String manufacturer;

    @Column(name = "MODEL_NAME", nullable = false)
    private String modelName;

    @Column(name = "DATA_FORMAT", nullable = false)
    private String dataFormat;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "LORA_API_KEY")
    private String loraApiKey;

    @Column(name = "REGISTER_TIME")
    private Date registerTime;

    @Column(name = "CREATE_TIME", nullable = false)
    private Date createTime;

    @Column(name = "UPDATE_TIME", nullable = false)
    private Date updateTime;

    @Column(name = "MANUFACTURER_ID")
    private String manufacturerId;
}
