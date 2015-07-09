#!/bin/sh
cd /home/gps/emmpgateway/bin
source /home/gps/.bash_profile

#time
timeStr=`date +%Y%m%d%H%M`
echo $timeStr
binFilepath=./jmap_dump/gateway_$timeStr.bin
echo $binFilepath

#jps
gatewayPort=$(jps | grep GatewayStart | grep -o "[0-9]*")
echo $gatewayPort

#jmap
jmap -dump:live,file=$binFilepath,format=b $gatewayPort
dumpSize=$(du -m $binFilepath |awk '{print $1}')
echo $dumpSize

if [[ $dumpSize -lt 100 ]]; then
rm $binFilepath
elif [[$dumpSize -lt 150]]; then
echo $binFilepath is bigger than 100m
else
echo '======================================================'
ps -mp $gatewayPort -o THREAD,tid,time
echo '------------------------------------------------------'
jstack $gatewayPort
echo '======================================================'
netstat -an| awk '/^tcp/ {++S[$NF]} END {for(a in S) print a, S[a]}'
echo '------------------------------------------------------'
netstat -an| grep 5399| awk '/^tcp/ {++S[$NF]} END {for(a in S) print a, S[a]}'
echo '------------------------------------------------------'
netstat -anp| grep 5399
echo '------------------------------------------------------'
netstat -an| grep 21361| awk '/^tcp/ {++S[$NF]} END {for(a in S) print a, S[a]}'
echo '------------------------------------------------------'
echo '======================================================'
# restart server
./start.h
fi

