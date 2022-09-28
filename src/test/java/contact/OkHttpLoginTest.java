package contact;

import com.google.gson.Gson;
import dto.AuthResponceDto;
import dto.AuthrequestDto;
import dto.ErrorDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHttpLoginTest {
    Gson gson= new Gson();
    OkHttpClient client=new OkHttpClient();
//    String email = "Strakovskaya.valeriia@gmail.com";
//    String password = "BigBubbles~182";
    public static final MediaType JSON =MediaType.get("application/json;charset=UTF-8");

//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6IlN0cmFrb3Zza2F5YS52YWxlcmlpYUBnbWFpbC5jb20ifQ.ieAauND4SFy-J0AB7TRPyOUBVRrgWFAuUFzYcF-nHYA
    @Test
    public void loginTest() throws IOException {
        AuthrequestDto authrequestDto= AuthrequestDto.builder()
                .email("Strakovskaya.valeriia@gmail.com")
                .password("BigBubbles~182")
                .build();


        RequestBody requestBody = RequestBody.create(gson.toJson(authrequestDto),JSON);

        Request request = new Request.Builder()
                .url("http://contacts-telran.herokuapp.com/api/login")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        if(response.isSuccessful()) {
            String responseJason = response.body().string();

            AuthResponceDto responseDto = gson.fromJson(responseJason, AuthResponceDto.class);
            System.out.println(responseDto.getToken());
            System.out.println(response.code());

            Assert.assertTrue(response.isSuccessful());
        }else{
            System.out.println("Response code is ===> "+response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(),ErrorDto.class);
            System.out.println(errorDto.getCode() + "*****"+ errorDto.getMessage()+"****"+errorDto.getDetails());
            Assert.assertTrue(response.isSuccessful());
        }


    }


}
