package ssucar.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssucar.driving.service.DrivingService;
import ssucar.home.service.HomeService;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "http://ssu-car.s3-website.ap-northeast-2.amazonaws.com"}, allowCredentials = "true")
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/score")
    public ResponseEntity<?> getScore() {

        return new ResponseEntity<>(homeService.getLatestScore(), HttpStatus.OK);
    }
}
