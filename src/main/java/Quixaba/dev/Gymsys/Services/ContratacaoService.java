package Quixaba.dev.Gymsys.Services;

import Quixaba.dev.Gymsys.DTO.ContratacaoDTO;
import Quixaba.dev.Gymsys.Mapper.ContratacaoMapper;
import Quixaba.dev.Gymsys.Models.AlunoModel;
import Quixaba.dev.Gymsys.Models.ContratacaoModel;
import Quixaba.dev.Gymsys.Models.PlanoModel;
import Quixaba.dev.Gymsys.Repository.AlunoRepository;
import Quixaba.dev.Gymsys.Repository.ContratacaoRepository;
import Quixaba.dev.Gymsys.Repository.PlanoRepository;

public class ContratacaoService {

    private AlunoRepository alunoRepository;
    private PlanoRepository planoRepository;
    private ContratacaoRepository contratacaoRepository;
    private ContratacaoMapper contratacaoMapper;


    public ContratacaoService(ContratacaoRepository contratacaoRepository, ContratacaoMapper contratacaoMapper, AlunoRepository alunoRepository, PlanoRepository planoRepository) {
        this.contratacaoRepository = contratacaoRepository;
        this.contratacaoMapper = contratacaoMapper;
        this.alunoRepository = alunoRepository;
        this.planoRepository = planoRepository;
    }
    public ContratacaoDTO criarContratacao(ContratacaoDTO contratacaoDTO){
        AlunoModel alunoExiste = alunoRepository.findById(contratacaoDTO.getIdAluno())
                .orElseThrow(() -> new RuntimeException("Aluno não existe"));
        PlanoModel planoExiste = planoRepository.findById(contratacaoDTO.getIdPlano())
                .orElseThrow(() -> new RuntimeException("Plano não existe"));
        ContratacaoModel contratacao = contratacaoMapper.mapToModel(contratacaoDTO);
        contratacao.setPlano(planoExiste);
        contratacao.setAluno(alunoExiste);
        ContratacaoModel salvo = contratacaoRepository.save(contratacao);
        return contratacaoMapper.mapToDTO(salvo);
    }

}
