/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.BankAssignment.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Nasabah {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nama_lengkap", nullable = false, length = 50)
    private String namaLengkap;
    
    @Column(name = "alamat", nullable = false)
    private String alamat;
    
    @Column(name = "tempat_lahir", nullable = false, length = 20)
    private String tempatLahir;
    
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggalLahir;
    
    @Column(name = "nomor_ktp", nullable = false, length = 16, unique = true)
    private String noKtp;
    
    @Column(name = "nomor_handphone", nullable = false, length = 13)
    private String noHp;
    
    
    
}
