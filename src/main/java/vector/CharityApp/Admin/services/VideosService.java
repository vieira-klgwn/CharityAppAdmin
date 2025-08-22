package vector.CharityApp.Admin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vector.CharityApp.Admin.models.Event;
import vector.CharityApp.Admin.models.Video;
import vector.CharityApp.Admin.repositories.EventRepository;
import vector.CharityApp.Admin.repositories.VideoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideosService {
    private final VideoRepository videoRepository;
    private final EventRepository eventRepository;

    /***
     * this will include the functionality to
     * edit title and description of the video
     * upload the video
     * make a live stream
     * share a video
     * download a video
     * watch a video
     * delete a video
     * increase the number of views after being viewed
     */

    public Video crateVideo(Video video) {
        return videoRepository.save(video);
    }

    public Video findVideoById(long id) {
        return videoRepository.findById(id).orElseThrow(()-> new RuntimeException("Video with id " + id + " not found"));
    }

    public List<Video> findAllVideos() {
        return videoRepository.findAll();
    }

    public List<Video> findVideosByEventId(long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event with id " + eventId + " not found"));
        return event.getVideos();
    }

    public Video updateVideo(Video video) {
        Video existingVideo = videoRepository.findById(video.getId()).orElse(null);
        if (existingVideo != null) {
            existingVideo.setTitle(video.getTitle());
            existingVideo.setDescription(video.getDescription());
            existingVideo.setUrl(video.getUrl());
            existingVideo.setEvent(video.getEvent());
            existingVideo.setThumbnailUrl(video.getThumbnailUrl());
            return videoRepository.save(existingVideo);
        }
        else{
            throw new RuntimeException("Video with id " + video.getId() + " not found");
        }

    }
}
