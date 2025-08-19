package vector.CharityApp.Admin.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
     * name of events
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
}
