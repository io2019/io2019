package net.io.kino.service.impl;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;

public class PayPalClientServiceImpl {

    private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
            "AWOmw_Y6KJATjfP5IPSXF4Zf0p2lVa4byHc2O4q9sJq7B7Afd6pMuQ8AWu1vcVeiwRK3TA3fKv25mb3L",
            "EI1xE6hmO_F9mcnJyBNPWP1kboHfLXxzg9ZgTq-4cRkf2anhGGbRA8VN2paFFsi8rr5SGCdi9jvGPy8i");

    PayPalHttpClient client = new PayPalHttpClient(environment);

    public PayPalHttpClient client() {
        return this.client;
    }
}
