package dto;

import lombok.*;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
// "address": "string",
//         "description": "string",
//         "email": "string",
//         "id": 0,
//         "lastName": "string",
//         "name": "string",
//         "phone": "string"

public class ContactDto {
String address;
String description;
String email;
int id;
String lastName;
String name;
String phone;


//    @Nullable
//    @Override
//    public MediaType contentType() {
//        return null;
//    }
//
//    @Override
//    public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
//
 }

