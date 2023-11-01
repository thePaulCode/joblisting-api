package dev.thepaulcode.joblisting.model.repository;

import dev.thepaulcode.joblisting.model.JobListing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobListingRepository extends MongoRepository<JobListing, String> {
    // Esta é uma interface que estende a MongoRepository e é usada para interagir com o banco de dados MongoDB.

    // Ela é parametrizada com dois tipos:
    // 1. JobListing: Tipo da entidade que esta interface irá gerenciar no banco de dados.
    // 2. String: Tipo da chave primária da entidade, que é usada para identificar registros no banco.

    // Esta interface herda métodos de alto nível do MongoRepository para realizar operações de CRUD (Create, Read, Update, Delete)
    // no banco de dados MongoDB relacionadas à entidade JobListing.

    // Não há necessidade de implementar explicitamente os métodos de CRUD, pois o Spring Data MongoDB fornece uma implementação
    // padrão para esses métodos com base na definição da interface.

    // Essa interface fornece métodos para buscar, salvar, atualizar e excluir registros da coleção "JobPost" no banco de dados MongoDB,
    // onde a entidade JobListing é mapeada.

    // Qualquer classe que injete ou dependa desta interface pode facilmente realizar operações de banco de dados relacionadas
    // à entidade JobListing sem escrever código de acesso ao banco de dados personalizado.
}

