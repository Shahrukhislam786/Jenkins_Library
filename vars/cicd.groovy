def newDownload(repo)
{
  git 'https://github.com/Shahrukhislam786/${repo}'
}

def newBuild()
{
  sh 'mvn package'
}

def newDeployment(jobname,ip,appname)
{
  sh 'scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${appname}.war'
}

def runSelenium(jobname)
{
  sh 'java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar'
}
