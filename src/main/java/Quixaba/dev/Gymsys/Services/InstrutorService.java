package Quixaba.dev.Gymsys.Services;

import Quixaba.dev.Gymsys.DTO.InstrutorDTO;
import Quixaba.dev.Gymsys.Mapper.InstrutorMapper;
import Quixaba.dev.Gymsys.Models.InstrutorModel;
import Quixaba.dev.Gymsys.Models.TurmaModel;
import Quixaba.dev.Gymsys.Repository.InstrutorRepository;
import Quixaba.dev.Gymsys.Repository.TurmaRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<InstrutorDTO> listarTodos(){
        List<InstrutorModel> instrutores = instrutorRepository.findAll();
        return instrutores.stream()
                .map(instrutor -> instrutorMapper.mapToDto(instrutor))
                .collect(Collectors.toList());
    }

    public InstrutorDTO listarPorId(Long id){
        InstrutorModel buscaId = instrutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrutor com ID" + id + "não existe!"));
        return instrutorMapper.mapToDto(buscaId);
    }

    public InstrutorDTO alterarInstrutor (Long id, InstrutorDTO instrutorDTO){
        InstrutorModel instrutorExiste = instrutorRepository.findById(id).orElseThrow(() -> new RuntimeException("Instrutor não existe!"));
        TurmaModel turmaExiste = turmaRepository.findById(instrutorDTO.getIdTurma())
                .orElseThrow(() -> new RuntimeException("Turma com o ID" + instrutorDTO.getIdTurma() + "não existe");
        List<TurmaModel> lista = List.of(turmaExiste);
        instrutorExiste.setHorario(instrutorDTO.getHorario());
        instrutorExiste.setNome(instrutorDTO.getNome());
        instrutorExiste.setCpf(instrutorDTO.getCpf());
        instrutorExiste.setTurmas(lista);
        InstrutorModel salvo = instrutorRepository.save(instrutorExiste);
        return instrutorMapper.mapToDto(salvo);
    }

    public String deletePorId(Long id){
        InstrutorModel idExiste = instrutorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Instrutor com ID:" + id + "Não existe, digite um valido!"));
        instrutorRepository.deleteById(id);
        return "Instrutor deletado com sucesso!";
    }
}

