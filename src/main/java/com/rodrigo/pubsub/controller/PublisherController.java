package com.rodrigo.pubsub.controller;

import com.rodrigo.pubsub.config.PubsubPublisher;
import com.rodrigo.pubsub.model.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filas")
@AllArgsConstructor
@Slf4j
public class PublisherController {

    private final PubsubPublisher pubsubPublisher;

    @GetMapping("/publish/{mensagem}")
    public void publicar(@PathVariable String mensagem) {
        log.info("Recebida no controller!");
        pubsubPublisher.publishMessage(mensagem);
    }

    @PostMapping
    public ResponseEntity<?> publicarObjeto(@RequestBody UsuarioDTO usuarioDTO) {
        log.info("Controller recebendo requisição de objeto");
        pubsubPublisher.publishMessageObject(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
    }
}
