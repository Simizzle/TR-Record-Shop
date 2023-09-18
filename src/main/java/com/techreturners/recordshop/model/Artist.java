package com.techreturners.recordshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column
    private String artistName;
    @Column
    private String altName;

//    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private Set<Album> albums;
}
