#!/bin/bash
mkdir -p test-results
docker-compose up --build --abort-on-container-exit tests
docker-compose down