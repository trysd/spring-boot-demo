#!/bin/bash
/etc/init.d/nginx start 
sleep 5

/amazon-corretto-8/bin/java -jar demo.example.jar

sleep 1800
