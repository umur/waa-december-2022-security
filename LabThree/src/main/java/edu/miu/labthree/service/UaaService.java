package edu.miu.labthree.service;

import edu.miu.labthree.model.SignInRequest;
import edu.miu.labthree.model.SignInResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public interface UaaService {
    SignInResponse accessToken(SignInRequest req) throws Exception;
    SignInResponse refreshToken(SignInResponse res);
}
