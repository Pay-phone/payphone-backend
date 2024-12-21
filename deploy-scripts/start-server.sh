#!/bin/bash
cd /home/ec2-user/payphone-backend
java -jar payphone-backend-0.0.1-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &
