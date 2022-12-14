#! /bin/bash

# ディレクトリがある確認
DIR="front/app"
if [ -d $DIR ];then
echo "Directory exists."
  rm -rf $DIR
fi

# docker
docker-compose build
docker-compose run --rm react-app sh -c "yarn global add create-react-app && create-react-app app --template typescript"
