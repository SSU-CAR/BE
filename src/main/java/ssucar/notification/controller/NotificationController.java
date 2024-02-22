package ssucar.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ssucar.notification.service.NotificationService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080", "http://ssu-car.s3-website.ap-northeast-2.amazonaws.com" }, allowCredentials = "true")
@RestController
@RequestMapping("/driving/events")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe() {
        System.out.println("sse get!!!");
        Long id = 1L;
        return notificationService.subscribe(id);
    }

//    @PostMapping("/send-data/{id}")
//    public void sendData(@PathVariable Long id) {
//        notificationService.notify(id, "data");
//    }
}
