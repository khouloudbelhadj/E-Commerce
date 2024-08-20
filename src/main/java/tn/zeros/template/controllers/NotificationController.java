package tn.zeros.template.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.zeros.template.entities.Notification;
import tn.zeros.template.services.IServices.INotificationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class NotificationController {
    private final INotificationService notificationService;
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Notification notification){
        return ResponseEntity.ok().body(notificationService.addNotification(notification));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        notificationService.removeNotification(id);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modify(@RequestBody Notification notification){
        return ResponseEntity.ok().body(notificationService.modifyNotification(notification));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(notificationService.retrieveAllNotifications());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(notificationService.retrieveNotification(id));

    }
}
