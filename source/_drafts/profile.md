title: Profile
date: 2016-08-23 11:03:30
categories: [后端]
tags: [Linux]
---

```shell
LANG=C
JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/
PATH=$PATH:$JAVA_HOME/bin
PATH="/usr/local/node/bin:$PATH"

Ver="dev"


#export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/usr/local/apr/lib:${HOME}/apache-tomcat-7.0.39/native/lib
alias stopscm="${HOME}/apache-tomcat-7.0.39/bin/shutdown.sh;${HOME}/killtomcat.sh;"
alias startscm="rm -fr ${HOME}/apache-tomcat-7.0.39/logs/catalina.out;rm -fr ${HOME}/apache-tomcat-7.0.39/work/*; ${HOME}/apache-tomcat-7.0.39/bin/startup.sh;tail -f  ${HOME}/apache-tomcat-7.0.39/logs/catalina.out"
alias restartscm="stopscm;copyscm;startscm;";

function updatescm()
{
        cd ${HOME}/project/SCM-top;
        echo "pwd is :";
        pwd;
        echo "git pull:";
        git pull;

        echo "remove war with quantz";
        rm -rf ${HOME}/project/SCM-top/SCM-cnorder/target/SCM-cnorder-${Ver}/*
        rm -rf ${HOME}/project/SCM-top/SCM-usorder/target/SCM-usorder-${Ver}/*
        rm -rf ${HOME}/project/SCM-top/SCM-jporder/target/SCM-jporder-${Ver}/*
        rm -rf ${HOME}/project/SCM-top/SCM-cnshipping/target/SCM-cnshipping-${Ver}/*
        rm -rf ${HOME}/project/SCM-top/SCM-usshipping/target/SCM-usshipping-${Ver}/*

        echo "remove war without quantz";
        rm -rf ${HOME}/project/SCM-top/SCM-usorder/target/SCM-usorder-${Ver}/noquantz/*
        rm -rf ${HOME}/project/SCM-top/SCM-jporder/target/SCM-jporder-${Ver}/noquantz/*
        rm -rf ${HOME}/project/SCM-top/SCM-usshipping/target/SCM-usshipping-${Ver}/noquantz/*

        echo "remove all war"
        rm -rf ${HOME}/project/war/*
        rm -rf ${HOME}/project/war/noquantz/*

        if [ ! -n "$1" ] ;then
            mvn clean package -P ${Ver};
            
            echo "copy war with quantz";
            cp -r ${HOME}/project/SCM-top/SCM-cnorder/target/SCM-cnorder-${Ver}/SCM-cnorder.war ${HOME}/project/war/
            cp -r ${HOME}/project/SCM-top/SCM-usorder/target/SCM-usorder-${Ver}/SCM-usorder.war ${HOME}/project/war/
            cp -r ${HOME}/project/SCM-top/SCM-jporder/target/SCM-jporder-${Ver}/SCM-jporder.war ${HOME}/project/war/
            cp -r ${HOME}/project/SCM-top/SCM-cnshipping/target/SCM-cnshipping-${Ver}/SCM-cnshipping.war ${HOME}/project/war/
            cp -r ${HOME}/project/SCM-top/SCM-usshipping/target/SCM-usshipping-${Ver}/SCM-usshipping.war ${HOME}/project/war/

            echo "copy war without quantz";
            cp -r ${HOME}/project/SCM-top/SCM-usorder/target/SCM-usorder-${Ver}/noquantz/SCM-usorder.war ${HOME}/project/war/noquantz/
            cp -r ${HOME}/project/SCM-top/SCM-jporder/target/SCM-jporder-${Ver}/noquantz/SCM-jporder.war ${HOME}/project/war/noquantz/
            cp -r ${HOME}/project/SCM-top/SCM-usshipping/target/SCM-usshipping-${Ver}/noquantz/SCM-usshipping.war ${HOME}/project/war/noquantz/
        else
            mvn clean package -P ${Ver} -pl ${1} -am;
            
            echo "copy war with quantz";
            cp -r ${HOME}/project/SCM-top/${1}/target/${1}-${Ver}/${1}.war ${HOME}/project/war/

            echo "copy war without quantz";
            cp -r ${HOME}/project/SCM-top/${1}/target/${1}-${Ver}/noquantz/${1}.war ${HOME}/project/war/noquantz/
        fi

        echo "updatescm finished."
}

function copyscm()
{
        cd ${HOME}/project/SCM-top;
		
        if [ ! -n "$1" ] ;then
            echo "-------- copyscm parameter can not be empty! parameter maybe like this:----------";
            echo "-------- copyscm SCM-usorder"
            echo "-------- copyscm SCM-cnorder"
            echo "-------- copyscm SCM-jporder"
			echo "-------- copyscm SCM-cnshipping"
			echo "-------- copyscm SCM-usshipping"
            return;
        fi

		rm -rf ${HOME}/apache-tomcat-7.0.39/webapps/scm*;
		cp ${HOME}/project/war/${1}.war ${HOME}/apache-tomcat-7.0.39/webapps/scm.war;

        echo "copyscm finished."
}
```