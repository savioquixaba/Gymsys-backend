package Quixaba.dev.Gymsys.Services;


import Quixaba.dev.Gymsys.DTO.PlanoDTO;
import Quixaba.dev.Gymsys.Mapper.PlanoMapper;
import Quixaba.dev.Gymsys.Models.PlanoModel;
import Quixaba.dev.Gymsys.Repository.ContratacaoRepository;
import Quixaba.dev.Gymsys.Repository.PlanoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PlanoService {

    private PlanoMapper planoMapper;
    private PlanoRepository planoRepository;
    private ContratacaoRepository contratacaoRepository;

    public PlanoService(PlanoMapper planoMapper, PlanoRepository planoRepository, ContratacaoRepository contratacaoRepository) {
        this.planoMapper = planoMapper;
        this.planoRepository = planoRepository;
        this.contratacaoRepository = contratacaoRepository;
    }

    public PlanoDTO criarPlano(PlanoDTO planoDTO){
        PlanoModel plano = planoMapper.mapToModel(planoDTO);
        PlanoModel salvo = planoRepository.save(plano);
        return planoMapper.mapToDto(salvo);
    }

    public List<PlanoDTO> listarTodos(){
        List<PlanoModel> listar = planoRepository.findAll();
        return listar.stream()
                .map(plano -> planoMapper.mapToDto(plano))
                .collect(Collectors.toList());
    }

}
