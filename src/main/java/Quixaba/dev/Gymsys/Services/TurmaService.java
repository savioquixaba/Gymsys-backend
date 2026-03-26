package Quixaba.dev.Gymsys.Services;

import Quixaba.dev.Gymsys.DTO.TurmaDTO;
import Quixaba.dev.Gymsys.Mapper.TurmaMapper;
import Quixaba.dev.Gymsys.Models.AlunoModel;
import Quixaba.dev.Gymsys.Models.InstrutorModel;
import Quixaba.dev.Gymsys.Models.TurmaModel;
import Quixaba.dev.Gymsys.Repository.InstrutorRepository;
import Quixaba.dev.Gymsys.Repository.TurmaRepository;

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
        InstrutorModel instrutorId = instrutorRepository.findById(turmaDTO.getIdInstrutor()).orElse(null);
        TurmaModel turma = turmaMapper.mapToDmodel(turmaDTO);
        turma.setInstrutor(instrutorId);
        turma = turmaRepository.save(turma);
        return turmaMapper.mapToDto(turma);
    }

}
