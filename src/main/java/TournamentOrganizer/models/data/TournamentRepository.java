package TournamentOrganizer.models.data;

import TournamentOrganizer.models.Tournaments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends CrudRepository<Tournaments, Integer> {
}
