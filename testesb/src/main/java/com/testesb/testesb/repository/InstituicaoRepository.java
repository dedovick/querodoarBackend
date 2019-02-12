package com.testesb.testesb.repository;

import com.testesb.testesb.model.Instituicao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends CrudRepository<Instituicao, Long> {

}
