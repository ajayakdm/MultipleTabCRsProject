package com.blackBoard;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Generic.BaseClassLaunchBrowser;
import com.Generic.CrsLearnerFlow;

public class BBTestCases extends BaseClassLaunchBrowser
{

	BBPage all;
	CrsLearnerFlow page;
	int n=1;
//	String parentWindow=driver.getWindowHandle();
	
	@Parameters({"un","pw"})
	
	@Test (priority=1)
	public void loginIntoLMS(String un,String pw) throws Exception 
	{
		driver.get("https://qa-blackboard.cogbooks.com/");
		Thread.sleep(3000);
	    all=new BBPage(driver);
	    all.clickOnPopup();
	    all.enterUserName(un);
	    all.enterPassword(pw);
	    all.clickLoginBtn();
	}
	@Test (priority=2)
	public void selectCourse() throws Exception 
	{
		all=new BBPage(driver);
		all.clickOnCourseLink();
		Thread.sleep(2000);
		
	}

	@Test (priority=3)
	public void launchTopic1() throws Exception
	{
		all=new BBPage(driver);
		
		all.clickOnContentLink();
		all.clickOnCogBooksContentItemsFolder();
		all.clickOnTopic1();
		Thread.sleep(2000);
	}
	
	@Test (priority=4)
	public void launchTopic2() throws Exception
	{
		all=new BBPage(driver);
		all.clickOnContentLink();
		all.clickOnCogBooksContentItemsFolder();
		all.clickOnTopic2();
		
		Thread.sleep(2000);
	}
	
	@Test (priority=5)
	public void launchTopic3() throws Exception
	{
		all=new BBPage(driver);
		all.clickOnContentLink();
		all.clickOnCogBooksContentItemsFolder();
		all.clickOnTopic3();
		
		Thread.sleep(2000);
	}
	
	@Test (priority=6)
	public void launchTopic4() throws Exception
	{
		all=new BBPage(driver);
		all.clickOnContentLink();
		all.clickOnCogBooksContentItemsFolder();
		all.clickOnTopic4();
		
		Thread.sleep(2000);
	}
	

	/*
	 * @Test (priority=6) public void continueLearning() throws Exception {
	 * Thread.sleep(4000);
	 * 
	 * all=new AllPages(driver); Set<String> allWindows = driver.getWindowHandles();
	 * for(String curWindow : allWindows){ driver.switchTo().window(curWindow);}
	 * all.clickOnContinue();
	 * 
	 * }
	 */
	
	@Test(priority=7)
	public void startCourse() throws Exception 
	{
		  Thread.sleep(4000);
		  all=new BBPage(driver);
		   // hold all window handles in array list
	      ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newTb.get(1));
	      Thread.sleep(4000);
		  all.clickOnStartCourse();
		  
	      driver.switchTo().window(newTb.get(2));
	      Thread.sleep(2000);
	      all.clickOnStartCourse();
		  
	      driver.switchTo().window(newTb.get(3));
	      Thread.sleep(2000);
	      all.clickOnStartCourse();
		  
	      driver.switchTo().window(newTb.get(4));
	      Thread.sleep(2000);
	      all.clickOnStartCourse();
		  
			
		  // switch to parent window 
		  driver.switchTo().window(newTb.get(0));
		  Thread.sleep(2000);
			 
	      
	
		
		/*
		 * // String parentWindow=driver.getWindowHandle(); // Set<String> allWindows =
		 * driver.getWindowHandles(); // int size=allWindows.size(); //
		 * System.out.println("Opened windows are "+size); // Iterator<String> win=
		 * allWindows.iterator(); while(win.hasNext()) { String child_window=win.next();
		 * if(!parentWindow.equals(child_window)) {
		 * driver.switchTo().window(child_window);
		 * 
		 * System.out.println(driver.switchTo().window(child_window).getTitle());
		 * 
		 * driver.close(); }
		 */
			
		}
		
	
	
	@Test(priority=8)
	public void CourseActivity() throws Exception{
		
		CrsLearnerFlow page=new CrsLearnerFlow(driver);
		/*
		 * ExcelData exl=new ExcelData(); PrintScreen scr= new PrintScreen(); LTIPage
		 * ltiPage=new LTIPage(driver);
		 */
		
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(n));
	for (int i = 1; i <= 60; i++) {
			
			Thread.sleep(4000);
			
			try {
				
				page.moveSliderBar();
				Thread.sleep(3000);
				
				try {
					page.clickOnStartButtonOfSlider();
					Thread.sleep(3000);
				} catch (Exception e3) {
					page.clickOnReview();
					Thread.sleep(3000);
					if(page.getNextModuleText().equalsIgnoreCase("Next Sub-Topic in your learning path")) 
					{
						page.clickToNewActivity();
					}
					else if(page.getNextModuleText().equalsIgnoreCase("Next Topic in your learning path"))
					{
						page.clickToNewActivity();
					}
				}

			} catch (Exception e1) {
				try {
					page.clickOnwithoutSubmit();
					page.moveSliderBar();
					Thread.sleep(3000);
				} catch (Exception e2) {
					page.switchToFrame();
					
					page.selectAnswer();
					
					Thread.sleep(3000);
				
					//driver.switchTo().defaultContent();
					Thread.sleep(3000);
					page.switchBackToWindow();
					page.clickOnSubmitBtn();
					Alert alert = driver.switchTo().alert();
					alert.accept();
					Thread.sleep(3000);
					try {
							try {
								page.clickOnAnswerStartButton();
								Thread.sleep(3000);
								} 
							catch (Exception e5) 
								{
								page.clickOnUpNext();
								} 
						
						} 
					catch (Exception e4) 
						{
						page.clickOnReview();
						Thread.sleep(3000);
						if(page.getNextModuleText().equalsIgnoreCase("Next Sub-Topic in your learning path")) 
						{
							page.clickToNewActivity();
						}
						else if(page.getNextModuleText().equalsIgnoreCase("Next Topic in your learning path"))
						{
							page.clickToNewActivity();
						}
						}
				}
			}
			
			
			
			  if(i%4==0)
			  { 
				  try 
				  {
				  n++;
				  driver.switchTo().window(newTb.get(n));
				  Thread.sleep(3000);
				  }
				  catch(Exception e7)
				  {
					  if(i==16) 
					  {
					  i=1;
					  n=1; 
					  driver.switchTo().window(newTb.get(n));
					  } 
				  }
			  }
			  

		}
		
		

	}
	
}
