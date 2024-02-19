package ssucar.driving.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.entity.Report;
import ssucar.driving.entity.Risk;
import ssucar.driving.service.DrivingService;
import ssucar.dto.SingleResponseDto;
import ssucar.utils.UriCreator;

import java.net.URI;
import java.util.HashMap;


@RestController
@RequestMapping("/driving")
public class DrivingController {
    private final static String DRIVING_DEFAULT_URL = "/driving";

    @Autowired
    private DrivingService drivingService;

    @PostMapping("/embedded")
    public ResponseEntity embedded(@RequestBody HashMap<String, Object> requestJsonHashMap) {

        int scenarioType = (int) requestJsonHashMap.get("type");
        String createdAt = (String) requestJsonHashMap.get("createdAt");
        System.out.println("type: " + scenarioType);
        System.out.println("createdAt: " + createdAt);

        boolean isDriving = drivingService.isDriving();
        if(isDriving){
            if(scenarioType == 100){
                drivingService.updateMileage(scenarioType, createdAt);
                return new ResponseEntity<>(HttpStatus.OK);
            } else if (scenarioType == 200){
                // 속도 값 들어오는거 처리

                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                Risk postRisk = drivingService.createRisk(scenarioType, createdAt);
//            URI location = UriCreator.createUri(DRIVING_DEFAULT_URL, (long) postRisk.getRiskId());
                return new ResponseEntity<>(HttpStatus.OK);
//            return ResponseEntity.created(location).build();
            }


        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/start")
    public ResponseEntity<?> postStartDriving(){

        return new ResponseEntity<>(drivingService.startDriving(), HttpStatus.CREATED);
    }

    @PatchMapping("/end")
    public ResponseEntity<?> postEndDriving(){

        return new ResponseEntity<>(drivingService.endDriving(), HttpStatus.OK);
    }

}
