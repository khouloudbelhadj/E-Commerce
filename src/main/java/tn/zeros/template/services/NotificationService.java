package tn.zeros.template.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.zeros.template.entities.Notification;
import tn.zeros.template.repositories.NotificationRepository;
import tn.zeros.template.services.IServices.INotificationService;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class NotificationService implements INotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void removeNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<Notification> retrieveAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification retrieveNotification(Long id) {
        return notificationRepository.findById(id).get();
    }

    @Override
    public Notification modifyNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
}
