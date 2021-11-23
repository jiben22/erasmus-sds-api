# API - Erasmus+ SDS project

[![CircleCI](https://circleci.com/gh/jiben22/erasmus-sds-api/tree/develop.svg?style=svg)](https://circleci.com/gh/jiben22/erasmus-sds-api/tree/develop)

[![codecov](https://codecov.io/gh/jiben22/erasmus-sds-api/branch/develop/graph/badge.svg)](https://codecov.io/gh/jiben22/erasmus-sds-api/branch/develop)

[Web application: Erasmus+ CES](https://github.com/jiben22/erasmus-sds)

## Get started

`git clone https://github.com/jiben22/erasmus-sds-api.git`

### Database

1. Install MySQL server

2. Turn on the server with these values (or update `src/main/resources/application.yml` file)
> Host name: **127.0.0.1** \
> Port: **3306** \
> Username: **root** \
> Password: **password**

3. Create database
> Database: **CES**

4. Launch the application, it will do the rest

5. You can use `docs/script.sql` file to feed the database