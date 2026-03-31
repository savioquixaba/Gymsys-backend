package Quixaba.dev.Gymsys.Services;


import Quixaba.dev.Gymsys.DTO.TurmaDTO;
import Quixaba.dev.Gymsys.Mapper.TurmaMapper;
import Quixaba.dev.Gymsys.Models.InstrutorModel;
import Quixaba.dev.Gymsys.Models.TurmaModel;
import Quixaba.dev.Gymsys.Repository.InstrutorRepository;
import Quixaba.dev.Gymsys.Repository.TurmaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TurmaService {

    private TurmaRepository turmaRepository;
    private InstrutorRepository instrutorRepository;
    private TurmaMapper turmaMapper;

    public TurmaService(TurmaRepository turmaRepository, InstrutorRepository instrutorRepository, TurmaMapper turmaMapper){
        this.turmaRepository = turmaRepository;
        this.instrutorRepository = instrutorRepository;
        this.turmaMapper = turmaMapper;
    }

    public TurmaDTO criarTurma(TurmaDTO turmaDTO){
        InstrutorModel instrutorId = instrutorRepository.findById(turmaDTO.getIdInstrutor()).orElseThrow(() -> new RuntimeException("Instrutor não existe, digite um valido!"));
        TurmaModel turma = turmaMapper.mapToDmodel(turmaDTO);
        turma.setInstrutor(instrutorId);
        turma = turmaRepository.save(turma);
        return turmaMapper.mapToDto(turma);
    }

    public List<TurmaDTO> listarTodasTurmas(){
        List<TurmaModel> turmas = turmaRepository.findAll();
        return turmas.stream()
                .map(turma -> turmaMapper.mapToDto(turma))
                .collect(Collectors.toList());
    }

    public TurmaDTO turmaPorId(Long id){
        TurmaModel turma = turmaRepository.findById(id).orElseThrow(() -> new RuntimeException("ID de Turma Invalido!"));

        return turmaMapper.mapToDto(turma);
    }

    public String deletePorId(Long id){
        TurmaModel turmaExiste = turmaRepository.findById(id).orElseThrow(() -> new RuntimeException("Turma não existe!"));
        turmaRepository.deleteById(id);
        return "Turma deletada com Sucesso";
    }

    public TurmaDTO alterarTurma(Long id, TurmaDTO turmaDTO){
        TurmaModel turmaExiste = turmaRepository.findById(id).orElseThrow(() -> new RuntimeException("Turma não existe"));
        InstrutorModel instrutorId = instrutorRepository.findById(turmaDTO.getIdInstrutor()).orElseThrow(() -> new RuntimeException("Instrutor não existe"));

        turmaExiste.setNome(turmaDTO.getNome());
        turmaExiste.setInstrutor(instrutorId);

        TurmaModel turmaAlterada = turmaRepository.save(turmaExiste);
        return turmaMapper.mapToDto(turmaAlterada);
        }

}
