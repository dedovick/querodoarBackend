package com.testesb.testesb.controler;

import java.util.List;

import com.testesb.testesb.model.Instituicao;
import com.testesb.testesb.repository.InstituicaoRepository;
import com.testesb.testesb.service.IInstituicaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstituicaoController {
    
    @Autowired
    IInstituicaoService instituicaoService;

    @Autowired
    InstituicaoRepository instituicaoRepository;


    @CrossOrigin(origins = "/**")
    @GetMapping("/instituicoes")
    public List<Instituicao> getInstituicoes() {
        System.out.println("Passou aqui aooooooooooooooooo");
        List<Instituicao> instituicoes = (List<Instituicao>) this.instituicaoService.findAll();
        return instituicoes;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/inseririnstituicao")
    public String createInstituicao(
                @RequestParam String nome, 
                @RequestParam String endereco,
                @RequestParam String facebook,
                @RequestParam String instagram,
                @RequestParam String twitter,
                @RequestParam String website,
                @RequestParam long telefone,
                @RequestParam String url_image,
                @RequestParam String cidade,
                @RequestParam String estado) {
        
        Instituicao instituicao = new Instituicao();

        instituicao.setNome(nome);
        instituicao.setEndereco(endereco);
        instituicao.setFacebook(facebook);
        instituicao.setInstagram(instagram);
        instituicao.setTwitter(twitter);
        instituicao.setWebsite(website);
        instituicao.setTelefone(telefone);
        instituicao.setUrl_image(url_image);
        instituicao.setCidade(cidade);
        instituicao.setEstado(estado);

        instituicaoRepository.save(instituicao);

        return instituicao.getNome() + " - " + instituicao.getEndereco();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/insertInstituicao")
    public Instituicao insertInstituicao(@RequestBody Instituicao instituicao){
        System.out.println("Passou aqui caraaaaaai: " + instituicao.getTelefone());
        return instituicaoRepository.save(instituicao);
    }
}