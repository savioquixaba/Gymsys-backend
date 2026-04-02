package Quixaba.dev.Gymsys.Mapper;

import Quixaba.dev.Gymsys.DTO.ContratacaoDTO;
import Quixaba.dev.Gymsys.Models.ContratacaoModel;
import org.springframework.stereotype.Component;

@Component
public class ContratacaoMapper {

    public ContratacaoModel mapToModel (ContratacaoDTO contratacaoDTO){
        ContratacaoModel contratacaoModel = new ContratacaoModel();

        contratacaoModel.setDataInicio(contratacaoDTO.getDataInicio());
        contratacaoModel.setDataFinal(contratacaoDTO.getDataFinal());

        return contratacaoModel;
    }

    public ContratacaoDTO mapToDTO(ContratacaoModel contratacaoModel){
        ContratacaoDTO contratacaoDTO = new ContratacaoDTO();

        contratacaoDTO.setId(contratacaoDTO.getId());
        contratacaoDTO.setDataInicio(contratacaoModel.getDataInicio());
        contratacaoDTO.setDataFinal(contratacaoModel.getDataFinal());

        return contratacaoDTO;

    }
}
