package com.DatNguyen.EngRisk.Repository;

import com.DatNguyen.EngRisk.Entity.Vocab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DataRepo extends JpaRepository<Vocab, Long> {
}
