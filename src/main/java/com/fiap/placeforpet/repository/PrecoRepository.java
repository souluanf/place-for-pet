package com.fiap.placeforpet.repository;

import com.fiap.placeforpet.domain.entity.Preco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, Long> {
}
