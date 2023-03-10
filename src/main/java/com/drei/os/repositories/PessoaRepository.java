package com.drei.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.drei.os.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

    @Query(value = "SELECT * FROM TB_PESSOA as p WHERE p.cpf = :cpf", 
                            nativeQuery = true)
    Pessoa findByCPF(@Param("cpf") String cpf);
    
}
