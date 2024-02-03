package org.vladstasyshyn.mapper;

import org.mapstruct.*;
import org.vladstasyshyn.model.dao.CompanyDAO;
import org.vladstasyshyn.model.dao.ContactDAO;
import org.vladstasyshyn.model.dao.PersonDAO;
import org.vladstasyshyn.model.dto.request.CompanyRequestDTO;
import org.vladstasyshyn.model.dto.request.ContactRequestDTO;
import org.vladstasyshyn.model.dto.request.PersonRequestDTO;
import org.vladstasyshyn.model.dto.response.CompanyResponseDTO;
import org.vladstasyshyn.model.dto.response.ContactResponseDTO;
import org.vladstasyshyn.model.dto.response.PersonResponseDTO;
import org.vladstasyshyn.model.entity.CompanyEntity;
import org.vladstasyshyn.model.entity.ContactEntity;
import org.vladstasyshyn.model.entity.PersonEntity;

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


