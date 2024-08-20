package tn.zeros.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.zeros.template.entities.Adress;

public interface AdressRepository extends JpaRepository<Adress,Long> {
}
