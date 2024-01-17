package org.vlad_stasyshyn.model.dao;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonTypeName(PersonDAO.PERSON_JSON_TYPE_NAME)
public class PersonDAO extends ContactDAO {
    public static final String PERSON_JSON_TYPE_NAME = "PERSON";


    private String firstName;

    private String lastName;

    private String PESEL;


}
