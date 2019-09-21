package pl.sda.clinic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import pl.sda.clinic.service.SessionUserProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

        @Autowired
        private SessionUserProvider sessionUserProvider;
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                            Authentication authentication) throws IOException, ServletException {
            sessionUserProvider.saveLoggedUser(authentication.getName());
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }

