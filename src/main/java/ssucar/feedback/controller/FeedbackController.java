package ssucar.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssucar.feedback.service.FeedbackService;
import ssucar.history.service.HistoryService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080", "http://ssu-car.s3-website.ap-northeast-2.amazonaws.com" }, allowCredentials = "true")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

//    @GetMapping("/bio")
//    public ResponseEntity<?> getFeedbackBio() {
//        return new ResponseEntity<>(feedbackService.makeBio(), HttpStatus.OK);
//    }


}
