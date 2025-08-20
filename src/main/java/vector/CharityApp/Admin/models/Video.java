package vector.CharityApp.Admin.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /***
     * add in the models like
     * Video name
     * Video description
     * Views
     */

    private String title;
    private String description;
    private String url;
    private String thumbnailUrl;
    private int views;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
