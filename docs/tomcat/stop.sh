id=`ps -ef|grep tom6018|grep -v grep|awk {'print $2'}`
if test -n "$id"
then
  echo "kill tom6018 id=$id process success"
  kill -9 $id
else
  echo "no process kill"
fi

