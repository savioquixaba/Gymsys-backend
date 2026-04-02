package Quixaba.dev.Gymsys.Mapper;

import Quixaba.dev.Gymsys.DTO.TurmaDTO;
import Quixaba.dev.Gymsys.Models.TurmaModel;
import org.springframework.stereotype.Component;

@Component
public class TurmaMapper {

    public TurmaModel mapToDmodel(TurmaDTO turmaDTO) {
        TurmaModel turmaModel = new TurmaModel();

        turmaModel.setNome(turmaDTO.getNome());

        return turmaModel;
    }

    public TurmaDTO mapToDto(TurmaModel turmaModel){
        TurmaDTO turmaDTO = new TurmaDTO();

        turmaDTO.setId(turmaModel.getId());
        turmaDTO.setNome(turmaModel.getNome());

        return turmaDTO;
    }
}
