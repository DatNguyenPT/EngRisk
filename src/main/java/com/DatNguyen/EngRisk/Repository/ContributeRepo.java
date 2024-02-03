package com.DatNguyen.EngRisk.Repository;

import com.DatNguyen.EngRisk.Entity.DTO.WordContributionDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributeRepo extends JpaRepository<WordContributionDTO, Long> {
}
