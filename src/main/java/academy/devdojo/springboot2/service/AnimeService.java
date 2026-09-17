package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.spi.ToolProvider.findFirst;


@Service
public class AnimeService  {
    private static List<Anime> animes;
    static {
        animes = new ArrayList<>(List.of(new Anime(1L,"DBZ"), new Anime(2L,"Berserk")));
    }


    public List<Anime> listall(){
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
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
