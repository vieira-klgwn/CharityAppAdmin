package vector.CharityApp.Admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vector.CharityApp.Admin.models.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
