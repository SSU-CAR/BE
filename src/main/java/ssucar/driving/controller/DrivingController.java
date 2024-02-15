package ssucar.driving.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.service.DrivingService;
import ssucar.dto.SingleResponseDto;

@RestController
@RequestMapping("/driving")
public class DrivingController {

    private DrivingService drivingService;


    @PostMapping("/start")
    public ResponseEntity<?> postStartDriving(){
        return ResponseEntity.ok(drivingService.startDriving());
    }

}
