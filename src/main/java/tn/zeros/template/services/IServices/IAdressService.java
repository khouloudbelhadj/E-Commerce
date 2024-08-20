package tn.zeros.template.services.IServices;

import tn.zeros.template.entities.Adress;

import java.util.List;

public interface IAdressService {
    Adress addAdress (Adress adress);

    public void removeAdress(Long id);
    public List<Adress> retrieveAllAdresses();
    public Adress retrieveAdress(Long id);

    public Adress modifyAdress(Adress adress);
}
