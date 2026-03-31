package Quixaba.dev.Gymsys.Services;

import Quixaba.dev.Gymsys.DTO.InstrutorDTO;
import Quixaba.dev.Gymsys.Mapper.InstrutorMapper;
import Quixaba.dev.Gymsys.Models.InstrutorModel;
import Quixaba.dev.Gymsys.Models.TurmaModel;
import Quixaba.dev.Gymsys.Repository.InstrutorRepository;
import Quixaba.dev.Gymsys.Repository.TurmaRepository;

import java.util.List;

public class InstrutorService {

    private InstrutorMapper instrutorMapper;
    private InstrutorRepository instrutorRepository;
    private TurmaRepository turmaRepository;

    public InstrutorService(InstrutorMapper instrutorMapper, InstrutorRepository instrutorRepository, TurmaRepository turmaRepository){
        this.instrutorRepository = instrutorRepository;
        this.instrutorMapper = instrutorMapper;
        this.turmaRepository = turmaRepository;
    }

    public InstrutorDTO criarInstrutor(InstrutorDTO instrutorDTO){
        TurmaModel turmaId = turmaRepository.findById(instrutorDTO.getIdTurma())
                .orElseThrow(() -> new RuntimeException("Turma não existe, digite um ID de turma valido!"));
        InstrutorModel instrutor = instrutorMapper.mapToModel(instrutorDTO);
        //transforma a lista em outra lista com um só indice
        List<TurmaModel> lista = List.of(turmaId);
        instrutor.setTurmas(lista);
        InstrutorModel salvo = instrutorRepository.save(instrutor);
        return instrutorMapper.mapToDto(salvo);
    }

}

