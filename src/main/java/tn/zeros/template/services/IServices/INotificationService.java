package tn.zeros.template.services.IServices;

import tn.zeros.template.entities.Notification;

import java.util.List;

public interface INotificationService {
    Notification addNotification (Notification notification);

    public void removeNotification(Long id);
    public List<Notification> retrieveAllNotifications();
    public Notification retrieveNotification(Long id);

    public Notification modifyNotification(Notification notification);
}
