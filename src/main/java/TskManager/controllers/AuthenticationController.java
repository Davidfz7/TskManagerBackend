package TskManager.controllers;

import TskManager.auth.AuthenticationRequest;
import TskManager.auth.AuthenticationResponse;
import TskManager.auth.RegisterRequest;
import TskManager.services.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request
    ) {
        var testing = authService.register(request);
        if(testing == null){
            return "duplicate_user";
        }
        return "all_fine";
    }

    @PostMapping("/authenticate")
    public String  authenticate(
            @RequestBody AuthenticationRequest request
    ) {
       var testing = authService.authenticate(request);
       if(testing == null){
           return "notfound";
       }
       
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String currentPrincipalName = authentication.getName();
       System.out.println(currentPrincipalName);
       
       return "success";
    }
    


}
