package Lab11PA.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AllGames extends CrudRepository<Game, Integer> {
    @Override
    <Ag extends Game> Ag save(Ag ag);

    @Override
    <Ag extends Game> Iterable<Ag> saveAll(Iterable<Ag> iterable);

    @Override
    long count();


    @Override
    Optional<Game> findById(Integer integer);

    @Override
    Iterable<Game> findAll();

    @Override
    Iterable<Game> findAllById(Iterable<Integer> iterable);

    @Override
    void delete(Game game);

    @Override
    void deleteById(Integer integer);

    @Override
    void deleteAll(Iterable<? extends Game> iterable);

    @Override
    void deleteAll();

}