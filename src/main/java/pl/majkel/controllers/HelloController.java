package pl.majkel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.majkel.dtos.EmptyResponseDto;
import pl.majkel.dtos.enums.Status;
import pl.majkel.managers.HelloManager;

@RestController
@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
public class HelloController extends ApiController {

    @Autowired
    protected HelloManager helloManager;

    @ResponseBody
    @RequestMapping(value = "/test")
    public EmptyResponseDto hello() {
        EmptyResponseDto emptyResponseDto = new EmptyResponseDto();
        emptyResponseDto.setStatus(Status.ERROR_EMAIL_TAKEN);
        emptyResponseDto.setExtras(helloManager.randomString());

        return emptyResponseDto;
    }
}
