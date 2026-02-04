package com.example.demo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController()

public class Hello
{
	@GetMapping("/")
	public String check()
	{
		return "Hello Testing 1 2 3 . . . . . ";
	}
}

