package Quixaba.dev.Gymsys.Mapper;

import Quixaba.dev.Gymsys.DTO.AlunoDTO;

import Quixaba.dev.Gymsys.Models.AlunoModel;

import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public AlunoModel mapToModel (AlunoDTO alunoDTO)
    {
       AlunoModel alunoModel = new AlunoModel();


       alunoModel.setCpf(alunoDTO.getCpf());
       alunoModel.setNome(alunoDTO.getNome());
       alunoModel.setDataNascimento(alunoDTO.getDataNascimento());
       alunoModel.setMatricula(alunoDTO.getMatricula());


       return alunoModel;
    }

    public AlunoDTO mapToDTO(AlunoModel alunoModel){
        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setId(alunoModel.getId());
        alunoDTO.setNome(alunoModel.getNome());
        alunoDTO.setCpf(alunoModel.getCpf());
        if (alunoModel.getTurma() != null){
            alunoDTO.setTurmaId( alunoModel.getTurma().getId());
        }
        alunoDTO.setMatricula(alunoModel.getMatricula());
        alunoDTO.setDataNascimento(alunoModel.getDataNascimento());

        return  alunoDTO;
    }
}

