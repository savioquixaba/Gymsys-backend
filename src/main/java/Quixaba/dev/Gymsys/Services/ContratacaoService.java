package Quixaba.dev.Gymsys.Services;

import Quixaba.dev.Gymsys.DTO.ContratacaoDTO;
import Quixaba.dev.Gymsys.Mapper.ContratacaoMapper;
import Quixaba.dev.Gymsys.Models.AlunoModel;
import Quixaba.dev.Gymsys.Models.ContratacaoModel;
import Quixaba.dev.Gymsys.Models.PlanoModel;
import Quixaba.dev.Gymsys.Repository.AlunoRepository;
import Quixaba.dev.Gymsys.Repository.ContratacaoRepository;
import Quixaba.dev.Gymsys.Repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
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

    public List<ContratacaoDTO> listarContratacao(){
        List<ContratacaoModel> lista = contratacaoRepository.findAll();
        return lista.stream()
                .map(contratacao -> contratacaoMapper
                        .mapToDTO(contratacao))
                .toList();
    }

    public ContratacaoDTO listarPorId(Long id){
        ContratacaoModel existeId = contratacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("ID não encontrado"));
        return contratacaoMapper.mapToDTO(existeId);
    }

    public String deleteContratacao(Long id){
        ContratacaoModel existe = contratacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contratação não existe"));
        contratacaoRepository.deleteById(id);
        return "Contratação excluida com sucesso!";
    }

    public ContratacaoDTO alterarContratacao(Long id, ContratacaoDTO contratacaoDTO){
        ContratacaoModel contratacao = contratacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Contratação não existe"));
        PlanoModel planoExiste = planoRepository.findById(contratacaoDTO.getIdPlano()).orElseThrow(() -> new RuntimeException("Plano não existe"));
        AlunoModel alunoExiste = alunoRepository.findById(contratacaoDTO.getIdAluno()).orElseThrow(() -> new RuntimeException("Aluno não existe"));

        contratacao.setAluno(alunoExiste);
        contratacao.setPlano(planoExiste);
        contratacao.setDataFinal(contratacaoDTO.getDataFinal());
        contratacao.setDataInicio(contratacaoDTO.getDataInicio());

        ContratacaoModel salvo = contratacaoRepository.save(contratacao);
        return contratacaoMapper.mapToDTO(contratacao);

    }
}
