package com.artronics.satrapi.repositories;

import com.artronics.satrapi.entities.packet.NetworkPacket;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PacketRepo extends PagingAndSortingRepository<NetworkPacket,Long>
{
}
