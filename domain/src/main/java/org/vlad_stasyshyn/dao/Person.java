package org.vlad_stasyshyn.dao;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonTypeName(Person.PERSON_JSON_TYPE_NAME)
public class Person extends Contact {
    public static final String PERSON_JSON_TYPE_NAME = "PERSON";


    private String firstName;

    private String lastName;

    private String PESEL;


}
