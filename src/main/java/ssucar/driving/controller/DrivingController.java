package ssucar.driving.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.entity.Report;
import ssucar.driving.entity.Risk;
import ssucar.driving.entity.Summary;
import ssucar.driving.service.DrivingService;
import ssucar.dto.SingleResponseDto;
import ssucar.utils.UriCreator;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080", "http://ssu-car.s3-website.ap-northeast-2.amazonaws.com" }, allowCredentials = "true")
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

                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                // 이때마다 열려있는 SSE로 프론트엔드에 type, createdAt 보내기
                Risk postRisk = drivingService.createRisk(scenarioType, createdAt);
                Summary postSummary = drivingService.updateSummary(scenarioType);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/start")
    public ResponseEntity<?> postStartDriving(){
        //SSE 통신 열어주기
        return new ResponseEntity<>(drivingService.startDriving(), HttpStatus.CREATED);
    }

    @PatchMapping("/end")
    public ResponseEntity<?> patchEndDriving(){
        //SSE 통신 닫아주기
        return new ResponseEntity<>(drivingService.endDriving(), HttpStatus.OK);
    }

    @GetMapping("/end/{report-id}")
    public ResponseEntity<?> getReport(@PathVariable("report-id") Integer reportId) {

        return new ResponseEntity<>(drivingService.getReport(reportId), HttpStatus.OK);
    }




    //SSE
    @GetMapping("/driving/events")
    public void postEmbedded(@RequestBody HashMap<String, Object> requestJsonHashMap) {
        // SseEmitter 객체 생성
        SseEmitter emitter = new SseEmitter();

        // DrivingService의 embedded 메서드 호출하여 값을 받음
        Map<String, Object> eventData = drivingService.sendEmbedded(requestJsonHashMap, emitter);

        // 받은 값으로 SSE 이벤트 생성 및 전송
        if (eventData != null) {
            ServerSentEvent<Map<String, Object>> event = ServerSentEvent.<Map<String, Object>>builder()
                    .id(String.valueOf(System.currentTimeMillis()))
                    .event("riskCreated")
                    .data(eventData)
                    .build();
            // SSE 이벤트 전송
            drivingService.sendSSEEvent(event, emitter);
        }
    }

}
