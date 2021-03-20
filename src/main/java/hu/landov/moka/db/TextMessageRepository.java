package hu.landov.moka.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


public interface TextMessageRepository extends CrudRepository<TextMessage,Long> {
}
