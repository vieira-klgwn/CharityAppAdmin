package vector.CharityApp.Admin.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
     * User donors
     * Amount
     * Cause (e.g Education)
     * Status
     * Method of payment
     * Event
     * donationTime(when the donation was given)
     */



    @ManyToMany(mappedBy = "donations", fetch = FetchType.LAZY, targetEntity = User.class)
    private List<User> donors;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Enumerated(EnumType.STRING)
    private DonationStatus status;

    private LocalDateTime donationTime;

    private String donationText;

    private String methodOfPayment;

    @Enumerated(EnumType.STRING)
    private DonationCause donationCause;




}
