package com.APITesting;

import com.google.gson.Gson;
import com.qmetry.qaf.automation.ws.rest.RestWSTestCase;
import com.sun.jersey.api.client.ClientResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GET extends RestWSTestCase {

    @Test
    public void run(){

        Map<String, String> data = new HashMap<String, String>();
        data.put("clientName", "Amit");
        data.put("amount", "100");
        //create post request
        getWebResource("/orders.json").post(new Gson().toJson(data));

        //verify response
        verifyThat("Response Status", getResponse().getStatus(), Matchers.equalTo(ClientResponse.Status.CREATED));
    }

}
