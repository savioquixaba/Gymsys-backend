package Quixaba.dev.Gymsys.Mapper;

import Quixaba.dev.Gymsys.DTO.PlanoDTO;
import Quixaba.dev.Gymsys.Models.PlanoModel;
import org.springframework.stereotype.Component;

@Component
public class PlanoMapper {

    public PlanoModel mapToModel (PlanoDTO planoDTO){
        PlanoModel planoModel = new PlanoModel();

        planoModel.setPreco(planoDTO.getPreco());
        planoModel.setDuracaoDias(planoDTO.getDuracaoDias());
        planoModel.setTipoPlano(planoDTO.getTipoPlano());

        return planoModel;
    }

    public PlanoDTO mapToDto(PlanoModel planoModel){
        PlanoDTO planoDTO = new PlanoDTO();

        planoDTO.setId(planoModel.getId());
        planoDTO.setPreco(planoModel.getPreco());
        planoDTO.setTipoPlano(planoModel.getTipoPlano());
        planoDTO.setDuracaoDias(planoModel.getDuracaoDias());

        return planoDTO;
    }
}
