package org.vlad_stasyshyn.model.dao;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@JsonTypeName(CompanyDAO.COMPANY_JSON_TYPE_NAME)
public class CompanyDAO extends ContactDAO {
    public static final String COMPANY_JSON_TYPE_NAME = "COMPANY";


    private String name;

    private String NIP;

}
