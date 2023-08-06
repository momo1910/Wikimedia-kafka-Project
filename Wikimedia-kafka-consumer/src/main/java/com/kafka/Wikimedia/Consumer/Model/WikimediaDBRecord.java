package com.kafka.Wikimedia.Consumer.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Wikimedia_table")
@Getter
@Setter
public class WikimediaDBRecord {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private  int id;

    @Lob
    private String data;
}
