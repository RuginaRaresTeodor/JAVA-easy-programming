package Lab11PA.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AllPlayers extends CrudRepository<Player, Integer> {
    @Override
    <Ap extends Player> Ap save(Ap ap);

    @Override
    <Ap extends Player> Iterable<Ap> saveAll(Iterable<Ap> iterable);

    @Override
    long count();

    @Override
    Optional<Player> findById(Integer integer);

    @Override
    Iterable<Player> findAll();

    @Override
    void delete(Player player);

    @Override
    void deleteById(Integer integer);

    @Override
    Iterable<Player> findAllById(Iterable<Integer> iterable);

    @Override
    void deleteAll(Iterable<? extends Player> iterable);

    @Override
    void deleteAll();
}