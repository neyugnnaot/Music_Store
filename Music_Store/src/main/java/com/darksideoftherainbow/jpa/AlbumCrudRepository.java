package com.darksideoftherainbow.jpa;

import com.darksideoftherainbow.model.Album;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Toan on 4/28/2017.
 */
public interface AlbumCrudRepository extends CrudRepository<Album, Integer> {


}
