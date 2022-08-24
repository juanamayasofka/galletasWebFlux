package co.com.sofka.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Component;

@Component
public interface MongoDBRepository extends ReactiveMongoRepository<GalletaDocument, String>,
        ReactiveQueryByExampleExecutor<GalletaDocument> {
}
