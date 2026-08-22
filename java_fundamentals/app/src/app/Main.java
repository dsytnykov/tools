package app;

import utils.MessageService;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.example.greeting.Greeting;

public class Main {
	public static void main(String[] args) throws Exception {
		MessageService ms = new MessageService();
		System.out.println(ms.getMessage());
		
		System.out.println(Greeting.greet("Java Developer"));
		
		InputStream is = Main.class.getClassLoader().getResourceAsStream("message.txt");
		if (is == null) {
			throw new RuntimeException("message.txt not found");
		}
		
		String text = new String(is.readAllBytes(), StandardCharsets.UTF_8);
		
		System.out.println(text);
	}
}