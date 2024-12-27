package com.example.project_BE.project_BE.controller;


import com.example.project_BE.project_BE.DTO.KafeDTO;
import com.example.project_BE.project_BE.model.Kafe;
import com.example.project_BE.project_BE.service.KafeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class KafeController {

    private final KafeService KafeService;

    public KafeController(KafeService kafeService) {
        this.KafeService = kafeService;
    }

    @GetMapping("/kafe/all")
    public ResponseEntity<List<Kafe>> getAllKafe() {
        List<Kafe> kafeList = KafeService.getAllKafe();
        return ResponseEntity.ok(kafeList);
    }

    @GetMapping("/kafe/getAllByAdmin/{idAdmin}")
    public ResponseEntity<List<Kafe>> getAllByAdmin(@PathVariable Long idAdmin) {
        List<Kafe> kafeList = KafeService.getAllByAdmin(idAdmin);
        return ResponseEntity.ok(kafeList);
    }

    @GetMapping("/kafe/getById/{id}")
    public ResponseEntity<Kafe> getKafeById(@PathVariable Long id) {
        Optional<Kafe> kafe = KafeService.getKafeById(id);
        return kafe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/kafe/tambah/{idAdmin}")
    public ResponseEntity<KafeDTO> tambahKafeDTO(
            @PathVariable Long idAdmin,
            @RequestBody KafeDTO kafeDTO) {
        KafeDTO savedKafe = KafeService.tambahKafeDTO(idAdmin, kafeDTO);
        return ResponseEntity.ok(savedKafe);
    }

    @PutMapping(value = "/kafe/editById/{id}")
    public ResponseEntity<KafeDTO> editKafe(
            @PathVariable Long id,
            @RequestParam Long idAdmin,
            @RequestBody KafeDTO kafeDTO) throws IOException {

        // Edit kafe tanpa foto
        KafeDTO updatedKafe = KafeService.editKafeDTO(id, idAdmin, kafeDTO);
        return ResponseEntity.ok(updatedKafe);
    }

    @DeleteMapping("/kafe/delete/{id}")
    public ResponseEntity<Void> deleteKafe(@PathVariable Long id) throws IOException {
        KafeService.deleteKafe(id);
        return ResponseEntity.noContent().build();
    }
}
