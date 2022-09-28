package contact;

import com.google.gson.Gson;
import dto.ContactDto;
import dto.ErrorDto;
import dto.GetAllContactsDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHttpPOSTnewContact {

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6IlN0cmFrb3Zza2F5YS52YWxlcmlpYUBnbWFpbC5jb20ifQ.ieAauND4SFy-J0AB7TRPyOUBVRrgWFAuUFzYcF-nHYA";
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON=MediaType.get("application/json;charset=UTF-8");
    ContactDto contact = new ContactDto("Netanya", "bla bla", "dhsgj@sk.com", 1, "lastName", "Name", "0536095333");

    @Test
    public void postNewContact() throws IOException {
        RequestBody requestBody = RequestBody.create(gson.toJson(contact),JSON);

        Request request = new Request.Builder()
                .url("http://contacts-telran.herokuapp.com/api/contact")
                .addHeader("Authorization", token)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();

        ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
        System.out.println(errorDto.getCode() + "*****" + errorDto.getMessage() + "****" + errorDto.getDetails());
        Assert.assertTrue(response.isSuccessful());


        }
    }

