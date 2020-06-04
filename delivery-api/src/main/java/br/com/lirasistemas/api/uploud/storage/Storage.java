package br.com.lirasistemas.api.uploud.storage;

import br.com.lirasistemas.api.uploud.utils.Util;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author paullo.azevedo@gmail.com
 */
@Component
public class Storage {
    @Value("${uploud.disco.raiz}")
    private String raiz;

    @Value("${uploud.disco.diretorio-files}")
    private String diretorioArquivos;
    
    public String salvarArquivo(MultipartFile arquivo) {
        return this.salvar(this.diretorioArquivos, arquivo);
    }

    public String salvar(String diretorio, MultipartFile arquivo) {
        Path diretorioPath = Paths.get(this.raiz, diretorio);
        Path arquivoPath = diretorioPath.resolve(Util.md5(Util.gerarNumeroAleatorio(9999).toString()) + arquivo.getOriginalFilename());

        try {
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
            return arquivoPath.getFileName().toString();
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível salvar o arquivo: ", e);
        } catch (IllegalStateException io) {
            throw new RuntimeException("Maximum upload size exceeded: maximum (3 Mb)", io);
        }
    }
    
}
