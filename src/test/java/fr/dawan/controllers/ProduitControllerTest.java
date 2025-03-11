package fr.dawan.controllers;

import fr.dawan.entities.Produit;
import fr.dawan.services.ProduitService;
import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;




// Pour simuler les requêtes HTTP dans nos tests, on utilisera l'objet 'Mockmvc'

// SpringBootTest , nous fournir un context pour tester la couche controller

// Convention de nommage de la class: doit se termine par 'IT'
// Les outils qui génère des rapports de tests se basent sur le 'IT' pour fonctionner et différencier les controllersTests

@SpringBootTest
@AutoConfigureMockMvc
class ProduitControllerTestIT {

    @Autowired
    ProduitController controller;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProduitService produitService;

    private List<Produit> products = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        products.add(new Produit(1L, "produitTestController", 12.0 ));
        products.add(new Produit(2L, "produitTestController2", 16.0 ));
    }

    // Vérifier que mon controller est chargé correctement
    @Test
    void contextLoads() { assertThat(controller).isNotNull(); }

    // Tester le getAll() GET: /api/produits
    @Test
    void getAll() throws Exception {
    // S'il y a un appel à userService.getAll() => retourner une liste de products (notre liste 'products' )
    when(produitService.getAll()).thenReturn(products);

        mockMvc.perform(get("/api/produits"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(products.size())))
                .andExpect(jsonPath("$[0].nom", is(products.get(0).getNom())));


    }

    @Test
    void getById_TestOK() throws Exception {
        // S'il y a un appel à userService.getById(2) ==> retourner l'élément de la liste

       Long productId = 2L;
       when(produitService.getById(productId)).thenReturn(products.get(1));


        mockMvc.perform(get("/api/produits/{id}", productId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nom", is(products.get(1).getNom())))
            .andExpect(jsonPath("$.prix", is(products.get(1).getPrix())));
//           .andExpect(jsonPath("$.id", is(products.get(1).getId()));
    }

    @Test
    void getById_ProductNotFound() throws Exception {
        Long productId = 10L;
        when(produitService.getById(productId)).thenReturn(null);

        String res =  mockMvc.perform(get("/api/produits/{id}", productId))
                .andExpect(status().isNotFound())
                .andReturn().getResponse().getContentAsString();

        assertEquals("Produit avec id 10 introuvable", res );
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete_OK() throws Exception {
        Long productId = 2L;
        doNothing().when(produitService).delete(productId);

        String res = mockMvc.perform(get("/api/produits/{id}", productId))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals("suppression OK", res);

    }
}