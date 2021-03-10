package com.darksideoftherainbow.jpa;

import com.darksideoftherainbow.model.Artist;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Toan on 5/2/2017.
 */
public interface ArtistCrudRepository extends CrudRepository<Artist, Integer> {
}
