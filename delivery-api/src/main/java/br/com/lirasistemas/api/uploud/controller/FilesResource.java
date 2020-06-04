package br.com.lirasistemas.api.uploud.controller;

import br.com.lirasistemas.api.uploud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author paullo.azevedo@gmail.com
 */

@RestController
@RequestMapping("/files")
public class FilesResource {

    @Autowired
    private Storage storage;

    @PostMapping
    public String upload(@RequestParam MultipartFile file) {
        return storage.salvarArquivo(file);
    }

}
