package Quixaba.dev.Gymsys.Services;

import Quixaba.dev.Gymsys.DTO.AlunoDTO;
import Quixaba.dev.Gymsys.Mapper.AlunoMapper;
import Quixaba.dev.Gymsys.Models.AlunoModel;
import Quixaba.dev.Gymsys.Models.TurmaModel;
import Quixaba.dev.Gymsys.Repository.AlunoRepository;
import Quixaba.dev.Gymsys.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoMapper alunoMapper;
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public AlunoService (AlunoRepository alunoRepository, AlunoMapper alunoMapper, TurmaRepository turmaRepository){
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
        this.turmaRepository = turmaRepository;
    }

    //Cria metodo para salvar o Aluno.falta validações
    public AlunoDTO criarAluno (AlunoDTO alunoDTO){
        AlunoModel aluno =  alunoMapper.mapToModel(alunoDTO);
        if (alunoDTO.getTurmaId() != null){
            TurmaModel idTurma =  turmaRepository.findById(alunoDTO.getTurmaId()).orElse(null);
            aluno.setTurma(idTurma);
        }
        aluno = alunoRepository.save(aluno); //
        return alunoMapper.mapToDTO(aluno); //
    }

    public List<AlunoDTO> listarTodosAlunos(){
        List<AlunoModel> alunos = alunoRepository.findAll();
        return alunos.stream()
                .map(aluno -> alunoMapper.mapToDTO(aluno))
                .collect(Collectors.toList());
    }

    public AlunoDTO listarAlunoPorId(Long id){
       //sempre que for usar o repositorio ele retorna o Model da entidade
        Optional<AlunoModel> alunoPorId = alunoRepository.findById(id);
        //Model to DTO
        return alunoPorId.map(aluno -> alunoMapper.mapToDTO(aluno))
                .orElse(null);
    }

    public String deletarAlunoPorId(Long id){
        Optional<AlunoModel> alunoExiste = alunoRepository.findById(id);
        if (alunoExiste.isPresent()){
           alunoRepository.deleteById(id);
           return "Aluno deletado com Sucesso";
        }throw new RuntimeException("Aluno não existe para ser deletado");


    }

    public AlunoDTO AlterarAlunoPorId(Long id, AlunoDTO alunoDTO ){

        TurmaModel idTurma = turmaRepository.findById(alunoDTO.getTurmaId()).orElse(null);
        Optional<AlunoModel> alunoExiste = alunoRepository.findById(id);
        if (alunoExiste.isPresent()){
            AlunoModel alunoAtualizado = alunoMapper.mapToModel(alunoDTO);
            alunoAtualizado.setTurma(idTurma);
            alunoAtualizado.setId(id);
            AlunoModel alunoSalvo = alunoRepository.save(alunoAtualizado);
            return alunoMapper.mapToDTO(alunoSalvo);

        }throw new RuntimeException("Aluno não existe");


    }

}
