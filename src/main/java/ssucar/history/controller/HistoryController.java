package ssucar.history.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssucar.driving.service.DrivingService;
import ssucar.history.service.HistoryService;

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

}
