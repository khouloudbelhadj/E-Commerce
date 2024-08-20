package tn.zeros.template.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.zeros.template.entities.Adress;
import tn.zeros.template.repositories.AdressRepository;
import tn.zeros.template.services.IServices.IAdressService;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class AdressService implements IAdressService {
    private final AdressRepository adressRepository ;
    @Override
    public Adress addAdress(Adress adress) {
        return adressRepository.save(adress);
    }

    @Override
    public void removeAdress(Long id) {
        adressRepository.deleteById(id);
    }

    @Override
    public List<Adress> retrieveAllAdresses() {
        return adressRepository.findAll();
    }

    @Override
    public Adress retrieveAdress(Long id) {
        return adressRepository.findById(id).get();
    }

    @Override
    public Adress modifyAdress(Adress adress) {
        return adressRepository.save(adress);
    }
}
