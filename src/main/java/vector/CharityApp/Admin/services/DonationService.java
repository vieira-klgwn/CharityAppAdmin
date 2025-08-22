package vector.CharityApp.Admin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vector.CharityApp.Admin.models.Donation;
import vector.CharityApp.Admin.models.Event;
import vector.CharityApp.Admin.repositories.DonationRepository;
import vector.CharityApp.Admin.repositories.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository donationRepository;
    private final EventRepository eventRepository;

    /***
     * all services for helping register a Donation
     * increase the amount of donation
     *
     */
    public Donation createDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    public List<Donation> findAllDonations() {
        return donationRepository.findAll();
    }

    public Donation findDonationById(Long id) {
        return donationRepository.findById(id).orElseThrow(() -> new RuntimeException("Donation with id " + id + " not found"));
    }

    public Donation updateDonation(Donation donation) {
        Donation donationExists = findDonationById(donation.getId());
        if (donationExists != null) {
            donationExists.setDonationCause(donation.getDonationCause());
            donationExists.setDonationTime(donation.getDonationTime());
            donationExists.setDonationText(donation.getDonationText());
            donationExists.setMethodOfPayment(donation.getMethodOfPayment());
            donationExists.setStatus(donation.getStatus());
            donationExists.setAmount(donation.getAmount());
            donationExists.setDonor(donation.getDonor());
            return donationRepository.save(donationExists);
        }
        else {
            throw new RuntimeException("Donation with id " + donation.getId() + " not found");
        }
    }

    public void deleteDonation(Long id) {
        if (donationRepository.existsById(id)) {
            donationRepository.deleteById(id);
        }
    }
}
