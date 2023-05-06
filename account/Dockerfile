FROM ubuntu:23.04

# 1. Installs and launches all the required tools, packages and services.
ENV DEBIAN_FRONTEND=noninteractive
RUN apt update &&                       \
    apt install -y maven                \
                   openjdk-20-jdk       \
                   openjdk-20-jre       \
                   postgresql

# 2. Sets up the project directory
WORKDIR /home
RUN mkdir -p repo && chown postgres repo
WORKDIR /home/repo

# 3. Collects maven dependencies.
ADD pom.xml pom.xml
RUN mvn clean test package

# 4. Creates the development and test databases.
USER postgres
RUN service postgresql start && (echo "CREATE DATABASE e8galleryaccount WITH TEMPLATE = template0 ENCODING = 'UTF8';" | psql postgres)
RUN service postgresql start && (echo "CREATE DATABASE e8galleryaccounttest WITH TEMPLATE = template0 ENCODING = 'UTF8';" | psql postgres)

RUN service postgresql start && (echo "ALTER USER postgres WITH PASSWORD '0f21e4cd-44f8-48ab-b112-62030d7f7df1';" | psql e8galleryaccount)
RUN service postgresql start && (echo "ALTER USER postgres WITH PASSWORD '0f21e4cd-44f8-48ab-b112-62030d7f7df1';" | psql e8galleryaccounttest)

# 5. Updates the relational schema for both the development and test databases.
ADD e8galleryaccount.sql e8galleryaccount.sql
RUN service postgresql start && (cat 'e8galleryaccount.sql' | psql e8galleryaccount)
RUN service postgresql start && (cat 'e8galleryaccount.sql' | psql e8galleryaccounttest)

# 6. Adds the source code and the entrypoint script to the project directory.
USER root
ADD src src
ADD run.sh run.sh

# 7. Launches the account service by running the entrypoint script.
CMD ["./run.sh"]
