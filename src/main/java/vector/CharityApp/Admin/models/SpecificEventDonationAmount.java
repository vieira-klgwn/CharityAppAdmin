package vector.CharityApp.Admin.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecificEventDonationAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    private Double totalAmount;

    //  i know this is a service but let me hide it in here... i might forget the way i did it.
    public Double calculateDonationAmount() {
        totalAmount = 0.0;
        for (Donation donation: event.getDonations()) {
            totalAmount += donation.getAmount();

        }
        return totalAmount;
    }
}
