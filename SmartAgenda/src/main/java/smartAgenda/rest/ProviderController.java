package smartAgenda.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.pattern.PathPatternRouteMatcher;
import smartAgenda.entities.Provider;
import smartAgenda.storage.PersonRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProviderController {
    private final PersonRepository personRepository;

    @GetMapping("providers")
    public List<Provider> getProviders() {
        //personRepository.getProviders();
        return null;
    }
}
