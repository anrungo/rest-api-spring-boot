package one.digitalinnovation.personrestapi.service;

import one.digitalinnovation.personrestapi.dto.MessageResponseDTO;
import one.digitalinnovation.personrestapi.dto.request.PersonDTO;
import one.digitalinnovation.personrestapi.entity.Person;
import one.digitalinnovation.personrestapi.repository.PersonRepository;
import one.digitalinnovation.personrestapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personrestapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {


    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
       PersonDTO personDTO = createFakeDTO();
       Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(expectedSavedPerson)).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createdExpectedMessageResponse(expectedSavedPerson.getId());

       MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createdExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }

}
