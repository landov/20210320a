package hu.landov.moka;

import com.google.common.collect.Lists;
import hu.landov.moka.db.TextMessageRepository;
import hu.landov.moka.db.TextMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    @Autowired
    TextMessageRepository repository;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TextMessages listData() {
        return new TextMessages(Lists.newArrayList(repository.findAll()));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/xlist", method = RequestMethod.GET)
    @ResponseBody
    public TextMessages xlistData() {
        return new TextMessages(Lists.newArrayList(repository.findAll()));
    }
}
