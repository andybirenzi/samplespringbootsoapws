package andy.birenzi.springbootsoap.endpoints;

import andy.birenzi.springbootsoap.services.CountryRepository;
import andy.birenzi.springbootsoap.services.PersonRepository;
import io.andybirenzi.springbootsoap.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "http://andybirenzi.io/springbootsoap";
   @Autowired
    private PersonRepository personRepository;

    @Autowired
    public PersonEndpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getPerson(@RequestPayload GetPersonRequest request) {
        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(personRepository.findPerson(request.getName()));

        return response;
    }
}
