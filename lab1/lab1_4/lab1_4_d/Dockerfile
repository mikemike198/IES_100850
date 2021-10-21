FROM postgres:11
LABEL author="Miguel Marques"


ENV POSTGRES_PASSWORD sasa
ENV POSTGRES_DB sampledb

COPY scripts/ /docker-entrypoint-initdb.d/
