package com.opine.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opine.livros.domain.Comentario;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

}
