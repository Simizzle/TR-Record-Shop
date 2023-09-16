package com.techreturners.recordshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artist {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private String id;
    @Column
    private String name;
    @Column
    private String altName;

    @OneToMany(mappedBy = "artist", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Album> albums = new ArrayList<>();

}
