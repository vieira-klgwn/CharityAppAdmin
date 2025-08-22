package vector.CharityApp.Admin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vector.CharityApp.Admin.models.Donation;
import vector.CharityApp.Admin.models.Event;
import vector.CharityApp.Admin.models.SpecificEventDonationAmount;
import vector.CharityApp.Admin.repositories.SpecificEventDonationAmountRepository;

@Service
@RequiredArgsConstructor
public class EventDonationAmountService {
    private final SpecificEventDonationAmountRepository specificEventDonationAmountRepository;

    public SpecificEventDonationAmount calculateDonationAmount(Event event) {
        // I am stuck getting to know how to calculate the amount. But i was thinking of just calling the method of calculating which is in the main class
        return  null;
    }

}
