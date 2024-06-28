package io.cncf.community;

import java.util.ArrayList;
import java.util.List;

import io.cncf.community.dto.PersonDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    public List<PersonDto> list() {
        List<PersonDto> persons = new ArrayList<>();
        persons.add(new PersonDto("664f4bf9c70dd20036c229cb", "Luis Falero", "lfalero@gmail.com"));
        persons.add(new PersonDto("664f4c10c70dd20036c229cc", "Jean Lopez", "jlopez@gmail.com"));
        return persons;
    }

    @POST    
    public PersonDto create(PersonDto request) {
        return new PersonDto("664f4bf9c70dd20036c229cb", "Luis Falero", "lfalero@gmail.com");
    }

    @PUT
    @Path("/{id}")
    public PersonDto update(@PathParam("id") String id, PersonDto person) {
        return new PersonDto("664f4bf9c70dd20036c229cb", "Luis Falero", "lfalero@gmail.com");
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {        
    }
}
