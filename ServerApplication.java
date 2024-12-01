package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}

@RestController
class ServerController {
    // Refactored code to include hash function for checksum
    @RequestMapping("/hash")
    public String myHash() throws NoSuchAlgorithmException {
        String data = "YourFirstName YourLastName"; // Replace with your first and last name

        // Create MessageDigest object with SHA-256 algorithm
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

    // Function to convert byte array to hex string
    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}