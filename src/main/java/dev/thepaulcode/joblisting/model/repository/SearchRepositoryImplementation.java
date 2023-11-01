package dev.thepaulcode.joblisting.model.repository;

import com.mongodb.client.MongoClient;
import dev.thepaulcode.joblisting.model.JobListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;

/*
 * Requires the MongoDB Java Driver.
 * https://mongodb.github.io/mongo-java-driver
 */
@Component
public class SearchRepositoryImplementation implements SearchRepository {
    // Esta classe é uma implementação de SearchRepository e é um componente Spring gerenciado.

    @Autowired
    MongoClient client;
    // Injeta a instância do MongoClient, que é usado para se conectar ao banco de dados MongoDB.

    @Autowired
    MongoConverter converter;
    // Injeta o conversor MongoConverter, que é usado para converter documentos MongoDB em objetos Java.

    @Override
    public List<JobListing> findByText(String text) {
        // Este método realiza uma pesquisa no banco de dados MongoDB com base no texto fornecido.

        final List<JobListing> posts = new ArrayList<>();
        // Cria uma lista vazia para armazenar as vagas de emprego encontradas.

        MongoDatabase database = client.getDatabase("thepaulcode");
        // Obtém uma instância do banco de dados "thepaulcode" do MongoDB.

        MongoCollection<Document> collection = database.getCollection("JobPost");
        // Obtém uma coleção chamada "JobPost" no banco de dados.

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 2L)));
        // Cria uma agregação no banco de dados para realizar a pesquisa, classificar os resultados e limitar o número de documentos retornados.

        result.forEach(doc -> posts.add(converter.read(JobListing.class, doc)));
        // Itera sobre os documentos retornados e converte cada documento em um objeto JobListing usando o MongoConverter, adicionando-o à lista posts.

        return posts;
        // Retorna a lista de vagas de emprego encontradas.
    }
}

