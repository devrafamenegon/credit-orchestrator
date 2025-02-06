package io.github.devrafamenegon.msclients.application.representation;

import io.github.devrafamenegon.msclients.domain.Client;
import lombok.Data;

@Data
public class ClientSaveRequest {
    private String cpf;
    private String name;
    private Integer age;

    public Client toModel() {
        return new Client(name, cpf, age);
    }
}
