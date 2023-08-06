package com.kafka.Wikimedia.Consumer.Repository;

import com.kafka.Wikimedia.Consumer.Model.WikimediaDBRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiMediaRepostory extends JpaRepository<WikimediaDBRecord,Integer> {
}
