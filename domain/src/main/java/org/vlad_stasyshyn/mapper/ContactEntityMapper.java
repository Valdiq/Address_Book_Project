package org.vlad_stasyshyn.mapper;

import org.mapstruct.*;
import org.vlad_stasyshyn.model.dao.CompanyDAO;
import org.vlad_stasyshyn.model.dao.ContactDAO;
import org.vlad_stasyshyn.model.dao.PersonDAO;
import org.vlad_stasyshyn.model.entity.CompanyEntity;
import org.vlad_stasyshyn.model.entity.ContactEntity;
import org.vlad_stasyshyn.model.entity.PersonEntity;

@Mapper(
        componentModel = "spring",
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ContactEntityMapper {

    @SubclassMappings({
            @SubclassMapping(source = PersonDAO.class, target = PersonEntity.class),
            @SubclassMapping(source = CompanyDAO.class, target = CompanyEntity.class)
    })
    ContactEntity mapContactDAOToContactEntity(ContactDAO contactDAO);


}
