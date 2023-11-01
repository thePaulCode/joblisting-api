package dev.thepaulcode.joblisting.model.repository;

import dev.thepaulcode.joblisting.model.JobListing;

import java.util.List;

public interface SearchRepository {
    // Esta é uma interface chamada SearchRepository.

    List<JobListing> findByText(String text);
    // Declara um método chamado 'findByText', que espera receber um texto como argumento.
    // Esse método é projetado para realizar uma pesquisa com base no texto fornecido e retornar uma lista de objetos do tipo JobListing.
}
