package com.testesb.testesb.service;

import java.util.List;

import com.testesb.testesb.model.Instituicao;
import com.testesb.testesb.repository.InstituicaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoService implements IInstituicaoService {

    @Autowired
    private InstituicaoRepository repository;

    @Override
    public List<Instituicao> findAll() {

        List<Instituicao> cities = (List<Instituicao>) repository.findAll();
        
        return cities;
    }
}