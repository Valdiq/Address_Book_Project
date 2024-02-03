package org.vladstasyshyn.mapper;

import org.mapstruct.*;
import org.vladstasyshyn.model.dao.CompanyDAO;
import org.vladstasyshyn.model.dao.ContactDAO;
import org.vladstasyshyn.model.dao.PersonDAO;
import org.vladstasyshyn.model.entity.CompanyEntity;
import org.vladstasyshyn.model.entity.ContactEntity;
import org.vladstasyshyn.model.entity.PersonEntity;

@Mapper(
        componentModel = "spring",
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ContactEntityDAOMapper {

    @SubclassMappings({
            @SubclassMapping(source = PersonDAO.class, target = PersonEntity.class),
            @SubclassMapping(source = CompanyDAO.class, target = CompanyEntity.class)
    })
    ContactEntity mapContactDAOToContactEntity(ContactDAO contactDAO);

    @SubclassMappings({
            @SubclassMapping(source = PersonEntity.class, target = PersonDAO.class),
            @SubclassMapping(source = CompanyEntity.class, target = CompanyDAO.class)
    })
    ContactDAO mapContactEntityToContactDAO(ContactEntity contactEntity);

}
