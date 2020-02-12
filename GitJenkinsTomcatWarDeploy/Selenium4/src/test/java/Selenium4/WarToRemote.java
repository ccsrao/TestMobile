package Selenium4;

import java.net.URI;
import java.util.Map;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;

import com.offbytwo.jenkins.model.JobWithDetails;

public class WarToRemote {
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
				"  <rootModule>\r\n" + 
				"    <groupId>com.mcnz.rps.web</groupId>\r\n" + 
				"    <artifactId>roshambo</artifactId>\r\n" + 
				"  </rootModule>\r\n" + 
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
				"          <credentialsId>" + credentialsID + "</credentialsId>\r\n" + 
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
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
	  JenkinsServer jenkinsServer = new JenkinsServer(new URI("Jenkins URL *******"), "jenkinsusername******", "JenkinsPassword");
		Map<String, Job> allJobs = jenkinsServer.getJobs();
		String xml = xmlFile("gitRepoURL*********", "git Repo branch ****", "Tomacat Server URL ****", 8, "Credentials ID *****" ); //"int tomcat version 8, 9"
		String jobName = "jobName****";

		if (!allJobs.toString().contains(jobName)) {
			jenkinsServer.createJob(jobName, xml);
		}
		Map<String, Job> newJobs = jenkinsServer.getJobs();
		JobWithDetails job = newJobs.get(jobName).details();
		job.build();
		
		System.out.println("Job is : " + job.getName() + " : is being build.. please go and check on jenkins server.");
	}
}
