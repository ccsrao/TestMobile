package Selenium4;

import java.net.URI;
import java.util.Map;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

public class Selenium4 {
	public static String xmlFile(String gitRepoURL, String gitBranch, String tomaCatURL, int tomCatVersion, String credentialsID) {
		String xmlFile = "<?xml version='1.1' encoding='UTF-8'?>\r\n" + 
				"<maven2-moduleset plugin=\"maven-plugin@3.2\">\r\n" + 
				"  <actions/>\r\n" + 
				"  <description></description>\r\n" + 
				"  <keepDependencies>false</keepDependencies>\r\n" + 
				"  <properties/>\r\n" + 
				"  <scm class=\"hudson.plugins.git.GitSCM\" plugin=\"git@3.9.1\">\r\n" + 
				"    <configVersion>2</configVersion>\r\n" + 
				"    <userRemoteConfigs>\r\n" + 
				"      <hudson.plugins.git.UserRemoteConfig>\r\n" + 
				"        <url>" + gitRepoURL + "</url>\r\n" + 
				"      </hudson.plugins.git.UserRemoteConfig>\r\n" + 
				"    </userRemoteConfigs>\r\n" + 
				"    <branches>\r\n" + 
				"      <hudson.plugins.git.BranchSpec>\r\n" + 
				"        <name>*/" + gitBranch + "</name>\r\n" + 
				"      </hudson.plugins.git.BranchSpec>\r\n" + 
				"    </branches>\r\n" + 
				"    <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>\r\n" + 
				"    <submoduleCfg class=\"list\"/>\r\n" + 
				"    <extensions/>\r\n" + 
				"  </scm>\r\n" + 
				"  <canRoam>true</canRoam>\r\n" + 
				"  <disabled>false</disabled>\r\n" + 
				"  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>\r\n" + 
				"  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>\r\n" + 
				"  <triggers>\r\n" + 
				"    <com.cloudbees.jenkins.GitHubPushTrigger plugin=\"github@1.29.3\">\r\n" + 
				"      <spec></spec>\r\n" + 
				"    </com.cloudbees.jenkins.GitHubPushTrigger>\r\n" + 
				"  </triggers>\r\n" + 
				"  <concurrentBuild>false</concurrentBuild>\r\n" + 
				"  <goals>clean install</goals>\r\n" + 
				"  <aggregatorStyleBuild>true</aggregatorStyleBuild>\r\n" + 
				"  <incrementalBuild>false</incrementalBuild>\r\n" + 
				"  <ignoreUpstremChanges>true</ignoreUpstremChanges>\r\n" + 
				"  <ignoreUnsuccessfulUpstreams>false</ignoreUnsuccessfulUpstreams>\r\n" + 
				"  <archivingDisabled>false</archivingDisabled>\r\n" + 
				"  <siteArchivingDisabled>false</siteArchivingDisabled>\r\n" + 
				"  <fingerprintingDisabled>false</fingerprintingDisabled>\r\n" + 
				"  <resolveDependencies>false</resolveDependencies>\r\n" + 
				"  <processPlugins>false</processPlugins>\r\n" + 
				"  <mavenValidationLevel>-1</mavenValidationLevel>\r\n" + 
				"  <runHeadless>false</runHeadless>\r\n" + 
				"  <disableTriggerDownstreamProjects>false</disableTriggerDownstreamProjects>\r\n" + 
				"  <blockTriggerWhenBuilding>true</blockTriggerWhenBuilding>\r\n" + 
				"  <settings class=\"jenkins.mvn.DefaultSettingsProvider\"/>\r\n" + 
				"  <globalSettings class=\"jenkins.mvn.DefaultGlobalSettingsProvider\"/>\r\n" + 
				"  <reporters/>\r\n" + 
				"  <publishers>\r\n" + 
				"    <hudson.plugins.deploy.DeployPublisher plugin=\"deploy@1.15\">\r\n" + 
				"      <adapters>\r\n" + 
				"        <hudson.plugins.deploy.tomcat.Tomcat" + tomCatVersion + "xAdapter>\r\n" + 
				"          <credentialsId>" + credentialsID+ "</credentialsId>\r\n" + 
				"          <url> " + tomaCatURL + "</url>\r\n" + 
				"          <path></path>\r\n" + 
				"        </hudson.plugins.deploy.tomcat.Tomcat" + tomCatVersion + "xAdapter>\r\n" + 
				"      </adapters>\r\n" + 
				"      <contextPath>smartqe</contextPath>\r\n" + 
				"      <war>**/*.war</war>\r\n" + 
				"      <onFailure>false</onFailure>\r\n" + 
				"    </hudson.plugins.deploy.DeployPublisher>\r\n" + 
				"  </publishers>\r\n" + 
				"  <buildWrappers/>\r\n" + 
				"  <prebuilders/>\r\n" + 
				"  <postbuilders/>\r\n" + 
				"  <runPostStepsIfResult>\r\n" + 
				"    <name>FAILURE</name>\r\n" + 
				"    <ordinal>2</ordinal>\r\n" + 
				"    <color>RED</color>\r\n" + 
				"    <completeBuild>true</completeBuild>\r\n" + 
				"  </runPostStepsIfResult>\r\n" + 
				"</maven2-moduleset>";

		return xmlFile;
	}

	// public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		/*
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 * driver.manage().window().maximize();
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\Administrator\\Downloads\\chromedriver.exe"); driver=new
		 * ChromeDriver(); //driver.manage().timeouts().implicitlyWait(15,
		 * TimeUnit.SECONDS); driver.get("https://www.google.com/"); WebElement test =
		 * driver.findElement(By.xpath(
		 * "//img[@src='/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png']")
		 * ); File testt = test.getScreenshotAs(OutputType.FILE); Files.copy(testt, new
		 * File(System.getProperty("user.dir") + File.separator + "Reports" +
		 * File.separator + "testt.png"));
		 */
		@SuppressWarnings("resource")
		JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080/"), "chandra", "Sekhar@123");
		Map<String, Job> jobs = jenkins.getJobs();
		//System.out.println(jobs);String xmlf = jenkins.getJobXml("JenkinsGitPoll");
		//System.out.println("xml file :" + xmlf);
		
		final String secretKey = "";
	    String originalString = "test/test";
	    String encryptedString = AES.encrypt(originalString, secretKey) ;
	    String decryptedString = AES.decrypt(encryptedString, secretKey) ;
	     
	    System.out.println(originalString);
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);
	    String xml = xmlFile("https://github.com/ccsrao/JenkinsWar.git", "master", "http://localhost:8081/", 8, "globalcheck1");
		String jobName = "wartomcat";
		if (!jobs.toString().contains(jobName)) {
			jenkins.createJob(jobName, xml);
		}
		Map<String, Job> newJobs = jenkins.getJobs();
		JobWithDetails job = newJobs.get(jobName).details();
		String xmlf = jenkins.getJobXml(jobName);
		System.out.println("xml file :" + xmlf);
		job.build();
		System.out.println("job " + job.getName() + " is being build.. please go and check on jenkins portal.");
	}
}
