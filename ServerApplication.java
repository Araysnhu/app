package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;


@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}

@RestController
class ServerController{
    MessageDigest md = MessageDigest.getInstance("SHA-256");

    // Update digest with the data string
        md.update(data.getBytes());

    // Generate hash value of byte type
    byte[] byteHash = md.digest();

    // Convert hash value to hex
    String checksum = bytesToHex(byteHash);

    // Return response with data string, algorithm cipher, and checksum
        return "<p>data: " + data + "</p>" +
            "<p>algorithm: SHA-256</p>" +
            "<p>checksum: " + checksum + "</p>";
}
    @RequestMapping("/hash")
    public String myHash(){
    	String data = "Hello Joe Smith!";
       
        return "<p>data:"+data;
    }
}
