package vector.CharityApp.Admin.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vector.CharityApp.Admin.models.enums.EventStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /***
     * make an event model with feautures
     * name of event
     * status
     * organizer
     * event description
     * attendees of events
     * event location
     * time & date of the event
     * donation for that event or contribution
     * event type
     * capacity of event
     * organization name
     * contact Email for the organization
     * contact phone for the organization
     * tags for the event
     * Video video for the event
     */

    private String eventName;
    private String description;
    private String location;
    private String type;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    private String organizer;
    private int capacity;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String organization;
    private String organizerEmail;
    private String organizerPhone;
    private String tags;

    @OneToMany(mappedBy = "event" ,cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Video> videos;



    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Donation> donations;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    @OneToOne(mappedBy = "event")
    private SpecificEventDonationAmount specificEventDonationAmount;



}
