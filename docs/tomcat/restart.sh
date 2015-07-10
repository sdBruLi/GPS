id=`ps -ef|grep tom6018|grep -v grep|awk {'print $2'}`
if test -n "$id" 
then

#delete history
rm -rf jstack_gps*
rm -rf jmap_gps*
 
#time
timeStr=`date +%Y%m%d%H%M`
echo $timeStr
 
binFilepath=./jmap_gps_$timeStr.bin
echo $binFilepath

#jmap
jmap -dump:live,file=$binFilepath,format=b $id
dumpSize=$(du -m $binFilepath |awk '{print $1}')
echo $dumpSize
  
#jstack
jstack -F $id >> jstack_gps_$timeStr.log

  echo "kill tom6018 id=$id process success"
  kill -9 $id
else
  echo "no process kill"
fi

now=$(date '+%Y%m%d%H%M%S') 
mv ../tom6018/logs/catalina.out ../tom6018/logs/catalina.out.$now.bak
sh ../tom6018/bin/startup.sh
