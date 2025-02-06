package io.github.devrafamenegon.msclients.application;

import io.github.devrafamenegon.msclients.application.representation.ClientSaveRequest;
import io.github.devrafamenegon.msclients.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public String status() {
        return "OK";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest request) {
        Client client = request.toModel();
        clientService.save(client);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}").
                buildAndExpand(client.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getClient(@RequestParam("cpf") String cpf) {
        var client = clientService.findByCpf(cpf);

        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }
}
