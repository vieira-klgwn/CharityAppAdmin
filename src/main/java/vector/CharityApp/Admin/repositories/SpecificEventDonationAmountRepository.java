package vector.CharityApp.Admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vector.CharityApp.Admin.models.Event;
import vector.CharityApp.Admin.models.SpecificEventDonationAmount;

import java.util.List;

public interface SpecificEventDonationAmountRepository extends JpaRepository<SpecificEventDonationAmount, Long> {


}
