package vector.CharityApp.Admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vector.CharityApp.Admin.models.Donation;
import vector.CharityApp.Admin.repositories.DonationRepository;
import vector.CharityApp.Admin.services.DonationService;

import java.util.List;

@RestController
@RequestMapping("/api/donation")
@RequiredArgsConstructor
public class DonationController {
    private final DonationService donationService;
    /***
     * this controller will be having endpoints to register the endpoints using the donatios service but only after a payment have been done
     */
    @PostMapping
    public ResponseEntity<Donation> create(@RequestBody Donation donation) {
        Donation donation1 =  donationService.createDonation(donation);
        return new ResponseEntity<>(donation1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Donation>> getAll() {

        return new ResponseEntity<>(donationService.findAllDonations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getOne(@PathVariable Long id) {
        if (donationService.findDonationById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(donationService.findDonationById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donation> update(@PathVariable Long id, @RequestBody Donation donation) {
        if (donationService.findDonationById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(donationService.updateDonation(donation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Donation> delete(@PathVariable Long id) {
        if (donationService.findDonationById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        donationService.deleteDonation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
