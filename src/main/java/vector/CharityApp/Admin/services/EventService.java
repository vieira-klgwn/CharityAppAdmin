package vector.CharityApp.Admin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vector.CharityApp.Admin.models.Event;
import vector.CharityApp.Admin.repositories.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    /***
     * This is responsible for making all functionality of registering an event
     */
    public Event createEvent(Event event){
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event, Long id){
        Event eventExists = eventRepository.findById(id).orElseThrow(()-> new RuntimeException("Event with id " + id + " not found"));
        if (eventExists != null) {
            eventExists.setEventStatus(event.getEventStatus());
            eventExists.setStartDate(event.getStartDate());
            eventExists.setEndDate(event.getEndDate());
            eventExists.setDescription(event.getDescription());
            eventExists.setCapacity(event.getCapacity());
            eventExists.setLocation(event.getLocation());
            eventExists.setDonations(event.getDonations());
            eventExists.setOrganization(event.getOrganization());
            eventExists.setOrganizer(event.getOrganizer());
            eventExists.setOrganizerEmail(event.getOrganizerEmail());
            eventExists.setOrganizerPhone(event.getOrganizerPhone());
            eventExists.setEventName(event.getEventName());
            eventExists.setTags(event.getTags());
            eventExists.setType(event.getType());
            eventExists.setVideos(event.getVideos());
            eventExists.setOrganization(event.getOrganization());
            eventExists.setVideos(event.getVideos()); // check if this update service doesn't deletes things especially when updating listy things like donations, videos etc
            return eventRepository.save(eventExists);
        }
        throw new RuntimeException("Event with id " + event.getId() + " not found");
    }

    public void deleteEvent(Long id){
        if (eventRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Event with id " + id + " not found");
        }
        eventRepository.deleteById(id);
    }

    public Event getEventById(Long id){
        return eventRepository.findById(id).orElseThrow(()-> new RuntimeException("Event with id " + id + " not found"));
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

}
