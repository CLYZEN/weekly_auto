package kr.damda.weekly.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import kr.damda.weekly.service.IotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IotController {

    private final IotService iotService;

    @Autowired
    public IotController(IotService iotService) {
        this.iotService = iotService;
    }

    @GetMapping("/iot/device/count")
    public String getIotDeviceCount() {
        return "index";
    }

    @PostMapping("/weekly")
    public String getIotDeviceCount(String startDate, String endDate, String device, Model model)
        throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date start = formatter.parse(startDate);
        Date end = formatter.parse(endDate);

        model.addAttribute("list",iotService.getCountByDeviceId(device, start, end));
        return "result";
    }

}
