#! /bin/bash

docker-compose build
docker compose run --rm react-app sh -c "yarn global add create-react-app && create-react-app app --template typescript"
