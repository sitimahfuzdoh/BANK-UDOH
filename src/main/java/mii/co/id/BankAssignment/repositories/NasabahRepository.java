/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.BankAssignment.repositories;

import java.util.List;
import mii.co.id.BankAssignment.models.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository 
public interface NasabahRepository extends JpaRepository<Nasabah, Long> {
    
    @Query(value = "SELECT * FROM nasabah WHERE nomor_ktp = :noKtp", nativeQuery = true)
    public Nasabah findByKtp(@Param("noKtp") String noKtp);
    
}
