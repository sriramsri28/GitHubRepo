package test123;

import java.io.IOException;

import org.testng.annotations.Test;

@Test
public class TC_1 {
	public void SuiteSetup() throws IOException, InterruptedException
	{
		//if(runmode=="remote") 
		{
			Runtime rt = Runtime.getRuntime();
	//      Runtime.getRuntime().exec(new String[] {"cmd.exe", "/C", "cd \""+path+"\" && "+command});
			//rt.exec("cmd.exe /c cd \C:\\SS\\Selenium\\testDocJenSelGrid docker-compose up -d");
//			rt.exec("cmd.exe /c notepad");
			Process process = Runtime.getRuntime().exec("cmd.exe /c cd /d C:\\SS\\Selenium\\testDocJenSelGrid && docker-compose up -d");
            process.waitFor();
            Thread.sleep(40000);
//			rt.exec("cmd.exe /c cd /d C:\\SS\\Selenium\\testDocJenSelGrid && docker-compose down");
		}
	}
	public void teardown() throws IOException, InterruptedException
	{
		//if(runmode=="remote") 
		{
			Runtime rt = Runtime.getRuntime();
	//      Runtime.getRuntime().exec(new String[] {"cmd.exe", "/C", "cd \""+path+"\" && "+command});
			//rt.exec("cmd.exe /c cd \C:\\SS\\Selenium\\testDocJenSelGrid docker-compose up -d");
//			rt.exec("cmd.exe /c notepad");
			Process process = Runtime.getRuntime().exec("cmd.exe /c cd /d C:\\SS\\Selenium\\testDocJenSelGrid && docker-compose down");
            process.waitFor();
//			rt.exec("cmd.exe /c cd /d C:\\SS\\Selenium\\testDocJenSelGrid && docker-compose down");
		}
	}
}
