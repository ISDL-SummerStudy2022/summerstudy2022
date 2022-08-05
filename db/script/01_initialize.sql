-- DB作成
CREATE DATABASE testdb; 

-- 作成したDBへ切り替え
\c testdb

-- ロールの作成
-- CREATE ROLE testroot WITH LOGIN PASSWORD 'Password!';

-- 権限追加
-- GRANT ALL PRIVILEGES ON SCHEMA hogeschema TO hoge;