package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("new movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("new Director added successfully", HttpStatus.CREATED);

    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("m") String movie,@RequestParam("d") String director)
    {
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("new movie and director pair added successfully", HttpStatus.CREATED);

    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName)
    {
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName)
    {
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public  ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String name)
    {
        List<String> list = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public  ResponseEntity<List<String>> findAllMovies()
    {
        List<String> list = movieService.findAllMovies();
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("d") String director)
    {
        movieService.deleteDirectorByName(director);
        return new ResponseEntity<>("Director deleted successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All Director deleted successfully",HttpStatus.CREATED);
    }

}
