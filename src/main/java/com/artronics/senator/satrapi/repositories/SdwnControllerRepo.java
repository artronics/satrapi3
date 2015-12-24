package com.artronics.senator.satrapi.repositories;

import com.artronics.senator.satrapi.entities.SdwnController;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SdwnControllerRepo extends PagingAndSortingRepository<SdwnController,Long>, SdwnControllerCustomRepo
{
}
