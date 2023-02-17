package Collection_Framwork_Assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MovieDetails {
    private String movieName;
    private String actor;
    private String actress;
    private String genre;
	public MovieDetails(String movieName, String actor, String actress, String genre) {

		
		this.movieName = movieName;
		this.actor = actor;
		this.actress = actress;
		this.genre = genre;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
    
    @Override
    public String toString() {
    	String newline = System.lineSeparator();
    	return newline+"Movie_Details : "+ "Movies_Name = "+this.movieName +" , Actor_Name = "+ this.actor+", Actress_Name = "+
    			this.actress+",Movie_genre ="+this.genre+newline;
    }
}

class MovieDetailsList {
    private List<MovieDetails> movies;

    public MovieDetailsList() {
        movies = new ArrayList<>();
    }

    public void addMovie(MovieDetails movie) {
        movies.add(movie);
    }

    public void removeMovie(String movieName) {
        movies.removeIf(movie -> movie.getMovieName().equals(movieName));
    }

    public void removeAllMovies(List<MovieDetails> moviesToRemove) {
        movies.removeAll(moviesToRemove);
    }

    public MovieDetails find_movie_By_mov_Name(String movieName) {
        for (MovieDetails movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }
    public List<MovieDetails> find_movie_By_Genre(String genre) {
        List<MovieDetails> moviesByGenre = new ArrayList<>();
        for (MovieDetails movie : movies) {
            if (movie.getGenre().equals(genre)) {
                moviesByGenre.add(movie);
            }
        }
        return moviesByGenre;
    }
    public void sort(ArrayList<MovieDetails> movieDetails,Comparator<MovieDetails> movieDetailsComparator) {
    	movieDetails.sort(movieDetailsComparator);
    }

    public void removeAllMovies() {
        movies.clear();
    }
    
    public static Comparator<MovieDetails> sortAccordingly(String sortBy) {
        Comparator<MovieDetails> movieDetailsComparator;
        switch (sortBy.toLowerCase()) {
            case "name":
                movieDetailsComparator = Comparator.comparing(MovieDetails::getMovieName);
                break;
            case "actor":
                movieDetailsComparator = Comparator.comparing(MovieDetails::getActor);
                break;
            case "actress":
                movieDetailsComparator = Comparator.comparing((MovieDetails::getActress));
                break;
            case "genre":
                movieDetailsComparator = Comparator.comparing(MovieDetails::getGenre);
                break;
            default:
                movieDetailsComparator = null;
        }
        return movieDetailsComparator;
    }
}

public class Assignment3Q10{
	public static void main(String [] args) {
		ArrayList<MovieDetails>  movieDetailsList=new ArrayList<MovieDetails>();
        movieDetailsList.add(new MovieDetails("Thor:Rangrok "," Chris Hemsworth"," Natalia Portman"," Superhero-action"));
    	movieDetailsList.add(new MovieDetails("KGF-2"," Yash"," Srinidhi Shetty"," Action"));
    	movieDetailsList.add(new MovieDetails("3 idiots"," Aamir khan"," Kareena kapoor","Educational"));
    	movieDetailsList.add(new MovieDetails("Hera Pheri"," Akshay Kumar"," Tabu"," Comedy"));
    	movieDetailsList.add(new MovieDetails("Shiddat"," Sunny Kaushal"," Radhika Madan"," Romantic"));
    	
    	printSortedMovieList(movieDetailsList);
    	
	}
    	
    	public static void printSortedMovieList(ArrayList<MovieDetails> movieDetails) {
        	
        	MovieDetailsList a=new MovieDetailsList();
        	Comparator<MovieDetails> sortAccordingly = MovieDetailsList.sortAccordingly("name");
        	Comparator<MovieDetails> sortAccordingly_a = MovieDetailsList.sortAccordingly("actor");
        	for(MovieDetails movie:movieDetails)
        	{
        		a.addMovie(movie);
        	}
        	System.out.println("Sort by name :-");
        	a.sort(movieDetails,sortAccordingly);
        	for(MovieDetails movie:movieDetails)
        	{
        		System.out.println(movie);
        	}
        	System.out.println("Sort by actor :-");
        	a.sort(movieDetails,sortAccordingly_a);
        	for(MovieDetails movie:movieDetails)
        	{
        		System.out.println(movie);
        	}
        	System.out.println("Sort by actress :-");
        	a.sort(movieDetails,sortAccordingly_a);
        	for(MovieDetails movie:movieDetails)
        	{
        		System.out.println(movie);
        	}
        	
        	System.out.println("Sort by genes :-");
        	a.sort(movieDetails,sortAccordingly_a);
        	for(MovieDetails movie:movieDetails)
        	{
        		System.out.println(movie);
        	}

	}
}

	


	
