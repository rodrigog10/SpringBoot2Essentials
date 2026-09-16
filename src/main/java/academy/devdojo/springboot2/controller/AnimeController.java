package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


// Define que essa classe receberá requisições http e retornará respostas.
@RestController
// Define a rota que essa classe irá se basear para responder a requisição do usuário.
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor

public class AnimeController {

    private final DateUtil dateUtil;
    private final AnimeService animeService;

    // http://localhost:8080/animes

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.FormatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listall());
    }
    // http://localhost:8080/animes/id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id){
        return ResponseEntity.ok(animeService.findById(id));
    }

    // http://localhost:8080/animes/novoAnime
    @PostMapping(path = "novoAnime")
        public ResponseEntity<Anime> save(@RequestBody Anime anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }
}
