package Quixaba.dev.Gymsys.Services;

import Quixaba.dev.Gymsys.Models.AlunoModel;
import Quixaba.dev.Gymsys.Repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService (AlunoRepository alunoRepository ){
        this.alunoRepository = alunoRepository;
    }

    //Cria metodo para salvar o Aluno.falta validações
    public AlunoModel criarAluno (AlunoModel alunoModel){
        AlunoModel aluno =  alunoRepository.save(alunoModel);
        return aluno;
    }

    public List<AlunoModel> listarTodosAlunos(){
        List<AlunoModel> alunos = alunoRepository.findAll();
        return alunos;
    }
}
