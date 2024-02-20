package ssucar.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssucar.feedback.service.FeedbackService;
import ssucar.history.service.HistoryService;

import java.util.HashMap;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080", "http://ssu-car.s3-website.ap-northeast-2.amazonaws.com" }, allowCredentials = "true")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;


    @GetMapping("/bio")
    public ResponseEntity<?> getFeedbackBio(@RequestBody HashMap<String, Object> requestJsonHashMap) {
        int thisMonth = (int) requestJsonHashMap.get("thisMonth");
        return new ResponseEntity<>(feedbackService.makeBio(thisMonth), HttpStatus.OK);
    }

    @GetMapping("/score")
    public ResponseEntity<?> getFeedbackAverageScore(@RequestBody HashMap<String, Object> requestJsonHashMap) {
        int thisMonth = (int) requestJsonHashMap.get("thisMonth");
        return new ResponseEntity<>(feedbackService.getAverage(thisMonth), HttpStatus.OK);
    }


}
