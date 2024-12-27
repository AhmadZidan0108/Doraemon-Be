package com.example.project_BE.project_BE.impl;


import com.example.project_BE.project_BE.DTO.KafeDTO;
import com.example.project_BE.project_BE.exception.NotFoundException;
import com.example.project_BE.project_BE.model.Admin;
import com.example.project_BE.project_BE.model.Kafe;
import com.example.project_BE.project_BE.repository.AdminRepository;
import com.example.project_BE.project_BE.repository.KafeRepository;
import com.example.project_BE.project_BE.service.KafeService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class KafeImpl implements KafeService {

    private final KafeRepository kafeRepository;
    private final AdminRepository adminRepository;

    public KafeImpl(KafeRepository kafeRepository, AdminRepository adminRepository) {
        this.kafeRepository = kafeRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Kafe> getAllKafe() {
        return kafeRepository.findAll();
    }

    @Override
    public List<Kafe> getAllByAdmin(Long idAdmin) {
        return kafeRepository.findByAdminId(idAdmin);
    }

    @Override
    public Optional<Kafe> getKafeById(Long id) {
        return kafeRepository.findById(id);
    }

    @Override
    public KafeDTO tambahKafeDTO(Long idAdmin, KafeDTO kafeDTO) {
        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new NotFoundException("Admin dengan ID " + idAdmin + " tidak ditemukan"));

        Kafe kafe = new Kafe();
        kafe.setAdmin(admin);
        kafe.setNamaMinuman(kafeDTO.getNamaMinuman());
        kafe.setHargaMinuman(kafeDTO.getHargaMinuman());
        kafe.setDeskripsiMinuman(kafeDTO.getDeskripsiMinuman());

        Kafe savedKafe = kafeRepository.save(kafe);

        KafeDTO result = new KafeDTO();
        result.setId(savedKafe.getId());
        result.setIdAdmin(admin.getId());
        result.setNamaMinuman(savedKafe.getNamaMinuman());
        result.setHargaMinuman(savedKafe.getHargaMinuman());
        result.setDeskripsiMinuman(savedKafe.getDeskripsiMinuman());

        return result;
    }

    @Override
    public KafeDTO editKafeDTO(Long id, Long idAdmin, KafeDTO kafeDTO) throws IOException {
        Kafe existingKafe = kafeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Minuman tidak ditemukan"));

        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new NotFoundException("Admin dengan ID " + idAdmin + " tidak ditemukan"));

        existingKafe.setAdmin(admin);
        existingKafe.setNamaMinuman(kafeDTO.getNamaMinuman());
        existingKafe.setHargaMinuman(kafeDTO.getHargaMinuman());
        existingKafe.setDeskripsiMinuman(kafeDTO.getDeskripsiMinuman());

        Kafe updatedKafe = kafeRepository.save(existingKafe);

        KafeDTO result = new KafeDTO();
        result.setId(updatedKafe.getId());
        result.setIdAdmin(admin.getId());
        result.setNamaMinuman(updatedKafe.getNamaMinuman());
        result.setHargaMinuman(updatedKafe.getHargaMinuman());
        result.setDeskripsiMinuman(updatedKafe.getDeskripsiMinuman());

        return result;
    }

    @Override
    public void deleteKafe(Long id) throws IOException {
        kafeRepository.deleteById(id);
    }

}