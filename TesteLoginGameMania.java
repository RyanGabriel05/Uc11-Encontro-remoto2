package br.senai.sp.testepagina;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLoginGameMania {

private  WebDriver driver;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestarLogin() {
		driver.get("http://localhost:4200/");
		
		driver.findElement(By.xpath("/html/body/app-root/app-header/header/div/nav/a[4]")).click();
		
		// Primeiro Teste
		WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement inputSenha = driver.findElement(By.xpath("//*[@id=\"senha\"]"));
		WebElement botao = driver.findElement(By.xpath("/html/body/app-root/app-login/div/form[1]/button"));
		
		String[] listaSenhas = {"batata", "batata", "ryan"};
						
		for(int tentativas = 0; tentativas < 3; tentativas++) {
			try {
				
				inputEmail.clear();
				inputSenha.clear();
				
				inputEmail.sendKeys("ryan@mail.com");
				//inputSenha.sendKeys("batata");
				inputSenha.sendKeys(listaSenhas[tentativas]);
				botao.click();
				
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		
		WebElement mensagem = driver.findElement(By.id("mensagem"));
		
		System.out.println(mensagem.getText());
	}
}
