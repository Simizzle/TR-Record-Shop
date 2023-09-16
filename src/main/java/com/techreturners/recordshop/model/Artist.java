package com.techreturners.recordshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Artist {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private String altName;
    @OneToMany(mappedBy = "artist", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Album> albums = new ArrayList<>();

}
