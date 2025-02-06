package io.github.devrafamenegon.msclients.application;

import io.github.devrafamenegon.msclients.domain.Client;
import io.github.devrafamenegon.msclients.infra.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }
}