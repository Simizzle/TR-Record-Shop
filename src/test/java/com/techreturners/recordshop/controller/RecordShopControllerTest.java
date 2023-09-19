package com.techreturners.recordshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.recordshop.model.Album;
import com.techreturners.recordshop.model.Format;
import com.techreturners.recordshop.model.Genre;
import com.techreturners.recordshop.service.RecordShopServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class RecordShopControllerTest {

    @Mock
    private RecordShopServiceImpl mockRecordShopServiceImpl;

    @InjectMocks
    private RecordShopController recordShopController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(recordShopController).build();
        mapper = new ObjectMapper();
    }

    @Test
    public void testGetAllAlbumsReturnsAlbums() throws Exception {

        List<Album> albums = new ArrayList<>();
        albums.add(new Album(1L, "Oasis", "Definitely Maybe", Genre.INDIE, 1994, "Creation", List.of(Format.CD)));
        albums.add(new Album(2L, "Moderat", "II", Genre.ELECTRONIC, 2013, "Monkeytown Records", List.of(Format.VINYL, Format.CD)));
        albums.add(new Album(3L, "Radiohead", "OK Computer", Genre.INDIE, 1997, "Parlaphone", List.of(Format.CD, Format.VINYL)));

        when(mockRecordShopServiceImpl.getAllAlbums()).thenReturn(albums);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/recordshop/albums/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artist").value("Oasis"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artist").value("Moderat"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].artist").value("Radiohead"));
    }
}
