package vector.CharityApp.Admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vector.CharityApp.Admin.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
