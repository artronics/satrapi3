package com.artronics.senator.satrapi.repositories;

import com.artronics.senator.satrapi.entities.PacketModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PacketRepo extends PagingAndSortingRepository<PacketModel,Long>
{
}
