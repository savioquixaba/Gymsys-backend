package Quixaba.dev.Gymsys.Mapper;

import Quixaba.dev.Gymsys.DTO.InstrutorDTO;
import Quixaba.dev.Gymsys.Models.InstrutorModel;

public class InstrutorMapper {

 public InstrutorModel mapToModel (InstrutorDTO instrutorDTO){

     InstrutorModel instrutorModel = new InstrutorModel();
    // nunca setar ID vindo de um DTO, boas praticas
     instrutorModel.setCpf(instrutorDTO.getCpf());
     instrutorModel.setNome(instrutorDTO.getNome());
     instrutorModel.setHorario(instrutorDTO.getHorario());

     return instrutorModel;
 }

 public InstrutorDTO mapToDto (InstrutorModel instrutorModel){
     InstrutorDTO instrutorDTO = new InstrutorDTO();

     // pode retornar o ID para ser usado em outras partes do codigo
     instrutorDTO.setId(instrutorModel.getId());
     instrutorDTO.setCpf(instrutorModel.getCpf());
     instrutorDTO.setHorario(instrutorModel.getHorario());
     instrutorDTO.setNome(instrutorModel.getNome());

     return instrutorDTO;
 }
}
