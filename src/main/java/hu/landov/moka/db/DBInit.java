package hu.landov.moka.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DBInit {
    @Autowired
    TextMessageRepository messageRepository;

    @PostConstruct
    private void Init(){
        messageRepository.save(new TextMessage("Némi adat:"));
        messageRepository.save(new TextMessage("Helló Simon!"));
    }
}
