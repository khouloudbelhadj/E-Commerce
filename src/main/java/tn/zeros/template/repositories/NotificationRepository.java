package tn.zeros.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.zeros.template.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository <Notification,Long>{

}
