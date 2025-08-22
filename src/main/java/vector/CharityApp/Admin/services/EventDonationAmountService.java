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

    public SpecificEventDonationAmount create(SpecificEventDonationAmount specificEventDonationAmount) {
        specificEventDonationAmount.calculateDonationAmount();

        return specificEventDonationAmountRepository.save(specificEventDonationAmount);

    }

}
