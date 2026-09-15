package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


// Aqui é onde ocorre a primeira interação com a requisição do usuário com o sistema back-end.
//Exemplo seguido: visualizar a lista de animes.
@RestController
@RequestMapping("anime")
@Log4j2
@RequiredArgsConstructor

public class AnimeController {

    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping(path = "list")
    public List<Anime> list(){
        log.info(dateUtil.FormatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return animeService.listall();
    }
}
