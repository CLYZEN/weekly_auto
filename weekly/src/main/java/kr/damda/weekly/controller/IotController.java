package kr.damda.weekly.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.damda.weekly.dto.request.SingleRequestDto;
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

    @GetMapping("/api/v1/search/single")
    public String getIotDeviceCount(Model model) {
        model.addAttribute("singleRequestDto", new SingleRequestDto());
        return "single_request";
    }

    @PostMapping("/api/v1/search/single")
    public String getIotDeviceCount(SingleRequestDto singleRequestDto, Model model)
        throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date start = formatter.parse(singleRequestDto.getStartDate());
        Date end = formatter.parse(singleRequestDto.getEndDate());

        model.addAttribute("singleResponseDto", iotService.getSingleDeviceInfo(singleRequestDto.getDeviceId(), start,end));

        return "single_result";
    }

    @GetMapping("/api/v1/search/single/connect")
    public String getIotDeviceCountForConnStatus(Model model) {
        model.addAttribute("connRequestDto", new SingleRequestDto());
        return "conn_request";
    }

    @PostMapping("/api/v1/search/single/connect")
    public String getIotDeviceCountForConnStatus(SingleRequestDto connRequestDto, Model model) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date start = formatter.parse(connRequestDto.getStartDate());
        Date end = formatter.parse(connRequestDto.getEndDate());

        model.addAttribute("count",iotService.getCountByDeviceIdAndConnStatus(connRequestDto.getDeviceId(),connRequestDto.getConnStatus(),start,end));
        return "single_result";
    }


}
