package contact;

import com.google.gson.Gson;
import dto.ContactDto;
import dto.ErrorDto;
import dto.GetAllContactsDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHttpGetAllContacts {

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6IlN0cmFrb3Zza2F5YS52YWxlcmlpYUBnbWFpbC5jb20ifQ.ieAauND4SFy-J0AB7TRPyOUBVRrgWFAuUFzYcF-nHYA";

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();


    @Test
    public void getAllContacts() throws IOException {

        Request request = new Request.Builder()
                .url("https://contacts-telran.herokuapp.com/api/contact")
                .addHeader("Authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        ErrorDto errorDto = gson.fromJson(response.body().string(), ErrorDto.class);
        System.out.println(errorDto.getCode() + " **** " + errorDto.getMessage() + " **** " + errorDto.getDetails());
        Assert.assertTrue(response.isSuccessful());


        GetAllContactsDto contacts = gson.fromJson(response.body().string(), GetAllContactsDto.class);

        for (ContactDto contactDto : contacts.getContacts()) {
            System.out.println(contactDto.getId());
            System.out.println(contactDto.getPhone());
            System.out.println("==========================");
        }
    }
}
