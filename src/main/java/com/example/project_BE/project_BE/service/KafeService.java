package com.example.project_BE.project_BE.service;



import com.example.project_BE.project_BE.DTO.KafeDTO;
import com.example.project_BE.project_BE.model.Kafe;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface KafeService {

    Optional<Kafe> getKafeById(Long id);

    List<Kafe> getAllKafe();

    List<Kafe> getAllByAdmin(Long idAdmin);

    KafeDTO tambahKafeDTO(Long idAdmin, KafeDTO kafeDTO);

    KafeDTO editKafeDTO(Long id, Long idCafe, KafeDTO kafeDTO) throws IOException;

    void deleteKafe(Long id) throws IOException;
}
