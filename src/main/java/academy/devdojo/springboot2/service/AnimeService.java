package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.spi.ToolProvider.findFirst;


@Service
@RequiredArgsConstructor
public class AnimeService  {

    private final AnimeRepository animerepository;

    public List<Anime> listall(){
        return animerepository.findAll();
    }

    public Anime findById(long id) {
        return animerepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }



    public Anime save(Anime anime) {

        long idAleatorio = ThreadLocalRandom.current().nextLong(3, 100000);
        anime.setId(idAleatorio);
        animes.add(anime);
        return anime;
    }

    public void delete(long id) {
        animes.remove(findById(id));
    }

    public void replace(Anime anime) {
        delete(anime.getId());
        animes.add(anime);
    }
}
