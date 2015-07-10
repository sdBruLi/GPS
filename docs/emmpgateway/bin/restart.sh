#!/bin/sh
id=`ps -ef|grep GatewayStart|grep -v grep|awk {'print $2'}`
if test -n "$id"
then
  echo "kill GatewayStart id=$id process success"
  kill -9 $id
else
  echo "no process kill"
fi

#export JAVA_HOME=/usr/java/jdk1.7.0_55
#export PATH=$JAVA_HOME/bin:$PATH

echo startting server....

#mv ../logs/vehout.txt ../logs/vehout.txt.bak
#此种方式启动会有一个bash进程通过ps -ef | grep java可以找到。这种方法的好处就是，没有cd命令，也可以在任何下执行，因为 cd命令写到字符串里面去了。
su - gps -c "cd /home/gps/emmpgateway/bin && java -server -Xss256k -Xmx1024M -Xms512m -XX:MaxPermSize=128m -XX:-UseGCOverheadLimit -XX:+UseConcMarkSweepGC -server -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8788 -classpath ".:../lib/core-1.2beta.jar:../lib/emmp-1.2beta.jar:../lib/dom4j-1.5-rc1.jar:../lib/mina-core-2.0.4.jar:../lib/slf4j-api-1.6.1.jar:../lib/slf4j-log4j12-1.6.1.jar:../lib/commons-logging-1.0.4.jar:../lib/log4j-1.2.16.jar"  com.china317.emmp.jtt808Gateway.server.GatewayStart > /dev/null 2>&1 &" 

echo server started.