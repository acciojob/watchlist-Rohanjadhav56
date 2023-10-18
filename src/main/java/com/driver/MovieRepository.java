package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    HashMap<String,Movie> m1 = new HashMap<>();
    HashMap<String,Director> m2 = new HashMap<>();
    HashMap<String, List<String>> m3 = new HashMap<>();

    public void addMovie(Movie movie) {
        m1.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        m2.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        if(m1.containsKey(movie) && m2.containsKey(director))
        {
            List<String> curr = new ArrayList<String>();
            if(m3.containsKey(director)) curr = m3.get(director);
            curr.add(movie);
            m3.put(director,curr);

        }
    }

    public Movie getMovieByName(String movieName) {

            return m1.get(movieName);

    }

    public Director getDirectorByName(String directorName) {
        return m2.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String name) {
        return m3.getOrDefault(name,new ArrayList<String>());
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(m1.keySet());

    }

    public void deleteDirectorByName(String director) {
        List<String> movies = new ArrayList<String>();
        if(m3.containsKey(director))
        {
            movies = m3.get(director);
            for (String movie:movies) {
                if(m1.containsKey(movie)) m1.remove(movie);

            }
            m3.remove(director);
        }
        if(m2.containsKey(director)) m2.remove(director);
    }

    public void deleteAllDirectors() {
        HashSet<String> moviesSet = new HashSet<>();

        for(String director : m3.keySet())
        {
            for(String movie : m3.get(director))
            {
                moviesSet.add(movie);
            }
        }
        for(String movie : moviesSet)
        {
            if(m1.containsKey(movie)) m1.remove(movie);
        }
    }
}
