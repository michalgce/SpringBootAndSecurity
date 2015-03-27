package pl.majkel.managers;

import org.springframework.stereotype.Component;

@Component
public class HelloManagerImpl implements HelloManager {

    @Override
    public String randomString() {
        return "SIEMA_TESTY";
    }
}
