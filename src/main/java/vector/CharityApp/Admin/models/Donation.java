package vector.CharityApp.Admin.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vector.CharityApp.Admin.models.enums.DonationCause;
import vector.CharityApp.Admin.models.enums.DonationStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /***
     * attributes like
     * User donor
     * Amount
     * Cause (e.g Education)
     * Status
     * Method of payment
     * Event
     * donationTime(when the donation was given)
     */



    @OneToOne
    private User donor;

  //removed the event and donors list

    @Enumerated(EnumType.STRING)
    private DonationStatus status;

    private LocalDateTime donationTime;

    private Double amount;


    private String donationText;

    private String methodOfPayment;

    @Enumerated(EnumType.STRING)
    private DonationCause donationCause;



}
