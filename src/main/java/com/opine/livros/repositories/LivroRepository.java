package com.opine.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opine.livros.domain.Livros;

@Repository
public interface LivroRepository extends JpaRepository<Livros, Long> {

}
