package org.vlad_stasyshyn.mapper;

import org.mapstruct.*;
import org.vlad_stasyshyn.model.dao.CompanyDAO;
import org.vlad_stasyshyn.model.dao.ContactDAO;
import org.vlad_stasyshyn.model.dao.PersonDAO;
import org.vlad_stasyshyn.model.dto.request.CompanyRequestDTO;
import org.vlad_stasyshyn.model.dto.request.ContactRequestDTO;
import org.vlad_stasyshyn.model.dto.request.PersonRequestDTO;
import org.vlad_stasyshyn.model.dto.response.CompanyResponseDTO;
import org.vlad_stasyshyn.model.dto.response.ContactResponseDTO;
import org.vlad_stasyshyn.model.dto.response.PersonResponseDTO;
import org.vlad_stasyshyn.model.entity.CompanyEntity;
import org.vlad_stasyshyn.model.entity.ContactEntity;
import org.vlad_stasyshyn.model.entity.PersonEntity;

@Mapper(
        componentModel = "spring",
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ContactModelMapper {

    @SubclassMappings({
            @SubclassMapping(source = PersonRequestDTO.class, target = PersonDAO.class),
            @SubclassMapping(source = CompanyRequestDTO.class, target = CompanyDAO.class)
    })
    ContactDAO mapContactRequestDTOToContactDAO(ContactRequestDTO contactRequestDTO);

    @SubclassMappings({
            @SubclassMapping(source = PersonEntity.class, target = PersonResponseDTO.class),
            @SubclassMapping(source = CompanyEntity.class, target = CompanyResponseDTO.class)
    })
    ContactResponseDTO mapContactEntityToContactResponseDTO(ContactEntity contactEntity);

}


