package co.com.sofka.mongo;

import co.com.sofka.model.galletas.Galleta;
import co.com.sofka.model.galletas.gateways.GalletasRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Galleta, GalletaDocument, String, MongoDBRepository>
 implements GalletasRepository {

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Galleta.class));
    }
}
