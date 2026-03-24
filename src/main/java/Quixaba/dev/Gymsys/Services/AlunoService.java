package Quixaba.dev.Gymsys.Services;

import Quixaba.dev.Gymsys.DTO.AlunoDTO;
import Quixaba.dev.Gymsys.Mapper.AlunoMapper;
import Quixaba.dev.Gymsys.Models.AlunoModel;
import Quixaba.dev.Gymsys.Repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoMapper alunoMapper;
    private final AlunoRepository alunoRepository;

    public AlunoService (AlunoRepository alunoRepository, AlunoMapper alunoMapper){
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    //Cria metodo para salvar o Aluno.falta validações
    public AlunoModel criarAluno (AlunoModel alunoModel){
        AlunoModel aluno =  alunoRepository.save(alunoModel);
        return aluno;
    }

    public List<AlunoDTO> listarTodosAlunos(){
        List<AlunoModel> alunos = alunoRepository.findAll();
        return alunos.stream()
                .map(aluno -> alunoMapper.mapToDTO(aluno))
                .collect(Collectors.toList());
    }
}
