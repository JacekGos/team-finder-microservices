SELECT 'CREATE DATABASE user' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'user')\gexec