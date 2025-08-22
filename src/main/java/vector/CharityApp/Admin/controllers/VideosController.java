package vector.CharityApp.Admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vector.CharityApp.Admin.models.Video;
import vector.CharityApp.Admin.services.VideosService;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideosController {
    /***
     * This will interact with the Videos Service to give endpoints to download, upload, share video, watch , delete, livestream, edit title and other functionalities
     * in the VidoesService
     */
    private final VideosService videosService;

    @PostMapping
    public ResponseEntity<Video> create(@RequestBody Video video) {
        Video newVideo = videosService.crateVideo(video);
        return new ResponseEntity<>(newVideo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Video>> getAll() {
        List<Video> videos = videosService.findAllVideos();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getById(@PathVariable Long id) {
        if (videosService.findVideoById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Video video = videosService.findVideoById(id);
        return new ResponseEntity<>(video, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> update(@PathVariable Long id, @RequestBody Video video) {
        if (videosService.findVideoById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        videosService.updateVideo(video);
        return new ResponseEntity<>(video, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        if (videosService.findVideoById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        videosService.deleteVideo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
