package kr.damda.weekly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IotController {

    @GetMapping("/iot/device/count")
    public String getIotDeviceCount() {

    }

}
