package fr.dawan.controllers;

import fr.dawan.entities.Produit;
import fr.dawan.services.ProduitService;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;




// Pour simuler les requêtes HTTP dans nos tests, on utilisera l'objet 'Mockmvc'

// SpringBootTest , nous fournir un context pour tester la couche controller
@SpringBootTest
@AutoConfigureMockMvc
class ProduitControllerTest {

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
    void getById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}