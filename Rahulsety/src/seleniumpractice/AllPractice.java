package seleniumpractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AllPractice {
	WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		AllPractice all=new AllPractice();
		//all.radio();
		//all.radioAll();
		//all.dropdown();
		//all.windowhandle();
		//all.tab();
		//all.popuphandle();
		//all.isdesplayed();
		//all.mouseover();
		all.frame();

	}
	
	public  void browser_hiturl()
	{
		driver=   new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

	}
	public void radio()
	{
		browser_hiturl();
		driver.findElement(By.xpath("//label[@for='radio1']//input[@name='radioButton']")).click();

	}
	public void radioAll()
	{
		browser_hiturl();
		List<WebElement> radio=		driver.findElements(By.xpath("//input[@name='radioButton']"));
		for(int i=1; i<=radio.size()-1; i++)
		{
			WebElement r=  radio.get(i);  
			r.click();
		}
	}

	public void dropdown()
	{
		browser_hiturl();
		WebElement sel= driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select drop1= new Select(sel);
		drop1.selectByIndex(1);

	}

	public void windowhandle()
	{
		browser_hiturl();
		driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		Set<String> windowvalue= driver.getWindowHandles();
		for (String string : windowvalue) {
			driver.switchTo().window(string);
			if(driver.getTitle().equalsIgnoreCase("QAClick Academy - A Testing Academy to Learn, Earn and Shine"))
			{
				break;   
			}
		}
		driver.findElement(By.xpath("//a[text()='Access all our Courses']/parent::div/preceding-sibling::div/parent::div/parent::div/preceding-sibling::div/parent::div/parent::div/parent::div/following-sibling::div//div//div//div//nav//button/following-sibling::div//ul//li/following-sibling::li//a[text()='Courses']")).click();

	}

	public void tab()
	{
		browser_hiturl();
		driver.findElement(By.xpath("//a[text()='Open Tab']")).click();
		ArrayList<String> tabs=     new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//a[text()='Access all our Courses']/parent::div/preceding-sibling::div/parent::div/parent::div/preceding-sibling::div/parent::div/parent::div/parent::div/following-sibling::div//div//div//div//nav//button/following-sibling::div//ul//li/following-sibling::li//a[text()='Courses']")).click();
		driver.switchTo().window(tabs.get(0));
		WebElement sel= driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select drop1= new Select(sel);
		drop1.selectByIndex(1);  
	}

	public void popuphandle() throws InterruptedException
	{
		browser_hiturl();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Kishan");
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();

	}

	public void isdesplayed()
	{
		browser_hiturl();
		driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		WebElement ele=	driver.findElement(By.xpath("//input[@id='displayed-text']"));
		if(ele.isDisplayed()==true)
		{
			System.out.println("Element is displayed");	 
		}else
		{
			System.out.println("Element is not displayed");
		}

	}

	public void mouseover()
	{
		browser_hiturl();
		Actions ac=	    new Actions(driver);
	WebElement	scroll= driver.findElement(By.xpath("//legend[text()='iFrame Example']"));
	     ac.scrollToElement(scroll).build().perform();
		WebElement mouse=		driver.findElement(By.xpath("//button[@id='mousehover']"));
	   ac.moveToElement(mouse).build().perform();
	   driver.findElement(By.xpath("//a[text()='Top']")).click();
	
	}
	
	public void frame()
	{
		browser_hiturl();
		driver.switchTo().frame(0);
WebElement	frame=driver.findElement(By.xpath("//span[@class='fa fa-linkedin']/parent::a/parent::li/preceding-sibling::li/parent::ul/parent::div/preceding-sibling::div/parent::div//parent::div/parent::div/following-sibling::div//div//div//div/following-sibling::div//nav//div/following-sibling::div//ul//following-sibling::li//following-sibling::li/following-sibling::li/following-sibling::li/following-sibling::li/following-sibling::li/following-sibling::li/following-sibling::li//a[text()='Blog']"));
       frame.click(); 
	}



}
