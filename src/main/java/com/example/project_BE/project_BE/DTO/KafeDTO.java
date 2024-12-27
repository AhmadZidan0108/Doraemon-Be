package com.example.project_BE.project_BE.DTO;

public class KafeDTO {
    private Long id;
    private Long idAdmin;
    private String namaMinuman;
    private Double hargaMinuman;
    private String deskripsiMinuman;

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
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
}
