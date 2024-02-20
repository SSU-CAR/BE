package ssucar.history.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssucar.driving.service.DrivingService;
import ssucar.history.service.HistoryService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080", "http://ssu-car.s3-website.ap-northeast-2.amazonaws.com" }, allowCredentials = "true")
@RestController
@RequestMapping("/history")
public class HistoryController {
    private final static String HISTORY_DEFAULT_URL = "/driving";
    @Autowired
    private HistoryService historyService;

    @GetMapping
    public ResponseEntity<?> getHistories() {
        return new ResponseEntity<>(historyService.findHistories(), HttpStatus.OK);
    }

    @GetMapping("/{report-id}")
    public ResponseEntity<?> getHistory(@PathVariable("report-id") Integer reportId) {
        return new ResponseEntity<>(historyService.findHistory(reportId), HttpStatus.OK);
    }


}
