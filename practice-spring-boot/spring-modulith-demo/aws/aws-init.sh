#!/bin/sh
# aws secrets manager
awslocal secretsmanager create-secret --name=tes/test-service/dev/service-1
  --secret-string "{\"authToken\":\"SOME_AUTH_TOKEN\"}"
awslocal secretsmanager create-secret --name=test/test-service/dev/api-keys
  --secret-string "file://api-keys.json"
# sqs
# this url format is necessary, aws sqs client tries to "guess" the region based on the url.
# endpoint-url needs to match a network alias of the localstack docker container.
awslocal --endpoint-url=http://sqs.eu-west-1.test-alias.localstack:4566 sqs create-queue --queue-name test_queue

wait
echo "AWS init done"
