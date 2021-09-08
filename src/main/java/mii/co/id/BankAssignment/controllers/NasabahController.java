/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.BankAssignment.controllers;

import java.util.List;
import mii.co.id.BankAssignment.models.Nasabah;
import mii.co.id.BankAssignment.services.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/nasabah")
public class NasabahController {
    
    private NasabahService nasabahService;

    @Autowired
    public NasabahController(NasabahService nasabahService) {
        this.nasabahService = nasabahService;
    }
    
    @GetMapping
    public ResponseEntity<List<Nasabah>> getAll(){
        
        return new ResponseEntity(nasabahService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Nasabah> getById(@PathVariable ("id") Long id){
        
        return new ResponseEntity(nasabahService.getById(id), HttpStatus.OK);
    }
    
    @GetMapping("/no-ktp/{noKtp}")
    public ResponseEntity<Nasabah> getByKtp(@PathVariable("noKtp") String noKtp){
        
        return new ResponseEntity(nasabahService.getNasabahByKtp(noKtp),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Nasabah> create (@RequestBody Nasabah nasabah){
        
        return new ResponseEntity(nasabahService.create(nasabah), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Nasabah> update (
            @PathVariable ("id") Long id, @RequestBody Nasabah nasabah){
        
        return new ResponseEntity(nasabahService.update(id, nasabah),HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Nasabah> delete (@PathVariable ("id") Long id){
        
        return new ResponseEntity(nasabahService.delete(id),HttpStatus.OK);
    }
    
   
}
