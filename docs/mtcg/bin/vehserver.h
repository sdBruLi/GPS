id=`ps -ef|grep MocStarter|grep -v grep|awk {'print $2'}`
if test -n "$id" 
then
  echo "kill MocStarter id=$id process success"
  kill -9 $id
else
  echo "no process kill"
fi
 
mv ../logs/vehout.txt ../logs/vehout.txt.bak
java -Xss512k -Xmx512M  -classpath ".:../lib/mtcg-1.00.jar:../lib/dom4j-1.5-rc1.jar:../lib/mina-core-2.0.4.jar:../lib/slf4j-api-1.6.1.jar:../lib/slf4j-log4j12-1.6.1.jar:../lib/commons-logging-1.0.4.jar:../lib/log4j-1.2.16.jar"  com.china317.mtcg.moc.MocStarter >>../logs/vehout.txt &

