#!/bin/bash
echo "Stopping application..."
sudo pkill -f 'java -jar /home/ubuntu/app/payphone-backend-0.0.1-SNAPSHOT.jar' || true