package com.hornung.crud.clients.validations;

import com.hornung.crud.clients.builders.entity.ClientBuilder;
import com.hornung.crud.clients.entities.Address;
import com.hornung.crud.clients.entities.Cellphone;
import com.hornung.crud.clients.entities.Client;
import com.hornung.crud.clients.exceptions.*;
import com.hornung.crud.clients.repositories.ClientRepository;
import com.hornung.crud.clients.services.validations.client.aspects.ClientDataValidateAspect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientDataValidateAspectTest {

    ClientRepository repository;
    ClientDataValidateAspect aspectMock;

    @BeforeEach
    void setup() {
        repository = mock(ClientRepository.class);
        aspectMock = mock(ClientDataValidateAspect.class);
    }

    @Test
    @DisplayName("Throw_ClientIdNotIsValidException_When_clientIdInvalidValidate_Is_Called")
    public void clientIdNotIsValidException_When_clientIdInvalidValidate_Is_Called() {
        doThrow(ClientIdNotIsValidException.class).when(aspectMock).clientIdInvalidValidate(99999L);
        Assertions.assertThrows(ClientIdNotIsValidException.class,
                () -> aspectMock.clientIdInvalidValidate(99999L));
    }

    @Test
    @DisplayName("Throw_NameNotContaisMinimumCharactersException_When_nameMinimumTenCharactersValidate_Is_Called")
    public void nameNotContaisMinimumCharactersException_When_nameMinimumTenCharactersValidate_Is_Called() {
        doThrow(NameNotContaisMinimumCharactersException.class).when(aspectMock).nameMinimumTenCharactersValidate("12345");
        Assertions.assertThrows(NameNotContaisMinimumCharactersException.class,
                () -> aspectMock.nameMinimumTenCharactersValidate("12345"));

    }

    @Test
    @DisplayName("Throw_CellphoneNotIsValidException_When_cellphoneCanNotIsNullValidate_Is_Called")
    public void cellphoneNotIsValidException_When_cellphoneCanNotIsNullValidate_Is_Called() {
        List<String> cellphoneList = Arrays.asList("123", null, "2343");
        doThrow(CellphoneNotIsValidException.class).when(aspectMock).cellphoneCanNotIsNullValidate(cellphoneList);
        Assertions.assertThrows(CellphoneNotIsValidException.class,
                () -> aspectMock.cellphoneCanNotIsNullValidate(cellphoneList));
    }

    @Test
    @DisplayName("Throw_CellphoneCanNotEmptyException_When_cellphoneHasEmpty_Is_Called")
    public void cellphoneCanNotEmptyException_When_cellphoneHasEmpty_Is_Called() {
        List<String> cellphoneList = Arrays.asList();
        doThrow(CellphoneCanNotEmptyException.class).when(aspectMock).cellphoneCanNotIsNullValidate(cellphoneList);
        Assertions.assertThrows(CellphoneCanNotEmptyException.class,
                () -> aspectMock.cellphoneCanNotIsNullValidate(cellphoneList));
    }

    @Test
    @DisplayName("Throw_CellphoneHasExistsInDatabaseException_When_cellphoneExistsValidation_Is_Called_With_Existing_Cellphone")
    public void cellphoneHasExistsInDatabaseException_When_cellphoneExistsValidation_Is_Called_With_Existing_Cellphone() {
        Client client = ClientBuilder.builder()
                .id(1L)
                .cellphones(List.of(new Cellphone("123")))
                .name("Pedro Donato")
                .address(new Address("Neighbordhood", "Address"))
                .build();

        repository.save(client);
        doThrow(CellphoneHasExistsInDatabaseException.class).when(aspectMock).cellphoneExistsValidation(List.of("123"));
        Assertions.assertThrows(CellphoneHasExistsInDatabaseException.class,
                () -> aspectMock.cellphoneExistsValidation(List.of("123")));
    }
}