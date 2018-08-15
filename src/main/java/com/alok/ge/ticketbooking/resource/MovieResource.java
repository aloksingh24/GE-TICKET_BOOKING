package com.alok.ge.ticketbooking.resource;

import com.alok.ge.ticketbooking.model.BookTicket;
import com.alok.ge.ticketbooking.model.Movie;
import com.alok.ge.ticketbooking.model.Ticket;
import com.alok.ge.ticketbooking.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    MovieRepository movieRepository;

    public MovieResource(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @GetMapping("/getAll")
    public List<String> getAllMovies(){
        return getAllMoviesName();
    }

    @PostMapping(value ="/addMovie")
    public List<String> addMovie(@RequestBody Movie movie){
       Movie dbMovie = movieRepository.findByName(movie.getName());
       if(dbMovie != null){
           List<String> errorMsg= new ArrayList<>();
           errorMsg.add("Movie Name already in Database");
           return errorMsg;
       }

        movieRepository.save(new Movie(movie.getName(),100) );
        return getAllMoviesName();
    }

    @PostMapping("/bookTicket")
    public String bookTicket(@RequestBody BookTicket bookTicket){
        String movieName = bookTicket.getMovieName();
        Movie dbMovie = movieRepository.findByName(movieName);

        if(dbMovie != null){
            //List<Ticket> bookedTickets = dbMovie.getTicket();
            List<String> ticketNumber = dbMovie.getTicket().stream().map(ticket -> String.valueOf(ticket.getSeatNumber())).
                    collect(Collectors.toList());
            String notBookedTicket = new String();
            String[] seatNumber = bookTicket.getSeatNumber();
            for( String seat: seatNumber){
                if(ticketNumber.contains(seat)){
                    notBookedTicket+= seat+ " ";
                }else{
                    Ticket t = new Ticket(Integer.parseInt(seat));
                    dbMovie.getTicket().add(t);
                }
            }
            movieRepository.save(dbMovie);
            if(notBookedTicket.isEmpty()){
                return "Tickets Booked";
            }else
            {
                return "Tickets not booked for seats : "+ notBookedTicket;
            }

        }else
        {
            return "Invalid Movie Name, Please provide valid name";
        }


    }

    private List<String> getAllMoviesName() {
        return ((List<Movie>) movieRepository.findAll())
                .stream().map(movie -> movie.getName()).collect(Collectors.toList());
    }

}
