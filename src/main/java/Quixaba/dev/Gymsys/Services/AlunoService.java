package Quixaba.dev.Gymsys.Services;

import Quixaba.dev.Gymsys.DTO.AlunoDTO;
import Quixaba.dev.Gymsys.DTO.TurmaDTO;
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

        TurmaModel idTurma =  turmaRepository.findById(alunoDTO.getTurmaId()).orElse(null);
        AlunoModel aluno =  alunoMapper.mapToModel(alunoDTO);
        aluno.setTurma(idTurma);
        // recebe o DTO
        aluno = alunoRepository.save(aluno); //SALVA O OBJETO
        return alunoMapper.mapToDTO(aluno); // RETORNA COMO DTO
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

    public void deletarAlunoPorId(Long id){
        alunoRepository.deleteById(id);
    }


}
