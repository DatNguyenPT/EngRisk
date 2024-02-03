package com.DatNguyen.EngRisk.Repository;

import com.DatNguyen.EngRisk.Entity.DTO.VocabDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepo extends JpaRepository<VocabDTO, Long> {
}
