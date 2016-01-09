package Main;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface VisitorDescriptorRepository extends MongoRepository<VisitorDescriptor, String> {

    VisitorDescriptor findByTimestamp(Timestamp timestamp);

    List<VisitorDescriptor> findByData(String data);

    List<VisitorDescriptor> findAll();

    VisitorDescriptor save(VisitorDescriptor saved);
}