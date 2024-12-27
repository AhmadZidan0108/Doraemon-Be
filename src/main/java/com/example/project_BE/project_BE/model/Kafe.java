package com.example.project_BE.project_BE.model;

import javax.persistence.*;

@Entity
@Table(name = "kafe")
public class Kafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_minuman")
    private String namaMinuman;

    @Column(name = "harga_minuman")
    private Double hargaMinuman;

    @Column(name = "deskripsi_minuman")
    private String deskripsiMinuman;

    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = false)
    private Admin admin;

    public Kafe(Long id, Admin admin, String namaMinuman, Double hargaMinuman, String deskripsiMinuman) {
        this.id = id;
        this.admin = admin;
        this.namaMinuman = namaMinuman;
        this.hargaMinuman = hargaMinuman;
        this.deskripsiMinuman = deskripsiMinuman;
    }

    public Kafe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaMinuman() {
        return namaMinuman;
    }

    public void setNamaMinuman(String namaMinuman) {
        this.namaMinuman = namaMinuman;
    }

    public Double getHargaMinuman() {
        return hargaMinuman;
    }

    public void setHargaMinuman(Double hargaMinuman) {
        this.hargaMinuman = hargaMinuman;
    }

    public String getDeskripsiMinuman() {
        return deskripsiMinuman;
    }

    public void setDeskripsiMinuman(String deskripsiMinuman) {
        this.deskripsiMinuman = deskripsiMinuman;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
