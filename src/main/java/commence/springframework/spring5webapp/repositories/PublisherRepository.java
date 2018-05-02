package commence.springframework.spring5webapp.repositories;

import commence.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.client.MultipartBodyBuilder;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
