package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.HousingReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingReplyRepository extends JpaRepository<HousingReply, Long> {
}
