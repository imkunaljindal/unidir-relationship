package com.example.unidirapp;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_id",referencedColumnName = "id")
    List<CricketMatch> cricketMatches = new ArrayList<>();
}
