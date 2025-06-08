package com.starttohkar.learn;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        if(m1.getRating() < m2.getRating())
            return -1;
        else if(m1.getRating()> m2.getRating())
            return 1;
        else
            return 0;
    }
}

class NameCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2)
    {
        return m1.getName().compareTo(m2.getName());
    }
}