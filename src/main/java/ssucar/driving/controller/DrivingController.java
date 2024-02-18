package ssucar.driving.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.service.DrivingService;
import ssucar.dto.SingleResponseDto;

import java.util.HashMap;

@RestController
@RequestMapping("/driving")
public class DrivingController {

    @Autowired
    private DrivingService drivingService;

    @PostMapping("/embedded")
    public ResponseEntity embedded(@RequestBody HashMap<String, Object> requestJsonHashMap) {

        int type = (int) requestJsonHashMap.get("type");
        String createdAt = (String) requestJsonHashMap.get("createdAt");
        System.out.println("type: " + type);
        System.out.println("createdAt: " + createdAt);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/start")
    public ResponseEntity<?> postStartDriving(){
        return ResponseEntity.ok(drivingService.startDriving());
    }

}
