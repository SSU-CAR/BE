package ssucar.badge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssucar.badge.service.BadgeService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080", "http://ssu-car.s3-website.ap-northeast-2.amazonaws.com" }, allowCredentials = "true")
@RestController
@RequestMapping("/badge")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @GetMapping
    public ResponseEntity<?> getBadges() {
        return new ResponseEntity<>(badgeService.getBadges(), HttpStatus.OK);
    }
}
