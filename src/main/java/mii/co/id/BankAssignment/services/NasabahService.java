/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.BankAssignment.services;

import java.util.List;
import mii.co.id.BankAssignment.models.Nasabah;
import mii.co.id.BankAssignment.repositories.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author user
 */
@Service
public class NasabahService {

    private NasabahRepository nasabahRepository;

    @Autowired
    public NasabahService(NasabahRepository nasabahRepository) {
        this.nasabahRepository = nasabahRepository;
    }

    public List<Nasabah> getAll() {

        return nasabahRepository.findAll();
    }

    public Nasabah getById(Long id) {

        return nasabahRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Data Not Found"));
    }
    
    public Nasabah getNasabahByKtp(String noKtp){
        
        return nasabahRepository.findByKtp(noKtp);
    }
    
    public Nasabah create (Nasabah nasabah){
        
        if (nasabah.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT," Data Already Exist");
        }
        
        return nasabahRepository.save(nasabah);
    }
    public Nasabah update (Long id, Nasabah nasabah){
        
        getById(id);
        nasabah.setId(id);
        
        return nasabahRepository.save(nasabah);
        
    }
    
    public Nasabah delete (Long id){
        
        Nasabah nasabahdelete = getById(id);
        
        nasabahRepository.deleteById(id);
        
        return nasabahdelete;
    }
}
