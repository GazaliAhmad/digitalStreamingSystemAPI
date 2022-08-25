# Current State

@26/08/2020

Doing the ManyToMany relationship. It's not up to the requirements yet.

- Movies can have many Actors.
- Actors can have many Movies.

## Add actor to movie
The Json is: 
```JSON
{
    "actor_id": 6,
    "movies": [
        {
            "movie_id": 2,
            "movie_title": "Happy Beaver Goes to Town",
            "movie_cost": 55,
            "movie_year": 1995
        }
    ],
    "first_name": "Sean",
    "last_name": "Pean",
    "gender": "M",
    "age": 37
}
```
The result is 200. But when get all actors, the movie array is empty. Check DB and not result. Data is not written, and yet I get a 200 success.

## Add movie to actor
The Json is:

```JSON
{
    "movie_id": 5,
    "actors": [
        {
            "actor_id": 7,
            "first_name": "Gregory",
            "last_name": "Peck",
            "gender": "M",
            "age": 77
        }
    ],
    "movie_title": "Power Play",
    "movie_cost": 15,
    "movie_year": 2001
}
```
The result is 500.

## Attempt

Reread on the ManyToMany relationship. Key table is the MoviesActors. It is not created in the Schema.